package BUS;

import java.sql.Date;
import java.util.ArrayList;

import DTO.TaiKhoan;

public class TaiKhoanBUS {
	static ArrayList<TaiKhoan> dsTK = new ArrayList<TaiKhoan>();
	private static int slTK;

	public TaiKhoanBUS() {

	}

	public boolean addTaiKhoan(TaiKhoan obj) {
		if (checkTrung(obj)) {
			dsTK.add(obj);
			slTK++;
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
			slTK--;
		}

	}

	public void sua(TaiKhoan old_obj, TaiKhoan new_obj) {
		if (dsTK.indexOf(old_obj) != -1)
			dsTK.set(dsTK.indexOf(old_obj), new_obj);
	}

	public static ArrayList<TaiKhoan> getDsTK() {
		return dsTK;
	}

	public static int getSlTK() {
		return slTK;
	}

	public static void setDsTK(ArrayList<TaiKhoan> dsTK) {
		TaiKhoanBUS.dsTK = dsTK;
	}

	public static void setSlLT(int slTK) {
		TaiKhoanBUS.slTK = slTK;
	}

}
