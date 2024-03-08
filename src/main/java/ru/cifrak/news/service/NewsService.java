package ru.cifrak.news.service;

import ru.cifrak.news.dto.NewsRequestDto;
import ru.cifrak.news.dto.NewsResponseDto;
import ru.cifrak.news.dto.NewsShortResponseDto;

import java.util.List;

public interface NewsService {
    NewsResponseDto postNews(NewsRequestDto newsRequestDto);

    List<NewsShortResponseDto> getNews(List<Integer> ids, int from, int size);

    List<NewsResponseDto> getNewsByType(int typeId, int from, int size);

    NewsResponseDto patchNews(int id, NewsRequestDto newsRequestDto);

    void deleteNews(int id);

}
