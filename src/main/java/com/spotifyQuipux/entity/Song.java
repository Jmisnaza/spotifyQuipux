package com.spotifyQuipux.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "song")
public class Song {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id_song", nullable = false, unique = true)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_playlist")
    private PlayList playList;

    @Column(name = "title", length = 255)
    private String title;

    @Column(name = "artist", length = 255)
    private String artist;

    @Column(name = "album", length = 255)
    private String album;

    @Column(name = "year", length = 255)
    private String year;

    @Column(name = "gender", length = 255)
    private String gender;

    public Song() {
    }


    public Song(String title, String artist, String album, String year, String gender, PlayList playList) {
        this.title = title;
        this.artist = artist;
        this.album = album;
        this.year = year;
        this.gender = gender;
        this.playList = playList;
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

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public PlayList getPlayList() {
        return playList;
    }

    public void setPlayList(PlayList playList) {
        this.playList = playList;
    }

    @Override
    public String toString() {
        return "Song{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", artist='" + artist + '\'' +
                ", album='" + album + '\'' +
                ", year='" + year + '\'' +
                ", gender='" + gender + '\'' +
                ", playList=" + playList+
                '}';
    }
}
