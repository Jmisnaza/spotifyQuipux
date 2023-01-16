package com.spotifyQuipux.controller;

import com.spotifyQuipux.entity.Song;
import com.spotifyQuipux.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class SongRestController {

    @Autowired
    SongRepository songRepository;

    @GetMapping("/songs")
    public ResponseEntity<List<Song>> getAllSongs(@RequestParam(required = false) String title) {
        try {
            List<Song> songs = new ArrayList<Song>();

            if (title == null)
                songRepository.findAll().forEach(songs::add);
            else
                songRepository.findByTitleContaining(title).forEach(songs::add);

            if (songs.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(songs, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/song/{id}")
    public ResponseEntity<Song> getSongById(@PathVariable("id") long id) {
        Optional<Song> songData = songRepository.findById(id);

        if (songData.isPresent()) {
            return new ResponseEntity<>(songData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/savesong")
    public ResponseEntity<Song> createPlayList(@RequestBody Song song) {
        System.out.println("Entreeee " + song);
        try {
            Song _song = songRepository
                    .save(new Song(song.getTitle(), song.getArtist(), song.getAlbum(), song.getYear(), song.getGender(), song.getPlayList()));
            return new ResponseEntity<>(_song, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
