package com.example.shreyas.SnakeLadder;

import java.util.List;
import java.util.Map;

public class GameModel {
	private Map<Integer, Integer> ladderMap;
	private Map<Integer, Integer> snakeMap;
	private String gameHtml;
	private Integer energy;
	private Integer userLocation;
	private Integer compLocation;
	private List<Integer> pitStops;
	
	
	public Map<Integer, Integer> getLadderMap() {
		return ladderMap;
	}
	public void setLadderMap(Map<Integer, Integer> ladderMap) {
		this.ladderMap = ladderMap;
	}
	public Map<Integer, Integer> getSnakeMap() {
		return snakeMap;
	}
	public void setSnakeMap(Map<Integer, Integer> snakeMap) {
		this.snakeMap = snakeMap;
	}
	public String getGameHtml() {
		return gameHtml;
	}
	public void setGameHtml(String gameHtml) {
		this.gameHtml = gameHtml;
	}
	public Integer getEnergy() {
		return energy;
	}
	public void setEnergy(Integer energy) {
		this.energy = energy;
	}
	public Integer getUserLocation() {
		return userLocation;
	}
	public void setUserLocation(Integer userLocation) {
		this.userLocation = userLocation;
	}
	public Integer getCompLocation() {
		return compLocation;
	}
	public void setCompLocation(Integer compLocation) {
		this.compLocation = compLocation;
	}
	public List<Integer> getPitStops() {
		return pitStops;
	}
	public void setPitStops(List<Integer> pitStops) {
		this.pitStops = pitStops;
	}
	
	
}
