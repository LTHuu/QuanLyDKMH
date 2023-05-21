/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author MeoMeo
 */
public class TietHoc {
	String MaTH;
	String LoaiTH;
	String GioBD;
	String Ngay;
	int SoTiet;
	String Lop;
	String Phong;
	String MaHP;

	public TietHoc() {
	}

	public TietHoc(TietHoc obj) {
		MaTH = obj.MaTH;
		LoaiTH = obj.LoaiTH;
		GioBD = obj.GioBD;
		Ngay = obj.Ngay;
		SoTiet = obj.SoTiet;
		Lop = obj.Lop;
		Phong = obj.Phong;
		MaHP = obj.MaHP;
	}

	public TietHoc(String maTH, String loaiTH, String gioBD, String ngay, int soTiet, String lop, String phong,
			String maHP) {
		super();
		MaTH = maTH;
		LoaiTH = loaiTH;
		GioBD = gioBD;
		Ngay = ngay;
		SoTiet = soTiet;
		Lop = lop;
		Phong = phong;
		MaHP = maHP;
	}

	public Object[] toArray() {
		return new Object[] { MaTH, LoaiTH, GioBD, SoTiet, Phong };
	}

	public String getMaTH() {
		return MaTH;
	}

	public String getLoaiTH() {
		return LoaiTH;
	}

	public String getGioBD() {
		return GioBD;
	}

	public String getNgay() {
		return Ngay;
	}

	public void setMaTH(String maTH) {
		MaTH = maTH;
	}

	public void setLoaiTH(String loaiTH) {
		LoaiTH = loaiTH;
	}

	public void setGioBD(String gioBD) {
		GioBD = gioBD;
	}

	public void setNgay(String ngay) {
		Ngay = ngay;
	}

	public int getSoTiet() {
		return SoTiet;
	}

	public String getLop() {
		return Lop;
	}

	public String getPhong() {
		return Phong;
	}

	public void setSoTiet(int soTiet) {
		SoTiet = soTiet;
	}

	public void setLop(String lop) {
		Lop = lop;
	}

	public void setPhong(String phong) {
		Phong = phong;
	}

	public String getMaHP() {
		return MaHP;
	}

	public void setMaHP(String maHP) {
		MaHP = maHP;
	}

}
