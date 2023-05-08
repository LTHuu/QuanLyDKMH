package BUS;
import java.util.ArrayList;
import DAO.ChuyenNganhDTO;

public class ChuyenNganhBUS {
	static ArrayList<ChuyenNganhDTO> dsCN = new ArrayList<ChuyenNganhDTO>();
	static int slCN = 0;
	public ChuyenNganhBUS() {

	}
	public boolean them(ChuyenNganhDTO obj) {
		if (checkDuplicate(obj)) {
			dsCN.add(obj);
			slCN++;
			return true;
		}
		return false;
	}

	public boolean checkDuplicate(ChuyenNganhDTO obj) {
		for (ChuyenNganhDTO temp : dsCN) {
			if (temp.getMaCN().equals(obj.getMaCN())) {
				return false;
			}
		}
		return true;
	}

	public void sua(ChuyenNganhDTO old_obj, ChuyenNganhDTO new_obj) {
		if(dsCN.indexOf(old_obj)!=-1)
			dsCN.set(dsCN.indexOf(old_obj), new_obj);
	}

	public void xoa(ChuyenNganhDTO obj) {
		if(dsCN.indexOf(old_obj)!=-1) {
			dsCN.remove(dsCN.indexOf(obj));
			slCN--;
		}
	}

	public ArrayList<ChuyenNganhDTO> findCN(String str) {
		ArrayList<ChuyenNganhDTO> temp = new ArrayList<ChuyenNganhDTO>();
		for (ChuyenNganhDTO t : dsCN) {
			boolean ok = false;
			if (t.getMaCN().indexOf(str) != -1) {
				ok = true;
			}
			if (!ok && t.getTenCN().indexOf(str) != -1) {
				ok = true;
			}
			if (ok)
				temp.add(t);
		}
		return temp;
	}

	public static ArrayList<ChuyenNganhDTO> getDsCN() {
		return dsCN;
	}

	public static int getSlCN() {
		return slCN;
	}

	public static void setDsCN(ArrayList<ChuyenNganhDTO> dsCN) {
		ChuyenNganhBUS.dsCN = dsCN;
	}

	public static void setSlCN(int slCN) {
		ChuyenNganhBUS.slCN = slCN;
	}
}
