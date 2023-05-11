 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author MeoMeo
 */
public class PhongHoc {
    String TenPH;
    String MaPH;
    String CoSo;
    int Lau;
    String Khu;
public PhongHoc(){
    TenPH = null;
    MaPH  = null;
    CoSo  = null;
    Lau   = 0;
    Khu   = null;
}
public PhongHoc(PhongHoc obj){
    this.TenPH = obj.TenPH;
    this.MaPH = obj.MaPH;
    this.Khu = obj.Khu;
    this.CoSo = obj.CoSo;
    this.Lau = obj.Lau;
}
public PhongHoc(String maPH,String tenPH,String khu,String coso,int lau){
    super();
    TenPH = tenPH;
    MaPH = maPH;
    Khu = khu;
    CoSo = coso;
    Lau = lau;
}

public String getTenPH(){
    return TenPH;
}

public String getMaPH(){
    return MaPH;
}
public String getKhu(){
    return Khu;
}

public String getCoSo(){
    return CoSo;
}
public int getLau(){
    return Lau;
}

public void setTenPH(String tenPH){
    TenPH = tenPH;
}
public void setMaPH(String maPH){
    MaPH = maPH;
}
public void setKhu(String khu){
    Khu = khu;
}
public void setCoSo(String coso){
    CoSo = coso;
}
public void setLau(int lau){
    Lau = lau;
}
}
