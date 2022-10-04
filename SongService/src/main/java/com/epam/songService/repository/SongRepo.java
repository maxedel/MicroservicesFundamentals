package com.epam.songService.repository;

import com.epam.songService.entity.Song;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SongRepo extends JpaRepository<Song, Long> {
	Song createSong(Song song);

	List<Song> getSongById(Long id);

	List<Long> deleteSongsByIds(List<Long> ids);
}
