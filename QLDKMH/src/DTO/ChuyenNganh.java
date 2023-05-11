
package DTO;

class ChuyenNganhDTO {
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
		super();
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
}
