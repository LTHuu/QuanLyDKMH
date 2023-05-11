package BUS;

import java.util.ArrayList;

import DTO.PhongHoc;

public class PhongHocBUS {
    static ArrayList<PhongHoc> dsPH = new ArrayList<PhongHoc>();
    static int slPH = 0;

    public PhongHocBUS() {

    }

    public boolean them(PhongHoc obj) {
        if (checkTrung(obj)) {
            dsPH.add(obj);
            slPH++;
            return true;
        }
        return false;
    }

    public boolean checkTrung(PhongHoc obj) {
        for (PhongHoc temp : dsPH) {
            if (temp.getMaPH().equals(obj.getMaPH())) {
                return false;
            }
        }
        return true;
    }

    public void sua(PhongHoc old_obj, PhongHoc new_obj) {
        if(dsPH.indexOf(old_obj) != -1)
            dsPH.set(dsPH.indexOf(old_obj), new_obj);
    }

    public void xoa(PhongHoc obj) {
        if(dsPH.indexOf(old_obj)!= -1){
            dsPH.remove(dsPH.indexOf(obj));
            slPH--;
        }
    }

    public ArrayList<PhongHoc> tim(String str) {
        ArrayList<PhongHoc> temp = new ArrayList<PhongHoc>();
        for (PhongHoc t : dsPH) {
            boolean ok = false;
            if (t.getMaPH().indexOf(str) != -1) {
                ok = true;
            }
            if (!ok && t.getTenPH().indexOf(str) != -1) {
                ok = true;
            }

            if (ok)
                temp.add(t);
        }
        return temp;
    }

    public static ArrayList<PhongHoc> getDsPH() {
        return dsPH;
    }

    public static int getSlPH() {
        return slPH;
    }

    public static void setDsPH(ArrayList<PhongHoc> dsPH) {
        PhongHocBUS.dsPH = dsPH;
    }

    public static void setSlPH(int slPH) {
        PhongHocBUS.slPH = slPH;
    }
}
