package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import BUS.PhongHocBUS;
import DTO.PhongHoc;
import main.JDBConnect;

public class PhongHocDAO {
	public ArrayList<PhongHoc> ReadData() {
		ArrayList<PhongHoc> list = new ArrayList<PhongHoc>();
		try {
			Connection conn = JDBConnect.getConnection();
			java.sql.Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM PhongHoc");

			while (rs.next()) {
				int lau = rs.getInt("Lau");
				String maph = rs.getString("MAPH");
				String tenph = rs.getString("TENPH");
				String coso = rs.getString("COSO");
				String khu = rs.getString("KHU");

				// Do something with the retrieved data
				list.add(new PhongHoc(maph, tenph, khu, coso, lau));
			}

			JDBConnect.closeConnection(conn);
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Boolean WriteData() {
		if (ClearData(PhongHocBUS.getDsPH())) {
			for (PhongHoc temp : PhongHocBUS.getDsPH()) {
				Them(temp);
			}
			return true;
		}
		return false;
	}

	public boolean Them(PhongHoc obj) {
		String sql = "INSERT INTO PhongHoc(lau,maph,tenph,khu,coso) VALUES(?,?,?,?,?)";

		try (Connection conn = JDBConnect.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.setInt(1, obj.getLau());
			stmt.setString(1, obj.getMaPH());
			stmt.setString(2, obj.getTenPH());
			stmt.setString(3, obj.getKhu());
			stmt.setString(4, obj.getCoSo());

			stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	public boolean DeleteData(PhongHoc obj) {
		String sql = "DELETE FROM PhongHoc WHERE MAPH = '" + obj.getMaPH() + "'";

		try (Connection conn = JDBConnect.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	public Boolean ClearData(ArrayList<PhongHoc> obj) {
		String sql = "DELETE FROM PhongHoc";

		try (Connection conn = JDBConnect.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	public Boolean UpdateData(PhongHoc newobj, String maph) {
		String sql = "UPDATE PhongHoc SET MaPH='" + newobj.getMaPH() + "', TENPH='" + newobj.getTenPH() + "', LAU="
				+ newobj.getLau() + ",COSO='" + newobj.getCoSo() + ", KHU='" + newobj.getKhu() + "' WHERE MaPH='" + maph
				+ "'";

		try (Connection conn = JDBConnect.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}
}
