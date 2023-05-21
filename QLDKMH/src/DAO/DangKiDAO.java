
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DTO.DangKiDTO;
import DTO.GiangVien;
import main.JDBConnect;

public class DangKiDAO {

	public DangKiDAO() {
	}

	// Hàm đọc toàn bộ dữ liệu
	public ArrayList<DangKiDTO> getAllDangKi() {
		ArrayList<DangKiDTO> list = new ArrayList<DangKiDTO>();
		try {
			Connection conn = JDBConnect.getConnection();
			java.sql.Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM DangKy");

			while (rs.next()) {
				String mahp = rs.getString("MAHP");
				String masv = rs.getString("MASV");
				String ngdk = rs.getString("NGAYDK");

				list.add(new DangKiDTO(masv, ngdk, mahp));
			}

			JDBConnect.closeConnection(conn);
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	// Hàm thêm 1 dòng dữ liệu
	public boolean themDangKi(DangKiDTO obj) {
		String sql = "INSERT INTO DangKy(masv,ngaydk,mahp) VALUES(?,?,?)";

		try (Connection conn = JDBConnect.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.setString(1, obj.getMaSV());
			stmt.setString(2, obj.getNgDK());
			stmt.setString(3, obj.getMaHP());

			stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	// Hàm xóa toàn bộ dữ liệu
	public boolean xoaTatCaDangKi() {
		String sql = "DELETE FROM DangKy";

		try (Connection conn = JDBConnect.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	// Hàm xóa 1 dòng dữ liệu
	public boolean xoaDangKi(DangKiDTO obj) {
		String sql = "DELETE FROM DangKy WHERE MAHP = '" + obj.getMaHP() + "' AND MASV = '" + obj.getMaSV() + "'";

		try (Connection conn = JDBConnect.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}
}
