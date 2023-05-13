package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import BUS.SinhVienBUS;
import DTO.SinhVienDTO;
import main.JDBConnect;

public class SinhVienDAO {
	public ArrayList<SinhVienDTO> ReadData() {
		ArrayList<SinhVienDTO> list = new ArrayList<SinhVienDTO>();
		try {
			Connection conn = JDBConnect.getConnection();
			java.sql.Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM SinhVien");

			while (rs.next()) {
				String masv = rs.getString("MASV");
				String tensv = rs.getString("TENSV");
				String sdt = rs.getString("SODT");
				String khoa = rs.getString("KHOA");
				String diachi = rs.getString("DIACHI");

				// Do something with the retrieved data
				list.add(new SinhVienDTO(masv, tensv, sdt, khoa, diachi));
			}

			JDBConnect.closeConnection(conn);
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Boolean WriteData() {
		if (ClearData(SinhVienBUS.getDsSV())) {
			for (SinhVienDTO temp : SinhVienBUS.getDsSV()) {
				Them(temp);
			}
			return true;
		}
		return false;
	}

	public boolean Them(SinhVienDTO obj) {
		String sql = "INSERT INTO SinhVien(tensv, masv,sodt, khoa, diachi) VALUES(?,?,?,?,?)";

		try (Connection conn = JDBConnect.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.setString(1, obj.getTenSV());
			stmt.setString(2, obj.getMaSV());
			stmt.setString(3, obj.getSoDT());
			stmt.setString(4, obj.getKhoa());
			stmt.setString(5, obj.getDiaChi());

			stmt.executeUpdate();

			return true;

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	public boolean DeleteData(SinhVienDTO obj) {
		String sql = "DELETE FROM SinhVien WHERE MASV = '" + obj.getMaSV() + "'";

		try (Connection conn = JDBConnect.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	public Boolean ClearData(ArrayList<SinhVienDTO> obj) {
		String sql = "DELETE FROM SinhVien";

		try (Connection conn = JDBConnect.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	public Boolean UpdateData(SinhVienDTO newobj, String masv) {
		String sql = "UPDATE SinhVien SET MASV = '" + newobj.getMaSV() + "', TENSV = '" + newobj.getTenSV()
				+ "', SODT = '" + newobj.getSoDT() + "',Khoa='" + newobj.getKhoa() + "' WHERE DIACHI = '" + masv + "'";

		try (Connection conn = JDBConnect.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}
}
