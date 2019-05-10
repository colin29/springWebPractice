package colin29.court.datastore;

import java.util.List;

import colin29.court.domain.bank.Employee;
import colin29.court.service.DataStoreService;

public class DataStoreServiceImpl implements DataStoreService {

	private EmployeeDAO employeeDAO;

	public DataStoreServiceImpl(EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}

	@Override
	public int countEmployees() {
		return employeeDAO.countEmployees();
	}

	@Override
	public List<Employee> getEmployees() {
		return employeeDAO.queryAllEmployees();
	}

}
