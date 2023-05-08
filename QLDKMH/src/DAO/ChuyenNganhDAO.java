package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import BUS.ChuyenNganhBUS;
import DAO.ChuyenNganhDTO;
import DAO.KhoaDTO;
import main.JDBConnect;

public class ChuyenNganhDAO {
	public ArrayList<ChuyenNganhDTO> ReadData() {
		ArrayList<ChuyenNganhDTO> list = new ArrayList<ChuyenNganhDTO>();
		try {
			Connection conn = JDBConnect.getConnection();
			java.sql.Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM CHUYENNGANH");

			while (rs.next()) {
				String macn = rs.getString("MACN");
				String tencn = rs.getString("TENCN");
				String makhoa = rs.getString("MAKHOA");
				list.add(new ChuyenNganhDTO(macn, tencn, makhoa));
			}

			JDBConnect.closeConnection(conn);
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Boolean WriteData() {
		if (ClearData(ChuyenNganhBUS.getDsCN())) {
			for (ChuyenNganhDTO temp : ChuyenNganhBUS.getDsCN()) {
				addCN(temp);
			}
			return true;
		}
		return false;
	}

	public boolean addCN(ChuyenNganhDTO obj) {
		String sql = "INSERT INTO CHUYENNGANH(MACN, TENCN, MAKHOA) VALUES(?,?,?)";

		try (Connection conn = JDBConnect.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.setString(1, obj.getMaCN());
			stmt.setString(2, obj.getTenCN());
			stmt.setString(3, new KhoaDTO().getMaKhoa()); // Lấy giá trị MaKhoa từ đối tượng KhoaDTO
			stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	public boolean DeleteData(ChuyenNganhDTO obj) {
		String sql = "DELETE FROM CHUYENNGANH WHERE MACN = '" + obj.getMaCN() + "'";

		try (Connection conn = JDBConnect.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	public Boolean ClearData(ArrayList<ChuyenNganhDTO> obj) {
		String sql = "DELETE FROM CHUYENNGANH";

		try (Connection conn = JDBConnect.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	public Boolean UpdateData(ChuyenNganhDTO newobj, String macn) {
		String sql = "UPDATE CHUYENNGANH SET MACN='" + newobj.getMaCN() + "', TENCN='" + newobj.getTenCN() + "', MAKHOA="
				+ newobj.getMaKhoa() + "'" + " WHERE MACN='" + macn + "'";

		try (Connection conn = JDBConnect.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}
}
