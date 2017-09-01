package com.example.shreyas.SnakeLadder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Scope;

@Scope("session")
public class GameModel {
	private Map<Integer, Integer> ladderMap;
	private Map<Integer, Integer> snakeMap;
	private Map<Integer, Integer> snakeMapEnergy;
	private Map<Integer, Integer> ladderMapEnergy;
	private Map<Integer, String> memoryMap;
	private Map<Integer, String> magicMap;
	private Map<Integer, String> trampolineMap;
	private Map<Integer, String> elevatorMap;
	private Map<Integer, Integer> pitStopMap;
	private String gameHtml;
	private Integer energy;
	private Integer userLocation;
	private Integer compLocation;
	private String snakes;
	private boolean p1Chance;
	private boolean p2Chance;
	private String ladders;
	
	
	private String trampoline;
	private String elevator;
	private Integer numberOfPLayers;
	private String memorySqaure;
	private String magicSquare;
	private Integer numberOfSquares;
	private String pitStopSquare;
	private Integer diceValue;
	private Integer currentGamePostion;
	private Integer p1Energy;
	private Integer p2Energy;
	private boolean p1Magic;
	private boolean p2Magic;
	private Map<Integer, Integer> p1GameStep = new HashMap<Integer, Integer>();
	private Map<Integer, Integer> p2GameStep = new HashMap<Integer, Integer>();
	private Integer p1Step;
	private Integer p2Step;
	private String message;
	private String successMessage;
	
	
	
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
	public Map<Integer, String> getTrampolineMap() {
		return trampolineMap;
	}
	public void setTrampolineMap(Map<Integer, String> trampolineMap) {
		this.trampolineMap = trampolineMap;
	}
	public Map<Integer, String> getElevatorMap() {
		return elevatorMap;
	}
	public void setElevatorMap(Map<Integer, String> elevatorMap) {
		this.elevatorMap = elevatorMap;
	}
	public String getTrampoline() {
		return trampoline;
	}
	public void setTrampoline(String trampoline) {
		this.trampoline = trampoline;
	}
	public String getElevator() {
		return elevator;
	}
	public void setElevator(String elevator) {
		this.elevator = elevator;
	}
	public String getMemorySqaure() {
		return memorySqaure;
	}
	public void setMemorySqaure(String memorySqaure) {
		this.memorySqaure = memorySqaure;
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
	public Integer getCurrentGamePostion() {
		return currentGamePostion;
	}
	public void setCurrentGamePostion(Integer currentGamePostion) {
		this.currentGamePostion = currentGamePostion;
	}
	public Integer getP1Energy() {
		return p1Energy;
	}
	public void setP1Energy(Integer p1Energy) {
		this.p1Energy = p1Energy;
	}
	public Integer getP2Energy() {
		return p2Energy;
	}
	public void setP2Energy(Integer p2Energy) {
		this.p2Energy = p2Energy;
	}
	public boolean isP1Magic() {
		return p1Magic;
	}
	public void setP1Magic(boolean p1Magic) {
		this.p1Magic = p1Magic;
	}
	public boolean isP2Magic() {
		return p2Magic;
	}
	public void setP2Magic(boolean p2Magic) {
		this.p2Magic = p2Magic;
	}
	public Map<Integer, Integer> getP1GameStep() {
		return p1GameStep;
	}
	public void setP1GameStep(Map<Integer, Integer> p1GameStep) {
		this.p1GameStep = p1GameStep;
	}
	public Map<Integer, Integer> getP2GameStep() {
		return p2GameStep;
	}
	public void setP2GameStep(Map<Integer, Integer> p2GameStep) {
		this.p2GameStep = p2GameStep;
	}
	public Integer getP1Step() {
		return p1Step;
	}
	public void setP1Step(Integer p1Step) {
		this.p1Step = p1Step;
	}
	public Integer getP2Step() {
		return p2Step;
	}
	public void setP2Step(Integer p2Step) {
		this.p2Step = p2Step;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getSuccessMessage() {
		return successMessage;
	}
	public void setSuccessMessage(String successMessage) {
		this.successMessage = successMessage;
	}
	public Map<Integer, String> getMemoryMap() {
		return memoryMap;
	}
	public void setMemoryMap(Map<Integer, String> memoryMap) {
		this.memoryMap = memoryMap;
	}
	public Map<Integer, String> getMagicMap() {
		return magicMap;
	}
	public void setMagicMap(Map<Integer, String> magicMap) {
		this.magicMap = magicMap;
	}
	public String getMagicSquare() {
		return magicSquare;
	}
	public void setMagicSquare(String magicSquare) {
		this.magicSquare = magicSquare;
	}
	public Map<Integer, Integer> getPitStopMap() {
		return pitStopMap;
	}
	public void setPitStopMap(Map<Integer, Integer> pitStopMap) {
		this.pitStopMap = pitStopMap;
	}
	public Map<Integer, Integer> getSnakeMapEnergy() {
		return snakeMapEnergy;
	}
	public void setSnakeMapEnergy(Map<Integer, Integer> snakeMapEnergy) {
		this.snakeMapEnergy = snakeMapEnergy;
	}
	public Map<Integer, Integer> getLadderMapEnergy() {
		return ladderMapEnergy;
	}
	public void setLadderMapEnergy(Map<Integer, Integer> ladderMapEnergy) {
		this.ladderMapEnergy = ladderMapEnergy;
	}
	
	
}
