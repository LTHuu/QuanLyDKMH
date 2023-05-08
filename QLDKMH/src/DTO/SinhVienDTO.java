/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author Thanh
 */
public class SinhVienDTO {
    int SoDT,MaSV;
    String TenSV,DiaChi;
        public SinhVienDTO(int SoDT,int MaSV , String TenSV, String DiaChi) {
            this.DiaChi = DiaChi;
            this.MaSV = MaSV;
            this.TenSV = TenSV;
            this.SoDT = SoDT;

        } 
        // Getter
                // String 
            public String getDiaChi(){  
                return DiaChi;
            }
            public String getTenSV(){  
                return TenSV;
            }
                // Integer
            public int getSoDT(){
                return SoDT;
            }
            public int getMaSV(){
                return MaSV;
            }
        // Setter
            //String
            public void setDiaChi(String DiaChi){
               this.DiaChi = DiaChi;
            }
             public void setTenSV(String TenSV){
               this.TenSV = TenSV;
        }
             //Integer
             public void setSoDT(int SoDT){
               this.SoDT = SoDT;
             }
             public void setMaSV(int MaSV){
               this.MaSV = MaSV;
             }

}
