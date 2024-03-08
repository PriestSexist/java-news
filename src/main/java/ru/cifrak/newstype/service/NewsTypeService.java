package ru.cifrak.newstype.service;

import ru.cifrak.newstype.dto.NewsTypeRequestDto;
import ru.cifrak.newstype.dto.NewsTypeResponseDto;

import java.util.List;

public interface NewsTypeService {
    NewsTypeResponseDto postNewsType(NewsTypeRequestDto newsTypeDto);

    List<NewsTypeResponseDto> getNewsType(List<Integer> ids, int from, int size);

    NewsTypeResponseDto patchNewsType(int id, NewsTypeRequestDto newsTypeDto);

    void deleteNewsType(int id);
}
