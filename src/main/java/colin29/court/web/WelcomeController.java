package colin29.court.web;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import colin29.court.Logging;

@Controller
@RequestMapping("/")
public class WelcomeController {

	@RequestMapping(value = { "/", "/welcome/*" }, method = RequestMethod.GET)
	public String welcome(Model model) {

		System.out.println("getting stuff");

		Logging.logger.info("Got a request in method welcome in " + new Throwable()
				.getStackTrace()[0]
						.getMethodName()
				+ " from " + getClass().getSimpleName());

		Date today = new Date();
		model.addAttribute("today", today);
		return "welcome";
	}
}