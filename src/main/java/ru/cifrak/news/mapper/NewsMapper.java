package ru.cifrak.news.mapper;

import lombok.experimental.UtilityClass;
import ru.cifrak.news.dto.NewsRequestDto;
import ru.cifrak.news.dto.NewsResponseDto;
import ru.cifrak.news.dto.NewsShortResponseDto;
import ru.cifrak.news.model.News;
import ru.cifrak.newstype.mapper.NewsTypeMapper;
import ru.cifrak.newstype.model.NewsType;

@UtilityClass
public class NewsMapper {

    public static News createNews(NewsRequestDto newsRequestDto, NewsType newsType) {
        return News.builder()
                .name(newsRequestDto.getName())
                .shortDescription(newsRequestDto.getShortDescription())
                .longDescription(newsRequestDto.getLongDescription())
                .type(newsType)
                .build();
    }

    public static NewsResponseDto createNewsResponseDto(News news) {
        return NewsResponseDto.builder()
                .id(news.getId())
                .name(news.getName())
                .shortDescription(news.getShortDescription())
                .longDescription(news.getLongDescription())
                .type(NewsTypeMapper.createNewsTypeResponseDto(news.getType()))
                .build();
    }

    public static NewsShortResponseDto createNewsShortResponseDto(News news) {
        return NewsShortResponseDto.builder()
                .name(news.getName())
                .shortDescription(news.getShortDescription())
                .type(NewsTypeMapper.createNewsTypeResponseDto(news.getType()))
                .build();
    }
}
