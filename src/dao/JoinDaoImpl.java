package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import conn.DBConnect;
import model.Member;

public class JoinDaoImpl implements JoinDao {

	private DBConnect db;

	public JoinDaoImpl() {
		db = DBConnect.getInstance();
	}

	@Override
	public void insert(Member m) {
		Connection conn = null;

		// db에 한 줄 추가하는 sql
		String sql = "insert into member2 values(?, ?, ?, ?)";

		PreparedStatement pstmt = null;

		try {
			// 커넥션 객체 획득
			conn = db.getConnection();

			// java에서 sql을 실행하는 PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);

			// sql의 ? 파라메터 매칭
			pstmt.setString(1, m.getId());
			pstmt.setString(2, m.getPwd());
			pstmt.setString(3, m.getName());
			pstmt.setString(4, m.getEmail());

			// sql 실행
			pstmt.executeQuery();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// 자원 반환
				pstmt.close();
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	}

	@Override
	public Member select(String id) {
		Connection conn = null;
		ResultSet rs = null;
		Member m = null;
		String sql = "select * from member2 where id = ?";
		PreparedStatement pstmt = null;

		try {
			// 커넥션 객체 획득
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return new Member(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// 자원 반환
				rs.close();
				pstmt.close();
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		return null;
	}

	@Override
	public void update(Member m) {
		Connection conn = null;

		// db에 값 변경하는 sql
		String sql = "update member2 set pwd = ?, name = ?, email = ? where id = ?";

		PreparedStatement pstmt = null;

		try {
			// 커넥션 객체 획득
			conn = db.getConnection();

			// java에서 sql을 실행하는 PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			
			// sql의 ? 파라메터 매칭
			pstmt.setString(1, m.getPwd());
			pstmt.setString(2, m.getName());
			pstmt.setString(3, m.getEmail());
			pstmt.setString(4, m.getId());
			
			// sql 실행
			pstmt.executeQuery();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// 자원 반환
				pstmt.close();
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	@Override
	public void delete(String id) {
		Connection conn = null;
		
		String sql = "delete member2 where id=?";
		
		PreparedStatement pstmt = null;
		try {
			// 커넥션 객체 획득
			conn = db.getConnection();
			
			// java에서 sql을 실행하는 PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			
			// sql의 ? 파라미터 매칭
			pstmt.setString(1, id);
			
			// sql 실행
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// 자원 반환
				pstmt.close();
				conn.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
	}
}
