package com.vilt.viltcup.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.vilt.viltcup.model.Game;
import com.vilt.viltcup.model.Player;

@Repository
public class InMemoryGameRepository implements GameRepository {
	private Map<Integer, Game> games = new HashMap<Integer, Game>();

	public InMemoryGameRepository() {
		InMemoryPlayerRepositoryImpl playersRepo= new InMemoryPlayerRepositoryImpl();
		List<Player> players = playersRepo.findAll();
		
		Game g = new Game(1);
		g.setResult_team1(3);
		g.setResult_team2(1);
		g.setTeam1(players);
		List<Player> team1 = new ArrayList<Player>();
		List<Player> team2 = new ArrayList<Player>();
		int i = 0;
		for (Player p : players) {
			if( i >= 5 )
				team1.add(p);
			else
				team2.add(p);
			i++;
		}
		g.setTeam1(team1);
		g.setTeam2(team2);
		
		games.put(1, g);
		//games.put(2, g);
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
