package com.vilt.viltcup.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vilt.viltcup.model.Game;
import com.vilt.viltcup.model.Player;
import com.vilt.viltcup.service.GameService;
import com.vilt.viltcup.service.PlayerService;

@Controller
@RequestMapping("/results")
public class ResultController {
	
	@Autowired
	private GameService gameService;
	
	@Autowired
	private PlayerService playerService;
	
	@RequestMapping("/classification.json")
	public @ResponseBody List<Player> showGames() throws IOException {
		System.out.println("cenas");
		return playerService.getAll();
	}
	

	@RequestMapping("/layout")
	public String getCarPartialPage() {
		return "results/layout";
	}
}
