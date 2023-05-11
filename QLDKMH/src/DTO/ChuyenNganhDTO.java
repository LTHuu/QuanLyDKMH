package DTO;

public class ChuyenNganhDTO {
	String MaCN;
	String TenCn;
	String MaKhoa;

	public ChuyenNganhDTO() {

	}

	public ChuyenNganhDTO(String maCN, String tenCn,String maKhoa) {
		super();
		this.MaCN = maCN;
		this.TenCn = tenCn;
		this.MaKhoa = maKhoa;
	}
	
	public ChuyenNganhDTO(ChuyenNganhDTO obj) {
		this.MaCN = obj.MaCN;
		this.TenCn = obj.TenCn;
		this.MaKhoa = obj.MaKhoa;
	}

	public String getMaCN() {
		return MaCN;
	}

	public String getTenCn() {
		return TenCn;
	}

	public void setMaCN(String MaCN) {
		this.MaCN = MaCN;
	}

	public void setTenCn(String TenCn) {
		this.TenCn = TenCn;
	}

	public String getMaKhoa() {
		return MaKhoa;
	}

	public void setMaKhoa(String maKhoa) {
		MaKhoa = maKhoa;
	}
}
