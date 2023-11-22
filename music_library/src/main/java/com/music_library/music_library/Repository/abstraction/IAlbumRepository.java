package com.music_library.music_library.Repository.abstraction;

import com.music_library.music_library.domain.Album;

import java.util.List;

public interface IAlbumRepository {

    List<Album> getAllAlbums();
}
