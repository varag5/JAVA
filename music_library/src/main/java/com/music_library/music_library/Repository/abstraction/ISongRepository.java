package com.music_library.music_library.Repository.abstraction;

import com.music_library.music_library.domain.Song;

import java.util.List;

public interface ISongRepository {

    List<Song> getAllSongs();
}