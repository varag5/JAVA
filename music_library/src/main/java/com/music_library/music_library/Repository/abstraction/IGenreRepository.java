package com.music_library.music_library.Repository.abstraction;

import com.music_library.music_library.domain.Genre;

import java.util.List;

public interface IGenreRepository {

    Genre addGenre(Genre genre);

    Genre updateGenre(Genre genre);

    //get genre by id
    Genre getGenreById(Long id);

    List<Genre> getAllGenres();


}
