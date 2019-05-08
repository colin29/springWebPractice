package colin29.court.controllers;

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
public class IndexPageController {

	Logger logger = LoggerFactory.getLogger(IndexPageController.class);

	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public String defaultMethod(Model model,
			HttpServletRequest request,
			HttpServletResponse response) {
		Logging.logRequest();
		return "indexPage";
	}
}
