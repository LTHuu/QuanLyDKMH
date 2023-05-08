package DTO;

public class HocPhan {

	String MaHP;
	String TenHP;
	String NgBD;
	String NgKT;
	String MaHK;
	String MaMH;

	public HocPhan() {

	}

	public HocPhan(String maHP, String tenHP, String ngBD, String ngKT, String maHK, String maMH) {
		super();
		MaHP = maHP;
		TenHP = tenHP;
		NgBD = ngBD;
		NgKT = ngKT;
		MaHK = maHK;
		MaMH = maMH;
	}
	
	public HocPhan(HocPhan obj) {
		MaHP = obj.MaHP;
		TenHP = obj.TenHP;
		NgBD = obj.NgBD;
		NgKT = obj.NgKT;
		MaHK = obj.MaHK;
		MaMH = obj.MaMH;
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

}
