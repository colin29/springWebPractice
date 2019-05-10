package colin29.court.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import colin29.court.service.DataStoreService;

@Controller
@RequestMapping("/database")
public class DatabaseController {

	private DataStoreService dataStoreService;

	@Autowired
	public DatabaseController(DataStoreService dataStoreService) {
		this.dataStoreService = dataStoreService;
	}

	@RequestMapping(value = { "", "/" }, method = RequestMethod.GET)
	public String testDatabaseAccess() {
		dataStoreService.countEmployees();
		dataStoreService.getEmployees();
		return "placeholder";
	}

}
