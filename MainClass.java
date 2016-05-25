package automation;
/**
 * 
 * @author ThaoBTP
 * Gọi các đối tượng của class Số học để thực hiện tính toán
 */
public class MainClass {

	static soHoc sh;

	public static void main(String[] args) {
		sh = new soHoc();
		int a = 10;
		int b = 20;
		sh.PhepCong(a, b);
		sh.PhepTru(a, b);
		sh.PhepNhan(a, b);
		sh.PhepChia(a, b);
		sh.PhepChiaLaySoDu(a, b);
		sh.TangGiaTri(a);
		sh.GiamGiaTri(a);
		sh.PhepToanQuanHeVaLogic(a, b);
		sh.loopFor();
		sh.loopWhile();
		sh.loopDoWhile();
		sh.lenhDieuKienIf(a, b);
		sh.lenhDieuKienSwitch(a, b);
	}
}
