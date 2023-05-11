package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import BUS.HocPhiBUS;
import DTO.HocPhi;
import main.JDBConnect;

public class HocPhiDAO {
	public ArrayList<HocPhi> ReadData() {
		ArrayList<HocPhi> list = new ArrayList<HocPhi>();
		try {
			Connection conn = JDBConnect.getConnection();
			java.sql.Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM HocPhi");

			while (rs.next()) {
				String mahp = rs.getString("MAHP");
				String ngdong = rs.getString("ngdong");
				float sotien = rs.getFloat("sotien");
				String masv = rs.getString("masv");
				String hocphan = rs.getString("hocphan");

				// Do something with the retrieved data
				list.add(new HocPhi(mahp, ngdong, masv, hocphan, sotien));
			}

			JDBConnect.closeConnection(conn);
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Boolean WriteData() {
		if (ClearData(HocPhiBUS.getDsHPhi())) {
			for (HocPhi temp : HocPhiBUS.getDsHPhi()) {
				Them(temp);
			}
			return true;
		}
		return false;
	}

	public boolean Them(HocPhi obj) {
		String sql = "INSERT INTO HocPhi(mahp, ngdong, sotien, masv, hocphan) VALUES(?,?,?,?,?)";

		try (Connection conn = JDBConnect.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.setString(1, obj.getMaHocPhi());
			stmt.setString(2, obj.getNgDong());
			stmt.setFloat(3, obj.getSoTien());
			stmt.setString(4, obj.getMaSV());
			stmt.setString(5, obj.getMaHP());

			stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	public boolean DeleteData(HocPhi obj) {
		String sql = "DELETE FROM HocPhi WHERE MAHP = '" + obj.getMaHocPhi() + "'";

		try (Connection conn = JDBConnect.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	public Boolean ClearData(ArrayList<HocPhi> obj) {
		String sql = "DELETE FROM HocPhi";

		try (Connection conn = JDBConnect.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	public Boolean UpdateData(HocPhi newobj, String mahphi) {
		String sql = "UPDATE HocPhi SET MaHP='" + newobj.getMaHocPhi() + "', NGDONG='" + newobj.getNgDong() + "', SoTien="
				+ newobj.getSoTien() + ", MASV='" + newobj.getMaSV() + "',HocPhan='" + newobj.getMaHP() + "'"
				+ " WHERE MaHP='" + mahphi + "'";

		try (Connection conn = JDBConnect.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}
}
