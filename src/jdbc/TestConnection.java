package jdbc;

import java.io.IOException;
import java.sql.SQLException;

public class TestConnection {
	public static void main(String [] args) throws ClassNotFoundException, IOException, SQLException{
		ConnectDB connectDB = new ConnectDB();
		connectDB.connectToDatabase();
	}

}
