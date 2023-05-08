package DTO;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author MeoMeo
 */
public class Lop {

	String MaLop;
	String TenLop;
	int NamHoc;
	String HeDaoTao;
	String Khoa;

	public Lop() {
		this.MaLop = null;
		this.TenLop = null;
		this.NamHoc = 0;
		this.HeDaoTao = null;
		this.Khoa = null;
	}

	public Lop(Lop obj) {
		MaLop = obj.MaLop;
		TenLop = obj.TenLop;
		NamHoc = obj.NamHoc;
		HeDaoTao = obj.HeDaoTao;
		Khoa = obj.Khoa;
	}

	public Lop(String maLop, String tenLop, int namHoc,String heDaoTao,String khoa) {
		super();
		MaLop = maLop;
		TenLop = tenLop;
		NamHoc = namHoc;
		HeDaoTao = heDaoTao;
		Khoa = khoa;
	}

	public String getMaLop() {
		return MaLop;
	}

	public String getTenLop() {
		return TenLop;
	}

	public int getNamHoc() {
		return NamHoc;
	}

	public void setMaLop(String maLop) {
		MaLop = maLop;
	}

	public void setTenLop(String tenLop) {
		TenLop = tenLop;
	}

	public void setNamHoc(int namHoc) {
		NamHoc = namHoc;
	}

	public String getHeDaoTao() {
		return HeDaoTao;
	}

	public String getKhoa() {
		return Khoa;
	}

	public void setHeDaoTao(String heDaoTao) {
		HeDaoTao = heDaoTao;
	}

	public void setKhoa(String khoa) {
		Khoa = khoa;
	}

}
