package com.music_library.music_library.Repository.implementation;

import com.music_library.music_library.Controller.DTO.ArtistRequestDTO;
import com.music_library.music_library.Repository.abstraction.IArtistRepository;
import com.music_library.music_library.domain.Artist;
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

public class ArtistRepository implements IArtistRepository {

    @PersistenceContext
    private final EntityManager entityManager;
    private final GenreRepository genreRepository;

    @Override
    public List<Artist> getAllArtists() {
        try {
            return entityManager.createQuery("SELECT a FROM Artist a", Artist.class).getResultList();
        } catch (Exception e) {
            log.error("Error fetching all artists", e);
            throw new RuntimeException("Error fetching all artists", e);
        }
    }

    @Override
    public Artist getArtistById(Long id) {
            return entityManager.find(Artist.class, id);
    }

    @Override
    @Transactional
    public Artist addArtist(ArtistRequestDTO artistRequestDTO) {
        try {
            // Convert DTO to entity
            Artist artist = new Artist();
            artist.setName(artistRequestDTO.getName());

            // Assuming you have a GenreService to retrieve the G   enre by ID
            Genre genre = genreRepository.getGenreById(artistRequestDTO.getGenreId());
            artist.setGenre(genre);

            // Persist the entity
            entityManager.persist(artist);

            return artist;
        } catch (Exception e) {
            log.error("Error adding artist", e);
            throw new RuntimeException("Error adding artist", e);
        }
    }
    @Override
    @Transactional
    public Artist updateArtist(Artist artist) {
        return entityManager.merge(artist);
    }

    @Override
    @Transactional
    public void deleteArtist(Long id) {
        Artist artist = entityManager.find(Artist.class, id);
        if (artist != null) {
            entityManager.remove(artist);
        }
    }

}
