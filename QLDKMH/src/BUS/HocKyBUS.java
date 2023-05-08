package BUS;

import java.util.ArrayList;

import DTO.HocKy;

public class HocKyBUS {
	static ArrayList<HocKy> dsHK = new ArrayList<HocKy>();
	static int slHK = 0;

	public HocKyBUS() {

	}

	public boolean them(HocKy obj) {
		if (checkTrung(obj)) {
			dsHK.add(obj);
			slHK++;
			return true;
		} else
			return false;
	}

	public boolean checkTrung(HocKy obj) {
		for (HocKy temp : dsHK) {
			if (temp.getMaHK().equals(obj.getMaHK())) {
				return false;
			}
		}
		return true;
	}

	public void sua(HocKy old_obj, HocKy new_obj) {
		dsHK.set(dsHK.indexOf(old_obj), new_obj);
	}

	public void xoa(HocKy obj) {
		dsHK.remove(dsHK.indexOf(obj));
		slHK--;
	}

	public ArrayList<HocKy> tim(String str) {
		ArrayList<HocKy> temp = new ArrayList<HocKy>();
		for (HocKy t : dsHK) {
			boolean ok = false;
			if (t.getMaHK().indexOf(str) != -1) {
				ok = true;
			}

			if (!ok && t.getTenHK().indexOf(str) != -1) {
				ok = true;
			}

			if (!ok && t.getNgayBD().indexOf(str) != -1) {
				ok = true;
			}

			if (!ok && t.getNgayKT().indexOf(str) != -1) {
				ok = true;
			}

			if (!ok && Integer.toString(t.getNam()).indexOf(str) != -1) {
				ok = true;
			}

			if (ok)
				temp.add(t);
		}
		return temp;
	}

	public static ArrayList<HocKy> getDsHK() {
		return dsHK;
	}

	public static int getSlHK() {
		return slHK;
	}

	public static void setDsHK(ArrayList<HocKy> dsHK) {
		HocKyBUS.dsHK = dsHK;
	}

	public static void setSlHK(int slHK) {
		HocKyBUS.slHK = slHK;
	}
}
