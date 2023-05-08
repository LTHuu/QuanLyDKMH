package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import BUS.HeDaoTaoBUS;
import DAO.HeDaoTaoDTO;

import main.JDBConnect;

public class HeDaoTaoDAO {
	public ArrayList<HeDaoTaoDTO> ReadData() {
		ArrayList<HeDaoTaoDTO> list = new ArrayList<HeDaoTaoDTO>();
		try {
			Connection conn = JDBConnect.getConnection();
			java.sql.Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM HEDAOTAO");

			while (rs.next()) {
				String mahdt = rs.getString("MAHDT");
				String tenhdt = rs.getString("TENHDT");
			
				list.add(new HeDaoTaoDTO(mahdt, tenhdt));
			}

			JDBConnect.closeConnection(conn);
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Boolean WriteData() {
		if (ClearData(HeDaoTaoBUS.getDsHDT())) {
			for (HeDaoTaoDTO temp : HeDaoTaoBUS.getDsHDT()) {
				addHDT(temp);
			}
			return true;
		}
		return false;
	}

	public boolean addHDT(HeDaoTaoDTO obj) {
		String sql = "INSERT INTO HEDAOTAO(MAHDT, TENHDT) VALUES(?,?)";

		try (Connection conn = JDBConnect.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.setString(1, obj.getMaHDT());
			stmt.setString(2, obj.getTenHDT());
			stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	public boolean DeleteData(HeDaoTaoDTO obj) {
		String sql = "DELETE FROM HEDAOTAO WHERE MAHDT = '" + obj.getMaHDT() + "'";

		try (Connection conn = JDBConnect.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	public Boolean ClearData(ArrayList<HeDaoTaoDTO> obj) {
		String sql = "DELETE FROM HEDAOTAO";

		try (Connection conn = JDBConnect.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	public Boolean UpdateData(HeDaoTaoDTO newobj, String mahdt) {
		String sql = "UPDATE HEDAOTAO SET MAHDT='" + newobj.getMaHDT() + "', TENHDT='" + newobj.getTenHDT() + "'" + " WHERE MAHDT='" + mahdt + "'";

		try (Connection conn = JDBConnect.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}
}
