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

	public void run(String... arg) {
		SavePlayListInDataBase();
	}

	public SpotifyQuipuxApplication(PlayListRepository playListRepository) {
		this.playListRepository = playListRepository;
	}

	private void SavePlayListInDataBase(){

		PlayList playList1 = new PlayList("PlayList1", "my first playList");
		PlayList playList2 = new PlayList("PlayList2", "my second playList");
		List<PlayList> list = Arrays.asList(playList1, playList2);

		list.stream().forEach(playListRepository::save);
	}

}
