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
						ls = "<div id='snake_" + x + "'> S(" + x + "," + entry.getValue() + ")<span id='ene_" + x
								+ "'>E-" + gameModel.getSnakeEnergy() + "</span></div>";
						break;
					}

					if (x == entry.getValue()) {
						ls = "<div id='snake_" + x + "'> S(" + x + "," + entry.getKey() + ")<span id='ene_" + x
								+ "'>E-" + gameModel.getSnakeEnergy() + "</span></div>";
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
						+ memory + magic + "<span id='player1Loc_" + counter
						+ "' class='glyphicon glyphicon-asterisk' style='display:none'>P1</span><span id='player2Loc_"
						+ counter + "' class='glyphicon glyphicon-star' style='display:none'>P2</span></li>";

			}

			counter += iteration; // sets counter to add by iteration
			loopCount++;
		}

		gameModel.setGameHtml(html);

		gameModel.setEnergy(energy);
		gameModel.setP1Energy(energy);
		gameModel.setP2Energy(energy);
		gameModel.setUserLocation(1);
		gameModel.setCompLocation(1);
		gameModel.setP1Step(1);
		gameModel.setP2Step(1);
		gameModel.setPitStops(pitStops);

		gameModel.setP1Chance(true);
		gameModel.setP2Chance(false);

		session.setAttribute("session_id", GuidUtil.getId());

		session.setAttribute("AppUser", gameModel);

		return gameModel;
	}

	@ResponseBody
	@RequestMapping(value = "/diceRolled", method = RequestMethod.POST)
	public GameModel diceRolled(@RequestBody String gameDetails, Model model, HttpSession session) throws Exception {
		GameModel gameModel = new GsonBuilder().create().fromJson(gameDetails, GameModel.class);
		int currentPosition = 0;

		gameModel.setMessage("");
		gameModel.setSuccessMessage("");

		if (gameModel.isP1Chance()) {

			currentPosition = gameModel.getUserLocation();
			if (currentPosition != 1) {
				gameModel.setP1Step(gameModel.getP1Step() + 1);
			}
			if (gameModel.getP1Energy() == 0) {
				gameModel.setUserLocation(1);
				return gameModel;
			}

			gameModel.setP1Energy(gameModel.getP1Energy() - 1);
		} else {

			if (gameModel.getP2Energy() == 0) {
				gameModel.setCompLocation(1);
				return gameModel;
			}

			currentPosition = gameModel.getCompLocation();
			if (currentPosition != 1) {
				gameModel.setP2Step(gameModel.getP2Step() + 1);
			}
			gameModel.setP2Energy(gameModel.getP2Energy() - 1);
		}

		if (gameModel.isP1Chance()) {
			if (gameModel.isP1Magic()) {
				currentPosition -= gameModel.getDiceValue();
			} else {
				currentPosition += gameModel.getDiceValue();
			}
		} else {

			if (gameModel.isP2Magic()) {
				currentPosition -= gameModel.getDiceValue();
			} else {
				currentPosition += gameModel.getDiceValue();
			}

		}

		if (currentPosition == gameModel.getMagicSquare()) {
			if (gameModel.isP1Chance()) {
				if (gameModel.isP1Magic()) {
					gameModel.setP1Magic(false);
				} else {
					gameModel.setP1Magic(true);
				}
			} else {
				if (gameModel.isP2Magic()) {
					gameModel.setP2Magic(false);
				} else {
					gameModel.setP2Magic(true);
				}
			}
		}

		if (gameModel.getTrampoline() == currentPosition) {
			currentPosition += gameModel.getDiceValue();
		}

		if (gameModel.getElevator() == currentPosition) {
			int x = gameModel.getDiceValue();

			if (x % 2 == 0) {
				currentPosition = ((int) Math.sqrt(gameModel.getNumberOfSquares()) * x) + currentPosition;
			} else {
				currentPosition = (((int) Math.sqrt(gameModel.getNumberOfSquares()) * (x + 1)) - (currentPosition - 1));
			}

		}

		if (gameModel.getLadderMap().get(currentPosition) != null) {
			if (gameModel.getUserLocation() != gameModel.getLadderMap().get(currentPosition)
					&& gameModel.getCompLocation() != gameModel.getLadderMap().get(currentPosition))
				currentPosition = gameModel.getLadderMap().get(currentPosition);
		}

		if (gameModel.getSnakeMap().get(currentPosition) != null) {
			if (gameModel.getSnakeEnergy() > 0) {
				currentPosition = gameModel.getSnakeMap().get(currentPosition);
				gameModel.setSnakeEnergy(gameModel.getSnakeEnergy() - 1);
			}
		}

		if (gameModel.isP1Chance()) {

			if (currentPosition == gameModel.getNumberOfSquares()) {
				gameModel.setSuccessMessage("Congrats!!! P1 Wins.");
				return gameModel;
			}

			if (currentPosition > gameModel.getNumberOfSquares()) {
				gameModel.setMessage("Sorry!! You should reach " + gameModel.getNumberOfSquares()
						+ " to win. You cannot exceed " + gameModel.getNumberOfSquares());
			} else {
				gameModel.setUserLocation(currentPosition);
			}
			gameModel.setP1Chance(false);
			gameModel.setP2Chance(true);
			for (Integer pitStop : gameModel.getPitStops()) {
				if (currentPosition == pitStop) {
					gameModel.setP1Energy(gameModel.getP1Energy() + gameModel.getEnergy());
				}
			}

			if (currentPosition == gameModel.getMemorySqaure()) {
				if (gameModel.getP1GameStep().get(gameModel.getDiceValue()) != null) {
					gameModel.setUserLocation(gameModel.getP1GameStep().get(gameModel.getDiceValue()));
				} else {
					gameModel.setUserLocation(1);
				}
			}

			Map<Integer, Integer> p1Step = gameModel.getP1GameStep();
			p1Step.put(gameModel.getP1Step(), gameModel.getUserLocation());
			gameModel.setP1GameStep(p1Step);
			if (currentPosition < 1) {
				gameModel.setMessage("Sorry!! You cannot go below 0. Your magic feature is disabled now.");
				gameModel.setUserLocation(1);
				gameModel.setP1Magic(false);
			}
		} else {

			if (currentPosition == gameModel.getNumberOfSquares()) {
				gameModel.setSuccessMessage("Congrats!!! P2 Wins.");
				gameModel = null;
				return gameModel;
			}

			if (currentPosition > gameModel.getNumberOfSquares()) {
				gameModel.setMessage("Sorry!! You should reach " + gameModel.getNumberOfSquares()
						+ " to win. You cannot exceed " + gameModel.getNumberOfSquares());
			} else {
				gameModel.setCompLocation(currentPosition);
			}
			gameModel.setP1Chance(true);
			gameModel.setP2Chance(false);
			for (Integer pitStop : gameModel.getPitStops()) {
				if (currentPosition == pitStop) {
					gameModel.setP2Energy(gameModel.getP2Energy() + gameModel.getEnergy());
				}
			}

			if (currentPosition == gameModel.getMemorySqaure()) {
				if (gameModel.getP1GameStep().get(gameModel.getDiceValue()) != null) {
					gameModel.setCompLocation(gameModel.getP2GameStep().get(gameModel.getDiceValue()));
				} else {
					gameModel.setCompLocation(1);
				}
			}

			Map<Integer, Integer> p2Step = gameModel.getP2GameStep();
			p2Step.put(gameModel.getP2Step(), gameModel.getCompLocation());
			gameModel.setP2GameStep(p2Step);
			if (currentPosition < 1) {
				gameModel.setMessage("Sorry!! You cannot go below 0. Your magic feature is disabled now.");
				gameModel.setCompLocation(1);
				gameModel.setP2Magic(false);
			}
		}

		gameModel.setCurrentGamePostion(currentPosition);

		return gameModel;
	}

}
