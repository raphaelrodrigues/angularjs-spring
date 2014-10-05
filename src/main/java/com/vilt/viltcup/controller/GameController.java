package com.vilt.viltcup.controller;

import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vilt.viltcup.model.Game;
import com.vilt.viltcup.model.Player;
import com.vilt.viltcup.model.RailwayStation;
import com.vilt.viltcup.service.GameService;

@Controller
@RequestMapping("/games")
public class GameController {

	@Autowired
	private GameService gameService;

	@RequestMapping("/gameslist.json")
	public @ResponseBody List<Game> showGames() throws IOException {
		System.out.println("cenas");

		return gameService.getAll();
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public @ResponseBody void addGame(@RequestBody String game_json) {
		System.out.println("cenas game new" + game_json);
		//Player player = toObjectPlayer(game_json);
		//Game game = toObject(game_json);
		//gameService.addGame(game);
	}

	@RequestMapping("/layout")
	public String getCarPartialPage() {
		return "games/layout";
	}
	
	private Game toObject(String game_json) {
		Game game = null;
		ObjectMapper mapper = new ObjectMapper();
		try {
			game = mapper.readValue(game_json, Game.class);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(game);
		return game;
	}
	
	private Player toObjectPlayer(String player_json){
		Player player = null;
		ObjectMapper mapper = new ObjectMapper();
		try {
			player = mapper.readValue(player_json, Player.class);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(player);
		return player;
	}

}
