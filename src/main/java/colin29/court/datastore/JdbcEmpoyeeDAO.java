package colin29.court.datastore;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import colin29.court.domain.bank.Employee;

/**
 * Should be Thread-safe, ie. no shared state
 * 
 * @author Colin Ta
 *
 */
public class JdbcEmpoyeeDAO implements EmployeeDAO {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private final String SQL_COUNT_EMPLOYEES = "SELECT COUNT(*) FROM Employee;";
	private final String SQL_QUERY_EMPLOYEES = "SELECT * FROM Employee;";

	@Override
	public int countEmployees() {
		int result = jdbcTemplate.queryForObject(SQL_COUNT_EMPLOYEES, Integer.class);
		logger.debug("Employee Count  : " + result);
		return result;
	}

	@Override
	public List<Employee> queryAllEmployees() {
		List<Employee> employees = jdbcTemplate.query(SQL_QUERY_EMPLOYEES, new Object[] {},
				new RowMapper<Employee>() {
					@Override
					public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
						Employee e = new Employee();
						e.setEmployeeId(rs.getInt("emp_id"));
						e.setFname(rs.getString("fname"));
						e.setLname(rs.getString("lname"));
						e.setTitle(rs.getString("title"));
						e.setAssignedBranchId(rs.getInt("assigned_branch_id"));
						return e;
					}

				});

		logger.debug("\n" + getEmployeesListString(employees));

		return employees;
	}

	private String getEmployeesListString(List<Employee> employees) {
		TableStringBuilder t = new TableStringBuilder();

		t.addColumnsTitles("employeeId", "fname", "lname", "title", "assignedBranchId");

		for (Employee e : employees) {
			t.addRow(String.valueOf(e.getEmployeeId()), e.getFname(), e.getLname(), e.getTitle(),
					String.valueOf(e.getAssignedBranchId()));
		}
		return t.getTableString();

	}
}
