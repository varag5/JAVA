package com.music_library.music_library.Controller;

import com.music_library.music_library.domain.Artist;
import com.music_library.music_library.Repository.implementation.ArtistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RequestMapping("/Artist")
@RequiredArgsConstructor
@RestController
public class ArtistController {
    private final ArtistRepository artistRepository;

    @GetMapping
    public List<Artist> getAllGames() {

        var x = artistRepository.getAllArtists();
        return artistRepository.getAllArtists();
    }
    @PostMapping
    public Artist addArtist(Artist artist) {
        return artistRepository.addArtist(artist);
    }
}