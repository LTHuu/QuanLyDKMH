package BUS;

import java.util.ArrayList;

import DTO.TaiKhoan;

public class TaiKhoanBUS {
    static ArrayList<TaiKhoan> dsTK = new ArrayList <TaiKhoan>();
    private static int slTK;

    public TaiKhoanBUS(){

    }

    public boolean addTaiKhoan(TaiKhoan obj){
        if(checkTrung(obj)){
            dsTK.add(obj);
            slTK;
            return true;
        }
        return false;
    }
    public boolean checkTrungTaiKhoan(TaiKhoan obj){
        for (TaiKhoan t : dsTK){
            if(t.getMaTK().equals(obj.getMaTK)))
            return false;
        }
        return true;
    }
    public void xoa(TaiKhoan obj){
        dsTK.remove(dsTK.indexOf(obj));
        slTK--;
    }
    public void sua(TaiKhoan old_obj,TaiKhoan new_obj){
        dsTK.set(dsTK.indexOf(old_obj),new_obj);
    }

    public ArrayList<TaiKhoan> timkiem(String MaTK,String TenDN,String NgayLap,String Email){
        ArrayList<TaiKhoan> = new ArrayList<TaiKhoan>();
        for(TaiKhoan tk : dsTK){
            boolean ok  = false;
         // Find matk
            if(!ok && checkTk(tk,TenDN,NgayLap)){
                ok = true;
            }
            if(ok)
                temp.add(tk);
        }
        return temp;
    }
    public boolean checkNgayLap(TaiKhoan obj, Date NgayLap) throws NumberFormatException {
        Date NgayLap = new Date();
        if(NgayLap.before(Today)) {
            return true;
        }
        else{
            return false;
        }
    }
    public static ArrayList<TaiKhoan> getDsTK (){
        return dsTK;
    }

    public static int getSlTK(){
        return slTK;
    }

    public static void setDsTK(ArrayList<TaiKhoan> dsTK){
        TaiKhoanBUS.dsTK = slTK;
    }
    public static void setSlLT(int slTK) {
        TaiKhoanBUS.slTK = slTK;
    }

}
