package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import BUS.TaiKhoanBUS;
import DTO.TaiKhoan;
import main.JDBConnect;

public class TaiKhoanDAO {
	public ArrayList<TaiKhoan> ReadData() {
		ArrayList<TaiKhoan> list = new ArrayList<TaiKhoan>();
		try {
			Connection conn = JDBConnect.getConnection();
			java.sql.Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM TaiKhoan");

			while (rs.next()) {
				String matk = rs.getString("MATK");
				String tendn = rs.getString("TENDN");
				String ngaylap = rs.getString("NGLAP");
				String email = rs.getString("EMAIL");
				String matkhau = rs.getString("MATKHAU");

				list.add(new TaiKhoan(matk, tendn, matkhau, ngaylap, email));
			}

			JDBConnect.closeConnection(conn);
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Boolean WriteData() {
		if (ClearData(TaiKhoanBUS.getDsTK())) {
			for (TaiKhoan temp : TaiKhoanBUS.getDsTK()) {
				Them(temp);
			}
			return true;
		}
		return false;
	}

	public boolean Them(TaiKhoan obj) {
		String sql = "INSERT INTO TaiKhoan(matk, tendn,nglap, email,matkhau) VALUES(?,?,?,?,?)";

		try (Connection conn = JDBConnect.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.setString(1, obj.getMaTK());
			stmt.setString(2, obj.getTenDN());
			stmt.setString(3, obj.getNgLap());
			stmt.setString(4, obj.getEmail());
			stmt.setString(5, obj.getMatKhau());
			stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	public boolean DeleteData(TaiKhoan obj) {
		String sql = "DELETE FROM TaiKhoan WHERE MATK = '" + obj.getMaTK() + "'";
		try (Connection conn = JDBConnect.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	public Boolean ClearData(ArrayList<TaiKhoan> obj) {
		String sql = "DELETE FROM TaiKhoan";

		try (Connection conn = JDBConnect.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	public Boolean UpdateData(TaiKhoan newobj, String matk) {
		String sql = "UPDATE TaiKhoan SET MATK = '" + newobj.getMaTK() + "', TENDN = '" + newobj.getTenDN()
				+ "', NGLAP ='" + newobj.getNgLap() + "',EMAIL = '" + newobj.getEmail() + "',MATKHAU = '"
				+ newobj.getMatKhau() + "' WHERE MATK='" + matk + "'";

		try (Connection conn = JDBConnect.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}
}
