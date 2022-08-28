package thuc.thi.du.an;

import java.util.Scanner;

import danh.sach.DanhSachGiaoVien;
import danh.sach.DanhSachLichDay;
import danh.sach.DanhSachQuanLy;
import danh.sach.LichDayTrongLop;
import danh.sach.QuanLyGiangDay;
import model.GiangVien;
import model.Lop;
import model.MonHoc;

public class QuanLyTraLuong {
	private static final String GIAO_SU = "GS-TS";
	private static final String PHO_GIAO_SU = "PGS-TS";
	private static final String GIANG_VIEN_CHINH = "Giảng viên chính";
	private static final String THAC_SI = "Thạc sỹ";

	public static void main(String[] args) {

		DanhSachLichDay danhSachLichDay = new DanhSachLichDay();
		DanhSachGiaoVien danhSachGiaoVien = new DanhSachGiaoVien();
		DanhSachQuanLy danhSachQuanLy = new DanhSachQuanLy();
	
		Scanner sc = new Scanner(System.in);
		int luaChon;

		// vong lap chon chuc nang
		do {
			System.out.println("Vui lòng chọn chức năng(nhập số):");
			System.out.println("1. Nhập danh sách môn học mới ");
			System.out.println("2. Nhập danh sách giảng viên mới. ");
			System.out.println("3. Lập Bảng kê khai giảng dạy cho mỗi giảng viên ");
			System.out.println("4. Sắp xếp danh sách kê khai giảng dạy");
			System.out.println("5. Bảng tính tiền công cho mỗi giảng viên.");
			System.out.println("0.Thoát");
			luaChon = sc.nextInt();
			while (luaChon > 5 || luaChon < 0) {
				System.out.println("Chọn lại chức năng:");
				luaChon = sc.nextInt();
			}

			switch (luaChon) {
			// them mon hoc
			case 1: {
				danhSachLichDay = themDanhSachLichDay(sc, danhSachLichDay);
				System.out.println("da toi");
				danhSachLichDay.hienThongTin();
			}
				break;
			// them giao vien
			case 2: {
				danhSachGiaoVien = themDanhGiaoVien(sc, danhSachGiaoVien);
				danhSachGiaoVien.hienThongTin();
			}
				break;
			// lap bang ke khai cho giang vien
			case 3: {
//				danhSachQuanLy = themdanhSachQuanLy(sc, danhSachQuanLy, danhSachGiaoVien, danhSachLichDay);

				QuanLyGiangDay quanLyGiangDay = themQuanLyGiangDay(sc, danhSachGiaoVien, danhSachLichDay);
				int soTiet = quanLyGiangDay.getSoTiet();
				if(soTiet > 200) {
					System.out.println("Số tiết lớn hơn 200 thêm không thành công");
					
				}else {
					danhSachQuanLy.themQuanLyGiangDay(quanLyGiangDay);
					danhSachQuanLy.hienThongTin();
				}

			}
				break;
			case 4: {
				System.out.println("Chọn kiểu sắp xếp");
				System.out.println("1. Theo họ tên giảng viên");
				System.out.println("2.Theo số tiết giảng dạy mỗi môn");
				int chon = sc.nextInt();
				while (chon < 1 || chon > 2) {
					System.out.println("Vui lòng chọn lại");
					chon = sc.nextInt();
				}
				if (chon == 1) {
					if (danhSachQuanLy.getQuanLyGiangDays() == null) {
						System.out.println("Danh sách quản lý trống\n");
						break;
					}
					danhSachQuanLy.sapXepTheoTen();
					danhSachQuanLy.hienThongTin();
				} else {
					System.out.println("Nhập mã môn muôn sắp xếp theo");
					int maMon = sc.nextInt();
					MonHoc monHoc = danhSachLichDay.getMonHoc(maMon);
					while (monHoc == null) {
						System.out.println("Mã môn không đúng");
						System.out.println("Nhập mã môn học");
						maMon = sc.nextInt();
						monHoc = danhSachLichDay.getMonHoc(maMon);
					}
					danhSachQuanLy.sapXepTheoSoLuongTietTheoMon(monHoc);
					danhSachQuanLy.hienThongTin();
				}

			}
				break;
			case 5: {
				danhSachQuanLy.tinhTienCong();
			}
				break;
			}
		} while (luaChon != 0);

	}

	// ---------------- them quan ly giao vien--------------------------
	private static QuanLyGiangDay themQuanLyGiangDay(Scanner sc, DanhSachGiaoVien danhSachGiaoVien,
			DanhSachLichDay danhSachLichDay) {
		// khong co giao vien hay mon hoc
		if (danhSachGiaoVien.getGiangVien() == null || danhSachLichDay.getLichDayTrongLops() == null) {
			System.out.println("Không có giảng viên hoặc môn học");
			return null;
		}
		System.out.println("Chọn giảng viên bằng cách nhập mã giảng viên");
		int maGiangVien = sc.nextInt();
		GiangVien giangVien = danhSachGiaoVien.getGiangVien(maGiangVien);

		while (giangVien == null) {
			System.out.println("Giảng viên không tồn tại nhập lại mã");
			maGiangVien = sc.nextInt();
			giangVien = danhSachGiaoVien.getGiangVien(maGiangVien);
		}
		QuanLyGiangDay quanLyGiangDay = new QuanLyGiangDay();
		quanLyGiangDay.setGiangVien(giangVien);
		DanhSachLichDay lichDayGiangVien = themLichDayGiangVien(sc, danhSachLichDay);
		quanLyGiangDay.setDanhSachLichDay(lichDayGiangVien);

		return quanLyGiangDay;
	}

	private static DanhSachLichDay themLichDayGiangVien(Scanner sc, DanhSachLichDay danhSachLichDay) {
		DanhSachLichDay lichDayGiangVien = new DanhSachLichDay();
		System.out.println("Số môn học muốn thêm");
		int soMon = sc.nextInt();
		int soMonHienTai = danhSachLichDay.getLichDayTrongLops().length;
		while (soMon <= 0 || soMon > soMonHienTai) {
			System.out.println("Nhập lại số môn học muốn thêm số môn hiên tại " + soMonHienTai + " môn");
			soMon = sc.nextInt();
		}
		LichDayTrongLop[] dayTrongLop = new LichDayTrongLop[soMon];
		for (int i = 0; i < soMon; i++) {
			dayTrongLop[i] = themLichDayTrongLop(sc, danhSachLichDay);

		}
		lichDayGiangVien.themDanhSach(dayTrongLop);

		return lichDayGiangVien;
	}

	private static LichDayTrongLop themLichDayTrongLop(Scanner sc, DanhSachLichDay danhSachLichDay) {

		System.out.println("Chọn môn học, nhập mã môn học");
		int maMon = sc.nextInt();
		
		MonHoc monHoc = danhSachLichDay.getMonHoc(maMon);
		while (monHoc == null) {
			System.out.println("Mã môn không đúng");
			System.out.println("Nhập mã môn học");
			maMon = sc.nextInt();
			monHoc = danhSachLichDay.getMonHoc(maMon);
		}
		System.out.println("Chọn lớp cho môn " + monHoc.getTenMonHoc());
		Lop[] lop = danhSachLichDay.getdanhSachLop(monHoc).clone();

		Lop[] themLop = new Lop[3];
		int indexThemLop = 0;
		do {
			System.out.println("(ít nhất phải chọn 1 lớp)");
			for (int i = 0; i < lop.length; i++) {
				if (lop[i] != null) {
					System.out.println(i + 1 + ".Tên lớp " + lop[i].getTenLop());
					System.out.println("1.Thêm nhấn " +  "0.Bỏ qua");
					int luaChon = sc.nextInt();
					if (luaChon == 1) {
						themLop[indexThemLop] = lop[i];
						indexThemLop++;
					}
				}
			}
		} while (indexThemLop == 0);

		LichDayTrongLop dayTrongLop = new LichDayTrongLop(monHoc);
		dayTrongLop.setLop(themLop);
		return dayTrongLop;
	}

//-------------------end---------------------
	// them giao vien
	private static DanhSachGiaoVien themDanhGiaoVien(Scanner sc, DanhSachGiaoVien danhSachGiaoVien) {
		System.out.println("Số lượng giáo viên muốn thêm: ");
		int soLuong = sc.nextInt();
		while (soLuong <= 0) {
			System.out.println("Nhập lại số lượng (số lượng > 0): ");
			soLuong = sc.nextInt();
		}
		GiangVien[] giangViens = new GiangVien[soLuong];
		for (int i = 0; i < soLuong; i++) {
			giangViens[i] = themGiaoVien(sc);
		}
		danhSachGiaoVien.setGiangVien(giangViens);
		return danhSachGiaoVien;
	}

	private static GiangVien themGiaoVien(Scanner sc) {
		System.out.println("----------------------------\n");
		System.out.println("Nhập tên giáo viên: ");
		sc.nextLine();
		String tenMonHoc = sc.nextLine();

		System.out.println("Nhập địa chỉ: ");
		String diaChi = sc.nextLine();
		System.out.println("Nhập số điện thoại: ");
		int soDienThoai = sc.nextInt();
		String trinhDo = chonTrinhDo(sc);
		GiangVien giangVien = new GiangVien(tenMonHoc, diaChi, soDienThoai, trinhDo);
		return giangVien;
	}

	private static String chonTrinhDo(Scanner sc) {
		System.out.println("Chọn trình độ: ");
		System.out.println("1: " + GIAO_SU);
		System.out.println("2: " + PHO_GIAO_SU);
		System.out.println("3: " + GIANG_VIEN_CHINH);
		System.out.println("4: " + THAC_SI);
		int chon = sc.nextInt();
		while (chon <= 0 || chon > 4) {
			System.out.println("Vui lòng chọn lại : ");
			chon = sc.nextInt();
		}
		switch (chon) {
		case 1:
			return GIAO_SU;
		case 2:
			return PHO_GIAO_SU;

		case 3:
			return GIANG_VIEN_CHINH;

		case 4:
			return THAC_SI;
		}
		return null;
	}
	// -------------------------end---------------------

	// them danh sach lich day gom mon hoc va lop
	private static DanhSachLichDay themDanhSachLichDay(Scanner sc, DanhSachLichDay danhSachLichDay) {

		System.out.println("Số lượng sách môn học muốn thêm: ");
		int soLuongMonHoc = sc.nextInt();
		while (soLuongMonHoc <= 0) {
			System.out.println("Nhập lại số lượng (số lượng > 0): ");
			soLuongMonHoc = sc.nextInt();
		}
		// nhap vao danh sach sach
		LichDayTrongLop[] list = new LichDayTrongLop[soLuongMonHoc];
		for (int i = 0; i < soLuongMonHoc; i++) {
			list[i] = taoMonHoc(sc);
		}
		danhSachLichDay.themDanhSach(list);

		return danhSachLichDay;

	}

	private static LichDayTrongLop taoMonHoc(Scanner sc) {
		System.out.println("----------------------------\n");
		System.out.println("Nhập tên môn học: ");
		sc.nextLine();
		String tenMonHoc = sc.nextLine();

		System.out.println("Nhập tổng số tiết: ");
		int tongSoTiet = sc.nextInt();
		System.out.println("Nhập số tiết lý thuyểt: ");
		int soTietLyThuyet = sc.nextInt();

		while (soTietLyThuyet > tongSoTiet) {
			System.out.println("Nhập lại số tiết lý thuyểt: ");
			soTietLyThuyet = sc.nextInt();
		}

		System.out.println("Nhập kinh phí: ");
		int kinhPhi = sc.nextInt();
		MonHoc hoc = new MonHoc(tenMonHoc, tongSoTiet, soTietLyThuyet, kinhPhi);
		LichDayTrongLop lichDayTrongLop = new LichDayTrongLop(hoc);

		// them lop day vao lop
		System.out.println("Nhập số lơp dạy môn học: ");
		int soLop = sc.nextInt();
		while (soLop > 3 || soLop <= 0) {
			System.out.println("Số lớp dạy môn học không quá 3 lớp và có ít nhât một lớp: ");
			soLop = sc.nextInt();
		}
		sc.nextLine();
		Lop[] lop = new Lop[soLop];
		for (int i = 0; i < soLop; i++) {
			lop[i] = themLop(sc);
		}
		lichDayTrongLop.setLop(lop);
		return lichDayTrongLop;
	}

	private static Lop themLop(Scanner sc) {
		System.out.println("Nhập tên lớp: ");
		String ten = sc.nextLine();
		Lop lop = new Lop(ten);
		return lop;
	}
//---------------end------------------------------------
}
