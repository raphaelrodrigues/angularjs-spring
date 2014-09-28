package com.vilt.viltcup.repository;

import java.util.List;

import com.vilt.viltcup.model.Game;

public interface GameRepository {

	/* (non-Javadoc)
	 * @see com.vilt.tvshows.repository.GameRepository#findAll()
	 */
	public abstract List<Game> findAll();

	/* (non-Javadoc)
	 * @see com.vilt.tvshows.repository.GameRepository#save(com.vilt.tvshows.model.Game)
	 */
	public abstract void save(Game game);

	/* (non-Javadoc)
	 * @see com.vilt.tvshows.repository.GameRepository#delete(int)
	 */
	public abstract void delete(int id);

}