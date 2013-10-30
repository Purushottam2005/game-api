package com.firstProject.controllers;

import com.firstProject.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * Author: Øyvind Bjerke
 * Date: 10/21/13
 * Time: 1:12 PM
 */
@Controller
@RequestMapping("/game/delete/{id}")
public class DeleteGameController {

	@Autowired
	GameRepository gameRepository;

	@RequestMapping(method = RequestMethod.DELETE)
	public ModelAndView deleteGame(@PathVariable Long id, HttpServletRequest request) {

		gameRepository.delete(id);

		return new ModelAndView(new RedirectView(request.getContextPath() + "/index"));
	}
}
