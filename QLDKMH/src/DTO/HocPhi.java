/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author MeoMeo
 */
public class HocPhi {
 
	String MaHocPhi;
	String MaSV;
	String MaHP;
	String NgDong;
	float SoTien;

	public HocPhi() {
		this.MaHocPhi = null;
		this.MaSV = null;
		this.MaHP = null;
		this.NgDong = null;
		this.SoTien = 0;
	}

	public HocPhi(HocPhi obj) {
		this.MaHocPhi = obj.MaHocPhi;
		this.MaSV = obj.MaSV;
		this.MaHP = obj.MaHP;
		this.NgDong = obj.NgDong;
		this.SoTien = obj.SoTien;
	}

	public HocPhi(String maHocPhi,String maSV, String maHP, String ngDong, float soTien) {
		MaHocPhi = maHocPhi;
		MaSV = maSV;
		MaHP = maHP;
		NgDong = ngDong;
		SoTien = soTien;
	}

	public String getMaSV() {
		return MaSV;
	}

	public String getMaHP() {
		return MaHP;
	}

	public String getNgDong() {
		return NgDong;
	}

	public float getSoTien() {
		return SoTien;
	}

	public void setMaSV(String maSV) {
		MaSV = maSV;
	}

	public void setMaHP(String maHP) {
		MaHP = maHP;
	}

	public void setNgDong(String ngDong) {
		NgDong = ngDong;
	}

	public void setSoTien(float soTien) {
		SoTien = soTien;
	}

	public String getMaHocPhi() {
		return MaHocPhi;
	}

	public void setMaHocPhi(String maHocPhi) {
		MaHocPhi = maHocPhi;
	}

}


