package com.spotifyQuipux;

import com.spotifyQuipux.entity.PlayList;
import com.spotifyQuipux.repository.PlayListRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class SpotifyQuipuxApplication {
	private PlayListRepository playListRepository;
	public static void main(String[] args) {

		SpringApplication.run(SpotifyQuipuxApplication.class, args);
	}

	public SpotifyQuipuxApplication(PlayListRepository playListRepository) {
		this.playListRepository = playListRepository;
	}


}
