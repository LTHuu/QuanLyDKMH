package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import BUS.KetQuaKTBUS;
import DTO.KetQuaKT;
import main.JDBConnect;

public class KetQuaKTDAO {
	public ArrayList<KetQuaKT> ReadData() {
		ArrayList<KetQuaKT> list = new ArrayList<KetQuaKT>();
		try {
			Connection conn = JDBConnect.getConnection();
			java.sql.Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM KetQua");

			while (rs.next()) {
				String masv = rs.getString("MASV");
				String makt = rs.getString("MAKT");
				float diem = rs.getFloat("DIEM");

				// Do something with the retrieved data
				list.add(new KetQuaKT(makt, diem, masv));
			}

			JDBConnect.closeConnection(conn);
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Boolean WriteData() {
		if (ClearData(KetQuaKTBUS.getDsKQ())) {
			for (KetQuaKT temp : KetQuaKTBUS.getDsKQ()) {
				Them(temp);
			}
			return true;
		}
		return false;
	}

	public boolean Them(KetQuaKT obj) {
		String sql = "INSERT INTO KetQuaKT(masv, makt, diem,heso) VALUES(?,?,?)";

		try (Connection conn = JDBConnect.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.setString(1, obj.getMaSV());
			stmt.setString(2, obj.getMaKT());
			stmt.setFloat(3, obj.getDiem());

			stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	public boolean DeleteData(KetQuaKT obj) {
		String sql = "DELETE FROM KetQuaKT WHERE MASV = '" + obj.getMaSV() + "' and MAKT='" + obj.getMaKT() + "'";

		try (Connection conn = JDBConnect.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	public Boolean ClearData(ArrayList<KetQuaKT> obj) {
		String sql = "DELETE FROM KetQuaKT";

		try (Connection conn = JDBConnect.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	public Boolean UpdateData(KetQuaKT newobj, String masv, String makt) {
		String sql = "UPDATE KetQuaKT SET MaSV='" + newobj.getMaSV() + "', MAKT='" + newobj.getMaKT() + "', diem="
				+ newobj.getDiem() + " WHERE MaSV='" + masv + "' AND MAKT='" + makt + ",";

		try (Connection conn = JDBConnect.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}
}
