package BUS;

import java.util.ArrayList;
import DAO.PhanCongDTO;

public class PhanCongBUS {
	static ArrayList<PhanCongDTO> dsPC = new ArrayList<PhanCongDTO>();
	static int slPC = 0;

	public PhanCongBUS() {

	}

	public boolean them(PhanCongDTO obj) {
		if (checkDuplicate(obj)) {
			dsPC.add(obj);
			slPC++;
		}
		return false;
	}

	public boolean checkDuplicate(PhanCongDTO obj) {
		for (PhanCongDTO temp : dsPC) {
			if (temp.getMaDuocPC().equals(obj.getMaDuocPC())) {
				return false;
			}
		}
		return true;
	}

	public void sua(PhanCongDTO old_obj, PhanCongDTO new_obj) {
		if (dsPC.indexOf(old_obj) != -1)
			dsPC.set(dsPC.indexOf(old_obj), new_obj);
	}

	public void xoa(PhanCongDTO obj) {
		if (dsPC.indexOf(old_obj) != -1) {
			dsPC.remove(dsPC.indexOf(obj));
			slPC--;
		}
	}

	public ArrayList<PhanCongDTO> findPC(String str) {
		ArrayList<PhanCongDTO> temp = new ArrayList<PhanCongDTO>();
		for (PhanCongDTO t : dsPC) {
			boolean ok = false;
			if (t.getMaDuocPC().indexOf(str) != -1) {
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

	public static int getSlPC() {
		return slPC;
	}

	public static void setDsPC(ArrayList<PhanCongDTO> dsPC) {
		PhanCongBUS.dsPC = dsPC;
	}

	public static void setSlPC(int slPC) {
		PhanCongBUS.slPC = slPC;
	}
}
