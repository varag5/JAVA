package com.music_library.music_library.Controller;

import com.music_library.music_library.Repository.implementation.GenreRepository;
import com.music_library.music_library.domain.Genre;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/Genre")
@RequiredArgsConstructor
@RestController
public class GenreController {

    private final GenreRepository genreRepository;

    @GetMapping
    public Page<Genre> getAllGenres(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "2") int size
    ) {
        return genreRepository.getAllGenresPaged(page, size);
    }
}