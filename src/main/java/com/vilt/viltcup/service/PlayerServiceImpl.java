package com.vilt.viltcup.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.vilt.viltcup.model.Player;
import com.vilt.viltcup.repository.PlayerRepository;


@Service
public class PlayerServiceImpl implements PlayerService {
	
	@Autowired
	@Qualifier("a") 
	private PlayerRepository playerRepository;
	
	/* (non-Javadoc)
	 * @see com.vilt.tvshows.service.PlayerService#getAll()
	 */
	public List<Player> getAll() {
		return playerRepository.findAll();
	}
	
	/* (non-Javadoc)
	 * @see com.vilt.tvshows.service.PlayerService#addPlayer(com.vilt.tvshows.model.Player)
	 */
	public void addPlayer(Player player) {
		playerRepository.save(player);
	}
	
	/* (non-Javadoc)
	 * @see com.vilt.tvshows.service.PlayerService#deletePlayer(int)
	 */
	public void deletePlayer(int id) {
		playerRepository.delete(id);
	}
}