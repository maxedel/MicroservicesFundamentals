package com.epam.songService.controller;

import com.epam.songService.entity.Song;
import com.epam.songService.service.SongService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/songs")
public class SongController {

	private SongService songService;

	public SongController(SongService songService) {
		this.songService = songService;
	}

	@PostMapping(consumes = "application/json")
	Song createSong(@RequestBody Song song) {
		return songService.createSong(song);
	}

	@GetMapping("/{id}")
	List<Song> getSongById(@PathVariable Long id) {
		return songService.getSongById(id);
	}

	@DeleteMapping("/{id}")
	List<Long> deleteSongs(List<Long> ids) {
		return songService.deleteSongsByIds(ids);
	}
}
