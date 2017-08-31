package com.example.shreyas.SnakeLadder;

import java.util.Map;

import org.springframework.context.annotation.Scope;

@Scope("session")
public class GameModel {
	private Map<Integer, Integer> ladderMap;
	private Map<Integer, Integer> snakeMap;
	private String gameHtml;
	private Integer energy;
	private Integer userLocation;
	private Integer compLocation;
	private String snakes;
	private boolean p1Chance;
	private boolean p2Chance;
	private String ladders;
	//private List<Integer> pitStops;
	private Integer pitStops;
	private Integer trampoline;
	private Integer elevator;
	private Integer numberOfPLayers;
	private Integer memorySqaure;
	private Integer magicSquare;
	private Integer numberOfSquares;
	private Integer snakeEnergy;
	private String pitStopSquare;
	private Integer diceValue;
	
	
	
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
	public Integer getNumberOfPLayers() {
		return numberOfPLayers;
	}
	public void setNumberOfPLayers(Integer numberOfPLayers) {
		this.numberOfPLayers = numberOfPLayers;
	}
	public Integer getPitStops() {
		return pitStops;
	}
	public void setPitStops(Integer pitStops) {
		this.pitStops = pitStops;
	}
	public Integer getTrampoline() {
		return trampoline;
	}
	public void setTrampoline(Integer trampoline) {
		this.trampoline = trampoline;
	}
	public Integer getElevator() {
		return elevator;
	}
	public void setElevator(Integer elevator) {
		this.elevator = elevator;
	}
	public Integer getMemorySqaure() {
		return memorySqaure;
	}
	public void setMemorySqaure(Integer memorySqaure) {
		this.memorySqaure = memorySqaure;
	}
	public Integer getMagicSquare() {
		return magicSquare;
	}
	public void setMagicSquare(Integer magicSquare) {
		this.magicSquare = magicSquare;
	}
	public String getSnakes() {
		return snakes;
	}
	public void setSnakes(String snakes) {
		this.snakes = snakes;
	}
	public String getLadders() {
		return ladders;
	}
	public void setLadders(String ladders) {
		this.ladders = ladders;
	}
	public Integer getNumberOfSquares() {
		return numberOfSquares;
	}
	public void setNumberOfSquares(Integer numberOfSquares) {
		this.numberOfSquares = numberOfSquares;
	}
	public Integer getSnakeEnergy() {
		return snakeEnergy;
	}
	public void setSnakeEnergy(Integer snakeEnergy) {
		this.snakeEnergy = snakeEnergy;
	}
	public String getPitStopSquare() {
		return pitStopSquare;
	}
	public void setPitStopSquare(String pitStopSquare) {
		this.pitStopSquare = pitStopSquare;
	}
	public boolean isP1Chance() {
		return p1Chance;
	}
	public void setP1Chance(boolean p1Chance) {
		this.p1Chance = p1Chance;
	}
	public boolean getP2Chance() {
		return p2Chance;
	}
	public void setP2Chance(boolean p2Chance) {
		this.p2Chance = p2Chance;
	}
	public Integer getDiceValue() {
		return diceValue;
	}
	public void setDiceValue(Integer diceValue) {
		this.diceValue = diceValue;
	}
	
	
}
