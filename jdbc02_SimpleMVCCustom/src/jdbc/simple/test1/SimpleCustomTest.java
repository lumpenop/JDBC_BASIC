package jdbc.simple.test1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import config.ServerInfo;

// JDBC 프로그램을 조금 더 구조적으로..?

// Business Logic : 중요한 로직 - DAL (Database Access Logic)
// method 단위마다 꼭 해야할 일
//	1. Connection 리턴 (DB 서버 연결)
//	2. 쿼리문을 인자값으로 PreparedStatement 생성
//	3. 바인딩
//	4. 쿼리문 실행
//	5. 자원 close
/*
 *  고정 부분 - 공통 기능으로 작성 (재사용) : 1, 5 
 *  가변 부분 - 따로 작성 : 나머지
 */
public class SimpleCustomTest {
	
	//// 메소드 단위별 반복되는 기능 정의 ////
	
	public Connection getConnect() throws SQLException{
		Connection conn = DriverManager.getConnection(ServerInfo.URL,ServerInfo.USER,ServerInfo.PASS);
		System.out.println("DBServer Connet....");
		return conn;
	}
	
	public void closeAll(PreparedStatement ps, Connection conn) throws SQLException{
		if(ps != null) ps.close();
		if(conn != null) conn.close();
	}
	
	// closeAll() 메소드 오버로딩
	public void closeAll(PreparedStatement ps, Connection conn, ResultSet rs) throws SQLException{
		if(rs != null) rs.close();
		closeAll(ps, conn);
	}

	// 생성자 있음
	
	
	// DML에 해당하는 기능 정의

	// INSERT
	
	public void addCustom(int num, String name, String addr) throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = getConnect();
			
			System.out.println("DB Server Connect");
			String query = "INSERT INTO custom (num, name, addr) VALUES(?,?,?)";
			
			ps = conn.prepareStatement(query);
			
			ps.setInt(1, num);
			ps.setString(2, name);
			ps.setString(3, addr);
			
			ps.executeUpdate();
			System.out.println(name + "님 회원가입 완료");
			
		}finally {
			
			closeAll(ps, conn);
		}
		
	}
	
	// DELETE
	public void removeCustom(int num) throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			
			conn = getConnect();
			System.out.println("DB Server Connect");
			String query = "DELETE FROM custom WHERE num=?";
			
			ps = conn.prepareStatement(query);
			
			ps.setInt(1, num);
			
			ps.executeUpdate();
			System.out.println("회원번호" + num + "회원탈퇴 완료");
			
		}finally {
			closeAll(ps, conn);
		}
	}
	
	// UPDATE
	
	public void updateCustom(int num, String name, String addr) throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = getConnect();
			
			String query = "UPDATE custom SET name=?, addr=?, WHERE num=?";
			
			ps = conn.prepareStatement(query);
			
			ps.setString(1, name);
			ps.setString(2, addr);
			ps.setInt(3, num);
			
			ps.executeUpdate();
			System.out.println(name + "님의 정보가 수정되었습니다.");
			
		}finally{
			closeAll(ps, conn);
		}
	}
	
	// SELECT ALL
	
	public void printAllCustom() throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = getConnect();
			
			String query = "SELECT * FROM custom";
			ps = conn.prepareStatement(query);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				System.out.println(rs.getInt("num") + " "
								  +rs.getString("name") + " "
								  +rs.getString("addr"));
			}
			
			
		}finally {
			
			closeAll(ps, conn, rs);
		}
	}
	
	
	// SELECT 
	
	
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		
		SimpleCustomTest service = new SimpleCustomTest();
		
//		service.addCustom(444, "john", "London");
		
		service.printAllCustom();
		
	}//
	
	
	// static initialization - main 보다 먼저 실행됨
	
	static {
		try {
			Class.forName(ServerInfo.DRIVER);
			System.out.println("Driver Loading Success");
		}catch(ClassNotFoundException e) {
			System.out.println("Driver Loading Fail");
		}
	}
	
	

}
