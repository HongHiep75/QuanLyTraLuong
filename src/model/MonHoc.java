package model;

import java.util.Objects;

import chuc.nang.dung.chung.HienThongThiThongTin;
import chuc.nang.dung.chung.TinhLuong;

public class MonHoc implements TinhLuong,HienThongThiThongTin {
	
	private static int AUTO = 100;
	private int maMonHoc;
	private String tenMonHoc;
	private int tongSooTiet;
	private int soTietLyThuyet;
	private int kinhPhi;
	
	public MonHoc() {
		super();
		this.maMonHoc = AUTO++;
	}
	
	public MonHoc(String tenMonHoc, int tongSooTiet, int soTietLyThuyet, int kinhPhi) {
		this.maMonHoc = AUTO++;
		this.tenMonHoc = tenMonHoc;
		this.tongSooTiet = tongSooTiet;
		this.soTietLyThuyet = soTietLyThuyet;
		this.kinhPhi = kinhPhi;
	}


	@Override
	public double tinhLuong() {
		int tietThucHanh = this.tongSooTiet - this.soTietLyThuyet;
		return this.kinhPhi*(this.soTietLyThuyet + tietThucHanh*0.7);
	}

	@Override
	public int hashCode() {
		return Objects.hash(tenMonHoc);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MonHoc other = (MonHoc) obj;
		return Objects.equals(maMonHoc, other.maMonHoc);
	}

	
	
	@Override
	public String toString() {
		return " + maMonHoc = " + maMonHoc + ", tenMonHoc=" + tenMonHoc + ", tongSooTiet = " + tongSooTiet
				+ ", soTietLyThuyet = " + soTietLyThuyet + ", kinhPhi = " + kinhPhi ;
	}

	@Override
	public void hienThongTin() {
		System.out.println(toString());
		
	}

	public int getMaMonHoc() {
		return maMonHoc;
	}

	public void setMaMonHoc(int maMonHoc) {
		this.maMonHoc = maMonHoc;
	}

	public String getTenMonHoc() {
		return tenMonHoc;
	}

	public void setTenMonHoc(String tenMonHoc) {
		this.tenMonHoc = tenMonHoc;
	}

	public int getTongSooTiet() {
		return tongSooTiet;
	}

	public void setTongSooTiet(int tongSooTiet) {
		this.tongSooTiet = tongSooTiet;
	}

	public int getSoTietLyThuyet() {
		return soTietLyThuyet;
	}

	public void setSoTietLyThuyet(int soTietLyThuyet) {
		this.soTietLyThuyet = soTietLyThuyet;
	}

	public int getKinhPhi() {
		return kinhPhi;
	}

	public void setKinhPhi(int kinhPhi) {
		this.kinhPhi = kinhPhi;
	}
	
	
	
}
