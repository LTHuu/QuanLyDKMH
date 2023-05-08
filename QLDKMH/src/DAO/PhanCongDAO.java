package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import BUS.PhanCongBUS;
import DAO.PhanCongDTO;
import main.JDBConnect;

public class PhanCongDAO {
	public ArrayList<PhanCongDTO> ReadData() {
		ArrayList<PhanCongDTO> list = new ArrayList<PhanCongDTO>();
		try {
			Connection conn = JDBConnect.getConnection();
			java.sql.Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM PHANCONG");

			while (rs.next()) {
				String maduocpc = rs.getString("MADUOCPC");
				String loaipc = rs.getString("LOAIPC");
				String magv = rs.getString("MAGV");
				list.add(new PhanCongDTO(maduocpc, loaipc, magv));
			}

			JDBConnect.closeConnection(conn);
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Boolean WriteData() {
		if (ClearData(PhanCongBUS.getDsPC())) {
			for (PhanCongDTO temp : PhanCongBUS.getDsPC()) {
				addPC(temp);
			}
			return true;
		}
		return false;
	}

	public boolean addPC(PhanCongDTO obj) {
		String sql = "INSERT INTO PHANCONG(MADUOCPC, TENPC, MAGV) VALUES(?,?,?)";

		try (Connection conn = JDBConnect.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.setString(1, obj.getMaDuocPC());
			stmt.setString(2, obj.getLoaiPC());
			stmt.setInt(3, new GiangVienDTO().getMaGV());
			stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	public boolean DeleteData(PhanCongDTO obj) {
		String sql = "DELETE FROM PHANCONG WHERE MADUOCPC = '" + obj.getMaDuocPC() + "'";

		try (Connection conn = JDBConnect.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	public Boolean ClearData(ArrayList<PhanCongDTO> obj) {
		String sql = "DELETE FROM PHANCONG";

		try (Connection conn = JDBConnect.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	public Boolean UpdateData(PhanCongDTO newobj, String maloaipc) {
		String sql = "UPDATE PHANCONG SET MADUOCPC='" + newobj.getMaDuocPC() + "', LOAIPC='" + newobj.getLoaiPC() + "', MAGV='" + newobj.getLoaiPC() + "'" + " WHERE MALOAIPC='" + maloaipc + "'";

		try (Connection conn = JDBConnect.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}
}
