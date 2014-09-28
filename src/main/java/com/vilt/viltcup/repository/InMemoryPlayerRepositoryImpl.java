package com.vilt.viltcup.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.vilt.viltcup.model.Player;

@Component(value="a")
public class InMemoryPlayerRepositoryImpl implements PlayerRepository {

	private Map<Integer, Player> players = new HashMap<Integer, Player>();

	public InMemoryPlayerRepositoryImpl() {
		players.put(1, new Player(1, "Lionel"));
		players.put(2, new Player(2, "Ronaldo"));
	}

	/* (non-Javadoc)
	 * @see com.vilt.tvshows.repository.PlayerRepository#findAll()
	 */
	public List<Player> findAll() {
		return new ArrayList<Player>(players.values());
	}

	/* (non-Javadoc)
	 * @see com.vilt.tvshows.repository.PlayerRepository#save(com.vilt.tvshows.model.Player)
	 */
	public void save(Player player) {
		int id = 1;
		while (players.get(id) != null) {
			id++;
		}
		System.out.println(player.toString());
		player.setId(id);
		players.put(id, player);
	}

	/* (non-Javadoc)
	 * @see com.vilt.tvshows.repository.PlayerRepository#delete(int)
	 */
	public void delete(int id) {
		players.remove(id);
	}
	
	
}
