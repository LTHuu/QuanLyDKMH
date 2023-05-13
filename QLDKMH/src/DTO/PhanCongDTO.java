package DTO;

public class PhanCongDTO {
	String MaGV;
	String LoaiPC;
	String MaPC; // dùng lưu mã học phần hoặc mã kiểm tra

	public PhanCongDTO() {
	}

	public PhanCongDTO(String maGV, String loaiPC, String maPC) {
		MaGV = maGV;
		LoaiPC = loaiPC;
		MaPC = maPC;
	}

	public PhanCongDTO(PhanCongDTO obj) {
		MaGV = obj.MaGV;
		LoaiPC = obj.LoaiPC;
		MaPC = obj.MaPC;
	}

	public String getMaGV() {
		return MaGV;
	}

	public String getLoaiPC() {
		return LoaiPC;
	}

	public String getMaPC() {
		return MaPC;
	}

	public void setMaGV(String maGV) {
		MaGV = maGV;
	}

	public void setLoaiPC(String loaiPC) {
		LoaiPC = loaiPC;
	}

	public void setMaPC(String maPC) {
		MaPC = maPC;
	}


}
