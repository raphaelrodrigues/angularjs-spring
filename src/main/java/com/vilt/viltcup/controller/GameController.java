package com.vilt.viltcup.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vilt.viltcup.model.Game;
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

	@RequestMapping("/layout")
	public String getCarPartialPage() {
		return "games/layout";
	}
}
