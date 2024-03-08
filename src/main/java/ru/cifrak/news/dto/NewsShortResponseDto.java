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
public class NewsShortResponseDto {
    private final String name;
    private final String shortDescription;
    private final NewsTypeResponseDto type;
}
