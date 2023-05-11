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
	String MaSV;
	String TenSV;
	String SoDT;
	String Khoa;
	String DiaChi;

	public SinhVienDTO(String MaSV, String TenSV, String SoDT, String Khoa, String DiaChi) {
		this.MaSV = MaSV;
		this.TenSV = TenSV;
		this.SoDT = SoDT;
		this.Khoa = Khoa;
		this.DiaChi = DiaChi;

	}

	public String getMaSV() {
		return MaSV;
	}

	public String getTenSV() {
		return TenSV;
	}

	public String getSoDT() {
		return SoDT;
	}

	public String getKhoa() {
		return Khoa;
	}

	public String getDiaChi() {
		return DiaChi;
	}

	public void setMaSV(String maSV) {
		MaSV = maSV;
	}

	public void setTenSV(String tenSV) {
		TenSV = tenSV;
	}

	public void setSoDT(String soDT) {
		SoDT = soDT;
	}

	public void setKhoa(String khoa) {
		Khoa = khoa;
	}

	public void setDiaChi(String diaChi) {
		DiaChi = diaChi;
	}

}
