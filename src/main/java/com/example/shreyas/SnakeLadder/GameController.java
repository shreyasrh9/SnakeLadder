package com.example.shreyas.SnakeLadder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.shreyas.util.GuidUtil;
import com.google.gson.GsonBuilder;

@Controller
public class GameController {
	@RequestMapping("/")
	public String login() {
		return "index";
	}

	@ResponseBody
	@RequestMapping(value = "/gameBoard", method = RequestMethod.POST)
	public GameModel generateGameBoard(@RequestBody String gameDetails, Model model, HttpSession session)
			throws Exception {

		GameModel gameModel = new GsonBuilder().create().fromJson(gameDetails, GameModel.class);
		List<Integer> pitStops = new ArrayList<Integer>();

		List<Integer> trampolines = new ArrayList<Integer>();

		List<Integer> elevators = new ArrayList<Integer>();

		List<Integer> magicSquares = new ArrayList<Integer>();

		List<Integer> memorySqaures = new ArrayList<Integer>();

		String[] snakeSplit = gameModel.getSnakes().split(",");
		String[] ladderSplit = gameModel.getLadders().split(",");

		String[] hungerLevelSplit = snakeSplit[1].split("-");

		Map<Integer, Integer> snakeMap = new HashMap<Integer, Integer>();
		snakeMap.put(Integer.parseInt(snakeSplit[0]), Integer.parseInt(hungerLevelSplit[0]));

		gameModel.setSnakeEnergy(Integer.parseInt(hungerLevelSplit[1]));

		Map<Integer, Integer> ladderMap = new HashMap<Integer, Integer>();
		ladderMap.put(Integer.parseInt(ladderSplit[0]), Integer.parseInt(ladderSplit[1]));

		gameModel.setLadderMap(ladderMap);
		gameModel.setSnakeMap(snakeMap);

		int iteration = -1;

		int number = gameModel.getNumberOfSquares();

		int counter = number;

		int energy = number / 3;

		String[] pitStopSplit = gameModel.getPitStopSquare().split("-");

		int pitStop = Integer.parseInt(pitStopSplit[0]);

		int pitStopEnergy = Integer.parseInt(pitStopSplit[1]);

		String html = "";

		int sqrt = (int) Math.sqrt(number);
		
		gameModel.setUserLocation(1);
		
		gameModel.setCompLocation(1);

		int loopCount = 0;
		boolean ulStarted = false;
		boolean ulClosed = true;

		while (counter > 0) {// start while

			if (loopCount % sqrt == 0 && counter != number) {// checks if the
																// counter is at
																// a
				if (ulStarted && !ulClosed) {
					html += "</ul><br>";
					ulClosed = true;
					ulStarted = false;
				}

				if (iteration == -1) {
					// subtract sqrt from the counter
					// and sets it to start adding by one
					counter -= sqrt - 1;
					iteration = 1;

				} else {
					counter -= sqrt + 1;
					if (counter < 1) {
						break;
					}
					iteration = -1;
				}

			}

			if (counter != 0) {
				int x = counter;

				String ls = "";
				String ps = "";
				String trampoline = "";
				String elevator = "";
				String memory = "";
				String magic = "";

				for (Map.Entry<Integer, Integer> entry : gameModel.getLadderMap().entrySet()) {
					if (x == entry.getKey()) {
						ls = "<div> L(" + x + "," + entry.getValue() + ")</div>";
						break;
					}

					if (x == entry.getValue()) {
						ls = "<div> L(" + x + "," + entry.getKey() + ")</div>";
						break;
					}
				}

				for (Map.Entry<Integer, Integer> entry : gameModel.getSnakeMap().entrySet()) {
					if (x == entry.getKey()) {
						ls = "<div> S(" + x + "," + entry.getValue() + ")E-" + gameModel.getSnakeEnergy() + "</div>";
						break;
					}

					if (x == entry.getValue()) {
						ls = "<div> S(" + x + "," + entry.getKey() + ")E-" + gameModel.getSnakeEnergy() + "</div>";
						break;
					}
				}

				if (counter == pitStop) {
					ps = "<div id='ps_" + counter + "'>ps - " + pitStopEnergy + "</div>";
					pitStops.add(counter);
				}

				if (counter == gameModel.getTrampoline()) {
					trampoline = "<div id='trampoline_" + counter + "'>trampoline </div>";
					trampolines.add(counter);
				}

				if (counter == gameModel.getElevator()) {
					elevator = "<div id='elevator_" + counter + "'>elevator </div>";
					elevators.add(counter);
				}

				if (counter == gameModel.getMemorySqaure()) {
					memory = "<div id='memory_" + counter + "'>memory </div>";
					memorySqaures.add(counter);
				}

				if (counter == gameModel.getMagicSquare()) {
					magic = "<div id='magic_" + counter + "'>magic </div>";
					magicSquares.add(counter);
				}

				if (!ulStarted && ulClosed) {
					html += "<ul class='flex-container' style='margin-top:7%'>";
					ulStarted = true;
					ulClosed = false;
				}
				html += "<li><div id='div_" + counter + "'>" + counter + "</div>" + ls + ps + elevator + trampoline
						+ memory + magic + "<span id='player1Loc_"+counter+"' class='glyphicon glyphicon-asterisk' style='display:none'>P1</span><span id='player2Loc_"+counter+"' class='glyphicon glyphicon-star' style='display:none'>P2</span></li>";

			}

			counter += iteration; // sets counter to add by iteration
			loopCount++;
		}

		gameModel.setGameHtml(html);

		gameModel.setEnergy(energy);
		gameModel.setUserLocation(1);
		gameModel.setCompLocation(1);
		
		gameModel.setP1Chance(true);
		gameModel.setP2Chance(false);

		session.setAttribute("session_id", GuidUtil.getId());

		session.setAttribute("AppUser", gameModel);

		return gameModel;
	}
	
	@ResponseBody
	@RequestMapping(value = "/diceRolled", method = RequestMethod.POST)
	public GameModel diceRolled(@RequestBody String gameDetails, Model model, HttpSession session)
			throws Exception {
		GameModel gameModel = new GsonBuilder().create().fromJson(gameDetails, GameModel.class);
		int currentPosition = 0;
		if(gameModel.isP1Chance()){
			currentPosition = gameModel.getUserLocation();
			gameModel.setP1Chance(false);
			gameModel.setP2Chance(true);
		}else{
			currentPosition = gameModel.getCompLocation();
			gameModel.setP1Chance(true);
			gameModel.setP2Chance(false);
		}
		
		
		
		return gameModel;
	}

}
