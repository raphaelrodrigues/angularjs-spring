package com.vilt.viltcup.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vilt.viltcup.model.Game;
import com.vilt.viltcup.model.Player;
import com.vilt.viltcup.model.RailwayStation;
import com.vilt.viltcup.service.GameService;
import com.vilt.viltcup.service.PlayerService;

@Controller
@RequestMapping("/players")
public class PlayerController {

	@Autowired
	private PlayerService playerService;

	@RequestMapping("/playerslist.json")
	public @ResponseBody List<Player> showPlayers() throws IOException {
		System.out.println("sdsdsd");
		for (Player it : playerService.getAll()) {
			System.out.println(it.getName());
		}
		return playerService.getAll();
	}

	@RequestMapping(value = "/add/{name}", method = RequestMethod.POST)
	public @ResponseBody void addCar(@PathVariable("name") String name) {
		System.out.println("asasdasdasdd");
		Player p = new Player(name);
		playerService.addPlayer(p);
		for (Player it : playerService.getAll()) {
			System.out.println(it.getName());
		}
	}

}
