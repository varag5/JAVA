package com.music_library.music_library.domain;

import lombok.*;

import jakarta.persistence.*;

@Entity
@Table(name = "genres")
@Getter
@Setter
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "genre_id")
    private Long genreId;

    private String name;

    // Getters and setters
}