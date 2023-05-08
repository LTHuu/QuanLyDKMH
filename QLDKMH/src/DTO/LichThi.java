/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author MeoMeo
 */
public class LichThi {
	String MaKT;
	String NgayKT;
	String TGBatDau;
	String MaHP;
	String LoaiKT;

	public LichThi() {
		MaKT = null;
		NgayKT = null;
		TGBatDau = null;
		MaHP = null;
		LoaiKT = null;
	}

	public LichThi(LichThi obj) {
		this.MaKT = obj.MaKT;
		this.NgayKT = obj.NgayKT;
		this.TGBatDau = obj.TGBatDau;
		this.MaHP = obj.MaHP;
		this.LoaiKT = obj.LoaiKT;
	}

	public LichThi(String maKT, String ngayKT, String tgBatDau, String maHP, String loaiKT) {
		super();
		MaKT = maKT;
		NgayKT = ngayKT;
		TGBatDau = tgBatDau;
		MaHP = maHP;
		LoaiKT = loaiKT;
	}

	public String getMaKT() {
		return MaKT;
	}

	public String getNgayKT() {
		return NgayKT;
	}

	public String getTGBatDau() {
		return TGBatDau;
	}

	public void setMaKT(String maKT) {
		MaKT = maKT;
	}

	public void getNgayKT(String ngayKT) {
		NgayKT = ngayKT;
	}

	public void getTGBatDau(String tgBatDau) {
		TGBatDau = tgBatDau;
	}

	public String getMaHP() {
		return MaHP;
	}

	public void setNgayKT(String ngayKT) {
		NgayKT = ngayKT;
	}

	public void setTGBatDau(String tGBatDau) {
		TGBatDau = tGBatDau;
	}

	public void setMaHP(String maHP) {
		MaHP = maHP;
	}

	public String getLoaiKT() {
		return LoaiKT;
	}

	public void setLoaiKT(String loaiKT) {
		LoaiKT = loaiKT;
	}

}
