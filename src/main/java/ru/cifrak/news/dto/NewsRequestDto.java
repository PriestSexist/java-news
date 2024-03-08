package ru.cifrak.news.dto;


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
public class NewsRequestDto {
    @Size(min = 16, message = ErrorStrings.TOO_SHORT)
    @Size(max = 256, message = ErrorStrings.TOO_LONG)
    private final String name;
    @Size(min = 16, message = ErrorStrings.TOO_SHORT)
    @Size(max = 2048, message = ErrorStrings.TOO_LONG)
    private final String shortDescription;
    @Size(min = 16, message = ErrorStrings.TOO_SHORT)
    @Size(max = 8192, message = ErrorStrings.TOO_LONG)
    private final String longDescription;
    private final Integer typeId;
}
