package DTO;

import BUS.GiangVienBUS;
import BUS.HocPhanBUS;
import BUS.MonHocBUS;

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

	public Object[] toArray() {
		GiangVienBUS gvb = new GiangVienBUS();
		return new Object[] { MaGV, gvb.timMaGV(MaGV).getTenGV(), LoaiPC, MaPC };
	}

	public Object[] toArray1() {
		HocPhanBUS hpb = new HocPhanBUS();
		HocPhan hp = hpb.timMaHP(MaPC);
		if (hp == null)
			return null;
		MonHocBUS mhb = new MonHocBUS();
		MonHoc mh = mhb.timMaMH(hp.getMaMH());
		return new Object[] { LoaiPC, MaPC, hp.getMaMH(), mh.getTenMH() };
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
