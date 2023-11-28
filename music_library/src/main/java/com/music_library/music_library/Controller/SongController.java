package com.music_library.music_library.Controller;

import com.music_library.music_library.Repository.abstraction.ISongRepository;
import com.music_library.music_library.domain.Song;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Songs")
@RequiredArgsConstructor
public class SongController {

    private final ISongRepository songRepository;

    @GetMapping
    public List<Song> getAllSongs(@RequestParam(required = false, defaultValue = "100") Integer limit,
                                  @RequestParam(required = false, defaultValue = "desc") String sort) {

        //Page<Song> songs = songRepository.findAll(PageRequest.of(0, limit, sort));
        return songRepository.getAllSongs();
    }
}
