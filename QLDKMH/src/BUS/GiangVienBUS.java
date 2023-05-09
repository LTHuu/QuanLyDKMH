package BUS;

import java.util.ArrayList;

import DTO.GiangVienDTO;

public class GiangVienBUS {
        static ArrayList<GiangVienDTO> dsGV = new ArrayList<GiangVienDTO>();
        static int slGV = 0;

        public GiangVienBUS() {

        }

        public boolean them(GiangVienDTO obj) {
                if (checkTrung(obj)) {
                        dsGV.add(obj);
                        slGV++;
                        return true;
                }
                return false;
        }

        public boolean checkTrung(GiangVienDTO obj) {
                for (GiangVienDTO temp : dsGV) {
                        if (temp.getMaGV().equals(obj.getMaGV())) {
                                return false;
                        }
                }
                return true;
        }

        public void sua(GiangVienDTO old_obj, GiangVienDTO new_obj) {
                dsLH.set(dsGV.indexOf(old_obj), new_obj);
        }

        public void xoa(GiangVienDTO obj) {
                dsGV.remove(dsGV.indexOf(obj));
                slGV--;
        }

        public ArrayList<GiangVienDTO> tim(String str) {
                ArrayList<GiangVienDTO> temp = new ArrayList<GiangVienDTO>();
                for (GiangVien t : dsGV) {
                        boolean ok = false;
                        if (t.getMaGV().indexOf(str) != -1) {
                                ok = true;
                        }
                        if (!ok && t.getTenGV().indexOf(str) != -1) {
                                ok = true;
                        }

                        if (ok)
                                temp.add(t);
                }
                return temp;
        }

        public static ArrayList<GiangVien> getDsGV() {
                return dsGV;
        }

        public static int getSlGV() {
                return SlGV;
        }

        public static void setDsGV(ArrayList<GiangVien> dsGV) {
                GiangVienBUS.dsGV = dsGV;
        }

        public static void setSlGV(int slGV) {
                GiangVienBUS.slGV = slGV;
        }
}
