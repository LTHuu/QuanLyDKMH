package BUS;

import java.util.ArrayList;

import DTO.TietHoc;

public class TietHocBUS {
	static ArrayList<TietHoc> dsth = new ArrayList<TietHoc>();

	public TietHocBUS() {

	}

	public boolean them(TietHoc obj) {
		if (checkTrung(obj)) {
			dsth.add(obj);
			return true;
		}
		return false;
	}

	public boolean checkTrung(TietHoc obj) {
		for (TietHoc temp : dsth) {
			if (temp.getMaTH().equals(obj.getMaTH())) {
				return false;
			}
		}
		return true;
	}

	public boolean xoa(TietHoc obj) {
		if (dsth.indexOf(obj) != -1) {
			dsth.remove(dsth.indexOf(obj));
			return true;
		}
		return false;
	}

	public boolean sua(TietHoc old_obj, TietHoc new_obj) {
		if (dsth.indexOf(old_obj) != -1) {
			dsth.set(dsth.indexOf(old_obj), new_obj);
			return true;
		}
		return false;
	}
}

