package BUS;

import java.util.ArrayList;

import DTO.Lop;

public class LopHocBUS {
	static ArrayList<Lop> dsLH = new ArrayList<Lop>();
	static int slLH = 0;

	public LopHocBUS() {

	}

	public boolean them(Lop obj) {
		if (checkTrung(obj)) {
			dsLH.add(obj);
			slLH++;
		}
		return false;
	}

	public boolean checkTrung(Lop obj) {
		for (Lop temp : dsLH) {
			if (temp.getMaLop().equals(obj.getMaLop())) {
				return false;
			}
		}
		return true;
	}

	public void sua(Lop old_obj, Lop new_obj) {
		dsLH.set(dsLH.indexOf(old_obj), new_obj);
	}

	public void xoa(Lop obj) {
		dsLH.remove(dsLH.indexOf(obj));
		slLH--;
	}

	public ArrayList<Lop> tim(String str) {
		ArrayList<Lop> temp = new ArrayList<Lop>();
		for (Lop t : dsLH) {
			boolean ok = false;
			if (t.getMaLop().indexOf(str) != -1) {
				ok = true;
			}
			if (!ok && t.getTenLop().indexOf(str) != -1) {
				ok = true;
			}

			if (ok)
				temp.add(t);
		}
		return temp;
	}

	public static ArrayList<Lop> getDsLH() {
		return dsLH;
	}

	public static int getSlLH() {
		return slLH;
	}

	public static void setDsLH(ArrayList<Lop> dsLH) {
		LopHocBUS.dsLH = dsLH;
	}

	public static void setSlLH(int slLH) {
		LopHocBUS.slLH = slLH;
	}
}
