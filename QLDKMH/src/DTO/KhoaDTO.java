/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

public class KhoaDTO {
	String MaKhoa;
	String TenKhoa;
	int NamTL;

	public KhoaDTO() {
		MaKhoa = null;
		TenKhoa = null;
		NamTL = 0;
	}

	public KhoaDTO(KhoaDTO obj) {
		this.MaKhoa = obj.MaKhoa;
		this.TenKhoa = obj.TenKhoa;
		this.NamTL = obj.NamTL;
	}

	public KhoaDTO(String maKhoa, String tenKhoa, int namTL) {
		super();
		MaKhoa = maKhoa;
		TenKhoa = tenKhoa;
		NamTL = namTL;
	}

	public String getMaKhoa() {
		return MaKhoa;
	}

	public String getTenKhoa() {
		return TenKhoa;
	}

	public int getNamTL() {
		return NamTL;
	}

	public void setMaKhoa(String maKhoa) {
		MaKhoa = maKhoa;
	}

	public void setTenKhoa(String tenKhoa) {
		TenKhoa = tenKhoa;
	}

	public void setNamTL(int namTL) {
		NamTL = namTL;
	}
}
