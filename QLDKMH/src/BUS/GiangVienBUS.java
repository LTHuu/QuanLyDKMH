package BUS;

import java.util.ArrayList;

import DTO.GiangVien;
import DTO.SinhVienDTO;

public class GiangVienBUS {
	static ArrayList<GiangVien> dsGV = new ArrayList<GiangVien>();
	static int slGV = 0;

	public GiangVienBUS() {

	}

	public boolean them(GiangVien obj) {
		if (checkTrung(obj)) {
			dsGV.add(obj);
			slGV++;
			return true;
		}
		return false;
	}

	public boolean checkTrung(GiangVien obj) {
		for (GiangVien temp : dsGV) {
			if (temp.getMaGV().equals(obj.getMaGV())) {
				return false;
			}
		}
		return true;
	}

	public void sua(GiangVien old_obj, GiangVien new_obj) {
		dsGV.set(dsGV.indexOf(old_obj), new_obj);
	}

	public void xoa(GiangVien obj) {
		dsGV.remove(dsGV.indexOf(obj));
		slGV--;
	}

	public GiangVien timMaGV(String masv) {
		for (GiangVien temp : dsGV) {
			if (temp.getMaGV().equals(masv)) {
				return temp;
			}
		}
		return null;
	}

	public ArrayList<GiangVien> tim(String str) {
		ArrayList<GiangVien> temp = new ArrayList<GiangVien>();
		for (GiangVien t : dsGV) {
			boolean ok = false;
			if (t.getMaGV().indexOf(str) != -1) {
				ok = true;
			}
			if (!ok && t.getTenGV().indexOf(str) != -1) {
				ok = true;
			}

			if (ok)
				temp.add(t);
		}
		return temp;
	}

	public static ArrayList<GiangVien> getDsGV() {
		return dsGV;
	}

	public static int getSlGV() {
		return slGV;
	}

	public static void setDsGV(ArrayList<GiangVien> dsGV) {
		GiangVienBUS.dsGV = dsGV;
	}

	public static void setSlGV(int slGV) {
		GiangVienBUS.slGV = slGV;
	}
}
