package DTO;

public class KetQuaKT {
	String MaKT;
	float Diem;
	String MaSV;

	public KetQuaKT(String MaKT, float diem, String maSV) {
		this.MaKT = MaKT;
		Diem = diem;
		MaSV = maSV;
	}

	public KetQuaKT(KetQuaKT obj) {
		MaKT = obj.MaKT;
		Diem = obj.Diem;
		MaSV = obj.MaSV;
	}

	public Object[] toArray() {
		return new Object[] { MaKT, MaSV, Diem };
	}

	public String getMaKT() {
		return MaKT;
	}

	public float getDiem() {
		return Diem;
	}

	public String getMaSV() {
		return MaSV;
	}

	public void setMaKT(String MaKT) {
		this.MaKT = MaKT;
	}

	public void setDiem(float diem) {
		Diem = diem;
	}

	public void setMaSV(String maSV) {
		MaSV = maSV;
	}

}
