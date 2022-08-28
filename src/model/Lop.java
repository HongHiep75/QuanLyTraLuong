package model;

import chuc.nang.dung.chung.HienThongThiThongTin;

public class Lop implements HienThongThiThongTin {
	
	private String tenLop;
	
	
	
	public Lop( String tenLop) {
		this.tenLop = tenLop;
	}
	
	public Lop() {}

	public String getTenLop() {
		return tenLop;
	}

	public void setTenLop(String tenLop) {
		this.tenLop = tenLop;
	}

	
	@Override
	public String toString() {
		return "    TenLop = " + tenLop ;
	}

	@Override
	public void hienThongTin() {
		System.out.println(this.toString());
		
	}

	
	
	
}
