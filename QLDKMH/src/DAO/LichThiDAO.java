package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import BUS.LichThiBUS;
import DTO.LichThi;
import main.JDBConnect;

public class LichThiDAO {
	public ArrayList<LichThi> ReadData() {
		ArrayList<LichThi> list = new ArrayList<LichThi>();
		try {
			Connection conn = JDBConnect.getConnection();
			java.sql.Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM LichThi");

			while (rs.next()) {
				String makt = rs.getString("MAKT");
				String tgbd = rs.getString("TGBD");
				String ngkt = rs.getString("NGKT");
				String mahp = rs.getString("MaHP");
				String loaikt = rs.getString("LOAIKT");

				// Do something with the retrieved data
				list.add(new LichThi(makt, tgbd, ngkt, mahp, loaikt));
			}

			JDBConnect.closeConnection(conn);
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Boolean WriteData() {
		if (ClearData(LichThiBUS.getDsLT())) {
			for (LichThi temp : LichThiBUS.getDsLT()) {
				Them(temp);
			}
			return true;
		}
		return false;
	}

	public boolean Them(LichThi obj) {
		String sql = "INSERT INTO LichThi(makt, tgbd,ngkt, mahp,loaikt) VALUES(?,?,?,?,?)";

		try (Connection conn = JDBConnect.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.setString(1, obj.getMaKT());
			stmt.setString(2, obj.getTGBatDau());
			stmt.setString(3, obj.getNgayKT());
			stmt.setString(4, obj.getMaHP());
			stmt.setString(5, obj.getLoaiKT());

			stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	public boolean DeleteData(LichThi obj) {
		String sql = "DELETE FROM LichThi WHERE MAKT = '" + obj.getMaKT() + "'";

		try (Connection conn = JDBConnect.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	public Boolean ClearData(ArrayList<LichThi> obj) {
		String sql = "DELETE FROM LichThi";

		try (Connection conn = JDBConnect.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	public Boolean UpdateData(LichThi newobj, String makt) {
		String sql = "UPDATE LichThi SET MaKT='" + newobj.getMaKT() + "', TGBD='" + newobj.getTGBatDau() + "', NGKT='"
				+ newobj.getNgayKT() + "', LoaiKT='" + newobj.getLoaiKT() + "' WHERE MaKT='" + makt + "'";

		try (Connection conn = JDBConnect.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}
}
