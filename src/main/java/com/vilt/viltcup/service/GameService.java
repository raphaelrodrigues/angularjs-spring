package com.vilt.viltcup.service;

import java.util.List;

import com.vilt.viltcup.model.Game;

public interface GameService {

	/* (non-Javadoc)
	 * @see com.vilt.tvshows.service.GameService#getAll()
	 */
	public abstract List<Game> getAll();

	/* (non-Javadoc)
	 * @see com.vilt.tvshows.service.GameService#addGame(com.vilt.tvshows.model.Game)
	 */
	public abstract void addGame(Game Game);

	/* (non-Javadoc)
	 * @see com.vilt.tvshows.service.GameService#deleteGame(int)
	 */
	public abstract void deleteGame(int id);

}