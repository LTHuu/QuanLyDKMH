package DAO;

import DTO.MonHoc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MonHocDAO {
	private Connection conn;

	public MonHocDAO(Connection conn) {
		this.conn = conn;
	}

	public ArrayList<MonHoc> getAllMonHoc() throws SQLException {
		ArrayList<MonHoc> list = new ArrayList<>();
		String sql = "SELECT * FROM MonHoc";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			MonHoc mh = new MonHoc();
			mh.setMaMH(rs.getString("MaMH"));
			mh.setTenMH(rs.getString("TenMH"));
			mh.setSoTC(rs.getInt("SoTC"));
			list.add(mh);
		}
		rs.close();
		pstmt.close();
		return list;
	}

	public void addMonHoc(MonHoc mh) throws SQLException {
		String sql = "INSERT INTO MonHoc (MaMH, TenMH, SoTC) VALUES (?, ?, ?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, mh.getMaMH());
		pstmt.setString(2, mh.getTenMH());
		pstmt.setInt(3, mh.getSoTC());
		pstmt.executeUpdate();
		pstmt.close();
	}

	public void updateMonHoc(MonHoc mh) throws SQLException {
		String sql = "UPDATE MonHoc SET TenMH=?, SoTC=? WHERE MaMH=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, mh.getTenMH());
		pstmt.setInt(2, mh.getSoTC());
		pstmt.setString(3, mh.getMaMH());
		pstmt.executeUpdate();
		pstmt.close();
	}

	public void deleteMonHoc(String maMH) throws SQLException {
		String sql = "DELETE FROM MonHoc WHERE MaMH=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, maMH);
		pstmt.executeUpdate();
		pstmt.close();
	}

	public void deleteAllMonHoc() throws SQLException {
		String sql = "DELETE FROM MonHoc";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.executeUpdate();
		pstmt.close();
	}
}
