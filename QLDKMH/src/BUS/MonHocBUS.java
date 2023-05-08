package BUS;

import java.util.ArrayList;

import DTO.MonHoc;

public class MonHocBUS {
	static ArrayList<MonHoc> dsmh = new ArrayList<MonHoc>();
	static int slmh = 0;

	public MonHocBUS() {

	}

	public boolean them(MonHoc obj) {
		if (checkTrung(obj)) {
			dsmh.add(obj);
			slmh++;
			return true;
		}
		return false;
	}

	public boolean checkTrung(MonHoc obj) {
		for (MonHoc temp : dsmh) {
			if (temp.getMaMH().equals(obj.getMaMH()))
				return false;
		}
		return true;
	}

	public boolean xoa(MonHoc obj) {
		if (dsmh.indexOf(obj) != -1) {
			dsmh.remove(dsmh.indexOf(obj));
			slmh--;
			return true;
		}
		return false;
	}

	public boolean sua(MonHoc old_obj, MonHoc new_obj) {
		if (dsmh.indexOf(old_obj) != -1) {
			dsmh.set(dsmh.indexOf(old_obj), new_obj);
			return true;
		}
		return false;
	}
}
