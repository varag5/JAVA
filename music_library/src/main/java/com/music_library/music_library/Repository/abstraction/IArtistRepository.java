package com.music_library.music_library.Repository.abstraction;
import com.music_library.music_library.Controller.DTO.ArtistRequestDTO;
import com.music_library.music_library.domain.Artist;
import java.util.List;

public interface IArtistRepository {

    List<Artist> getAllArtists();

    Artist getArtistById(Long id);

    Artist addArtist(ArtistRequestDTO artist);

    Artist updateArtist(Artist artist);

    void deleteArtist(Long id);

}