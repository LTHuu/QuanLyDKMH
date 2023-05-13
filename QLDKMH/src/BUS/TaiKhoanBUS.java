package BUS;

import java.util.ArrayList;

import DAO.TaiKhoanDAO;
import DTO.TaiKhoan;
import main.jpSlideBar;

public class TaiKhoanBUS {
	static ArrayList<TaiKhoan> dsTK = new ArrayList<TaiKhoan>();

	TaiKhoanDAO dao = new TaiKhoanDAO();

	public TaiKhoanBUS() {
		dsTK = dao.ReadData();
	}

	public boolean addTaiKhoan(TaiKhoan obj) {
		if (checkTrung(obj)) {
			dsTK.add(obj);
			dao.Them(obj);
			return true;
		}
		return false;
	}

	public boolean checkTrung(TaiKhoan obj) {
		for (TaiKhoan t : dsTK) {
			if (t.getMaTK().equals(obj.getMaTK()))
				return false;
		}
		return true;
	}

	public void xoa(TaiKhoan obj) {
		if (dsTK.indexOf(obj) != -1) {
			dsTK.remove(dsTK.indexOf(obj));
			dao.DeleteData(obj);
		}

	}

	public void sua(TaiKhoan old_obj, TaiKhoan new_obj) {
		if (dsTK.indexOf(old_obj) != -1) {
			dsTK.set(dsTK.indexOf(old_obj), new_obj);
			dao.UpdateData(new_obj, old_obj.getMaTK());
		}
	}

	public boolean DangNhap(String tenDN, String pass) {
		for (TaiKhoan temp : dsTK) {
			if (temp.getTenDN().equals(tenDN)) {
				if (temp.getMatKhau().equals(pass)) {
					System.out.println("thành công!");
					SinhVienBUS sv = new SinhVienBUS();
					GiangVienBUS gv = new GiangVienBUS();
					jpSlideBar.setMaTK(temp.getMaTK());
					if (sv.timMaSV(temp.getMaTK()) != null) {
						jpSlideBar.setRole("SV");
						return true;
					} else {
						if (gv.timMaGV(temp.getMaTK()) != null) {
							jpSlideBar.setRole("GV");
							return true;
						} else {
							jpSlideBar.setRole("AD");
							return true;
						}
					}

				}
			}
		}
		return false;
	}

	public static ArrayList<TaiKhoan> getDsTK() {
		return dsTK;
	}

	public static void setDsTK(ArrayList<TaiKhoan> dsTK) {
		TaiKhoanBUS.dsTK = dsTK;
	}

}
