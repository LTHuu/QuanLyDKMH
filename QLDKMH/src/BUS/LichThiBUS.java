package BUS;

import java.util.ArrayList;

import DTO.LichThi;

public class LichThiBUS {
	static ArrayList<LichThi> dsLT = new ArrayList<LichThi>();
	static int slLT = 0;

	public LichThiBUS() {

	}

	public boolean them(LichThi obj) {
		if (checkTrung(obj)) {
			dsLT.add(obj);
			slLT++;
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
		dsLT.remove(dsLT.indexOf(obj));
		slLT--;
	}

	public void sua(LichThi old_obj, LichThi new_obj) {
		dsLT.set(dsLT.indexOf(old_obj), new_obj);
	}

	public ArrayList<LichThi> tim(String MaHP, String NgBD, String NgKT) {
		ArrayList<LichThi> temp = new ArrayList<LichThi>();
		for (LichThi t : dsLT) {
			boolean ok = false;
			// Tìm theo mã học phần thực hiện sau
			if (!ok && checkNg(t, NgBD, NgKT)) {
				ok = true;
			}
			if (ok)
				temp.add(t);
		}
		return temp;
	}

	public boolean checkNg(LichThi obj, String NgBD, String NgKT) throws NumberFormatException {
		String[] BD = NgBD.split("/");
		String[] KT = NgKT.split("/");
		String[] THEN = obj.getNgayKT().split("/");
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

	public static ArrayList<LichThi> getDsLT() {
		return dsLT;
	}

	public static int getSlLT() {
		return slLT;
	}

	public static void setDsLT(ArrayList<LichThi> dsLT) {
		LichThiBUS.dsLT = dsLT;
	}

	public static void setSlLT(int slLT) {
		LichThiBUS.slLT = slLT;
	}
}
