package BUS;

import java.util.ArrayList;

import DAO.HocPhanDAO;
import DTO.HocPhan;
import DTO.PhanCongDTO;

public class HocPhanBUS {
	static ArrayList<HocPhan> dshp = new ArrayList<HocPhan>();
	HocPhanDAO dao = new HocPhanDAO();

	public HocPhanBUS() {
		dshp = dao.ReadData();
	}

	public boolean them(HocPhan obj) {
		PhanCongBUS pc = new PhanCongBUS();
		if (checkTrung(obj)) {
			pc.them(new PhanCongDTO(obj.getMaGV(), "DayHoc", obj.getMaHP()));
			dshp.add(obj);
			dao.Them(obj);
			return true;
		}
		return false;
	}

	public boolean checkTrung(HocPhan obj) {
		for (HocPhan temp : dshp) {
			if (temp.getMaHP().equals(obj.getMaHP()))
				return false;
		}
		return true;
	}

	public boolean xoa(HocPhan obj) {
		if (dshp.indexOf(obj) != -1) {
			dshp.remove(dshp.indexOf(obj));
			dao.DeleteData(obj);
			return true;
		}
		return false;
	}

	public void xoa(String mahp) {
		HocPhan obj = timMaHP(mahp);
		if (dshp.indexOf(obj) != -1) {
			dshp.remove(dshp.indexOf(obj));
			dao.DeleteData(obj);
		}
	}

	public boolean sua(HocPhan old_obj, HocPhan new_obj) {
		if (dshp.indexOf(old_obj) != -1) {
			dshp.set(dshp.indexOf(old_obj), new_obj);
			dao.UpdateData(new_obj);
			return true;
		}
		return false;
	}

	public boolean sua(String mahp, HocPhan new_obj) {
		HocPhan temp = timMaHP(mahp);
		if (temp != null) {
			dshp.set(dshp.indexOf(temp), new_obj);
			dao.UpdateData(new_obj);
			return true;
		}
		return false;
	}

	public ArrayList<HocPhan> timMaMH(String str) {
		ArrayList<HocPhan> temp = new ArrayList<HocPhan>();
		for (HocPhan t : dshp) {
			if (t.getMaMH().indexOf(str) != -1) {
				temp.add(t);
			}
		}
		return temp;
	}

	public HocPhan timMaHP(String mahp) {
		for (HocPhan temp : dshp) {
			if (temp.getMaHP().equals(mahp)) {
				return temp;
			}
		}
		return null;
	}

	public boolean DangKy(String mahp) {
		HocPhan temp = timMaHP(mahp);
		if (temp != null) {
			if (temp.getSiSo() == temp.getSiSoToiDa()) {
				return false;
			} else {
				temp.setSiSo(temp.getSiSo() + 1);
				sua(temp.getMaHP(), temp);
				return true;
			}

		}
		return false;
	}

	public void HuyDangKy(String mahp) {
		HocPhan temp = timMaHP(mahp);
		if (temp != null) {
			temp.setSiSo(temp.getSiSo() - 1);
			sua(temp.getMaHP(), temp);
		}
	}

	public ArrayList<HocPhan> tim(String tim, String ngbd, String ngkt) {
		ArrayList<HocPhan> list = new ArrayList<HocPhan>();

		for (HocPhan temp : dshp) {
			boolean ok = false;
			if (temp.getMaHP().indexOf(tim) != -1) {
				ok = true;
			}
			if (temp.getMaMH().indexOf(tim) != -1) {
				ok = true;
			}
			if (checkNg(temp.getNgBD(), ngbd, ngkt) && checkNg(temp.getNgKT(), ngbd, ngkt) && ok) {
				list.add(temp);
			}
		}
		return list;
	}

	public boolean checkNg(String then, String NgBD, String NgKT) throws NumberFormatException {
		System.out.println("vào: " + then + " |ngbd " + NgBD + " |ngkt " + NgKT);
		if (then.isBlank() || NgBD.isBlank() || NgKT.isBlank())
			return true;
		System.out.println("vào");
		String[] BD = NgBD.split("/");
		System.out.println("BD: " + NgBD);
		String[] THEN = then.split("/");
		System.out.println("HT: " + then);
		String[] KT = NgKT.split("/");
		System.out.println("KT: " + NgKT);

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
			System.out.println("thỏa năm");
			// kiểm tra tháng
			if ((ybd < ythen || mbd <= mthen) && (ythen < ykt || mthen <= mkt)) {
				System.out.println("thỏa tháng");
				// kiểm tra ngày
				if ((mbd < mthen || dbd <= dthen) && (mthen < mkt || dthen <= dkt)) {
					System.out.println("thỏa ngày");
					return true;
				}
			}
		}
		return false;
	}

	public static ArrayList<HocPhan> getDshp() {
		return dshp;
	}

	public static void setDshp(ArrayList<HocPhan> dshp) {
		HocPhanBUS.dshp = dshp;
	}
}
