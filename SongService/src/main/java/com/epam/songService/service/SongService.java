package com.epam.songService.service;

import com.epam.songService.entity.Song;
import com.epam.songService.repository.SongRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SongService {

	private SongRepo songRepo;

	public SongService(SongRepo songRepo) {
		this.songRepo = songRepo;
	}

	public Song createSong(Song song) {
		return songRepo.save(song);
	}

	public Song getSongById(Long id) {
		return songRepo.findById(id).get();
	}

	public List<Long> deleteSongsByIds(List<Long> ids) {
		return songRepo.deleteSongsByIds(ids);
	}
}
