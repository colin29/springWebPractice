package colin29.court.controllers;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import colin29.court.Logging;

@Controller
@RequestMapping({ "/welcome" })
public class WelcomeController {

	private static final Logger logger = LoggerFactory.getLogger(WelcomeController.class);

	@RequestMapping("")
	public String mainPage(Model model,
			HttpServletRequest request,
			HttpServletResponse response) {
		Logging.logRequest();
		Date today = new Date();
		model.addAttribute("today", today);
		return "welcome";
	}

	@RequestMapping(value = { "/custom", "/custom.html", "/custom/*.html" }, method = RequestMethod.GET)
	public String custom(Model model, HttpServletRequest request) {

		Logging.logRequest();
		Date today = new Date();
		model.addAttribute("today", today);

		logger.debug(request.getRequestURL().toString());

		return "customWelcome";
	}
}