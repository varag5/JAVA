package com.music_library.music_library.Repository.implementation;

import com.music_library.music_library.Repository.abstraction.IGenreRepository;
import com.music_library.music_library.domain.Genre;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import java.util.List;

@Slf4j
@Repository
@RequiredArgsConstructor

public class GenreRepository implements IGenreRepository {
    @PersistenceContext
    private final EntityManager entityManager;

    @Override
    @Transactional
    public Genre addGenre(Genre genre) {
        entityManager.persist(genre);
        return genre;
    }

    @Override
    @Transactional
    public Genre updateGenre(Genre genre) {
        return null;
    }

    @Override
    public Genre getGenreById(Long id) {
        return entityManager.find(Genre.class, id);
    }
}
