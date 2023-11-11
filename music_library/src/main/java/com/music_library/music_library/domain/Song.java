package com.music_library.music_library.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Songs")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer songId;  // primary key

    private String songTitle;
    private Integer duration;

    @ManyToOne
    @JoinColumn(name = "album_id")
    private Album album;  // foreign key referencing Album class

    @ManyToOne
    @JoinColumn(name = "genre_id")
    private Genre genre;  // foreign key referencing Genre class

    // Other attributes related to the song
}
