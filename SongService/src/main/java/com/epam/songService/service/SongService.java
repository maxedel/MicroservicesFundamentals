package com.epam.songService.service;

import com.epam.songService.entity.Song;
import com.epam.songService.repository.SongRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongService {

	private SongRepo songRepo;

	public SongService(SongRepo songRepo) {
		this.songRepo = songRepo;
	}

	public Song createSong(Song song) {
		return songRepo.createSong(song);
	}

	public List<Song> getSongById(Long id) {
		return songRepo.getSongById(id);
	}

	public List<Long> deleteSongsByIds(List<Long> ids) {
		return songRepo.deleteSongsByIds(ids);
	}
}
