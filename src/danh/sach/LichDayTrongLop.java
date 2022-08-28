package danh.sach;

import java.util.Objects;

import chuc.nang.dung.chung.HienThongThiThongTin;
import chuc.nang.dung.chung.TinhLuong;
import model.Lop;
import model.MonHoc;

public class LichDayTrongLop implements HienThongThiThongTin, TinhLuong {

	private final int LOP_MAX = 3;
	MonHoc monHoc;
	Lop[] lop;

	public LichDayTrongLop(MonHoc monHoc) {
		this.monHoc = monHoc;
		lop = new Lop[LOP_MAX];
	}

	public LichDayTrongLop(MonHoc monHoc, Lop[] lop) {
		this.monHoc = monHoc;
		this.lop = lop;
	}

	public MonHoc getMonHoc() {
		return monHoc;
	}

	public void setMonHoc(MonHoc monHoc) {
		this.monHoc = monHoc;
	}

	public Lop[] getLop() {
		return lop;
	}

	public void setLop(Lop[] lop) {
		int n = lop.length;
		if (n > 3)
			return;
		for (int i = 0; i < n; i++) {

			this.lop[i] = lop[i];
		}

	}

	@Override
	public void hienThongTin() {
		int n = this.lop.length;
		this.monHoc.hienThongTin();

		for (int i = 0; i < n; i++) {
			if (this.lop[i] != null) {
				this.lop[i].hienThongTin();
			}
		}
	}

	public int getSoTiet() {
		return this.monHoc.getTongSooTiet() * this.getSoLop();
	}

	public int getSoTietLyThuyet() {
		return this.monHoc.getSoTietLyThuyet() * this.getSoLop();
	}

	public int getSoLop() {
		int n = this.lop.length;
		int tong = 0;
		for (int i = 0; i < n; i++) {
			if (this.lop[i] != null) {
				tong++;
			}
		}
		return tong;

	}

	@Override
	public int hashCode() {
		return Objects.hash(monHoc);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LichDayTrongLop other = (LichDayTrongLop) obj;
		return Objects.equals(monHoc, other.monHoc);
	}

	@Override
	public double tinhLuong() {
		System.out.println(" Môn :" + this.getMonHoc().getTenMonHoc());
		System.out.println(" Tổng số tiết  :" + this.getSoTiet() + " số tiết lý thuyết :" + this.getSoTietLyThuyet()
				+ " Kinh phí:" + this.getMonHoc().getKinhPhi());
		double thanhTien = this.getSoLop() * this.getMonHoc().tinhLuong();
		System.out.println(" Thành tiền  :" + thanhTien);
		return thanhTien;
	}

}
