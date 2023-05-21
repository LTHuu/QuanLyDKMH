package BUS;

import java.util.ArrayList;

import DAO.LichThiDAO;
import DTO.LichThi;

public class LichThiBUS {
	static ArrayList<LichThi> dsLT = new ArrayList<LichThi>();
	LichThiDAO dao = new LichThiDAO();

	public LichThiBUS() {
		dsLT = dao.ReadData();
	}

	public boolean them(LichThi obj) {
		if (checkTrung(obj)) {
			dsLT.add(obj);
			dao.Them(obj);
			KetQuaKTBUS ktb = new KetQuaKTBUS();
			ktb.them(obj.getMaHP(), obj.getMaKT());
			return true;
		}
		return false;
	}

	public boolean checkTrung(LichThi obj) {
		for (LichThi t : dsLT) {
			if (t.getMaKT().equals(obj.getMaKT()))
				return false;
		}
		return true;
	}

	public void xoa(LichThi obj) {
		if (dsLT.indexOf(obj) != -1) {
			KetQuaKTBUS kq = new KetQuaKTBUS();
			kq.xoa(obj.getMaKT());
			dsLT.remove(dsLT.indexOf(obj));
			dao.DeleteData(obj);
		}
	}

	public void xoa(String makt) {
		LichThi temp = timMaKT(makt);
		if (temp != null) {
			KetQuaKTBUS kq = new KetQuaKTBUS();
			kq.xoa(makt);
			dsLT.remove(dsLT.indexOf(temp));
			dao.DeleteData(temp);
		}
	}

	public void xoaMaHP(String mahp) {
		for (LichThi temp : timMaHP(mahp)) {
			xoa(temp.getMaKT());
		}
	}

	public void sua(LichThi old_obj, LichThi new_obj) {
		if (dsLT.indexOf(old_obj) != -1) {
			dao.UpdateData(new_obj, old_obj.getMaKT());
			dsLT.set(dsLT.indexOf(old_obj), new_obj);
		}
	}

	public void sua(LichThi new_obj, String makt) {
		LichThi temp = timMaKT(makt);
		if (temp != null) {
			dao.UpdateData(new_obj, makt);
			dsLT.set(dsLT.indexOf(temp), new_obj);
		}
	}

	public LichThi timMaKT(String makt) {
		for (LichThi temp : dsLT) {
			if (temp.getMaKT().equals(makt))
				return temp;
		}
		return null;
	}

	public ArrayList<LichThi> tim(String str) {
		ArrayList<LichThi> temp = new ArrayList<LichThi>();
		for (LichThi t : dsLT) {
			boolean ok = false;
			if (t.getMaKT().indexOf(str) != -1) {
				ok = true;
			}

			if (t.getMaHP().indexOf(str) != -1) {
				ok = true;
			}
			if (t.getLoaiKT().indexOf(str) != -1) {
				ok = true;
			}
			if (t.getNgayKT().indexOf(str) != -1) {
				ok = true;
			}
			if (ok)
				temp.add(t);
		}
		return temp;
	}

	public ArrayList<LichThi> timMaHP(String mahp) {
		ArrayList<LichThi> temp = new ArrayList<LichThi>();
		for (LichThi t : dsLT) {
			if (t.getMaHP().equals(mahp))
				temp.add(t);
		}
		return temp;
	}

	public static ArrayList<LichThi> getDsLT() {
		return dsLT;
	}

	public static void setDsLT(ArrayList<LichThi> dsLT) {
		LichThiBUS.dsLT = dsLT;
	}
}
