package model;

import java.util.Objects;

import chuc.nang.dung.chung.HienThongThiThongTin;
import chuc.nang.dung.chung.TinhGioLam;
import chuc.nang.dung.chung.TinhLuong;

public abstract class NhanVien implements TinhLuong,TinhGioLam,HienThongThiThongTin {
	
	private static int AUTO = 100;
	private int maNhaVien;
	private String hoVaTen;
	private String diaChi;
	private int soDienThoai;
	
	public NhanVien() {
		super();
		this.maNhaVien = AUTO++;
	}
	
	public NhanVien(String hoVaTen, String diaChi, int soDienThoai) {
		this.maNhaVien = AUTO++;
		this.hoVaTen = hoVaTen;
		this.diaChi = diaChi;
		this.soDienThoai = soDienThoai;
	}

	
	public String getHoVaTen() {
		return hoVaTen;
	}
	public void setHoVaTen(String hoVaTen) {
		this.hoVaTen = hoVaTen;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public int getSoDienThoai() {
		return soDienThoai;
	}
	public void setSoDienThoai(int soDienThoai) {
		this.soDienThoai = soDienThoai;
	}
	public int getMaNhaVien() {
		return maNhaVien;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maNhaVien);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NhanVien other = (NhanVien) obj;
		return maNhaVien == other.maNhaVien;
	}

}
