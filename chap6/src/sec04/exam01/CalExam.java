package sec04.exam01;

public class CalExam {

	public static void main(String[] args) {
		powerOn();	// 이건 내꺼
		powerOn();	// 두 번 써도 되서 두 번 씀
		
		Calc calc = new Calc();
		calc.powerOff();	// 이건 Calc꺼 '
		System.out.println(calc);
		
		Calc calc2 = new Calc();
		System.out.println(calc2);
	}
	
	static void powerOn() {
		System.out.println("전원을 켭니다.");
	}

}
