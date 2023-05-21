package BUS;

import java.util.ArrayList;

import DAO.GiangVienDAO;
import DTO.GiangVien;
import DTO.SinhVienDTO;

public class GiangVienBUS {
	static ArrayList<GiangVien> dsGV = new ArrayList<GiangVien>();
	GiangVienDAO dao = new GiangVienDAO();

	public GiangVienBUS() {
		dsGV = dao.ReadData();
	}

	public boolean them(GiangVien obj) {
		if (checkTrung(obj)) {
			dsGV.add(obj);
			dao.Them(obj);
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
		if (dsGV.indexOf(old_obj) != -1) {
			dsGV.set(dsGV.indexOf(old_obj), new_obj);
			dao.UpdateData(new_obj, old_obj.getMaGV());
		}
	}

	public void sua(String magv, GiangVien new_obj) {
		GiangVien gv = timMaGV(magv);
		if (gv != null) {
			dsGV.set(dsGV.indexOf(gv), new_obj);
			dao.UpdateData(new_obj, magv);
		}
	}

	public void xoa(GiangVien obj) {
		if (dsGV.indexOf(obj) != -1) {
			dao.DeleteData(obj);
			dsGV.remove(dsGV.indexOf(obj));
		}
	}
	
	public void xoa(String magv) {
		GiangVien obj = timMaGV(magv);
		if (dsGV.indexOf(obj) != -1) {
			dao.DeleteData(obj);
			dsGV.remove(dsGV.indexOf(obj));
		}
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

	public static void setDsGV(ArrayList<GiangVien> dsGV) {
		GiangVienBUS.dsGV = dsGV;
	}
}
