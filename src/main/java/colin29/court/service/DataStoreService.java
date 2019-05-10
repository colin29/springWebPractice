package colin29.court.service;

import java.util.List;

import colin29.court.domain.bank.Employee;

public interface DataStoreService {
	public int countEmployees();

	public List<Employee> getEmployees();
}
