package BUS;

import java.util.ArrayList;

import DAO.SinhVienDAO;
import DTO.SinhVienDTO;

public class SinhVienBUS {
	static ArrayList<SinhVienDTO> dsSV = new ArrayList<SinhVienDTO>();
	SinhVienDAO dao = new SinhVienDAO();

	public SinhVienBUS() {
		dsSV = dao.ReadData();
	}

	public boolean them(SinhVienDTO obj) {
		if (checkTrung(obj)) {
			dsSV.add(obj);
			dao.Them(obj);
			return true;
		}
		return false;
	}

	public boolean checkTrung(SinhVienDTO obj) {
		for (SinhVienDTO temp : dsSV) {
			if (temp.getMaSV().equals(obj.getMaSV())) {
				return false;
			}
		}
		return true;
	}

	public void sua(SinhVienDTO old_obj, SinhVienDTO new_obj) {
		if (dsSV.indexOf(old_obj) != -1) {
			dao.UpdateData(new_obj, old_obj.getMaSV());
			dsSV.set(dsSV.indexOf(old_obj), new_obj);
		}
	}
	
	public void sua(String masv,SinhVienDTO new_obj) {
		SinhVienDTO sv = timMaSV(masv);
		if (sv!=null) {
			dao.UpdateData(new_obj, masv);
			dsSV.set(dsSV.indexOf(sv), new_obj);
		}
	}

	public void xoa(SinhVienDTO obj) {
		if (dsSV.indexOf(obj) != -1) {
			dao.DeleteData(obj);
			dsSV.remove(dsSV.indexOf(obj));
		}
	}
	
	public void xoa(String masv) {
		SinhVienDTO obj = timMaSV(masv);
		if (dsSV.indexOf(obj) != -1) {
			dao.DeleteData(obj);
			dsSV.remove(dsSV.indexOf(obj));
		}
	}

	public SinhVienDTO timMaSV(String masv) {
//		System.out.println("tim ma sv");
		for (SinhVienDTO temp : dsSV) {
//			System.out.println("Mã SV: " + temp.getMaSV());
			if (temp.getMaSV().equals(masv)) {
				return temp;
			}
		}
		return null;
	}

	public ArrayList<SinhVienDTO> tim(String str) {
		ArrayList<SinhVienDTO> temp = new ArrayList<SinhVienDTO>();
		for (SinhVienDTO t : dsSV) {
			boolean ok = false;
			if (t.getMaSV().indexOf(str) != -1) {
				ok = true;
			}
			if (!ok && t.getTenSV().indexOf(str) != -1) {
				ok = true;
			}

			if (ok)
				temp.add(t);
		}
		return temp;
	}

	public static ArrayList<SinhVienDTO> getDsSV() {
		return dsSV;
	}

	public static void setDsSV(ArrayList<SinhVienDTO> dsSV) {
		SinhVienBUS.dsSV = dsSV;
	}

}
