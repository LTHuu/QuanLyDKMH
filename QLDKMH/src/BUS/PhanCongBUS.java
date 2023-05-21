package BUS;

import java.util.ArrayList;

import DAO.PhanCongDAO;
import DTO.PhanCongDTO;

public class PhanCongBUS {
	static ArrayList<PhanCongDTO> dsPC = new ArrayList<PhanCongDTO>();
	PhanCongDAO dao = new PhanCongDAO();

	public PhanCongBUS() {
		dsPC = dao.ReadData();
	}

	public boolean them(PhanCongDTO obj) {
		if (checkDuplicate(obj)) {
			dsPC.add(obj);
			dao.addPC(obj);
		}
		return false;
	}

	public boolean checkDuplicate(PhanCongDTO obj) {
		for (PhanCongDTO temp : dsPC) {
			if (temp.getMaPC().equals(obj.getMaPC())) {
				return false;
			}
		}
		return true;
	}

	public void sua(PhanCongDTO old_obj, PhanCongDTO new_obj) {
		if (dsPC.indexOf(old_obj) != -1) {
			dsPC.set(dsPC.indexOf(old_obj), new_obj);
			dao.UpdateData(new_obj, old_obj.getMaPC(),old_obj.getMaGV());
		}
	}

	public void xoa(PhanCongDTO obj) {
		if (dsPC.indexOf(obj) != -1) {
			dsPC.remove(dsPC.indexOf(obj));
			dao.DeleteData(obj);
		}
	}
	
	public ArrayList<PhanCongDTO> timMaGV(String magv) {
		ArrayList<PhanCongDTO> temp = new ArrayList<PhanCongDTO>();
		for (PhanCongDTO t : dsPC) {
			if(t.getMaGV().equals(magv))
				temp.add(t);
		}
		return temp;
	}
	

	public ArrayList<PhanCongDTO> findPC(String str) {
		ArrayList<PhanCongDTO> temp = new ArrayList<PhanCongDTO>();
		for (PhanCongDTO t : dsPC) {
			boolean ok = false;
			if (t.getMaPC().indexOf(str) != -1) {
				ok = true;
			}
			if (!ok && t.getLoaiPC().indexOf(str) != -1) {
				ok = true;
			}
			if (ok)
				temp.add(t);
		}
		return temp;
	}

	public static ArrayList<PhanCongDTO> getDsPC() {
		return dsPC;
	}

	public static void setDsPC(ArrayList<PhanCongDTO> dsPC) {
		PhanCongBUS.dsPC = dsPC;
	}
}
