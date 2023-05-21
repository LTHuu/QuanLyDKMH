package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DTO.DangKiDTO;
import DTO.GiangVien;
import DTO.HocPhan;
import main.JDBConnect;

public class HocPhanDAO {

	public HocPhanDAO() {
	}

	public ArrayList<HocPhan> ReadData() {
		ArrayList<HocPhan> list = new ArrayList<HocPhan>();
		try {
			Connection conn = JDBConnect.getConnection();
			java.sql.Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM HocPhan");

			while (rs.next()) {
				HocPhan hp = new HocPhan();
				hp.setMaHP(rs.getString("MaHP"));
				hp.setTenHP(rs.getString("TenHP"));
				hp.setNgBD(rs.getString("NgBD"));
				hp.setNgKT(rs.getString("NgKT"));
				hp.setMaHK(rs.getString("HocKy"));
				hp.setMaMH(rs.getString("MonHoc"));
				hp.setSiSo(rs.getInt("SISO"));
				hp.setSiSoToiDa(rs.getInt("SISOTOIDA"));
				hp.setMaGV(rs.getString("MaGV"));
				list.add(hp);
			}

			JDBConnect.closeConnection(conn);
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean Them(HocPhan hocPhan) {
		String sql = "INSERT INTO hocphan (MaHP, TenHP, NgBD, NgKT, MonHoc , HocKy, SISO,SISOTOIDA,MAGV) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try (Connection conn = JDBConnect.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.setString(1, hocPhan.getMaHP());
			stmt.setString(2, hocPhan.getTenHP());
			stmt.setString(3, hocPhan.getNgBD());
			stmt.setString(4, hocPhan.getNgKT());
			stmt.setString(5, hocPhan.getMaMH());
			stmt.setString(6, hocPhan.getMaHK());
			stmt.setInt(7, hocPhan.getSiSo());
			stmt.setInt(8, hocPhan.getSiSoToiDa());
			stmt.setString(9, hocPhan.getMaGV());

			stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	public boolean DeleteData(HocPhan obj) {
		String sql = "DELETE FROM HocPhan WHERE MAHP = '" + obj.getMaHP() + "'";

		try (Connection conn = JDBConnect.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	public Boolean ClearData() {
		String sql = "DELETE FROM HocPhan";

		try (Connection conn = JDBConnect.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}
	
	public Boolean UpdateData(HocPhan hp) {
		String sql = "UPDATE HocPhan SET TenHP = ?, NgBD = ? , NgKT = ?, MonHoc = ?, HocKy = ?,SISO = ?,SISOTOIDA = ?,MAGV = ? WHERE MaHP = ?";

		try (Connection conn = JDBConnect.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.setString(1, hp.getTenHP());
			stmt.setString(2, hp.getNgBD());
			stmt.setString(3, hp.getNgKT());
			stmt.setString(4, hp.getMaMH());
			stmt.setString(5, hp.getMaHK());
			stmt.setInt(6, hp.getSiSo());
			stmt.setInt(7, hp.getSiSoToiDa());
			stmt.setString(8, hp.getMaGV());
			stmt.setString(9, hp.getMaHP());
			
			stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

}
