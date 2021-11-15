package jdbc.test1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnectionTest {
	
	// 1. 드라이버 로딩 (드라이버는 정보를 가지고 있는..?)
	DBConnectionTest(){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("로딩 성공");
			
			// 2. DB 서버 연결
			
			String url = "jdbc:mysql://127.0.0.1:3306/scott?serverTimezone=UTC&useUnicode=yes&characterEncoding=UTF-8"; 
			
			Connection conn = DriverManager.getConnection(url, "root", "1234");
			System.out.println("서버 연결 성공");
			
			// 3. PreparedStatement 객체 생성
			/*String query = "INSERT INTO custom (num, name, addr) VALUES(?,?,?)"; //1,2,3
			PreparedStatement ps = conn.prepareStatement(query);
			
			// 4. ?값 바인딩 -> 쿼리문 실행 -> 1, 2, 3
			ps.setInt(1, 333);
			ps.setString(2, "sw");
			ps.setString(3, "HNC");
			
			ps.executeUpdate();*/
			
			// 기본키는 수정의 대상이 될 수 없다
/*			String query = "UPDATE custom Set name=?, addr=? WHERE num=?";
			PreparedStatement ps = conn.prepareStatement(query);
			
			System.out.println("쿼리 실행 완료");
			
			ps.setString(1, "sw");
			ps.setString(2, "Seoul");
			ps.setInt(3, 333);
			
			int row = ps.executeUpdate();
			
			System.out.println(row + " row(s) update success");
*/
			
				
/*			String query = "DELETE FROM custom WHERE num=?";
			PreparedStatement ps = conn.prepareStatement(query);
			
			System.out.println("쿼리 실행 완료");
		
			ps.setInt(1, 333);
			
			int row = ps.executeUpdate();
			
			System.out.println(row + " row(s) delete success");
*/			
			
			String query = "SELECT * FROM custom";
			
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) { // BOE에서 element가 있는 곳으로 한 단계 내려감
				int num = rs.getInt("num");
				String name = rs.getString("name");
				String addr = rs.getString("addr");;
				
				System.out.println(num +"\t |"+ name + "\t |"+ addr);
			}
			
		}catch(ClassNotFoundException e) {
			System.out.println("로딩 실패");
			
		}catch(SQLException e) {
			System.out.println("DB 서버 연결 실패");
		}
		
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new DBConnectionTest();
	}

}
