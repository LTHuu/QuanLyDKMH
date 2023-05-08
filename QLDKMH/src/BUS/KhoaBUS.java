package BUS;

import java.util.ArrayList;
import DAO.KhoaDTO;

public class KhoaBUS {
	static ArrayList<KhoaDTO> dsKhoa = new ArrayList<KhoaDTO>();
	static int slKhoa = 0;

	public KhoaBUS() {

	}

	public boolean them(KhoaDTO obj) {
		if (checkDuplicate(obj)) {
			dsKhoa.add(obj);
			slKhoa++;
			return true;
		}
		return false;
	}

	public boolean checkDuplicate(KhoaDTO obj) {
		for (KhoaDTO temp : dsKhoa) {
			if (temp.getMaKhoa().equals(obj.getMaKhoa())) {
				return false;
			}
		}
		return true;
	}

	public void sua(KhoaDTO old_obj, KhoaDTO new_obj) {
		if (dsKhoa.indexOf(old_obj) != -1)
			dsKhoa.set(dsKhoa.indexOf(old_obj), new_obj);
	}

	public void xoa(KhoaDTO obj) {
		if (dsKhoa.indexOf(old_obj) != -1) {
			dsKhoa.remove(dsKhoa.indexOf(obj));
			slKhoa--;
		}
	}

	public ArrayList<KhoaDTO> findKhoa(String str) {
		ArrayList<KhoaDTO> temp = new ArrayList<KhoaDTO>();
		for (KhoaDTO t : dsKhoa) {
			boolean ok = false;
			if (t.getMaKhoa().indexOf(str) != -1) {
				ok = true;
			}
			if (!ok && t.getTenKhoa().indexOf(str) != -1) {
				ok = true;
			}
			if (!ok && Integer.toString(t.getNamTL()).indexOf(str) != -1) {
				ok = true;
			}
			if (ok)
				temp.add(t);
		}
		return temp;
	}

	public static ArrayList<KhoaDTO> getDsKhoa() {
		return dsKhoa;
	}

	public static int getSlKhoa() {
		return slKhoa;
	}

	public static void setDsKhoa(ArrayList<KhoaDTO> dsKhoa) {
		KhoaBUS.dsKhoa = dsKhoa;
	}

	public static void setSlKhoa(int slKhoa) {
		KhoaBUS.slKhoa = slKhoa;
	}
}
