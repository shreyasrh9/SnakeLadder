package com.example.shreyas.SnakeLadder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.shreyas.util.GuidUtil;


@Controller
public class GameController {
	@RequestMapping("/")
	public String login() {
		return "index";
	}

	@ResponseBody
	@RequestMapping(value = "gameBoard/{number}", method = RequestMethod.GET)
	public GameModel getUserDetails(@PathVariable Integer number, Model model, HttpSession session) throws Exception {
		GameModel gameModel = new GameModel();

		int div = number / 60;
		int iteration = -1;
		List<Integer> pitStops = new ArrayList<Integer>();

		Map<Integer, Integer> ladderMap = new HashMap<Integer, Integer>();
		ladderMap.put(5, 13);
		ladderMap.put(11, 31);
		ladderMap.put(19, 37);
		

		Map<Integer, Integer> snakeMap = new HashMap<Integer, Integer>();
		snakeMap.put(59, 17);
		snakeMap.put(41, 23);
		snakeMap.put(53, 29);
		

		while (div != 1) {
			ladderMap.put(5 * div, 13 * div);
			ladderMap.put(11 * div, 31 * div);
			ladderMap.put(19 * div, 37 * div);
			
			snakeMap.put(59 * div, 17 * div);
			snakeMap.put(41 * div, 23 * div);
			snakeMap.put(53 * div, 29 * div);
			
			div--;
		}

		gameModel.setLadderMap(ladderMap);
		gameModel.setSnakeMap(snakeMap);

		session.setAttribute("session_id", GuidUtil.getId());

		session.setAttribute("AppUser", gameModel);

		int counter = number;
		
		int energy = number/3;

		String html = "";
		while (counter > 0) {// start while
			if (counter % 10 == 0 && counter != number) {// checks if the
															// counter is at a
															// 90, or 80...
				if (iteration == -1) {
					// subtract 9 from the counter
					// and sets it to start adding by one
					counter -= 9;
					iteration = 1;
				} else {
					int x = counter;

					String ls = "";
					String ps = "";

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
							ls = "<div> S(" + x + "," + entry.getValue() + ")</div>";
							break;
						}
						
						if (x == entry.getValue()) {
							ls = "<div> S(" + x + "," + entry.getValue() + ")</div>";
							break;
						}
					}

					if (counter % energy == 0) {
						ps = "<div id='ps_"+counter+"'>ps - "+energy+"</div>";
						pitStops.add(counter);
					}
					
					html += "<li><div id='div_"+counter+"'>" + counter +  "</div>"+ ls + ps+"</li>";
					
					
					
					
					counter -= 10;
					iteration = -1; // set the counter to start subtract by ones
				}
				if (counter != 0) {
					int x = counter;

					String ls = "";
					String ps = "";

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
							ls = "<div> S(" + x + "," + entry.getValue() + ")</div>";
							break;
						}
						
						if (x == entry.getValue()) {
							ls = "<div> S(" + x + "," + entry.getValue() + ")</div>";
							break;
						}
					}

					if (counter % energy == 0) {
						ps = "<div id='ps_"+counter+"'>ps - "+energy+"</div>";
						pitStops.add(counter);
					}
					
					html += "<li><div id='div_"+counter+"'>" + counter +  "</div>"+ ls + ps+"</li>";
				}
				
			} else {
				int x = counter;

				String ls = "";
				String ps = "";

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
						ls = "<div> S(" + x + "," + entry.getValue() + ")</div>";
						break;
					}
					
					if (x == entry.getValue()) {
						ls = "<div> S(" + x + "," + entry.getValue() + ")</div>";
						break;
					}
				}

				if (counter % energy == 0) {
					ps = "<div>Winner</div>";
					pitStops.add(counter);
				}
				
				html += "<li><div id='div_"+counter+"'>" + counter +  "</div>"+ ls + ps+"</li>";
			}
			
			counter += iteration; // sets counter to add by iteration
		}

		gameModel.setGameHtml(html);
		
		gameModel.setEnergy(energy);
		gameModel.setUserLocation(1);
		gameModel.setCompLocation(1);
		gameModel.setPitStops(pitStops);
		
		
		
		
		
		return gameModel;
	}
}
