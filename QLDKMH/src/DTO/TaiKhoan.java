/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;
public class TaiKhoan {
  
	private String MaTK;
	private String TenDN;
	private String MatKhau;
	private String NgLap;
	private String Email;

	public TaiKhoan() {
            MaTK = null;
            TenDN = null;
            MatKhau = null;
            NgLap = null;
            Email = null;          
	}

	public TaiKhoan(TaiKhoan obj) {
		this.MaTK = obj.MaTK;
		this.TenDN = obj.TenDN;
		this.MatKhau = obj.MatKhau;
		this.NgLap = obj.NgLap;
		this.Email = obj.Email;
	}

	public TaiKhoan(String maTK, String tenDN, String matKhau, String ngLap, String email) {
		super();
		MaTK = maTK;
		TenDN = tenDN;
		MatKhau = matKhau;
		NgLap = ngLap;
		Email = email;
	}

	public String getMaTK() {
		return MaTK;
	}

	public String getTenDN() {
		return TenDN;
	}

	public String getMatKhau() {
		return MatKhau;
	}

	public String getNgLap() {
		return NgLap;
	}

	public String getEmail() {
		return Email;
	}

	public void setMaTK(String maTK) {
		MaTK = maTK;
	}

	public void setTenDN(String tenDN) {
		TenDN = tenDN;
	}

	public void setMatKhau(String matKhau) {
		MatKhau = matKhau;
	}

	public void setNgLap(String ngLap) {
		NgLap = ngLap;
	}

	public void setEmail(String email) {
		Email = email;
	}

}


