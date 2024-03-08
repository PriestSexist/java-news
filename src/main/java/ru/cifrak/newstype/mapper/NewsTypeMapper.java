package ru.cifrak.newstype.mapper;

import lombok.experimental.UtilityClass;
import ru.cifrak.newstype.dto.NewsTypeRequestDto;
import ru.cifrak.newstype.dto.NewsTypeResponseDto;
import ru.cifrak.newstype.model.NewsType;

@UtilityClass
public class NewsTypeMapper {
    public static NewsTypeResponseDto createNewsTypeResponseDto(NewsType newsType) {
        return NewsTypeResponseDto.builder()
                .id(newsType.getId())
                .name(newsType.getName())
                .color(newsType.getColor())
                .build();
    }

    public static NewsType createNewsType(NewsTypeRequestDto newsTypeDto) {
        return NewsType.builder()
                .name(newsTypeDto.getName())
                .color(newsTypeDto.getColor())
                .build();
    }
}
