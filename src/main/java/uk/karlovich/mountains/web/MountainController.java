package uk.karlovich.mountains.web;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import uk.karlovich.mountains.data.*;

@RestController
public class MountainController {
	
	@Autowired
	private JdbcDataInterchange jdbcClient;

	@RequestMapping("/")
	public String index() {
		this.testMethod();
		return "Welcome to the Mountains API!";
	}
	
	@RequestMapping("/jdbc-test")
	public String jdbcTest() {
		String dbResult = jdbcClient.testJdbc("public.test");
		return dbResult;
	}
	
	private void testMethod() {
		System.out.println("Successfully running API");
	}
}
