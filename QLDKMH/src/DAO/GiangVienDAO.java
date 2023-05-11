package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import BUS.GiangVienBUS;
import DTO.GiangVien;
import main.JDBConnect;

public class GiangVienDAO {
	public ArrayList<GiangVien> ReadData() {
		ArrayList<GiangVien> list = new ArrayList<GiangVien>();
		try {
			Connection conn = JDBConnect.getConnection();
			java.sql.Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM GiangVien");

			while (rs.next()) {
				String magv = rs.getString("MAGV");
				String tengv = rs.getString("TENGV");
				String email = rs.getString("EMAIL");
				String sdt = rs.getString("SODT");
				String khoa = rs.getString("Khoa");
				String chuyen = rs.getString("Chuyen");

				list.add(new GiangVien(magv, tengv, email, sdt, khoa, chuyen));
			}

			JDBConnect.closeConnection(conn);
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Boolean WriteData() {
		if (ClearData(GiangVienBUS.getDsGV())) {
			for (GiangVien temp : GiangVienBUS.getDsGV()) {
				Them(temp);
			}
			return true;
		}
		return false;
	}

	public boolean Them(GiangVien obj) {
		String sql = "INSERT INTO GiangVien(magv,tengv,email, sodt, khoa, chuyen) VALUES(?,?,?,?,?,?)";

		try (Connection conn = JDBConnect.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.setString(1, obj.getMaGV());
			stmt.setString(2, obj.getTenGV());
			stmt.setString(3, obj.getEmail());
			stmt.setString(4, obj.getSDT());
			stmt.setString(5, obj.getKhoa());
			stmt.setString(6, obj.getChuyen());

			stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	public boolean DeleteData(GiangVien obj) {
		String sql = "DELETE FROM GiangVien WHERE MAGV = '" + obj.getMaGV() + "'";

		try (Connection conn = JDBConnect.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	public Boolean ClearData(ArrayList<GiangVien> obj) {
		String sql = "DELETE FROM GiangVien";

		try (Connection conn = JDBConnect.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	public Boolean UpdateData(GiangVien newobj, String magv) {
		String sql = "UPDATE GiangVien SET MaGV = '" + newobj.getMaGV() + ",TenGV = '" + newobj.getTenGV() + ",Email= '"
				+ newobj.getEmail() + ",SODT = '" + newobj.getSDT() + "'Khoa='" + newobj.getKhoa() + "',Chuyen='"
				+ newobj.getChuyen() + "' Where MaGV = '" + magv + "'";

		try (Connection conn = JDBConnect.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}
}
