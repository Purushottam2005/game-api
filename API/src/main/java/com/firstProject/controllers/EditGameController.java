package com.firstProject.controllers;

import com.firstProject.model.Game;
import com.firstProject.repositories.GameRepository;
import com.firstProject.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.EntityManagerFactoryUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;


/**
 * Author: Øyvind Bjerke
 * Date: 10/21/13
 * Time: 2:11 PM
 */
@Controller
@RequestMapping("/game/edit/{id}")
public class EditGameController {

	Logger logger = LoggerFactory.getLogger(AddGameController.class);

	@Autowired
	private GameRepository gameRepository;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView showAddGameView(ModelMap model, @PathVariable Long id) {
		model.addAttribute("game", gameRepository.findOne(id));
		model.addAttribute("titleAttr", "Edit");
		model.addAttribute("actionUrl", "game/edit/" + id);
		return new ModelAndView("editGame", model);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView saveEditedGame(ModelMap model,  @ModelAttribute("game") @Valid Game newGame, BindingResult result, @PathVariable Long id, HttpServletRequest request) {

		model.addAttribute("titleAttr", "Edit");
		model.addAttribute("actionUrl", "game/edit/" + id);

		if(result.hasErrors()){
			return new ModelAndView("editGame", model);
		}

		Game game = gameRepository.findOne(id);
		model.addAttribute("header", "Edit");

		/*if(isNewGameDifferentThanGame(newGame, game)){
			model.addAttribute("messageCode", "game.no.change");
			return new ModelAndView("editGame", model);
		}*/

		int oldVersion = game.getVersion();
		game = gameRepository.save(newGame);
		int newVersion = game.getVersion();
		if(newVersion != oldVersion){
			Utils.addMessage(model, "game.updated", request.getContextPath() + "/game/" + game.getId(), game.getName());
		} else {
			Utils.addMessage(model, "game.no.change");
		}
		model.addAttribute("game", game);
		return new ModelAndView("editGame", model);
	}

	private boolean isNewGameDifferentThanGame(Game newGame, Game game) {

		return (game.getName().equalsIgnoreCase(newGame.getName())) && (game.getPrice().equals(newGame.getPrice()) && (game.getYear().equals(newGame.getYear())));
	}
}
