package ru.cifrak.newstype.dto;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.cifrak.error.constants.ErrorStrings;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class NewsTypeDto {
    private final int id;
    @Size(min = 16, message = ErrorStrings.TOO_SHORT)
    @Size(max = 64, message = ErrorStrings.TOO_LONG)
    private final String name;
    @Size(min = 16, message = ErrorStrings.TOO_SHORT)
    @Size(max = 32, message = ErrorStrings.TOO_LONG)
    private final String color;
}
