package colin29.court.datastore;

import org.apache.commons.dbcp2.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class DataStoreConfig {

	Logger logger = LoggerFactory.getLogger(DataStoreConfig.class);

	// Boiler-plate bean definitions

	@Bean
	public BasicDataSource dataSource() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		BasicDataSource d = new BasicDataSource();
		d.setUrl("jdbc:mysql://localhost:3306/bank_copy");
		d.setUsername("colin29");
		d.setPassword("123");
		d.setInitialSize(5);
		d.setMaxTotal(10);

		return d;
	}

	@Bean
	public JdbcTemplate jdbcTemplate() {
		JdbcTemplate t = new JdbcTemplate(dataSource());
		return t;
	}

	// DAO bean definitions

	@Bean
	public EmployeeDAO employeeDAO() {
		return new JdbcEmpoyeeDAO();
	}

}
