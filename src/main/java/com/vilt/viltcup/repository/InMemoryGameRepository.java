package com.vilt.viltcup.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.vilt.viltcup.model.Game;

@Repository
public class InMemoryGameRepository implements GameRepository {
	private Map<Integer, Game> games = new HashMap<Integer, Game>();

	public InMemoryGameRepository() {
		games.put(1, new Game(1));
		games.put(2, new Game(1));
	}

	/* (non-Javadoc)
	 * @see com.vilt.tvshows.repository.GameRepository#findAll()
	 */
	/* (non-Javadoc)
	 * @see com.vilt.viltcup.repository.GameRepository#findAll()
	 */
	public List<Game> findAll() {
		return new ArrayList<Game>(games.values());
	}

	/* (non-Javadoc)
	 * @see com.vilt.tvshows.repository.GameRepository#save(com.vilt.tvshows.model.Game)
	 */
	/* (non-Javadoc)
	 * @see com.vilt.viltcup.repository.GameRepository#save(com.vilt.viltcup.model.Game)
	 */
	public void save(Game game) {
		int id = 1;
		while (games.get(id) != null) {
			id++;
		}
		System.out.println(game.toString());
		game.setId(id);
		games.put(id, game);
	}

	/* (non-Javadoc)
	 * @see com.vilt.tvshows.repository.GameRepository#delete(int)
	 */
	/* (non-Javadoc)
	 * @see com.vilt.viltcup.repository.GameRepository#delete(int)
	 */
	public void delete(int id) {
		games.remove(id);
	}
}
