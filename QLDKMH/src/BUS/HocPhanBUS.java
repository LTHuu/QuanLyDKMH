package BUS;

import java.util.ArrayList;

import DTO.HocPhan;

public class HocPhanBUS {
	static ArrayList<HocPhan> dshp = new ArrayList<HocPhan>();
	static int slhp;

	public HocPhanBUS() {
	}

	public boolean them(HocPhan obj) {
		if (checkTrung(obj)) {
			dshp.add(obj);
			slhp++;
			return true;
		}
		return false;
	}

	public boolean checkTrung(HocPhan obj) {
		for (HocPhan temp : dshp) {
			if (temp.getMaHP().equals(obj.getMaHP()))
				return false;
		}
		return true;
	}

	public boolean xoa(HocPhan obj) {
		if (dshp.indexOf(obj) != -1) {
			dshp.remove(dshp.indexOf(obj));
			return true;
		}
		return false;
	}

	public boolean sua(HocPhan old_obj, HocPhan new_obj) {
		if (dshp.indexOf(old_obj) != -1) {
			dshp.set(dshp.indexOf(old_obj), new_obj);
			return true;
		}
		return false;
	}

	public ArrayList<HocPhan> timMaMH(String str) {
		ArrayList<HocPhan> temp = new ArrayList<HocPhan>();
		for (HocPhan t : dshp) {
			if (t.getMaMH().indexOf(str) != -1) {
				temp.add(t);
			}
		}
		return temp;
	}

	public HocPhan timMaHP(String mahp) {
		for (HocPhan temp : dshp) {
			if (temp.getMaHP().equals(mahp)) {
				return temp;
			}
		}
		return null;
	}
}
