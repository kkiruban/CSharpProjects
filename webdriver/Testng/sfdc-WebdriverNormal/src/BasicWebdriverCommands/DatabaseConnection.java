package BasicWebdriverCommands;

import java.sql.DriverManager;
import java.sql.SQLException;

import org.testng.annotations.Test;

public class DatabaseConnection {
  
	@Test
  public void f() throws SQLException {
	
		
		DriverManager.getConnection("", "", "");
		
  }
	
}
