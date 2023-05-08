package DAO;

public class PhanCongDTO {
	String MaGV;
	String LoaiPC;
	String MaDuocPC; // dùng lưu mã học phần hoặc mã kiểm tra

	public PhanCongDTO() {
	}

	public PhanCongDTO(String maGV, String loaiPC, String maDuocPC) {
		MaGV = maGV;
		LoaiPC = loaiPC;
		MaDuocPC = maDuocPC;
	}

	public PhanCongDTO(PhanCongDTO obj) {
		MaGV = obj.MaGV;
		LoaiPC = obj.LoaiPC;
		MaDuocPC = obj.MaDuocPC;
	}

	public String getMaGV() {
		return MaGV;
	}

	public String getLoaiPC() {
		return LoaiPC;
	}

	public String getMaDuocPC() {
		return MaDuocPC;
	}

	public void setMaGV(String maGV) {
		MaGV = maGV;
	}

	public void setLoaiPC(String loaiPC) {
		LoaiPC = loaiPC;
	}

	public void setMaDuocPC(String maDuocPC) {
		MaDuocPC = maDuocPC;
	}

}
