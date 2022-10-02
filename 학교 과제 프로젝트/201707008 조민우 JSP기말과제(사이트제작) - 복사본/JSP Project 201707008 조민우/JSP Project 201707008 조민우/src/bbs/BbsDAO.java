package bbs;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
public class BbsDAO {
		// dao : 데이터베이스 접근 객체의 약자
		private Connection conn; // connection:db에접근하게 해주는 객체
		//private PreparedStatement pstmt;
		private ResultSet rs;
		// mysql 처리부분
		public BbsDAO() {
			// 생성자를 만들어준다.
			try {
				String dbURL = "jdbc:mysql://localhost:3306/jspproject?&useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
				String dbID = "root";
				String dbPassword = "jsp2021";
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		//현재의 시간을 가져오는 함수
		public String getDate() { 
			String SQL = "SELECT NOW()";
			try {
				PreparedStatement pstmt = conn.prepareStatement(SQL);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					return rs.getString(1);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return ""; //데이터베이스 오류
		}
		
		//bbsID 게시글 번호 가져오는 함수
			public int getNext() { 
				String SQL = "SELECT num FROM write_content ORDER BY num DESC";
				try {
					PreparedStatement pstmt = conn.prepareStatement(SQL);
					rs = pstmt.executeQuery();
					if(rs.next()) {
						return rs.getInt(1) + 1;
					}
					return 1;//첫 번째 게시물인 경우
				} catch (Exception e) {
					e.printStackTrace();
				}
				return -1; //데이터베이스 오류
			}
			
			//실제로 글을 작성하는 함수
			public int write(String bbsTitle,String bbsContent) { 
				String SQL = "INSERT INTO write_content(title,content) VALUES(?, ?)";
				try {
					PreparedStatement pstmt = conn.prepareStatement(SQL);
					pstmt.setString(1, bbsTitle);
					pstmt.setString(2, bbsContent);
					return pstmt.executeUpdate();
				} catch (Exception e) {
					e.printStackTrace();
				}
				return -1; //데이터베이스 오류
			}
			public ArrayList<Bbs> getList(int pageNumber){ 
				String SQL = "SELECT num,title,content,time FROM write_content WHERE num < ? available = 1 ORDER BY num DESC LIMIT 10";
				ArrayList<Bbs> list = new ArrayList<Bbs>();
				try {
					PreparedStatement pstmt = conn.prepareStatement(SQL);
					pstmt.setInt(1, getNext() - (pageNumber -1) * 10);
					rs = pstmt.executeQuery();
					while (rs.next()) {
						Bbs bbs = new Bbs();
						bbs.setNum(rs.getInt(1));
						bbs.setTitle(rs.getString(2));
						bbs.setContent(rs.getString(3));
						bbs.setTime(rs.getString(4));
						list.add(bbs);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				return list; 
			}
			
			//10 단위 페이징 처리를 위한 함수
			public boolean nextPage (int pageNumber) {
				String SQL = "SELECT num,title,content,time FROM write_content WHERE num < ? available = 1 ORDER BY num DESC LIMIT 10";
				ArrayList<Bbs> list = new ArrayList<Bbs>();
				try {
					PreparedStatement pstmt = conn.prepareStatement(SQL);
					pstmt.setInt(1, getNext() - (pageNumber -1) * 10);
					rs = pstmt.executeQuery();
					if (rs.next()) {
						return true;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				return false; 		
			}

	}
