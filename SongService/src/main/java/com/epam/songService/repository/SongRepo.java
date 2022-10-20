package com.epam.songService.repository;

import com.epam.songService.entity.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SongRepo extends JpaRepository<Song, Long> {
	@Query("DELETE FROM Song s WHERE s.id in (?1)")
	List<Long> deleteSongsByIds(List<Long> ids);
}
