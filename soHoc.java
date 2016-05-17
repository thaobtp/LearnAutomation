package automation;

/**
 * 
 * @author ThaoBTP
 * Sử dụng các phép toán số học để thực hiện tính toán
 */
public class soHoc {
	/**
	 * Sử dụng phép toán số học "+" tính tổng 2 số truyền vào Sau đó in kết quả
	 * ra màn hình
	 */
	public int PhepCong(int a, int b) {
		int tong;
		tong = a + b;
		System.out.println("Tổng 2 số là:" + tong);
		return tong;
	}

	/**
	 * Sử dụng phép toán số học "-" tính hiệu 2 số truyền vào Sau đó in kết quả
	 * ra màn hình
	 */
	public int PhepTru(int a, int b) {
		int hieu;
		hieu = a - b;
		System.out.println("Hiệu 2 số là:" + hieu);
		return hieu;
	}

	/**
	 * Sử dụng phép toán số học "*" tính Tích 2 số truyền vào Sau đó in kết quả
	 * ra màn hình
	 */
	public double PhepNhan(int a, int b) {
		int tich;
		tich = a * b;
		System.out.println("Tích 2 số là:" + tich);
		return tich;
	}

	/**
	 * Sử dụng phép toán số học "/" tính thương 2 số truyền vào Sau đó in kết
	 * quả ra màn hình
	 */
	public float PhepChia(int a, int b) {
		float thuong;
		thuong = a / b;
		System.out.println("Thương 2 số là:" + thuong);
		return thuong;
	}

	/**
	 * Sử dụng phép toán số học "%" lấy số dư của phép chia 2 số Sau đó in kết
	 * quả ra màn hình
	 */
	public int PhepChiaLaySoDu(int a, int b) {
		int soDu;
		soDu = a % b;
		System.out.println("Số dư của a/b là:" + soDu);
		return soDu;
	}

	/**
	 * Tăng giá trị của biến lên 1 đơn vị
	 */
	public int TangGiaTri(int a) {
		a++;
		System.out.println("Giá trị của a sau khi tăng lên 1 là:" + a);
		return a;
	}

	/**
	 * Giảm giá trị của biến lên 1 đơn vị
	 */
	public int GiamGiaTri(int a) {
		System.out.println("Giá trị của a sau khi giảm đi 1 là:" + a);
		return a;
	}

	/**
	 * Các phép toán quan hệ và logic để so sánh 2 giá trị với nhau Sau khi so
	 * sánh, in ra màn hình thông báo
	 */
	public void PhepToanQuanHeVaLogic(int a, int b) {
		if (a >= 0 && b >= 0) {
			System.out.println("a và b là hai số nguyên dương");
		}
		if (a > 0 || a == 0) {
			System.out.println("a là số nguyên dương");
		}
		if (a != b) {
			System.out.println("Hai số a và b có giá trị khác nhau");
		}
		if (a == b) {
			System.out.println("Hai số a và b có giá trị bằng nhau");
		} else if (a > b) {
			System.out.println("a lớn hơn b");
		} else if (a < b) {
			System.out.println("a nhỏ hơn b");
		}
	}

	/**
	 * Sử dụng vòng lặp để in ra màn hình các giá trị từ 1 -->10
	 */
	public void loopFor() {
		System.out.println("Các giá trị trong vòng lặp for");
		for (int i = 1; i <= 10; i++) {
			System.out.println(i);
		}
	}

	/**
	 * Sử dụng vòng lặp để in ra màn hình các giá trị từ 1 -->10
	 */
	public void loopWhile() {
		int i = 0;
		System.out.println("Các giá trị trong vòng lặp while");
		while (i < 10) {
			System.out.println(i);
			i++;
		}
	}

	/**
	 * Sử dụng vòng lặp để in ra màn hình các giá trị từ 1 -->10
	 */
	public void loopDoWhile() {
		int i = 0;
		System.out.println("Các giá trị trong vòng lặp do-while");
		do {
			System.out.println(i);
			i++;
		} while (i < 10);
	}

	/**
	 * Dùng lệnh if để so sánh 2 giá trị
	 */
	public void lenhDieuKienIf(int a, int b) {
		if (a > b) {
			System.out.println("a lớn hơn b");
		} else if (a < b) {
			System.out.println("a nhỏ hơn b");
		} else {
			System.out.println("a bằng b");
		}
	}

	/**
	 * 
	 * Lệnh điều kiện switch để so sánh các trường hợp giá trị của biến Sau đó
	 * in ra màn hình
	 */
	public void lenhDieuKienSwitch(int a, int b) {
		switch (a % b) {
		case 0:
			System.out.println("a chia hết cho b");
			break;
		case 1:
			System.out.println("a không chia hết cho b");
			break;
		default:
			System.out.println("a/b:" + a / b);
		}
	}

	/**
	 * Thực thi chương trình và kiểm tra kết quả in trên màn hình
	 */
	public static void main(String[] args) {

		soHoc sh = new soHoc();
		int a = 10;
		int b = 5;
		// Tính tổng 2 số và in kết quả ra màn hình
		sh.PhepCong(a, b);

		// Tính hiệu 2 số và in kết quả ra màn hình
		sh.PhepTru(a, b);

		// Tính tích 2 số và in kết quả ra màn hình
		sh.PhepNhan(a, b);

		// Tính thương 2 số
		sh.PhepChia(a, b);

		// Chia 2 số lấy dư
		sh.PhepChiaLaySoDu(a, b);

		// Tăng giá trị của biến lên 1 đơn vị
		sh.TangGiaTri(a);

		// Giảm giá trị của biến xuống 1 đơn vị
		sh.GiamGiaTri(b);

		// Sử dụng biểu thức quan hệ và logic so sánh giá trị
		sh.PhepToanQuanHeVaLogic(a, b);

		// Sử dụng vòng lặp để in ra màn hình các giá trị từ 1 -->10
		sh.loopFor();
		sh.loopWhile();
		sh.loopDoWhile();

		// Lệnh điều kiện switch để so sánh các trường hợp giá trị của biến sau
		// đó in ra màn hình
		sh.lenhDieuKienSwitch(a, b);

		// Lệnh điều kiện so sánh 2 giá trị
		sh.lenhDieuKienIf(a, b);
	}
}
