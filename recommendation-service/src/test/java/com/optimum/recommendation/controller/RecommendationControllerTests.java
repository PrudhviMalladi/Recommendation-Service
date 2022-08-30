package com.optimum.recommendation.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.optimum.recommendation.service.RecommendationService;

@SpringBootTest
class RecommendationControllerTests {

	private MockMvc mockMvc;
	
	@Mock
	RecommendationService recommendationService;
	
	@InjectMocks
	RecommendationController recommendationController;
	
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(recommendationController).build();
	}
	
	@Test
	void getAllPlaylistSuccess() throws Exception {
		when(recommendationService.getPlaylists()).thenReturn("Playlist");
		mockMvc.perform(get("/api/v1/recommend/all-playlists").contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk()).andDo(MockMvcResultHandlers.print());
	}
	
	@Test
	void getTopTracksSuccess() throws Exception {
		when(recommendationService.getPlaylists()).thenReturn("Tracks");
		mockMvc.perform(get("/api/v1/recommend/top-tracks").contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk()).andDo(MockMvcResultHandlers.print());
	}
	
	@Test
	void getTopAlbumsSuccess() throws Exception {
		when(recommendationService.getPlaylists()).thenReturn("Albums");
		mockMvc.perform(get("/api/v1/recommend/top-albums").contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk()).andDo(MockMvcResultHandlers.print());
	}
	
	@Test
	void getAllGenresSuccess() throws Exception {
		when(recommendationService.getPlaylists()).thenReturn("Success");
		mockMvc.perform(get("/api/v1/recommend/all-genres").contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk()).andDo(MockMvcResultHandlers.print());
	}

}
