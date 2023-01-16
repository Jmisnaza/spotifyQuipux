package com.spotifyQuipux.controller;

import com.spotifyQuipux.entity.PlayList;
import com.spotifyQuipux.repository.PlayListRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/api")
public class PlayListRestController {

    @Autowired
    PlayListRepository playListRepository;

    @GetMapping("/playlist")
    public ResponseEntity<List<PlayList>> getAllPlayList(@RequestParam(required = false) String name) {
        try {
            List<PlayList> playList = new ArrayList<PlayList>();

            if (name == null)
                playListRepository.findAll().forEach(playList::add);
            else
                playListRepository.findByNameContaining(name).forEach(playList::add);

            if (playList.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(playList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/playlist/{id}")
    public ResponseEntity<PlayList> getPlayListById(@PathVariable("id") long id) {
        Optional<PlayList> playListData = playListRepository.findById(id);

        if (playListData.isPresent()) {
            return new ResponseEntity<>(playListData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/saveplaylist")
    public ResponseEntity<PlayList> createPlayList(@RequestBody PlayList playList) {
        try {
            System.out.println("Entreeee playlist" + playList);
            PlayList _playList = playListRepository
                    .save(new PlayList(playList.getName(), playList.getDescription()));
            return new ResponseEntity<>(_playList, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
