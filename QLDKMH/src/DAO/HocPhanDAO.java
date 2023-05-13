package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DTO.DangKiDTO;
import DTO.HocPhan;

public class HocPhanDAO {
	private Connection conn;

	public HocPhanDAO(Connection conn) {
		this.conn = conn;
	}

	public List<HocPhan> getAllHocPhan() throws SQLException {
		String sql = "SELECT * FROM HocPhan";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();

		List<HocPhan> list = new ArrayList<>();
		while (rs.next()) {
			HocPhan hp = new HocPhan();
			hp.setMaHP(rs.getString("MaHP"));
			hp.setTenHP(rs.getString("TenHP"));
			hp.setNgBD(rs.getString("NgBD"));
			hp.setNgKT(rs.getString("NgKT"));
			hp.setMaHK(rs.getString("HocKy"));
			hp.setMaMH(rs.getString("MonHoc"));
			hp.setSiSo(rs.getInt("SISO"));
			hp.setSiSoToiDa(rs.getInt("SISOTOIDA"));
			hp.setMaGV(rs.getString("MaGV"));
			list.add(hp);
		}

		rs.close();
		pstmt.close();

		return list;
	}

	public boolean themHocPhan(HocPhan hocPhan) {
		PreparedStatement ps = null;
		boolean result = false;

		try {
			String sql = "INSERT INTO hocphan (MaHP, TenHP, NgBD, NgKT, MonHoc , HocKy, SISO,SISOTOIDA,MAGV) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, hocPhan.getMaHP());
			ps.setString(2, hocPhan.getTenHP());
			ps.setString(3, hocPhan.getNgBD());
			ps.setString(4, hocPhan.getNgKT());
			ps.setString(5, hocPhan.getMaMH());
			ps.setString(6, hocPhan.getMaHK());
			ps.setInt(7, hocPhan.getSiSo());
			ps.setInt(8, hocPhan.getSiSoToiDa());
			ps.setString(9, hocPhan.getMaGV());

			int rowsAffected = ps.executeUpdate();
			if (rowsAffected > 0) {
				result = true;
			}
		} catch (SQLException ex) {
			System.err.println("Loi: " + ex.getMessage());
		} finally {
		}

		return result;
	}

	public boolean xoaHocPhan(String maHP) {
		PreparedStatement ps = null;
		boolean result = false;

		try {
			String sql = "DELETE FROM hocphan WHERE MaHP = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, maHP);

			int rowsAffected = ps.executeUpdate();
			if (rowsAffected > 0) {
				result = true;
			}
		} catch (SQLException ex) {
			System.err.println("Loi: " + ex.getMessage());
		} finally {
		}

		return result;
	}

	public boolean xoaTatCaHocPhan() {
		PreparedStatement ps = null;
		boolean result = false;

		try {
			String sql = "DELETE FROM hocphan";
			ps = conn.prepareStatement(sql);
			int rowsAffected = ps.executeUpdate();
			if (rowsAffected > 0) {
				result = true;
			}
		} catch (SQLException ex) {
			System.err.println("Loi: " + ex.getMessage());
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
			} catch (SQLException ex) {
				System.err.println("Loi: " + ex.getMessage());
			}
		}

		return result;
	}
	
	public boolean capNhatHocPhan(HocPhan hp) throws SQLException {
		String sql = "UPDATE HocPhan SET TenHP = ?, NgBD = ? , NgKT = ?, MonHoc = ?, HocKy = ?,SISO = ?,SISOTOIDA = ?,MAGV = ? WHERE MaHP = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, hp.getTenHP());
		pstmt.setString(2, hp.getNgBD());
		pstmt.setString(3, hp.getNgKT());
		pstmt.setString(4, hp.getMaMH());
		pstmt.setString(5, hp.getMaHK());
		pstmt.setInt(6, hp.getSiSo());
		pstmt.setInt(7, hp.getSiSoToiDa());
		pstmt.setString(8, hp.getMaGV());
		pstmt.setString(9, hp.getMaHP());
		int rowsAffected = pstmt.executeUpdate();
		pstmt.close();

		return rowsAffected > 0;
	}

}
