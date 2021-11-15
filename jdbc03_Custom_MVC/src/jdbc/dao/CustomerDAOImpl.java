package jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import jdbc.vo.Customer;

public class CustomerDAOImpl implements CustomerDAO {
	private static CustomerDAOImpl dao = new CustomerDAOImpl();
	
	private CustomerDAOImpl() {
		System.out.println("DAO Imple Createing");
	}
	
	public static CustomerDAOImpl getInstance() {
		return dao;
	}
	
	@Override
	public Connection getConnect() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void closeAll(PreparedStatement ps, Connection conn) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void closeAll(PreparedStatement ps, Connection conn, ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void registerCustomer(Customer vo) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteCustomer(int num) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateCustomer(Customer vo) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Customer getCustomer(int num) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Customer> getAllCustomer() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	
}
