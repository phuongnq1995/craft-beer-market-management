package org.assignment.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Phuongnq
 * Home controller handle client request
 */
@Controller
public class HomeController {

	private static final String HOME_PATH = "home/homepage";

	/**
	 * Handle root request
	 * @return HOME_PATH
	 */
	@RequestMapping(value = "/")
	public String home(Model model) {
		return HOME_PATH;
	}

}
