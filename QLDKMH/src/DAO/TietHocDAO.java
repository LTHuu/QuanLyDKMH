package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.*;
import java.util.List;

import DTO.HocPhan;
import DTO.TietHoc;

public class TietHocDAO {
	private Connection conn;

	public TietHocDAO(Connection conn) {
		this.conn = conn;
	}

	public List<TietHoc> getAllTietHoc() throws SQLException {
		List<TietHoc> tietHocs = new ArrayList<>();
		String sql = "SELECT * FROM TietHoc";
		try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
			while (rs.next()) {
				TietHoc th = new TietHoc();
				th.setMaTH(rs.getString("MaTH"));
				th.setLoaiTH(rs.getString("LoaiTietHoc"));
				th.setGioBD(rs.getString("GioBD"));
				th.setNgay(rs.getString("NgHoc"));
				th.setLop(rs.getString("Lop"));
				th.setPhong(rs.getString("Phong"));
				th.setSoTiet(rs.getInt("SoTiet"));
				th.setMaHP(rs.getString("MAHP"));
				tietHocs.add(th);
			}
		}
		return tietHocs;
	}

	public void addTietHoc(TietHoc th) throws SQLException {
		String sql = "INSERT INTO TietHoc(MaTH, GioBD,NgHoc,SoTiet, LoaiTietHoc,Lop,Phong,MAHP) VALUES (?, ?, ?, ?, ?,?,?,?)";
		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, th.getMaTH());
			pstmt.setString(2, th.getGioBD());
			pstmt.setString(3, th.getNgay());
			pstmt.setInt(4, th.getSoTiet());
			pstmt.setString(5, th.getLoaiTH());
			pstmt.setString(6, th.getLop());
			pstmt.setString(7, th.getPhong());
			pstmt.setString(8, th.getMaHP());
			pstmt.executeUpdate();
		}
	}

	public void updateTietHoc(TietHoc th) throws SQLException {
		String sql = "UPDATE tiet_hoc SET GioBD = ?, NgBD = ?, NgHoc = ?, SoTiet = ?,LoaiTietHoc = ?,Lop = ?, Phong = ?,MAHP = ? WHERE MaTH = ?";
		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, th.getGioBD());
			pstmt.setString(2, th.getNgay());
			pstmt.setInt(3, th.getSoTiet());
			pstmt.setString(4, th.getLoaiTH());
			pstmt.setString(5, th.getLop());
			pstmt.setString(6, th.getPhong());
			pstmt.setString(7, th.getMaHP());
			pstmt.setString(8, th.getMaTH());
			pstmt.executeUpdate();
		}
	}

	public void deleteTietHoc(TietHoc th) throws SQLException {
		String sql = "DELETE FROM TietHoc WHERE MaTH = ?";
		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, th.getMaTH());
			pstmt.executeUpdate();
		}
	}

	public void deleteAllTietHoc() throws SQLException {
		String sql = "DELETE FROM TietHoc";
		try (Statement stmt = conn.createStatement()) {
			stmt.executeUpdate(sql);
		}
	}
}
