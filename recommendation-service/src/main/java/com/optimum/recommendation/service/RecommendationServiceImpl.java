package com.optimum.recommendation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RecommendationServiceImpl implements RecommendationService {

	@Autowired
	RestTemplate restTemplate;
	
	public String getPlaylists() {
		return restTemplate.getForObject("http://api.napster.com/v2.2/playlists", String.class);
	}

	public String getTopTracks() {
		return restTemplate.getForObject("http://api.napster.com/v2.2/tracks/top", String.class);
	}

	public String getTopAlbumsOfTheDay() {
		return restTemplate.getForObject("http://api.napster.com/v2.2/albums/top", String.class);
	}

	public String getAllGenres() {
		return restTemplate.getForObject("http://api.napster.com/v2.2/genres", String.class);
	}
}
