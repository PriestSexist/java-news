package ru.cifrak.newstype.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.cifrak.error.constants.ErrorStrings;

import javax.validation.constraints.Size;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class NewsTypeRequestDto {
    @Size(min = 4, message = ErrorStrings.TOO_SHORT)
    @Size(max = 64, message = ErrorStrings.TOO_LONG)
    private final String name;
    @Size(min = 4, message = ErrorStrings.TOO_SHORT)
    @Size(max = 32, message = ErrorStrings.TOO_LONG)
    private final String color;
}
