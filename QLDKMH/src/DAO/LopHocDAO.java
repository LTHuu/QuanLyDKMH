package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import BUS.LopHocBUS;
import DTO.Lop;
import main.JDBConnect;

public class LopHocDAO {
	public ArrayList<Lop> ReadData() {
		ArrayList<Lop> list = new ArrayList<Lop>();
		try {
			Connection conn = JDBConnect.getConnection();
			java.sql.Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM Lop");

			while (rs.next()) {
				String makt = rs.getString("MALOP");
				String tenlop = rs.getString("TENLOP");
				int namhoc = rs.getInt("NAMHOC");
				String hdt = rs.getString("HEDAOTAO");
				String khoa = rs.getString("KHOA");

				// Do something with the retrieved data
				list.add(new Lop(makt, tenlop, namhoc, hdt, khoa));
			}

			JDBConnect.closeConnection(conn);
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Boolean WriteData() {
		if (ClearData(LopHocBUS.getDsLH())) {
			for (Lop temp : LopHocBUS.getDsLH()) {
				Them(temp);
			}
			return true;
		}
		return false;
	}

	public boolean Them(Lop obj) {
		String sql = "INSERT INTO Lop(malop, tenlop,namhoc, hedaotao,khoa) VALUES(?,?,?,?,?)";

		try (Connection conn = JDBConnect.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.setString(1, obj.getMaLop());
			stmt.setString(2, obj.getTenLop());
			stmt.setInt(3, obj.getNamHoc());
			stmt.setString(4, obj.getHeDaoTao());
			stmt.setString(5, obj.getKhoa());

			stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	public boolean DeleteData(Lop obj) {
		String sql = "DELETE FROM Lop WHERE MALOP = '" + obj.getMaLop() + "'";

		try (Connection conn = JDBConnect.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	public Boolean ClearData(ArrayList<Lop> obj) {
		String sql = "DELETE FROM Lop";

		try (Connection conn = JDBConnect.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	public Boolean UpdateData(Lop newobj, String makt) {
		String sql = "UPDATE Lop SET MaLOP='" + newobj.getMaLop() + "', TenLop='" + newobj.getTenLop() + "', NamHoc="
				+ newobj.getNamHoc() + "',HeDaoTao='" + newobj.getHeDaoTao() + "',Khoa='" + newobj.getKhoa()
				+ "' WHERE MaKT='" + makt + "'";

		try (Connection conn = JDBConnect.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}
}
