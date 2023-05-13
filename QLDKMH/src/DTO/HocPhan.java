package DTO;

import BUS.GiangVienBUS;
import BUS.MonHocBUS;

public class HocPhan {

	String MaHP;
	String TenHP;
	String NgBD;
	String NgKT;
	String MaHK;
	String MaMH;
	String MaGV;
	int SiSo;
	int SiSoToiDa;

	public HocPhan() {

	}

	public HocPhan(String maHP, String tenHP, String ngBD, String ngKT, String maHK, String maMH, int siSo, int sstd,
			String magv) {
		super();
		MaHP = maHP;
		TenHP = tenHP;
		NgBD = ngBD;
		NgKT = ngKT;
		MaHK = maHK;
		MaMH = maMH;
		SiSo = siSo;
		SiSoToiDa = sstd;
		MaGV = magv;
	}

	public HocPhan(HocPhan obj) {
		MaHP = obj.MaHP;
		TenHP = obj.TenHP;
		NgBD = obj.NgBD;
		NgKT = obj.NgKT;
		MaHK = obj.MaHK;
		MaMH = obj.MaMH;
		SiSo = obj.SiSo;
		SiSoToiDa = obj.SiSoToiDa;
		MaGV = obj.MaGV;
	}

	public Object[] toArrayDKMH() {
		MonHocBUS mhb = new MonHocBUS();
		GiangVienBUS gvb = new GiangVienBUS();
		return new Object[] { MaMH, MaHP, TenHP, mhb.timMaMH(MaMH).getSoTC(), SiSo, SiSoToiDa,
				gvb.timMaGV(MaGV).getTenGV() };
	}
	
	public Object[] toArrayDaDK() {
		MonHocBUS mhb = new MonHocBUS();
		return new Object[] {MaMH,TenHP,MaHP,mhb.timMaMH(MaMH).getSoTC()};
	}

	public String getMaMH() {
		return MaMH;
	}

	public void setMaMH(String maMH) {
		MaMH = maMH;
	}

	public String getMaHP() {
		return MaHP;
	}

	public String getTenHP() {
		return TenHP;
	}

	public String getNgBD() {
		return NgBD;
	}

	public String getNgKT() {
		return NgKT;
	}

	public String getMaHK() {
		return MaHK;
	}

	public void setMaHP(String maHP) {
		MaHP = maHP;
	}

	public void setTenHP(String tenHP) {
		TenHP = tenHP;
	}

	public void setNgBD(String ngBD) {
		NgBD = ngBD;
	}

	public void setNgKT(String ngKT) {
		NgKT = ngKT;
	}

	public void setMaHK(String maHK) {
		MaHK = maHK;
	}

	public int getSiSo() {
		return SiSo;
	}

	public int getSiSoToiDa() {
		return SiSoToiDa;
	}

	public void setSiSo(int siSo) {
		SiSo = siSo;
	}

	public void setSiSoToiDa(int siSoToiDa) {
		SiSoToiDa = siSoToiDa;
	}

	public String getMaGV() {
		return MaGV;
	}

	public void setMaGV(String maGV) {
		MaGV = maGV;
	}

}
