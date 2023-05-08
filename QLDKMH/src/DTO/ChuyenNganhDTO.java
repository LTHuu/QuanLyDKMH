
package DTO;

public class ChuyenNganhDTO {
	String MaCN;
	String TenCN;
	String MaKhoa;

	public ChuyenNganhDTO() {

	}

	public ChuyenNganhDTO(String maCN, String tenCN, String maKhoa) {
		super();
		this.MaCN = maCN;
		this.TenCN = tenCN;
		this.MaKhoa = maKhoa;
	}
	
	public ChuyenNganhDTO(ChuyenNganhDTO obj) {
		super();
		this.MaCN = obj.MaCN;
		this.TenCN = obj.TenCN;
		this.MaKhoa = obj.MaKhoa;
	}

	public String getMaCN() {
		return MaCN;
	}

	public String getTenCN() {
		return TenCN;
	}

	public void setMaCN(String MaCN) {
		this.MaCN = MaCN;
	}

	public void setTenCN(String TenCN) {
		this.TenCN = TenCN;
	}

        public String getMaKhoa() {
            return MaKhoa;
        }

        public void setMaKhoa(String MaKhoa) {
            this.MaKhoa = MaKhoa;
        }
 
}
