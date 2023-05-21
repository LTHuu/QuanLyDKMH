package BUS;

import java.util.ArrayList;

import DAO.DangKiDAO;
import DTO.DangKiDTO;
import DTO.HocPhan;
import GUI.DangKyMHGUI;

public class DangKiBUS {
	static ArrayList<DangKiDTO> dsdk = new ArrayList<DangKiDTO>();
	DangKiDAO dao = new DangKiDAO();

	public DangKiBUS() {
		dsdk = dao.getAllDangKi();
	}

	public boolean them(DangKiDTO obj) {
		HocPhanBUS hp = new HocPhanBUS();
		if (checkTrung(obj) && hp.DangKy(obj.getMaHP())) {
			dsdk.add(obj);
			dao.themDangKi(obj);
			return true;
		}
		return false;
	}

	public boolean checkTrung(DangKiDTO obj) {
		for (DangKiDTO temp : dsdk) {
			if (temp.getMaHP().equals(obj.getMaHP()) && temp.getMaSV().equals(obj.getMaSV())) {
				return true;
			}
		}
		return true;
	}

	public void xoa(DangKiDTO obj) {
		dsdk.remove(dsdk.indexOf(obj));
		dao.xoaDangKi(obj);
		HocPhanBUS hpb = new HocPhanBUS();
		hpb.HuyDangKy(obj.getMaHP());
	}

	public void xoa2(DangKiDTO obj) {
		dsdk.remove(dsdk.indexOf(timMaHp_MaSV(obj.getMaHP(), obj.getMaSV())));
		dao.xoaDangKi(obj);
		HocPhanBUS hpb = new HocPhanBUS();
		hpb.HuyDangKy(obj.getMaHP());
	}

	public ArrayList<HocPhan> timMaSV(String masv) {
		ArrayList<HocPhan> ds = new ArrayList<HocPhan>();
		HocPhanBUS hpb = new HocPhanBUS();
		for (DangKiDTO temp : dsdk) {
			if (temp.getMaSV().equals(masv)) {
				ds.add(hpb.timMaHP(temp.getMaHP()));
			}
		}
		return ds;
	}

	public ArrayList<DangKiDTO> timMaSVDK(String masv) {
		ArrayList<DangKiDTO> ds = new ArrayList<DangKiDTO>();
		for (DangKiDTO temp : dsdk) {
			if (temp.getMaSV().equals(masv)) {
				ds.add(temp);
			}
		}
		return ds;
	}
	
	public ArrayList<DangKiDTO> timMaHP(String mahp) {
		ArrayList<DangKiDTO> ds = new ArrayList<DangKiDTO>();
		for (DangKiDTO temp : dsdk) {
			if (temp.getMaHP().equals(mahp)) {
				ds.add(temp);
			}
		}
		return ds;
	}

	public DangKiDTO timMaHp_MaSV(String mahp, String masv) {
		for (DangKiDTO temp : dsdk) {
			if (temp.getMaSV().equals(masv)) {
				if (temp.getMaHP().equals(mahp))
					return temp;
			}
		}
		return null;
	}
}
