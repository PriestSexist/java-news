package ru.cifrak.news.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.cifrak.newstype.dto.NewsTypeResponseDto;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class NewsResponseDto {
    private final int id;
    private final String name;
    private final String shortDescription;
    private final String longDescription;
    private final NewsTypeResponseDto type;
}
