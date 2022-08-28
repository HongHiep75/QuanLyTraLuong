package danh.sach;

import chuc.nang.dung.chung.HienThongThiThongTin;
import model.GiangVien;

public class DanhSachGiaoVien implements HienThongThiThongTin{

	GiangVien[] giangVien;

	public GiangVien[] getGiangVien() {
		return giangVien;
	}

	public GiangVien getGiangVien(int maGiangVien) {
		if(this.giangVien == null) return null;
		int n = this.giangVien.length;
		for (int i = 0; i < n; i++) {
		 if(this.giangVien[i].getMaNhaVien() == maGiangVien)
			return this.giangVien[i];
		}
		
		
		
		return null;
	}
	
	
	public void setGiangVien(GiangVien[] list) {
		if (this.giangVien == null) {
			this.giangVien = list;
		} else {

			int lenghtGiangVien = this.giangVien.length;
			int leghtList = list.length;
			int lenghtTong = lenghtGiangVien + leghtList;
			GiangVien[] danhSachMoi = new GiangVien[lenghtTong];
			int n = 0;
			int m = 0;
			boolean ckeckDanhSach1 = true;
			boolean ckeckDanhSach2 = true;
			int trungGian = lenghtGiangVien;
			while (ckeckDanhSach1 || ckeckDanhSach2) {
				if (n == lenghtGiangVien) {
					ckeckDanhSach1 = false;
				} else {
					danhSachMoi[n] = this.giangVien[n];
					n++;
				}

				if (m == leghtList) {
					ckeckDanhSach2 = false;
				} else {
					danhSachMoi[trungGian] = list[m];
					m++;
					trungGian++;
				}

			}

			this.giangVien = danhSachMoi;
		}
	}

	@Override
	public void hienThongTin() {
		int n = this.giangVien.length;
		for (int i = 0; i < n; i++) {
			this.giangVien[i].hienThongTin();
			System.out.println();
		}
		
	}




}
