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
	int SiSo;
	String GioBD;
	String Ngay;
	int SoTiet;
	String Lop;
	String Phong;

	public TietHoc() {
	}

	public TietHoc(TietHoc obj) {
		MaTH = obj.MaTH;
		LoaiTH = obj.LoaiTH;
		SiSo = obj.SiSo;
		GioBD = obj.GioBD;
		Ngay = obj.Ngay;
		SoTiet = obj.SoTiet;
		Lop = obj.Lop;
		Phong = obj.Phong;
	}

	public TietHoc(String maTH, String loaiTH, int siSo, String gioBD, String ngay, int soTiet, String lop, String phong,
			String lTH) {
		super();
		MaTH = maTH;
		LoaiTH = loaiTH;
		SiSo = siSo;
		GioBD = gioBD;
		Ngay = ngay;
		SoTiet = soTiet;
		Lop = lop;
		Phong = phong;
	}

	public String getMaTH() {
		return MaTH;
	}

	public String getLoaiTH() {
		return LoaiTH;
	}

	public int getSiSo() {
		return SiSo;
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

	public void setSiSo(int siso) {
		SiSo = siso;
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

}
