package jdbc.client;

import java.sql.SQLException;

import config.ServerInfo;
import jdbc.dao.CustomerDAOImpl;
import jdbc.vo.Customer;

public class CustomerClientTest {
	
	static {
		try {
			Class.forName(ServerInfo.DRIVER);
			System.out.println("Driver Loading Success");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Driver Loading Fail");
		}
	}

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		CustomerDAOImpl dao  = CustomerDAOImpl.getInstance();
		dao.registerCustomer(new Customer(444,"아이유", "방배동"));
	}

}
