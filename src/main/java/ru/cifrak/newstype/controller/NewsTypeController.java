package ru.cifrak.newstype.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.cifrak.newstype.dto.NewsTypeRequestDto;
import ru.cifrak.newstype.dto.NewsTypeResponseDto;
import ru.cifrak.newstype.service.NewsTypeService;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.util.List;

@RequiredArgsConstructor
@Slf4j
@RestController
@RequestMapping("/news-type")
@Validated
public class NewsTypeController {

    private final NewsTypeService newsTypeService;

    @PostMapping()
    public NewsTypeResponseDto postNewsType(@RequestBody @Valid NewsTypeRequestDto newsTypeRequestDto) {
        log.debug("Вызван метод postNewsType");
        return newsTypeService.postNewsType(newsTypeRequestDto);
    }

    @GetMapping()
    public List<NewsTypeResponseDto> getNewsType(@RequestParam(defaultValue = "") List<Integer> ids,
                                                 @RequestParam(defaultValue = "0") @PositiveOrZero int from,
                                                 @RequestParam(defaultValue = "10") @Positive int size) {
        log.debug("Вызван метод getNewsType");
        return newsTypeService.getNewsType(ids, from, size);
    }

    @PatchMapping("/{id}")
    public NewsTypeResponseDto patchNewsType(@RequestBody @Valid NewsTypeRequestDto newsTypeDto,
                                             @PathVariable int id) {
        log.debug("Вызван метод patchNewsType");
        return newsTypeService.patchNewsType(id, newsTypeDto);
    }

    @DeleteMapping("/{id}")
    public void deleteNewsType(@PathVariable int id) {
        log.debug("Вызван метод deleteNewsType");
        newsTypeService.deleteNewsType(id);
    }
}
