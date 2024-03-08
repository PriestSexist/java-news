package ru.cifrak.newstype.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class NewsTypeResponseDto {
    private final int id;
    private final String name;
    private final String color;
}
