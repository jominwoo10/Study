package user;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {
	private Connection conn; //자바와 데이터베이스를 연결
	private PreparedStatement pstmt; //쿼리문 대기 및 설정
	private ResultSet rs; //결과값 받아오기
	//기본 생성자
	//UserDAO가 실행되면 자동으로 생성되는 부분
	//메소드마다 반복되는 코드를 이곳에 넣으면 코드가 간소화된다
	public UserDAO() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dbURL = "jdbc:mysql://localhost:3306/jspproject?useSSL=false&useUnicode=yes&characterEncoding=UTF-8";
			String dbID = "root";
			String dbPassword = "jsp2021";
			conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int login(String id, String password) {
		String sql = "select password from userinfo where id = ?";
		try {
			pstmt = conn.prepareStatement(sql); //sql쿼리문을 대기 시킨다
			pstmt.setString(1, id); //첫번째 '?'에 매개변수로 받아온 'id'를 대입
			rs = pstmt.executeQuery(); //쿼리를 실행한 결과를 rs에 저장
			if(rs.next()) {
				if(rs.getString(1).equals(password)) {
					return 1; //로그인 성공
				}else
					return 0; //비밀번호 틀림
			}
			return -1; //아이디 없음
		}catch (Exception e) {
			e.printStackTrace();
		}
		return -2; //오류
	}
	
	public int join(User user) {
		  String sql = "insert into userinfo values( ?, ?, ?, ?)";
		  try {
		    pstmt = conn.prepareStatement(sql);
		    pstmt.setString(1, user.getName());
		    pstmt.setString(2, user.getId());
		    pstmt.setString(3, user.getPassword());
		    pstmt.setString(4, user.getEmail());
		    return pstmt.executeUpdate();
		  }catch (Exception e) {
		 	e.printStackTrace();
		  }
		  return -1;
		}
	
		public User getuser(String id) {
			String sql = "select * from userinfo where id = ?";
			try {
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, id);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					User user = new User();
					user.setNum(rs.getInt(1));
					user.setName(rs.getString(2));
					user.setId(rs.getString(3));
					user.setPassword(rs.getString(4));
					user.setEmail(rs.getString(5));
					return user;
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
		
		//게시글 수정 메소드
		public int update(String userPassword,String userName,String userGender,String userEmail,String userID) {
			String sql = "update user set userPassword = ?, userName =?, userGender=?, userEmail=? where userID = ?";
			try {
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, userPassword);
				pstmt.setString(2, userName);
				pstmt.setString(3, userGender);
				pstmt.setString(4, userEmail);
				pstmt.setString(5, userID);
				return pstmt.executeUpdate();
			}catch (Exception e) {
				e.printStackTrace();
			}
			return -1; //데이터베이스 오류
		}

}
