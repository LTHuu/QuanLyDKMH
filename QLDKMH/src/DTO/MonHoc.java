/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author MeoMeo
 */
public class MonHoc {
	String MaMH;
	String TenMH;
	int SoTC;
	String MonHocTrc;

	public MonHoc() {
		MaMH = null;
		TenMH = null;
		SoTC = 0;
		MonHocTrc = null;
	}

	public MonHoc(MonHoc obj) {
		this.MaMH = obj.MaMH;
		this.TenMH = obj.TenMH;
		this.SoTC = obj.SoTC;
		this.MonHocTrc = obj.MonHocTrc;
	}

	public MonHoc(String maMH, String tenMH, int soTC, String mht) {
		super();
		MaMH = maMH;
		TenMH = tenMH;
		SoTC = soTC;
		MonHocTrc = mht;
	}

	public Object[] toArray() {
		return new Object[] { MaMH, TenMH, SoTC, MonHocTrc };
	}

	public String getMaMH() {
		return MaMH;
	}

	public String getTenMH() {
		return TenMH;
	}

	public int getSoTC() {
		return SoTC;
	}

	public void setMaMH(String maMH) {
		MaMH = maMH;
	}

	public void setTenMH(String tenMH) {
		TenMH = tenMH;
	}

	public void setSoTC(int soTC) {
		SoTC = soTC;
	}

	public String getMonHocTrc() {
		return MonHocTrc;
	}

	public void setMonHocTrc(String monHocTrc) {
		MonHocTrc = monHocTrc;
	}

}
