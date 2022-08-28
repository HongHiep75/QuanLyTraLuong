package model;

public class GiangVien extends NhanVien{
 
	private String trinhDo;
	
	public GiangVien() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GiangVien(String hoVaTen, String diaChi, int soDienThoai,String trinhDo) {
		super(hoVaTen, diaChi, soDienThoai);
		this.trinhDo = trinhDo;
	}

	@Override
	public double tinhLuong() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double tinhGioLam() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void hienThongTin() {
		System.out.print("- Mã nhân viên:" + this.getMaNhaVien() + "; Họ và tên:" + this.getHoVaTen() );
		System.out.print(";  Địa chỉ:" + this.getDiaChi() + "; Số điện thoại:" + this.getSoDienThoai());
		System.out.print("; Trình độ:" + this.getTrinhDo());
		System.out.println();
		
	}

	public String getTrinhDo() {
		return trinhDo;
	}

	public void setTrinhDo(String trinhDo) {
		this.trinhDo = trinhDo;
	}

	

	
}
