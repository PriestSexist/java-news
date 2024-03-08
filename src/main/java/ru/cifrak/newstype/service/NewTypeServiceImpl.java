package ru.cifrak.newstype.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ru.cifrak.newstype.dto.NewsTypeRequestDto;
import ru.cifrak.newstype.dto.NewsTypeResponseDto;
import ru.cifrak.newstype.mapper.NewsTypeMapper;
import ru.cifrak.newstype.model.NewsType;
import ru.cifrak.newstype.repository.NewsTypeRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

import static ru.cifrak.error.constants.ErrorStrings.NEWS_NOT_FOUND_BY_ID;
import static ru.cifrak.error.constants.ErrorStrings.NEWS_TYPE_NOT_FOUND_BY_ID;

@Service
@RequiredArgsConstructor
public class NewTypeServiceImpl implements NewsTypeService {

    private final NewsTypeRepository newsTypeRepository;

    @Override
    public NewsTypeResponseDto postNewsType(NewsTypeRequestDto newsTypeDto) {
        NewsType newsType = NewsTypeMapper.createNewsType(newsTypeDto);
        return NewsTypeMapper.createNewsTypeResponseDto(newsTypeRepository.save(newsType));
    }

    @Override
    public List<NewsTypeResponseDto> getNewsType(List<Integer> ids, int from, int size) {
        if (ids.isEmpty()) {
            PageRequest pageRequest = PageRequest.of(from > 0 ? from / size : 0, size);
            return newsTypeRepository.findAll(pageRequest).map(NewsTypeMapper::createNewsTypeResponseDto).getContent();
        }
        return newsTypeRepository.getAllNewsTypeById(ids).stream().map(NewsTypeMapper::createNewsTypeResponseDto).collect(Collectors.toList());

    }

    @Override
    public NewsTypeResponseDto patchNewsType(int id, NewsTypeRequestDto newsTypeDto) {
        NewsType newsTypeFromDb = newsTypeRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(String.format(NEWS_TYPE_NOT_FOUND_BY_ID, id)));

        if (newsTypeDto.getName() != null) {
            newsTypeFromDb.setName(newsTypeDto.getName());
        }

        if (newsTypeDto.getColor() != null) {
            newsTypeFromDb.setColor(newsTypeDto.getColor());
        }

        return NewsTypeMapper.createNewsTypeResponseDto(newsTypeRepository.save(newsTypeFromDb));
    }

    @Override
    public void deleteNewsType(int id) {
        if (!newsTypeRepository.existsById(id)) {
            throw new EntityNotFoundException(String.format(NEWS_NOT_FOUND_BY_ID, id));
        }
        newsTypeRepository.deleteById(id);
    }
}
