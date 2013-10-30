package com.firstProject.controllers;

import com.firstProject.repositories.GameRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * Author: Øyvind Bjerke
 * Date: 10/17/13
 * Time: 3:54 PM
 */
@Controller
@RequestMapping("/index")
public class IndexController {
	Logger logger = LoggerFactory.getLogger(IndexController.class);

	@Autowired
	private GameRepository gameRepository;

	@RequestMapping(method = RequestMethod.GET)
	public String listGames(ModelMap model) {
		model.addAttribute("games", gameRepository.findAll());
		return "index";
	}
}
