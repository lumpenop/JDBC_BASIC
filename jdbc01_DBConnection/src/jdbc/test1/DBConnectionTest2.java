package jdbc.test1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnectionTest2 {
	
	public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	public static final String URL= "jdbc:mysql://127.0.0.1:3306/scott?serverTimezone=UTC&useUnicode=yes&characterEncoding=UTF-8";
	public static final String USER = "root";
	public static final String PASS = "1234";
	
	
	
	DBConnectionTest2() throws ClassNotFoundException, SQLException{
		
		
		
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			
			Class.forName(DRIVER);
			System.out.println("1. Driver Loading...");
			
			
			conn = DriverManager.getConnection(URL, USER , PASS); 
			System.out.println("2. DB Server Connect...");
			
		/*	String query = "insert into custom(num, name, addr) values(?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(query);
			System.out.println("3. PreparedStatement Creating...");
			
			ps.setInt(1, 333);
			ps.setString(2, "js");
			ps.setString(3, "LA");*/
			
			/*String query = "select * from custom";
			PreparedStatement ps = conn.prepareStatement(query);
			System.out.println("3. PreparedStatement Creating...");
			
			ResultSet rs = ps.executeQuery(query);
			
			while(rs.next()) {
				int num = rs.getInt("num");
				String name = rs.getString("name");
				String addr = rs.getString("addr");;
				
				System.out.println(num +"\t |"+ name + "\t |"+ addr);
			}*/
			
			
			
			
			String query = "select * from custom where num=?";
			
			ps = conn.prepareStatement(query);
			System.out.println("3. PreparedStatement Creating...");
			
			
			ps.setInt(1, 444);
			
			rs = ps.executeQuery();

			
			if(rs.next()) {
				System.out.println(rs.getString("name"));
			}

			
		}finally {
			rs.close();
			ps.close();
			
		}
		
		
				
		
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		// TODO Auto-generated method stub
		
		
		
		new DBConnectionTest2();
		

	}

}
