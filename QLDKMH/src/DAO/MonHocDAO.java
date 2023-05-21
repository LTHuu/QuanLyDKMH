package DAO;

import DTO.GiangVien;
import DTO.MonHoc;
import main.JDBConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MonHocDAO {
	
	public ArrayList<MonHoc> ReadData() {
		ArrayList<MonHoc> list = new ArrayList<MonHoc>();
		try {
			Connection conn = JDBConnect.getConnection();
			java.sql.Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM MonHoc");

			while (rs.next()) {
				MonHoc mh = new MonHoc();
				mh.setMaMH(rs.getString("MaMH"));
				mh.setTenMH(rs.getString("TenMH"));
				mh.setSoTC(rs.getInt("SoTC"));
				mh.setMonHocTrc(rs.getString("MonHocTrc"));
				list.add(mh);
			}

			JDBConnect.closeConnection(conn);
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean Them(MonHoc mh) {
		String sql = "INSERT INTO MonHoc (MaMH, TenMH, SoTC,MonHocTrc) VALUES (?, ?, ?, ?)";

		try (Connection conn = JDBConnect.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.setString(1, mh.getMaMH());
			stmt.setString(2, mh.getTenMH());
			stmt.setInt(3, mh.getSoTC());
			stmt.setString(2, mh.getMonHocTrc());

			stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}
	
	public Boolean UpdateData(MonHoc mh) {
		String sql = "UPDATE MonHoc SET TenMH=?, SoTC=?, MonHocTrc=? WHERE MaMH=?";

		try (Connection conn = JDBConnect.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.setString(1, mh.getTenMH());
			stmt.setInt(2, mh.getSoTC());
			stmt.setString(3, mh.getMonHocTrc());
			stmt.setString(4, mh.getMaMH());
			
			stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}
	
	public boolean DeleteData(MonHoc obj) {
		String sql = "DELETE FROM MonHoc WHERE MaMH=?";

		try (Connection conn = JDBConnect.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	public Boolean ClearData() {
		String sql = "DELETE FROM MonHoc";

		try (Connection conn = JDBConnect.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}
}
