/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author MeoMeo
 */
public class HocKy {
     String MaHK;
     String TenHK;
     String NgayBD;
     String NgayKT;
     int Nam;

public HocKy() {
              
}

public HocKy(String maHK, String tenHK, String ngayBD, String ngayKT, int nam){
    super();
    MaHK = maHK;
    TenHK = tenHK;
    NgayBD = ngayBD;
    NgayKT = ngayKT;
    Nam = nam;
}

public Object[] toArray() {
	return new Object[] {MaHK,TenHK,NgayBD,NgayKT};
}

public String getMaHK(){
    return MaHK;
}

public String getTenHK(){
    return TenHK;
}

public String getNgayBD(){
    return NgayBD;
}

public String getNgayKT(){
    return NgayKT;
}

public int getNam(){
    return Nam;
}

public void setMaHK(String maHK){
    MaHK = maHK;
}

public void setTenHK(String tenHK){
    TenHK = tenHK;
}

public void setNgayBD(String ngayBD){
    NgayBD = ngayBD;
}

public void setNgayKT(String ngayKT){
    NgayKT = ngayKT;
}

public void setNam(int nam){
    Nam = nam;
}

}

