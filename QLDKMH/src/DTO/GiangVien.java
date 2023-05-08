/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author MeoMeo
 */
public class GiangVien {
	String MaGV;
	String TenGV;
	String Email;

	public GiangVien() {
          
	}	
	public GiangVien(String maGV, String tenGV, String email) {
		super();
		MaGV = maGV;
		TenGV = tenGV;
		Email = email;
	}

	public String getMaGV() {
		return MaGV;
	}

	public String getTenGV() {
		return TenGV;
	}

	public String getEmail() {
		return Email;
	}

	public void setMaGV(String maGV) {
		MaGV = maGV;
	}

	public void setTenGV(String tenGV) {
		TenGV = tenGV;
	}

	public void setEmail(String email) {
		Email = email;
	}

}


