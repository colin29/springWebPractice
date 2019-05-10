package colin29.court.datastore;

import java.util.List;

import colin29.court.domain.bank.Employee;

public interface EmployeeDAO {

	int countEmployees();

	List<Employee> queryAllEmployees();

}