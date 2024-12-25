package com.example.validatesonginformation.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "song")
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Không được để trống")
    @Size(max = 800, message = "Không vượt quá 800 ký tự ")
    @Pattern(regexp = "^[^@;,.\\-=+]*$", message = "Không được chứa các ký tự đặc biệt @;,.\\-=+")
    @Column(columnDefinition = "TEXT")
    private String title;

    @NotNull(message = "Không được để trống")
    @Size(max = 300, message = "Không vượt quá 300 ký tự ")
    @Pattern(regexp = "^[^@;,.\\-=+]*$", message = "Không được chứa các ký tự đặc biệt @;,.\\-=+")
    @Column(columnDefinition = "TEXT")
    private String artist;

    @NotNull(message = "Không được để trống")
    @Size(max = 1000, message = "Không vượt quá 1000 ký tự ")
    @Pattern(regexp = "^[^@;.\\-=+]*$", message = "Không được chứa các ký tự đặc biệt @;.\\-=+")
    @Column(columnDefinition = "TEXT")
    private String genre;

    public Song() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
