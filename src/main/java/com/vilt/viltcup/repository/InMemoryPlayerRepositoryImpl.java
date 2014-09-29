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
		players.put(1, new Player(1, "Messi"));
		players.put(2, new Player(2, "Ronaldo"));
		players.put(3, new Player(3, "Diego Costa"));
		players.put(4, new Player(4, "Pepe"));
		players.put(5, new Player(5, "Figo"));
		players.put(6, new Player(6, "Nani"));
		players.put(7, new Player(7, "Mossoro"));
		players.put(8, new Player(8, "Toti"));
		players.put(9, new Player(9, "Neuer"));
		players.put(10, new Player(10, "Pirlo"));
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
