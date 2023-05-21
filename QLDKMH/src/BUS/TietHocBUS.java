package BUS;

import java.util.ArrayList;

import DAO.TietHocDAO;
import DTO.TietHoc;

public class TietHocBUS {
	static ArrayList<TietHoc> dsth = new ArrayList<TietHoc>();
	TietHocDAO dao = new TietHocDAO();

	public TietHocBUS() {
		dsth = dao.ReadData();
	}

	public boolean them(TietHoc obj) {
		if (checkTrung(obj) && checkTrungLich(obj)) {
			dsth.add(obj);
			dao.Them(obj);
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

	public boolean checkTrungLich(TietHoc obj) {
		int tbd = getTietBD(obj.getGioBD());
		for (TietHoc temp : dsth) {
			if (temp.getPhong().equals(obj.getPhong())) {
				if (temp.getNgay().equals(obj.getNgay())) {
					if (getTietBD(temp.getGioBD()) <= tbd && tbd <= getTietBD(temp.getGioBD()) + temp.getSoTiet()) {
						return false;
					}
				}
			}
		}
		return true;
	}

	public int getTietBD(String gbd) {
		switch (gbd) {
		case "7:00": {
			return 0;

		}
		case "7:50": {
			return 1;

		}
		case "9:00": {
			return 2;

		}
		case "9:50": {
			return 3;

		}
		case "10:40": {
			return 4;

		}
		case "13:00": {
			return 5;

		}
		case "13:50": {
			return 6;

		}
		case "15:00": {
			return 7;

		}
		case "15:50": {
			return 8;

		}
		case "16:40": {
			return 9;

		}
		case "17:40": {
			return 10;

		}
		case "18:30": {
			return 11;

		}
		case "19:20": {
			return 12;

		}
		default:
			return -1;
		}
	}

	public boolean xoa(TietHoc obj) {
		if (dsth.indexOf(obj) != -1) {
			dsth.remove(dsth.indexOf(obj));
			dao.deleteTietHoc(obj);
			return true;
		}
		return false;
	}

	public boolean sua(TietHoc old_obj, TietHoc new_obj) {
		if (dsth.indexOf(old_obj) != -1) {
			dsth.set(dsth.indexOf(old_obj), new_obj);
			dao.updateTietHoc(new_obj);
			return true;
		}
		return false;
	}

	public ArrayList<TietHoc> timMaHP(String mahp) {
		ArrayList<TietHoc> temp = new ArrayList<TietHoc>();
		for (TietHoc t : dsth) {
			if (t.getMaHP().equals(mahp)) {
				temp.add(t);
			}
		}
		return temp;
	}

}
