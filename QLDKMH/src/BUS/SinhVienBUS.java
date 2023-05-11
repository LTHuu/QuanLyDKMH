package BUS;

import java.util.ArrayList;

import DTO.SinhVienDTO;

public class SinhVienBUS {
    static ArrayList<SinhVienDTO> dsSV = new ArrayList<SinhVienDTO>();
    static int slSV = 0;

    public SinhVienBUS() {

    }

    public boolean them(SinhVienDTO obj) {
        if (checkTrung(obj)) {
            dsSV.add(obj);
            slSV++;
            return true;
        }
        return false;
    }

    public boolean checkTrung(SinhVienDTO obj) {
        for (SinhVienDTO temp : dsSV) {
            if (temp.getMaSV().equals(obj.getMaSV())) {
                return false;
            }
        }
        return true;
    }

    public void sua(SinhVienDTO old_obj, SinhVienDTO new_obj) {
        dsSV.set(dsSV.indexOf(old_obj), new_obj);
    }

    public void xoa(SinhVienDTO obj) {
        dsSV.remove(dsSV.indexOf(obj));
        slSV--;
    }

    public ArrayList<SinhVienDTO> tim(String str) {
        ArrayList<SinhVienDTO> temp = new ArrayList<SinhVienDTO>();
        for (SinhVienDTO t : dsSV) {
            boolean ok = false;
            if (t.getMaSV().indexOf(str) != -1) {
                ok = true;
            }
            if (!ok && t.getTenSV().indexOf(str) != -1) {
                ok = true;
            }

            if (ok)
                temp.add(t);
        }
        return temp;
    }

    public static ArrayList<SinhVienDTO> getDsSV() {
        return dsSV;
    }

    public static int getSlSV() {
        return slSV;
    }

    public static void setDsSV(ArrayList<SinhVienDTO> dsSV) {
        SinhVienBUS.dsSV = dsSV;
    }

    public static void setSlSV(int slSV) {
        SinhVienBUS.slSV = slSV;
    }
}
