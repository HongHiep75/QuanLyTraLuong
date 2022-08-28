package danh.sach;

import chuc.nang.dung.chung.HienThongThiThongTin;
import model.MonHoc;

public class DanhSachQuanLy implements HienThongThiThongTin {

	QuanLyGiangDay[] quanLyGiangDays;

	public QuanLyGiangDay[] getQuanLyGiangDays() {
		return quanLyGiangDays;
	}

	@Override
	public void hienThongTin() {
		if (this.quanLyGiangDays == null)
			return;
		int n = this.quanLyGiangDays.length;
		for (int i = 0; i < n; i++) {
			quanLyGiangDays[i].hienThongTin();
		}

	}

	public void themQuanLyGiangDay(QuanLyGiangDay quanLyGiangDay) {
		if (this.quanLyGiangDays == null) {
			this.quanLyGiangDays = new QuanLyGiangDay[1];
			this.quanLyGiangDays[0] = quanLyGiangDay;
			return;
		}

		int n = this.quanLyGiangDays.length;
		int nTang = n + 1;
		QuanLyGiangDay[] listGiangDays = new QuanLyGiangDay[nTang];
		for (int i = 0; i < n; i++) {
			if (this.quanLyGiangDays[i].equals(quanLyGiangDay)) {
				this.quanLyGiangDays[i] = quanLyGiangDay;
				return;
			}
			listGiangDays[i] = this.quanLyGiangDays[i];
		}
		listGiangDays[nTang - 1] = quanLyGiangDay;
		this.quanLyGiangDays = listGiangDays;
	}

	public void sapXepTheoTen() {
		int n = this.quanLyGiangDays.length;
		String[] danhSachTenGiangVien = new String[n];

		for (int i = 0; i < n; i++) {
			danhSachTenGiangVien[i] = this.quanLyGiangDays[i].getGiangVien().getHoVaTen();
		}

		for (int i = 0; i < n - 1; i++) {
		
			for (int j = 1; j < n ; j++) {
				if (danhSachTenGiangVien[j - 1].compareTo(danhSachTenGiangVien[j]) > 0) {
					String trungGian = danhSachTenGiangVien[j - 1];
					danhSachTenGiangVien[j - 1] = danhSachTenGiangVien[j];
					danhSachTenGiangVien[j] = trungGian;
  
					QuanLyGiangDay temp = this.quanLyGiangDays[j - 1];
					this.quanLyGiangDays[j - 1] = this.quanLyGiangDays[j];
					this.quanLyGiangDays[j] = temp;
				}
			}
		}
	}

	public void sapXepTheoSoLuongTietTheoMon(MonHoc monHoc) {
		if(this.quanLyGiangDays == null) return ;
		int n = this.quanLyGiangDays.length;
		int[] danhSachSoTiet = new int[n];
		int maMon = monHoc.getMaMonHoc();
		for (int i = 0; i < n; i++) {
			danhSachSoTiet[i] = tinhSoTietTheoMon(maMon, this.quanLyGiangDays[i]);
		}

		for (int i = 0; i < n - 1; i++) {		
			for (int j = 1; j < n ; j++) {
				if (danhSachSoTiet[j - 1] < danhSachSoTiet[j]) {
					int trungGian = danhSachSoTiet[j - 1];
					danhSachSoTiet[j - 1] = danhSachSoTiet[j];
					danhSachSoTiet[j] = trungGian;
					
					QuanLyGiangDay temp = this.quanLyGiangDays[j - 1];
					this.quanLyGiangDays[j - 1] = this.quanLyGiangDays[j];
					this.quanLyGiangDays[j] = temp;
				}
			}
		}
		
	}
	
	
	public int tinhSoTietTheoMon(int maHoc, QuanLyGiangDay quanLyGiangDay) {
		
		int tongTiet = 0;
		MonHoc monHoc = quanLyGiangDay.getDanhSachLichDay().getMonHoc(maHoc);
			DanhSachLichDay dayTrongLop = quanLyGiangDay.getDanhSachLichDay();
			LichDayTrongLop[] dayTrongLops = dayTrongLop.getLichDayTrongLops();
			int n = dayTrongLops.length;
			for (int i = 0; i < n; i++) {
				if(dayTrongLops[i].getMonHoc().equals(monHoc)) {
					tongTiet += dayTrongLops[i].getSoTiet();
				}
			}
		
		return tongTiet;			
	}

	public void tinhTienCong() {
		if(this.quanLyGiangDays == null) return;
		int n = this.quanLyGiangDays.length;
		double tongLuong;
		for (int i = 0; i < n; i++) {
			tongLuong = 0;
			tongLuong = this.quanLyGiangDays[i].tinhLuong();
			System.out.println("-->Tổng lương " + tongLuong + "\n");
		}
	}
	
}
