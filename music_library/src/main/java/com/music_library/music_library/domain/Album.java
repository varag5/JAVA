package com.music_library.music_library.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.NoArgsConstructor;
import java.util.Date;

@Entity
@Table(name = "Albums")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer albumId;  // primary key

    private String albumTitle;
    private Date releaseDate;

    @ManyToOne
    @JoinColumn(name = "artist_id")
    private Artist artist;  // foreign key referencing Artist class

    // Other attributes related to the album
}