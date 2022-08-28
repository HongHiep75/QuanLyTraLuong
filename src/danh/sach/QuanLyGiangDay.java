package danh.sach;

import java.util.Objects;

import chuc.nang.dung.chung.HienThongThiThongTin;
import chuc.nang.dung.chung.TinhLuong;
import model.GiangVien;

public class QuanLyGiangDay implements HienThongThiThongTin,TinhLuong {

	GiangVien giangVien;
	DanhSachLichDay danhSachLichDay;

	public GiangVien getGiangVien() {
		return giangVien;
	}

	public void setGiangVien(GiangVien giangVien) {
		this.giangVien = giangVien;
	}

	public DanhSachLichDay getDanhSachLichDay() {
		return danhSachLichDay;
	}

	public void setDanhSachLichDay(DanhSachLichDay danhSachLichDay) {
		this.danhSachLichDay = danhSachLichDay;
	}

	public int getSoTiet() {
		int tongSoTiet = 0;
		LichDayTrongLop[] dayTrongLop = this.danhSachLichDay.getLichDayTrongLops();
		int n = dayTrongLop.length;
		for (int i = 0; i < n; i++) {
			tongSoTiet += dayTrongLop[i].getSoTiet();
		}

		return tongSoTiet;
	}

	@Override
	public int hashCode() {
		return Objects.hash(giangVien);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		QuanLyGiangDay other = (QuanLyGiangDay) obj;
		return Objects.equals(giangVien, other.giangVien);
	}

	@Override
	public void hienThongTin() {
		this.giangVien.hienThongTin();
		this.danhSachLichDay.hienThongTin();
		
	}

	@Override
	public double tinhLuong() {
		double tongLuong = 0;
		GiangVien giangVien = this.getGiangVien();
		System.out.println("- Mã giảng viên " + giangVien.getMaNhaVien() +"  Giáo viên: " + giangVien.getHoVaTen());
		LichDayTrongLop dayTrongLop[] = this.danhSachLichDay.getLichDayTrongLops();
		int n = dayTrongLop.length;
		for (int i = 0; i < n; i++) {
			tongLuong +=	dayTrongLop[i].tinhLuong();
		}
		return tongLuong;
	}

	
}
