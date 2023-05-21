package BUS;

import java.util.ArrayList;

import DAO.LopHocDAO;
import DTO.Lop;

public class LopHocBUS {
	static ArrayList<Lop> dsLH = new ArrayList<Lop>();
	LopHocDAO dao = new LopHocDAO();

	public LopHocBUS() {
		dsLH = dao.ReadData();
	}

	public boolean them(Lop obj) {
		if (checkTrung(obj)) {
			dsLH.add(obj);
			dao.Them(obj);
		}
		return false;
	}

	public boolean checkTrung(Lop obj) {
		for (Lop temp : dsLH) {
			if (temp.getMaLop().equals(obj.getMaLop())) {
				return false;
			}
		}
		return true;
	}

	public void sua(Lop old_obj, Lop new_obj) {
		if (dsLH.indexOf(old_obj) != -1) {
			dao.UpdateData(new_obj, old_obj.getMaLop());
			dsLH.set(dsLH.indexOf(old_obj), new_obj);
		}
	}

	public void xoa(Lop obj) {
		if (dsLH.indexOf(obj) != -1) {
			dsLH.remove(dsLH.indexOf(obj));
			dao.DeleteData(obj);
		}
	}

	public ArrayList<Lop> tim(String str) {
		ArrayList<Lop> temp = new ArrayList<Lop>();
		for (Lop t : dsLH) {
			boolean ok = false;
			if (t.getMaLop().indexOf(str) != -1) {
				ok = true;
			}
			if (!ok && t.getTenLop().indexOf(str) != -1) {
				ok = true;
			}

			if (ok)
				temp.add(t);
		}
		return temp;
	}

	public static ArrayList<Lop> getDsLH() {
		return dsLH;
	}

	public static void setDsLH(ArrayList<Lop> dsLH) {
		LopHocBUS.dsLH = dsLH;
	}
}
