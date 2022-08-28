package danh.sach;

import chuc.nang.dung.chung.HienThongThiThongTin;
import model.Lop;
import model.MonHoc;

public class DanhSachLichDay implements HienThongThiThongTin {

	LichDayTrongLop[] lichDayTrongLops;

	
	
	public LichDayTrongLop[] getLichDayTrongLops() {
		return lichDayTrongLops;
	}

	public void setLichDayTrongLops(LichDayTrongLop[] lichDayTrongLops) {
		this.lichDayTrongLops = lichDayTrongLops;
	}

	@Override
	public void hienThongTin() {
		int n = this.lichDayTrongLops.length;
		for (int i = 0; i < n; i++) {
			this.lichDayTrongLops[i].hienThongTin();
			System.out.println();
		}
		
	}

	public void themDanhSach(LichDayTrongLop[] list) {
		if(this.lichDayTrongLops == null) {
			this.lichDayTrongLops = list;
		}else {
			
			int lenghtDayTrongLops = this.lichDayTrongLops.length;
			int leghtList = list.length;
			int lenghtTong = lenghtDayTrongLops + leghtList;
			LichDayTrongLop[] danhSachMoi = new LichDayTrongLop[lenghtTong];
			int n = 0;
			int m = 0;
			boolean ckeckDanhSach1 = true;
			boolean ckeckDanhSach2 = true;
			int trungGian = lenghtDayTrongLops;
			while (ckeckDanhSach1 || ckeckDanhSach2) {
				if (n == lenghtDayTrongLops) {
					ckeckDanhSach1 = false;
				} else {
					danhSachMoi[n] = this.lichDayTrongLops[n];
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

			this.lichDayTrongLops = danhSachMoi;				
		}
		
	}

	public MonHoc getMonHoc(int maMon) {
		if(this.lichDayTrongLops == null) return null;
		int n = this.lichDayTrongLops.length;
		for (int i = 0; i < n; i++) {
		 if(this.lichDayTrongLops[i].getMonHoc().getMaMonHoc() == maMon)
			return this.lichDayTrongLops[i].getMonHoc();
		}
		return null;
	}

	public Lop[] getdanhSachLop(MonHoc monHoc) {
		if(this.lichDayTrongLops == null ) return null;
		int n = this.lichDayTrongLops.length;
		for (int i = 0; i < n; i++) {
			 if(this.lichDayTrongLops[i].getMonHoc().equals(monHoc))
				return this.lichDayTrongLops[i].lop;
			}
		return null;
	}


}
