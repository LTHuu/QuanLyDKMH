package BUS;

import java.util.ArrayList;

import DTO.TietHoc;

public class TietHocBUS {
	static ArrayList<TietHoc> dsth = new ArrayList<TietHoc>();

	public TietHocBUS() {

	}

	public boolean them(TietHoc obj) {
		if(checkTrung(obj)) {
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
}
