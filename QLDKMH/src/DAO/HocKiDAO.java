package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import BUS.HocKyBUS;
import DTO.HocKy;
import main.JDBConnect;

public class HocKiDAO {
	public ArrayList<HocKy> ReadData() {
		ArrayList<HocKy> list = new ArrayList<HocKy>();
		try {
			Connection conn = JDBConnect.getConnection();
			java.sql.Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM HOCKY");

			while (rs.next()) {
				String mahk = rs.getString("MAHK");
				String tenhk = rs.getString("TenHK");
				String ngbd = rs.getString("NgayBD");
				String ngkt = rs.getString("NgayKT");
				int nam = rs.getInt("Nam");

				// Do something with the retrieved data
				list.add(new HocKy(mahk, tenhk, ngbd, ngkt, nam));
			}

			JDBConnect.closeConnection(conn);
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Boolean WriteData() {
		if (ClearData(HocKyBUS.getDsHK())) {
			for (HocKy temp : HocKyBUS.getDsHK()) {
				Them(temp);
			}
			return true;
		}
		return false;
	}

	public boolean Them(HocKy obj) {
		String sql = "INSERT INTO HOCKY(mahk, tenhk, ngaybd, ngaykt, nam) VALUES(?,?,?,?,?)";

		try (Connection conn = JDBConnect.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.setString(1, obj.getMaHK());
			stmt.setString(2, obj.getTenHK());
			stmt.setString(3, obj.getNgayBD());
			stmt.setString(4, obj.getNgayKT());
			stmt.setInt(5, obj.getNam());

			stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	public boolean DeleteData(HocKy obj) {
		String sql = "DELETE FROM HOCKY WHERE MAHK = '" + obj.getMaHK() + "'";

		try (Connection conn = JDBConnect.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	public Boolean ClearData(ArrayList<HocKy> obj) {
		String sql = "DELETE FROM HOCKY";

		try (Connection conn = JDBConnect.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	public Boolean UpdateData(HocKy newobj, String mahk) {
		String sql = "UPDATE HOCKY SET MaHK='" + newobj.getMaHK() + "', TenHK='" + newobj.getTenHK() + "', NgayBD='"
				+ newobj.getNgayBD() + "', NgayKT='" + newobj.getNgayKT() + "',Nam=" + newobj.getNam()
				+ " WHERE MaHK='" + mahk + "'";

		try (Connection conn = JDBConnect.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}
}
