package BUS;

import java.util.ArrayList;

import DAO.MonHocDAO;
import DTO.MonHoc;

public class MonHocBUS {
	static ArrayList<MonHoc> dsmh = new ArrayList<MonHoc>();
	MonHocDAO dao = new MonHocDAO();

	public MonHocBUS() {
		dsmh = dao.ReadData();
	}

	public boolean them(MonHoc obj) {
		if (checkTrung(obj)) {
			dsmh.add(obj);
			dao.Them(obj);
			return true;
		}
		return false;
	}

	public boolean checkTrung(MonHoc obj) {
		for (MonHoc temp : dsmh) {
			if (temp.getMaMH().equals(obj.getMaMH()))
				return false;
		}
		return true;
	}

	public boolean xoa(MonHoc obj) {
		if (dsmh.indexOf(obj) != -1) {
			dsmh.remove(dsmh.indexOf(obj));
			dao.DeleteData(obj);
			return true;
		}
		return false;
	}
	
	public void xoa(String mamh) {
		xoa(timMaMH(mamh));
	}

	public boolean sua(MonHoc old_obj, MonHoc new_obj) {
		if (dsmh.indexOf(old_obj) != -1) {
			dsmh.set(dsmh.indexOf(old_obj), new_obj);
			dao.UpdateData(new_obj);
			return true;
		}
		return false;
	}
	
	public boolean sua(MonHoc new_obj) {
		MonHoc old_obj = timMaMH(new_obj.getMaMH());
		return sua(old_obj,new_obj);
	}
	
	public MonHoc timMaMH(String mamh) {
		for(MonHoc temp : dsmh) {
			if(temp.getMaMH().equals(mamh))
				return temp;
		}
		return null;
	}
	
	public ArrayList<MonHoc> tim(String str){
		ArrayList<MonHoc> list = new ArrayList<MonHoc>();
		for(MonHoc temp : dsmh) {
			boolean ok = false;
			if(temp.getMaMH().indexOf(str)==-1)
				ok = true;
			if(temp.getTenMH().indexOf(str)==-1)
				ok = true;
			if(temp.getMonHocTrc().indexOf(str)==-1)
				ok = true;
			if(ok)
				list.add(temp);
		}
		return list;
	}

	public static ArrayList<MonHoc> getDsmh() {
		return dsmh;
	}

	public static void setDsmh(ArrayList<MonHoc> dsmh) {
		MonHocBUS.dsmh = dsmh;
	}
}
