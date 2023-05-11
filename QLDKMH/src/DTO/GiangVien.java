/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author MeoMeo
 */
public class GiangVien {
	String MaGV;
	String TenGV;
	String Email;
	String SDT;
	String Khoa;
	String Chuyen;

	public GiangVien() {

	}

	public GiangVien(String maGV, String tenGV, String email, String sdt, String khoa, String chuyen) {
		super();
		MaGV = maGV;
		TenGV = tenGV;
		Email = email;
		SDT = sdt;
		Khoa = khoa;
		Chuyen = chuyen;
	}
	
	public GiangVien(GiangVien obj) {
		MaGV = obj.MaGV;
		TenGV = obj.TenGV;
		Email = obj.Email;
		SDT = obj.SDT;
		Khoa = obj.Khoa;
		Chuyen = obj.Chuyen;
	}

	public String getMaGV() {
		return MaGV;
	}

	public String getTenGV() {
		return TenGV;
	}

	public String getEmail() {
		return Email;
	}

	public void setMaGV(String maGV) {
		MaGV = maGV;
	}

	public void setTenGV(String tenGV) {
		TenGV = tenGV;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getSDT() {
		return SDT;
	}

	public String getKhoa() {
		return Khoa;
	}

	public String getChuyen() {
		return Chuyen;
	}

	public void setSDT(String sDT) {
		SDT = sDT;
	}

	public void setKhoa(String khoa) {
		Khoa = khoa;
	}

	public void setChuyen(String chuyen) {
		Chuyen = chuyen;
	}

}
