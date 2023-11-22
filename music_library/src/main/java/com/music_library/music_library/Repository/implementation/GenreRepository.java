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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
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

    public List<Genre> getAllGenres() {
        try {
            return entityManager.createQuery("SELECT g FROM Genre g", Genre.class).getResultList();
        } catch (Exception e) {
            log.error("Error fetching all genres", e);
            throw new RuntimeException("Error fetching all genres", e);
        }
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


    //@Override
    public Page<Genre> getAllGenresPaged(int page, int size) {
        try {
            List<Genre> genres = entityManager.createQuery("SELECT g FROM Genre g", Genre.class)
                    .setFirstResult(page * size)
                    .setMaxResults(size)
                    .getResultList();

            return new PageImpl<>(genres, PageRequest.of(page, size), countTotalGenres());
        } catch (Exception e) {
            log.error("Error fetching paged genres", e);
            throw new RuntimeException("Error fetching paged genres", e);
        }
    }

    private long countTotalGenres() {
        return entityManager.createQuery("SELECT COUNT(g) FROM Genre g", Long.class)
                .getSingleResult();
    }



}
