package BUS;

import java.util.ArrayList;

import DTO.DangKiDTO;

public class DangKiBUS {
	static ArrayList<DangKiDTO> dsdk = new ArrayList<DangKiDTO>();
	static int sldk = 0;

	public DangKiBUS() {
	}

	public boolean them(DangKiDTO obj) {
		if (checkTrung(obj)) {
			dsdk.add(obj);
			sldk++;
			return true;
		}
		return false;
	}

	public boolean checkTrung(DangKiDTO obj) {
		for (DangKiDTO temp : dsdk) {
			if (temp.getMaHP().equals(obj.getMaHP()) && temp.getMaSV().equals(obj.getMaSV())) {
				return true;
			}
		}
		return true;
	}

	public void xoa(DangKiDTO obj) {
		dsdk.remove(dsdk.indexOf(obj));
		sldk--;
	}

	public boolean sua(DangKiDTO old_obj, DangKiDTO new_obj) {
		if (dsdk.indexOf(old_obj) != -1) {
			dsdk.set(dsdk.indexOf(old_obj), new_obj);
			return true;
		}
		return false;
	}
}
