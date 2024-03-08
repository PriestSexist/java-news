package ru.cifrak.news.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.cifrak.news.dto.NewsRequestDto;
import ru.cifrak.news.dto.NewsResponseDto;
import ru.cifrak.news.dto.NewsShortResponseDto;
import ru.cifrak.news.service.NewsService;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.util.List;

@RequiredArgsConstructor
@Slf4j
@RestController
@RequestMapping("/news")
@Validated
public class NewsController {

    private final NewsService newsService;

    @PostMapping()
    public NewsResponseDto postNews(@RequestBody @Valid NewsRequestDto newsRequestDto) {
        log.debug("Вызван метод postNews");
        return newsService.postNews(newsRequestDto);
    }

    @GetMapping()
    public List<NewsShortResponseDto> getNews(@RequestParam(defaultValue = "") List<Integer> ids,
                                              @RequestParam(defaultValue = "0") @PositiveOrZero int from,
                                              @RequestParam(defaultValue = "10") @Positive int size) {
        log.debug("Вызван метод getNews");
        return newsService.getNews(ids, from, size);
    }

    @GetMapping("/type")
    public List<NewsResponseDto> getNewsByType(@RequestParam int typeId,
                                               @RequestParam(defaultValue = "0") @PositiveOrZero int from,
                                               @RequestParam(defaultValue = "10") @Positive int size) {
        log.debug("Вызван метод getNews");
        return newsService.getNewsByType(typeId, from, size);
    }

    @PatchMapping("/{id}")
    public NewsResponseDto patchNews(@RequestBody @Valid NewsRequestDto newsRequestDto,
                                     @PathVariable int id) {
        log.debug("Вызван метод patchNews");
        return newsService.patchNews(id, newsRequestDto);
    }

    @DeleteMapping("/{id}")
    public void deleteNews(@PathVariable int id) {
        log.debug("Вызван метод deleteNews");
        newsService.deleteNews(id);
    }


}
