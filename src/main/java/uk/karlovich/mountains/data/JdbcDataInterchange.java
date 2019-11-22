package uk.karlovich.mountains.data;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import uk.karlovich.mountains.AppConfiguration;

/**
 * A class that uses JDBC to connect to the database
 * @author Ryland
 *
 */
@Component
public class JdbcDataInterchange {
	
	@Autowired
	private AppConfiguration config;

	/**
	 * An example method which tests getting some data through a JDBC connection
	 */
	public String testJdbc(String tableName) {
		List<String> values = new ArrayList<>();
		
		String SQL_SELECT = "Select * from public.test";
		
		try (Connection conn = DriverManager.getConnection(config.getUrl(), config.getUsername(), config.getPassword());
				PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT)) {
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			// Add result display values to a String list - simplest object model, useful for further operations
			while (resultSet.next()) {
				String display = resultSet.getString("test");
				values.add(display);
			}

			// Add each of the resulting values to a semicolon-separated string for output
			if (values.size() > 0) {
				String output = "";
	            for (int i = 0; i < values.size(); i++) {
	            		output = output.concat(values.get(i));
	            		if (i < values.size()-1) {
	            			output = output.concat("; ");
	            		}
	            }
	            return output;
            } else {
            		return "Table " + tableName + " is empty";
            }

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        } 
		return "Something went wrong!";
	}
}
