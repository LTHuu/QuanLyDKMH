package DTO;

public class DangKiDTO {
	String MaSV;
	String NgDK;
	String MaHP;

	public DangKiDTO() {

	}

	public DangKiDTO(String maSV, String ngDK, String maHP) {
		MaSV = maSV;
		NgDK = ngDK;
		MaHP = maHP;
	}

	public DangKiDTO(DangKiDTO obj) {
		MaSV = obj.MaSV;
		NgDK = obj.NgDK;
		MaHP = obj.MaHP;
	}

	public String getMaSV() {
		return MaSV;
	}

	public String getNgDK() {
		return NgDK;
	}

	public String getMaHP() {
		return MaHP;
	}

	public void setMaSV(String maSV) {
		MaSV = maSV;
	}

	public void setNgDK(String ngDK) {
		NgDK = ngDK;
	}

	public void setMaHP(String maHP) {
		MaHP = maHP;
	}

}
