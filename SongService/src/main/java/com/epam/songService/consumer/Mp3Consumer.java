package com.epam.songService.consumer;

import com.epam.songService.entity.Song;
import com.epam.songService.repository.SongRepo;
import com.mpatric.mp3agic.ID3v1;
import com.mpatric.mp3agic.Mp3File;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Component
public class Mp3Consumer {

	private SongRepo songRepo;

	@Bean
	public Consumer<Mp3File> onReceive() {
		return (mp3file) -> {
			if (mp3file.hasId3v1Tag()) {
				ID3v1 id3v1Tag = mp3file.getId3v1Tag();
				String title = id3v1Tag.getTitle();
				String artist = id3v1Tag.getArtist();
				String album = id3v1Tag.getAlbum();
				String year = id3v1Tag.getYear();
				String length = String.valueOf(mp3file.getLengthInSeconds());
				String resourceId = id3v1Tag.getVersion();
				songRepo.createSong(new Song(title, artist, album, length, resourceId, year));
			}
		};
	}
}
