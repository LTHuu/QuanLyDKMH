
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DTO.DangKiDTO;

public class DangKiDAO {

	private Connection conn;

	public DangKiDAO(Connection conn) {
		this.conn = conn;
	}

	// Hàm đọc toàn bộ dữ liệu
	public List<DangKiDTO> getAllDangKi() throws SQLException {
		List<DangKiDTO> list = new ArrayList<>();
		String sql = "SELECT * FROM DangKi";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			String maSV = rs.getString("MaSV");
			String ngDK = rs.getString("NgDK");
			String maHP = rs.getString("MaHP");

			DangKiDTO dangKi = new DangKiDTO(maSV, ngDK, maHP);
			list.add(dangKi);
		}

		rs.close();
		pstmt.close();

		return list;
	}

	// Hàm thêm 1 dòng dữ liệu
	public boolean themDangKi(DangKiDTO dangKi) throws SQLException {
		String sql = "INSERT INTO DangKi (MaSV, NgDK, MaHP) VALUES (?, ?, ?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, dangKi.getMaSV());
		pstmt.setString(2, dangKi.getNgDK());
		pstmt.setString(3, dangKi.getMaHP());
		int rowsAffected = pstmt.executeUpdate();
		pstmt.close();

		return rowsAffected > 0;
	}

	// Hàm xóa toàn bộ dữ liệu
	public boolean xoaTatCaDangKi() throws SQLException {
		String sql = "DELETE FROM DangKi";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		int rowsAffected = pstmt.executeUpdate();
		pstmt.close();

		return rowsAffected > 0;
	}

	// Hàm xóa 1 dòng dữ liệu
	public boolean xoaDangKi(DangKiDTO dangKi) throws SQLException {
		String sql = "DELETE FROM DangKi WHERE MaSV = ? AND NgDK = ? AND MaHP = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, dangKi.getMaSV());
		pstmt.setString(2, dangKi.getNgDK());
		pstmt.setString(3, dangKi.getMaHP());
		int rowsAffected = pstmt.executeUpdate();
		pstmt.close();

		return rowsAffected > 0;
	}

	// Hàm cập nhật dòng dữ liệu
	public boolean capNhatDangKi(DangKiDTO dangKi) throws SQLException {
		String sql = "UPDATE DangKi SET NgDK = ? WHERE MaSV = ? AND MaHP = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, dangKi.getNgDK());
		pstmt.setString(2, dangKi.getMaSV());
		pstmt.setString(3, dangKi.getMaHP());
		int rowsAffected = pstmt.executeUpdate();
		pstmt.close();

		return rowsAffected > 0;
	}
}
