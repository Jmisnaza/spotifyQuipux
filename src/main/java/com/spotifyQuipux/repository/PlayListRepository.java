package com.spotifyQuipux.repository;

import com.spotifyQuipux.entity.PlayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayListRepository extends JpaRepository<PlayList, Long> {
    List<PlayList> findByNameContaining(String name);

}
