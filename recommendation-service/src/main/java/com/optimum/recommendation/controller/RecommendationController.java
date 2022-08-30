package com.optimum.recommendation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.optimum.recommendation.service.RecommendationService;

@RestController
@RequestMapping("/api/v1/recommend")
public class RecommendationController {
	
	@Autowired
	RecommendationService recommendationService;

	@GetMapping(value = "/all-playlists", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<String> getPlaylistsOfTheDay() {
		return new ResponseEntity<>(recommendationService.getPlaylists(), HttpStatus.OK);
	}
	
	@GetMapping(value = "/top-tracks", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<String> getTopTracks() {
		return new ResponseEntity<>(recommendationService.getTopTracks(), HttpStatus.OK);
	}
	
	@GetMapping(value = "/top-albums", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<String> getTopAlbumsOfTheDay() {
		return new ResponseEntity<>(recommendationService.getTopAlbumsOfTheDay(), HttpStatus.OK);
	}
	
	@GetMapping(value = "/all-genres", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<String> getAllGenres() {
		return new ResponseEntity<>(recommendationService.getAllGenres(), HttpStatus.OK);
	}
	
	
}
