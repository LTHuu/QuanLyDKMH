package BUS;
import java.util.ArrayList;
import DAO.HeDaoTaoDTO;

public class HeDaoTaoBUS {
	static ArrayList<HeDaoTaoDTO> dsHDT = new ArrayList<HeDaoTaoDTO>();
	static int slHDT = 0;
	public HeDaoTaoBUS() {

	}
	public boolean them(HeDaoTaoDTO obj) {
		if (checkDuplicate(obj)) {
			dsHDT.add(obj);
			slHDT++;
			return true;
		}
		return false;
	}

	public boolean checkDuplicate(HeDaoTaoDTO obj) {
		for (HeDaoTaoDTO temp : dsHDT) {
			if (temp.getMaHDT().equals(obj.getMaHDT())) {
				return false;
			}
		}
		return true;
	}

	public void sua(HeDaoTaoDTO old_obj, HeDaoTaoDTO new_obj) {
		dsHDT.set(dsHDT.indexOf(old_obj), new_obj);
	}

	public void xoa(HeDaoTaoDTO obj) {
		dsHDT.remove(dsHDT.indexOf(obj));
		slHDT--;
	}

	public ArrayList<HeDaoTaoDTO> findHDT(String str) {
		ArrayList<HeDaoTaoDTO> temp = new ArrayList<HeDaoTaoDTO>();
		for (HeDaoTaoDTO t : dsHDT) {
			boolean ok = false;
			if (t.getMaHDT().indexOf(str) != -1) {
				ok = true;
			}
			if (!ok && t.getTenHDT().indexOf(str) != -1) {
				ok = true;
			}
			if (ok)
				temp.add(t);
		}
		return temp;
	}

	public static ArrayList<HeDaoTaoDTO> getDsHDT() {
		return dsHDT;
	}

	public static int getSlHDT() {
		return slHDT;
	}

	public static void setDsHDT(ArrayList<HeDaoTaoDTO> dsHDT) {
		HeDaoTaoBUS.dsHDT = dsHDT;
	}

	public static void setSlHDT(int slHDT) {
		HeDaoTaoBUS.slHDT = slHDT;
	}
}
