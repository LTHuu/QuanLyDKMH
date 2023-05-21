package BUS;

import java.util.ArrayList;

import DAO.HocKiDAO;
import DTO.HocKy;

public class HocKyBUS {
	static ArrayList<HocKy> dsHK = new ArrayList<HocKy>();
	HocKiDAO dao = new HocKiDAO();

	public HocKyBUS() {
		dsHK = dao.ReadData();
	}

	public boolean them(HocKy obj) {
		if (checkTrung(obj)) {
			dsHK.add(obj);
			dao.Them(obj);
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
		if (dsHK.indexOf(old_obj) != -1) {
			dsHK.set(dsHK.indexOf(old_obj), new_obj);
			dao.UpdateData(new_obj, old_obj.getMaHK());
		}
	}

	public void xoa(HocKy obj) {
		dsHK.remove(dsHK.indexOf(obj));
		dao.DeleteData(obj);
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

	public static void setDsHK(ArrayList<HocKy> dsHK) {
		HocKyBUS.dsHK = dsHK;
	}
}
