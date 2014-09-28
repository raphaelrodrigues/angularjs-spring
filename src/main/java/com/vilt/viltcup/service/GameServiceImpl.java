package com.vilt.viltcup.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.vilt.viltcup.model.Game;
import com.vilt.viltcup.repository.GameRepository;

@Service
public class GameServiceImpl implements GameService {
	
	@Autowired
	private GameRepository gameRepository;
	
	/* (non-Javadoc)
	 * @see com.vilt.tvshows.service.GameService#getAll()
	 */
	public List<Game> getAll() {
		return gameRepository.findAll();
	}
	
	/* (non-Javadoc)
	 * @see com.vilt.tvshows.service.GameService#addGame(com.vilt.tvshows.model.Game)
	 */
	public void addGame(Game Game) {
		gameRepository.save(Game);
	}
	
	/* (non-Javadoc)
	 * @see com.vilt.tvshows.service.GameService#deleteGame(int)
	 */
	public void deleteGame(int id) {
		gameRepository.delete(id);
	}
}
