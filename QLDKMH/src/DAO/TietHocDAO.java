package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.*;
import java.util.List;

import DTO.GiangVien;
import DTO.HocPhan;
import DTO.TietHoc;
import main.JDBConnect;

public class TietHocDAO {

	public ArrayList<TietHoc> ReadData() {
		ArrayList<TietHoc> list = new ArrayList<TietHoc>();
		try {
			Connection conn = JDBConnect.getConnection();
			java.sql.Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM TietHoc");

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
				list.add(th);
			}

			JDBConnect.closeConnection(conn);
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean Them(TietHoc th) {
		String sql = "INSERT INTO TietHoc(MaTH, GioBD,NgHoc,SoTiet, LoaiTietHoc,Lop,Phong,MAHP) VALUES (?, ?, ?, ?, ?,?,?,?)";

		try (Connection conn = JDBConnect.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.setString(1, th.getMaTH());
			stmt.setString(2, th.getGioBD());
			stmt.setString(3, th.getNgay());
			stmt.setInt(4, th.getSoTiet());
			stmt.setString(5, th.getLoaiTH());
			stmt.setString(6, th.getLop());
			stmt.setString(7, th.getPhong());
			stmt.setString(8, th.getMaHP());

			stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	public void updateTietHoc(TietHoc th) {
		String sql = "UPDATE tiet_hoc SET GioBD = ?, NgBD = ?, NgHoc = ?, SoTiet = ?,LoaiTietHoc = ?,Lop = ?, Phong = ?,MAHP = ? WHERE MaTH = ?";
		try (Connection conn = JDBConnect.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, th.getGioBD());
			pstmt.setString(2, th.getNgay());
			pstmt.setInt(3, th.getSoTiet());
			pstmt.setString(4, th.getLoaiTH());
			pstmt.setString(5, th.getLop());
			pstmt.setString(6, th.getPhong());
			pstmt.setString(7, th.getMaHP());
			pstmt.setString(8, th.getMaTH());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void deleteTietHoc(TietHoc th) {
		String sql = "DELETE FROM TietHoc WHERE MaTH = ?";
		try (Connection conn = JDBConnect.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, th.getMaTH());
			stmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void deleteAllTietHoc() {
		String sql = "DELETE FROM TietHoc";
		try (Connection conn = JDBConnect.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
