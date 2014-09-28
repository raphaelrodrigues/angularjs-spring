package com.vilt.viltcup.repository;

import java.util.List;

import com.vilt.viltcup.model.Player;


public interface PlayerRepository {

	public List<Player> findAll();

	public void save(Player player);

	public void delete(int id);

}