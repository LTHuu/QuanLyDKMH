package BUS;

import java.util.ArrayList;

import DAO.ChuyenNganhDAO;
import DTO.ChuyenNganhDTO;

public class ChuyenNganhBUS {
	static ArrayList<ChuyenNganhDTO> dsCN = new ArrayList<ChuyenNganhDTO>();
	ChuyenNganhDAO dao = new ChuyenNganhDAO();

	public ChuyenNganhBUS() {
		dsCN = dao.ReadData();
	}

	public boolean them(ChuyenNganhDTO obj) {
		if (checkDuplicate(obj)) {
			dsCN.add(obj);
			dao.addCN(obj);
			return true;
		}
		return false;
	}

	public boolean checkDuplicate(ChuyenNganhDTO obj) {
		for (ChuyenNganhDTO temp : dsCN) {
			if (temp.getMaCN().equals(obj.getMaCN())) {
				return false;
			}
		}
		return true;
	}

	public void sua(ChuyenNganhDTO old_obj, ChuyenNganhDTO new_obj) {
		if (dsCN.indexOf(old_obj) != -1) {
			dsCN.set(dsCN.indexOf(old_obj), new_obj);
			dao.UpdateData(new_obj, old_obj.getMaCN());
		}
	}

	public void xoa(ChuyenNganhDTO obj) {
		if (dsCN.indexOf(obj) != -1) {
			dsCN.remove(dsCN.indexOf(obj));
			dao.DeleteData(obj);
		}
	}
	
	public ChuyenNganhDTO timMaCN(String macn) {
		for(ChuyenNganhDTO temp : dsCN) {
			if(temp.getMaCN().equals(macn)) {
				return temp;
			}
		}
		return null;
	}

	public ArrayList<ChuyenNganhDTO> findCN(String str) {
		ArrayList<ChuyenNganhDTO> temp = new ArrayList<ChuyenNganhDTO>();
		for (ChuyenNganhDTO t : dsCN) {
			boolean ok = false;
			if (t.getMaCN().indexOf(str) != -1) {
				ok = true;
			}
			if (!ok && t.getTenCn().indexOf(str) != -1) {
				ok = true;
			}
			if (ok)
				temp.add(t);
		}
		return temp;
	}

	public static ArrayList<ChuyenNganhDTO> getDsCN() {
		return dsCN;
	}

	public static void setDsCN(ArrayList<ChuyenNganhDTO> dsCN) {
		ChuyenNganhBUS.dsCN = dsCN;
	}
}
