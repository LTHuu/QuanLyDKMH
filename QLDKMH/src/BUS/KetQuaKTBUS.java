package BUS;

import java.util.ArrayList;
import java.util.Arrays;

import DAO.KetQuaKTDAO;
import DTO.DangKiDTO;
import DTO.KetQuaKT;
import DTO.LichThi;

public class KetQuaKTBUS {
	static ArrayList<KetQuaKT> dsKQ = new ArrayList<KetQuaKT>();
	KetQuaKTDAO dao = new KetQuaKTDAO();

	public KetQuaKTBUS() {
		dsKQ = dao.ReadData();
	}

	public boolean them(KetQuaKT obj) {
		if (checkTrung(obj)) {
			System.out.println("vào thêm");
			dsKQ.add(obj);
			dao.Them(obj);
		}
		return false;
	}

	public void them(String mahp, String makt) {
		DangKiBUS dkb = new DangKiBUS();
		System.out.println("size: " + dkb.timMaHP(mahp).size());
		for (DangKiDTO temp : dkb.timMaHP(mahp)) {
			System.out.println("thêm");
			them(new KetQuaKT(makt, 0, temp.getMaSV()));
		}
	}

	public boolean checkTrung(KetQuaKT obj) {
		for (KetQuaKT temp : dsKQ) {
			if (temp.getMaKT().equals(obj.getMaKT()) && temp.getMaSV().equals(obj.getMaSV())) {
				return false;
			}
		}
		return true;
	}

	public void sua(KetQuaKT old_obj, KetQuaKT new_obj) {
		if (dsKQ.indexOf(old_obj) != -1) {
			dsKQ.set(dsKQ.indexOf(old_obj), new_obj);
			dao.UpdateData(new_obj, old_obj.getMaSV(), old_obj.getMaKT());
		}
	}

	public void sua(String masv, String makt, KetQuaKT new_obj) {
		KetQuaKT t = timMaSV_MaKT(masv, makt);
		sua(t, new_obj);
	}

	public void xoa(KetQuaKT obj) {
		if (dsKQ.indexOf(obj) != -1) {
			dsKQ.remove(dsKQ.indexOf(obj));
			dao.DeleteData(obj);
		}
	}

	public void xoa(String makt) {
		for (KetQuaKT temp : timMaKT(makt)) {
			xoa(temp);
		}
	}

	public void xoa(String makt, String masv) {
		KetQuaKT t = timMaSV_MaKT(masv, makt);
		xoa(t);
	}

	public ArrayList<KetQuaKT> tim(String MaSV, float diem1, float diem2) {
		ArrayList<KetQuaKT> temp = new ArrayList<KetQuaKT>();
		for (KetQuaKT t : dsKQ) {
			boolean ok = false;
			if (t.getMaSV().indexOf(MaSV) != -1) {
				ok = true;
			}
			if (!ok && (diem1 <= t.getDiem() && t.getDiem() <= diem2)) {
				ok = true;
			}
		}
		return temp;
	}

	public float[] getDiemLoaiKT(String mahp, String masv, String LoaiKT) {
		float[] diem = new float[0];
		for (KetQuaKT t : getDiem(mahp, masv, LoaiKT)) {
			diem = Arrays.copyOf(diem, diem.length + 1);
			diem[diem.length - 1] = t.getDiem();
		}
		return diem;
	}

	public ArrayList<KetQuaKT> getDiem(String mahp, String masv, String LoaiKT) {
		ArrayList<KetQuaKT> list = new ArrayList<KetQuaKT>();
		LichThiBUS ltb = new LichThiBUS();
		for (LichThi t : ltb.timMaHP(mahp)) {
			if (t.getLoaiKT().equals(LoaiKT))
				list.add(timMaSV_MaKT(masv, t.getMaKT()));
		}
		return list;
	}

	public KetQuaKT timMaSV_MaKT(String masv, String makt) {
		for (KetQuaKT t : dsKQ) {
			if (t.getMaKT().equals(makt) && t.getMaSV().equals(masv))
				return t;
		}
		return null;
	}

	public ArrayList<KetQuaKT> timMaSV(String masv) {
		ArrayList<KetQuaKT> list = new ArrayList<KetQuaKT>();
		for (KetQuaKT temp : dsKQ) {
			if (temp.getMaSV().equals(masv))
				list.add(temp);
		}
		return list;
	}

	public ArrayList<KetQuaKT> timMaKT(String makt) {
		ArrayList<KetQuaKT> list = new ArrayList<KetQuaKT>();
		for (KetQuaKT temp : dsKQ) {
			if (temp.getMaKT().equals(makt))
				list.add(temp);
		}
		return list;
	}

	public static ArrayList<KetQuaKT> getDsKQ() {
		return dsKQ;
	}

	public static void setDsKQ(ArrayList<KetQuaKT> dsKQ) {
		KetQuaKTBUS.dsKQ = dsKQ;
	}

}