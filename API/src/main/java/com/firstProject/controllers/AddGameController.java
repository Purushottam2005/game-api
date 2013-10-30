package com.firstProject.controllers;

import com.firstProject.model.Game;
import com.firstProject.repositories.GameRepository;
import com.firstProject.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.PersistenceException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * Author: Øyvind Bjerke
 * Date: 10/17/13
 * Time: 3:54 PM
 */
@Controller
@RequestMapping(value = "/addGame")
public class AddGameController {
	Logger logger = LoggerFactory.getLogger(AddGameController.class);

	@Autowired
	private GameRepository gameRepository;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView showAddGameView(ModelMap model){
		model.addAttribute("titleAttr", "Add Game");
		model.addAttribute("game", new Game());
		model.addAttribute("actionUrl", "addGame");
		return new ModelAndView("editGame", model);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView addGame(ModelMap model, @Valid @ModelAttribute("game") Game game, BindingResult result, HttpServletRequest request)
	{
		model.addAttribute("titleAttr", "Add Game");
		model.addAttribute("actionUrl", "addGame");

		if(result.hasErrors()){
			return new ModelAndView("editGame", model);
		}
		model.addAttribute("game", game);
		try{
			game = gameRepository.save(game);
		}
		catch(PersistenceException e){
			Utils.addMessage(model, "game.exists", request.getContextPath() + "/game/" + gameRepository.findByNameIgnoreCase(game.getName()).getId(), game.getName());
			return new ModelAndView("editGame", model);
		}
		Utils.addMessage(model, "game.saved", request.getContextPath() + "/game/" + game.getId(), game.getName());
		return new ModelAndView("editGame", model);
	}
}
