package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import BUS.KhoaBUS;
import DTO.Khoa;
import main.JDBConnect;

public class KhoaDAO {
	public ArrayList<Khoa> ReadData() {
		ArrayList<Khoa> list = new ArrayList<Khoa>();
		try {
			Connection conn = JDBConnect.getConnection();
			java.sql.Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM KHOA");

			while (rs.next()) {
				String makhoa = rs.getString("MAKHOA");
				String tenkhoa = rs.getString("TENKHOA");
				int namtl = rs.getInt("NAMTL");
				list.add(new Khoa(makhoa, tenkhoa, namtl));
			}

			JDBConnect.closeConnection(conn);
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Boolean WriteData() {
		if (ClearData(KhoaBUS.getDsKhoa())) {
			for (Khoa temp : KhoaBUS.getDsKhoa()) {
				addKhoa(temp);
			}
			return true;
		}
		return false;
	}

	public boolean addKhoa(Khoa obj) {
		String sql = "INSERT INTO KHOA(MAKHOA, TENKHOA, NAMTL) VALUES(?,?,?)";

		try (Connection conn = JDBConnect.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.setString(1, obj.getMaKhoa());
			stmt.setString(2, obj.getTenKhoa());
			stmt.setInt(3, obj.getNamTL());
			stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	public boolean DeleteData(Khoa obj) {
		String sql = "DELETE FROM KHOA WHERE MAKHOA = '" + obj.getMaKhoa() + "'";

		try (Connection conn = JDBConnect.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	public Boolean ClearData(ArrayList<Khoa> obj) {
		String sql = "DELETE FROM KHOA";

		try (Connection conn = JDBConnect.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	public Boolean UpdateData(Khoa newobj, String makhoa) {
		String sql = "UPDATE KHOA SET MAKHOA='" + newobj.getMaKhoa() + "', TENKHOA='" + newobj.getTenKhoa() + "'NamTL="
				+ newobj.getNamTL() + " WHERE MAKHOA='" + makhoa + "'";

		try (Connection conn = JDBConnect.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}
}
