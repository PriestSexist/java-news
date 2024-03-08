package ru.cifrak.news.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ru.cifrak.news.dto.NewsRequestDto;
import ru.cifrak.news.dto.NewsResponseDto;
import ru.cifrak.news.dto.NewsShortResponseDto;
import ru.cifrak.news.mapper.NewsMapper;
import ru.cifrak.news.model.News;
import ru.cifrak.news.repository.NewsRepository;
import ru.cifrak.newstype.model.NewsType;
import ru.cifrak.newstype.repository.NewsTypeRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

import static ru.cifrak.error.constants.ErrorStrings.NEWS_NOT_FOUND_BY_ID;
import static ru.cifrak.error.constants.ErrorStrings.NEWS_TYPE_NOT_FOUND_BY_ID;

@Service
@RequiredArgsConstructor
public class NewsServiceImpl implements NewsService {

    private final NewsRepository newsRepository;
    private final NewsTypeRepository newsTypeRepository;

    @Override
    public NewsResponseDto postNews(NewsRequestDto newsRequestDto) {
        NewsType newsTypeFromDb = newsTypeRepository.findById(newsRequestDto.getTypeId()).orElseThrow(() -> new EntityNotFoundException(String.format(NEWS_TYPE_NOT_FOUND_BY_ID, newsRequestDto.getTypeId())));
        News news = NewsMapper.createNews(newsRequestDto, newsTypeFromDb);
        return NewsMapper.createNewsResponseDto(newsRepository.save(news));
    }

    @Override
    public List<NewsShortResponseDto> getNews(List<Integer> ids, int from, int size) {
        if (ids.isEmpty()) {
            PageRequest pageRequest = PageRequest.of(from > 0 ? from / size : 0, size);
            return newsRepository.findAll(pageRequest).map(NewsMapper::createNewsShortResponseDto).getContent();
        }
        return newsRepository.getAllNewsById(ids).stream().map(NewsMapper::createNewsShortResponseDto).collect(Collectors.toList());
    }


    @Override
    public List<NewsResponseDto> getNewsByType(int typeId, int from, int size) {
        return newsRepository.getAllNewsByTypeId(typeId).stream().map(NewsMapper::createNewsResponseDto).collect(Collectors.toList());
    }

    @Override
    public NewsResponseDto patchNews(int id, NewsRequestDto newsRequestDto) {
        News newsFromDb = newsRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(String.format(NEWS_NOT_FOUND_BY_ID, id)));

        if (newsRequestDto.getName() != null) {
            newsFromDb.setName(newsRequestDto.getName());
        }

        if (newsRequestDto.getShortDescription() != null) {
            newsFromDb.setShortDescription(newsRequestDto.getShortDescription());
        }
        if (newsRequestDto.getLongDescription() != null) {
            newsFromDb.setLongDescription(newsRequestDto.getLongDescription());
        }
        if (newsRequestDto.getTypeId() != null) {
            NewsType newsTypeFromDb = newsTypeRepository.findById(newsRequestDto.getTypeId()).orElseThrow(() -> new EntityNotFoundException(String.format(NEWS_TYPE_NOT_FOUND_BY_ID, newsRequestDto.getTypeId())));
            newsFromDb.setType(newsTypeFromDb);
        }

        return NewsMapper.createNewsResponseDto(newsRepository.save(newsFromDb));
    }

    @Override
    public void deleteNews(int id) {
        if (!newsRepository.existsById(id)) {
            throw new EntityNotFoundException(String.format(NEWS_NOT_FOUND_BY_ID, id));
        }
        newsRepository.deleteById(id);
    }

}
