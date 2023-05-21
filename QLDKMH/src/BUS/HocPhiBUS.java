package BUS;

import java.util.ArrayList;

import DAO.HocPhiDAO;
import DTO.HocPhi;

public class HocPhiBUS {
	static ArrayList<HocPhi> dsHPhi = new ArrayList<HocPhi>();
	HocPhiDAO dao = new HocPhiDAO();

	public HocPhiBUS() {

	}

	public boolean them(HocPhi obj) {
		if (CheckTrung(obj)) {
			dsHPhi.add(obj);
			dao.Them(obj);
			return true;
		}
		return false;
	}

	public boolean CheckTrung(HocPhi obj) {
		for (HocPhi temp : dsHPhi) {
			if (temp.getMaHocPhi().equals(obj.getMaHocPhi()))
				return false;
		}
		return true;
	}

	public void sua(HocPhi old_obj, HocPhi new_obj) {
		if (dsHPhi.indexOf(old_obj) != -1) {
			dsHPhi.set(dsHPhi.indexOf(old_obj), new_obj);
			dao.UpdateData(new_obj, old_obj.getMaHocPhi());
		}
	}

	public void xoa(HocPhi obj) {
		if (dsHPhi.indexOf(obj) != -1) {
			dsHPhi.remove(dsHPhi.indexOf(obj));
			dao.DeleteData(obj);
		}

	}

	/**
	 * 
	 * @param findType nếu là 0 thì tìm kiếm thỏa toàn bộ các thuộc tính nếu là 1
	 *                 thì chỉ cần thỏa 1 thuộc tính
	 * @return
	 */
	public ArrayList<HocPhi> tim(int findType, String MaHPhi, String MaSV, String MaHP, String NgBD, String NgKT,
			float Tien1, float Tien2) {
		ArrayList<HocPhi> temp = new ArrayList<HocPhi>();
		for (HocPhi t : dsHPhi) {
			boolean ok = false;
			if (t.getMaHocPhi().indexOf(MaHPhi) != -1) {
				ok = true;
			}
			if ((!ok || findType == 1) && t.getMaSV().indexOf(MaSV) != -1) {
				ok = true;
			}

			if ((!ok || findType == 1) && t.getMaHP().indexOf(MaHP) != -1) {
				ok = true;
			}

			if ((!ok || findType == 1) && checkNg(t, NgBD, NgKT)) {
				ok = true;
			}

			if ((!ok || findType == 1) && (Tien1 <= t.getSoTien() && t.getSoTien() >= Tien2)) {
				ok = true;
			}

			if (ok) {
				temp.add(t);
			}
		}
		return temp;
	}

	public boolean checkNg(HocPhi obj, String NgBD, String NgKT) throws NumberFormatException {
		String[] BD = NgBD.split("/");
		String[] KT = NgKT.split("/");
		String[] THEN = obj.getNgDong().split("/");
		// so sánh năm
		int ybd = Integer.parseInt(BD[2]);
		int ythen = Integer.parseInt(THEN[2]);
		int ykt = Integer.parseInt(KT[2]);
		int mbd = Integer.parseInt(BD[1]);
		int mthen = Integer.parseInt(THEN[1]);
		int mkt = Integer.parseInt(KT[1]);
		int dbd = Integer.parseInt(BD[0]);
		int dthen = Integer.parseInt(THEN[0]);
		int dkt = Integer.parseInt(KT[0]);
		// kiểm tra năm
		if (ybd <= ythen && ythen <= ykt) {
			// kiểm tra tháng
			if ((ybd < ythen || mbd <= mthen) && (ythen < ykt || mthen <= mkt)) {
				// kiểm tra ngày
				if ((mbd < mthen || dbd <= dthen) && (mthen < mkt || dthen <= dkt)) {
					return true;
				}
			}
		}
		return false;
	}

	public static ArrayList<HocPhi> getDsHPhi() {
		return dsHPhi;
	}

	public static void setDsHPhi(ArrayList<HocPhi> dsHPhi) {
		HocPhiBUS.dsHPhi = dsHPhi;
	}
}
