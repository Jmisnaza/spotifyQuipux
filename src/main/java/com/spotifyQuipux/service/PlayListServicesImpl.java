package com.spotifyQuipux.service;

import com.spotifyQuipux.entity.PlayList;
import com.spotifyQuipux.repository.PlayListRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class PlayListServicesImpl implements PlayListServices {
    private final static Logger logger = LoggerFactory.getLogger(PlayListServicesImpl.class);
    //private static final String MESSAGE_USER_NOT_FOUND = "Ha ocurrido un error buscando el usuario por email";
    private PlayListRepository playListRepository;

    public PlayListServicesImpl(PlayListRepository playListRepository) {
        this.playListRepository = playListRepository;
    }

    @Transactional
    public void save(List<PlayList> playLists) {
        playLists.stream()
                .peek(playList -> logger.info("Insert: " + playList))
                .forEach(playList -> playListRepository.save(playList));
    }
}
