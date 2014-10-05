package com.vilt.viltcup.model;


import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class Game {
	private int id;
	private List<Player> team1;
	private List<Player> team2;
	private int result_team1;
	private int result_team2;
	private Date date_of_game;
	private Date created_at;
	
	public Game(){
		
	}
	
	public Game(int id, List<Player> team1, List<Player> team2,
			int result_team1, int result_team2, Date date_of_game,
			Date created_at) {
		
		this.id = 43;
		this.team1 = team1;
		this.team2 = team2;
		this.result_team1 = result_team1;
		this.result_team2 = result_team2;
		this.date_of_game = date_of_game;
		this.created_at = created_at;
	}

	public Game(int id) {
		super();
		this.id = id;
	}
	
	public Game(int id, Date date_of_game, Date created_at) {
		this.id = id;
		this.date_of_game = date_of_game;
		this.created_at = created_at;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	public List<Player> getTeam1() {
		return team1;
	}
	public void setTeam1(List<Player> team1) {
		this.team1 = team1;
	}
	public List<Player> getTeam2() {
		return team2;
	}
	public void setTeam2(List<Player> team2) {
		this.team2 = team2;
	}
	public int getResult_team1() {
		return result_team1;
	}
	public void setResult_team1(int result_team1) {
		this.result_team1 = result_team1;
	}
	public int getResult_team2() {
		return result_team2;
	}
	public void setResult_team2(int result_team2) {
		this.result_team2 = result_team2;
	}
	public Date getDate_of_game() {
		return date_of_game;
	}
	public void setDate_of_game(Date date_of_game) {
		this.date_of_game = date_of_game;
	}
	public Date getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}
	
	
	
}