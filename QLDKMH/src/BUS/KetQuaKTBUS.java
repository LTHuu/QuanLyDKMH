package BUS;

import java.util.ArrayList;

import DTO.KetQuaKT;

public class KetQuaKTBUS {
	static ArrayList<KetQuaKT> dsKQ = new ArrayList<KetQuaKT>();
	static int slKQ = 0;

	public KetQuaKTBUS() {

	}

	public boolean them(KetQuaKT obj) {
		if (checkTrung(obj)) {
			dsKQ.add(obj);
			slKQ++;
		}
		return false;
	}

	public boolean checkTrung(KetQuaKT obj) {
		for (KetQuaKT temp : dsKQ) {
			if (temp.getMaKT().equals(obj.getMaKT())) {
				return true;
			}
		}
		return false;
	}

	public void sua(KetQuaKT old_obj, KetQuaKT new_obj) {
		dsKQ.set(dsKQ.indexOf(old_obj), new_obj);
	}

	public void xoa(KetQuaKT obj) {
		dsKQ.remove(dsKQ.indexOf(obj));
		slKQ--;
	}

	public ArrayList<KetQuaKT> tim(String MaSV, float diem1, float diem2) {
		ArrayList<KetQuaKT> temp = new ArrayList<KetQuaKT>();
		for (KetQuaKT t : dsKQ) {
			boolean ok = false;
			if (t.getMaSV().indexOf(MaSV) != -1) {
				ok = true;
			}
			if (!ok && (diem1 <= t.getDiem() && t.getDiem() <= diem2)) {
				ok = true;
			}
		}
		return temp;
	}

	public static ArrayList<KetQuaKT> getDsKQ() {
		return dsKQ;
	}

	public static int getSlKQ() {
		return slKQ;
	}

	public static void setDsKQ(ArrayList<KetQuaKT> dsKQ) {
		KetQuaKTBUS.dsKQ = dsKQ;
	}

	public static void setSlKQ(int slKQ) {
		KetQuaKTBUS.slKQ = slKQ;
	}
}
