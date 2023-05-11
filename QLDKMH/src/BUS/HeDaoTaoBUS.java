package BUS;

import java.util.ArrayList;

import DTO.HeDaoTao;

public class HeDaoTaoBUS {
	static ArrayList<HeDaoTao> dsHDT = new ArrayList<HeDaoTao>();
	static int slHDT = 0;

	public HeDaoTaoBUS() {

	}

	public boolean them(HeDaoTao obj) {
		if (checkDuplicate(obj)) {
			dsHDT.add(obj);
			slHDT++;
			return true;
		}
		return false;
	}

	public boolean checkDuplicate(HeDaoTao obj) {
		for (HeDaoTao temp : dsHDT) {
			if (temp.getMaHDT().equals(obj.getMaHDT())) {
				return false;
			}
		}
		return true;
	}

	public void sua(HeDaoTao old_obj, HeDaoTao new_obj) {
		if (dsHDT.indexOf(old_obj) != -1)
			dsHDT.set(dsHDT.indexOf(old_obj), new_obj);
	}

	public void xoa(HeDaoTao obj) {
		if (dsHDT.indexOf(obj) != -1) {
			dsHDT.remove(dsHDT.indexOf(obj));
			slHDT--;
		}
	}

	public ArrayList<HeDaoTao> findHDT(String str) {
		ArrayList<HeDaoTao> temp = new ArrayList<HeDaoTao>();
		for (HeDaoTao t : dsHDT) {
			boolean ok = false;
			if (t.getMaHDT().indexOf(str) != -1) {
				ok = true;
			}
			if (!ok && t.getTenHDT().indexOf(str) != -1) {
				ok = true;
			}
			if (ok)
				temp.add(t);
		}
		return temp;
	}

	public static ArrayList<HeDaoTao> getDsHDT() {
		return dsHDT;
	}

	public static int getSlHDT() {
		return slHDT;
	}

	public static void setDsHDT(ArrayList<HeDaoTao> dsHDT) {
		HeDaoTaoBUS.dsHDT = dsHDT;
	}

	public static void setSlHDT(int slHDT) {
		HeDaoTaoBUS.slHDT = slHDT;
	}
}
