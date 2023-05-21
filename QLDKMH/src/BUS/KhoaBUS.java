package BUS;

import java.util.ArrayList;

import DAO.KhoaDAO;
import DTO.Khoa;

public class KhoaBUS {
	static ArrayList<Khoa> dsKhoa = new ArrayList<Khoa>();
	KhoaDAO dao = new KhoaDAO();

	public KhoaBUS() {
		dsKhoa = dao.ReadData();
	}

	public boolean them(Khoa obj) {
		if (checkDuplicate(obj)) {
			dsKhoa.add(obj);
			dao.addKhoa(obj);
			return true;
		}
		return false;
	}

	public boolean checkDuplicate(Khoa obj) {
		for (Khoa temp : dsKhoa) {
			if (temp.getMaKhoa().equals(obj.getMaKhoa())) {
				return false;
			}
		}
		return true;
	}

	public void sua(Khoa old_obj, Khoa new_obj) {
		if (dsKhoa.indexOf(old_obj) != -1) {
			dsKhoa.set(dsKhoa.indexOf(old_obj), new_obj);
			dao.UpdateData(new_obj, old_obj.getMaKhoa());
		}
	}

	public void xoa(Khoa obj) {
		if (dsKhoa.indexOf(obj) != -1) {
			dsKhoa.remove(dsKhoa.indexOf(obj));
			dao.DeleteData(obj);
		}
	}
	
	public Khoa timMaKhoa(String makhoa) {
		for(Khoa temp : dsKhoa) {
			if(temp.getMaKhoa().equals(makhoa)) {
				return temp;
			}
		}
		return null;
	}

	public ArrayList<Khoa> findKhoa(String str) {
		ArrayList<Khoa> temp = new ArrayList<Khoa>();
		for (Khoa t : dsKhoa) {
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

	public static ArrayList<Khoa> getDsKhoa() {
		return dsKhoa;
	}

	public static void setDsKhoa(ArrayList<Khoa> dsKhoa) {
		KhoaBUS.dsKhoa = dsKhoa;
	}
}
