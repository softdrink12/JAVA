package Quiz;

public class Car {

	/*
	 * 다음의 클래스를 상속받은 클래스 2개 이상 만들기 
	 * 단, drive() 메소드는 필수 
	 * 
	 * 자동차 만들기 
	 * 부모 클래스 Car
	 * void drive() {
	 * 		syso("운전을 시작합니다");
	 *	 }
	 */
	
	int oilmax; // max
	int oiltank; // 기름양
	String color;
	int speed;
	int price;
	
	public void drive() {
		System.out.println("운전을 한다!!!!!!!!!");
	}
	
	int insert(int oiltank) {
		if (this.oilmax < oiltank) {
			System.out.println(oiltank - this.oilmax  + "리터 주유완료!!!!!");
			System.out.println(oiltank - this.oilmax + "기름은 주유소에서 처리했으니 안심하라구~");
			int Oil = oiltank -= this.oilmax;
			this.oiltank = Oil;
			System.out.println("현재 기름 : " + this.oiltank);
		} else {
			System.out.println(oiltank + "리터 주유완료!!!!!");
		}
		this.oilmax = oiltank;
		
//		this.oiltank += oiltank;
		
//		System.out.println(oilmax + "리터 주유완료!!!!!");
		return this.oiltank;
	}
	
//	int insert(int oilmax) {
//		int a = this.oilmax;
//		a += oilmax;
//		if (a < oilmax) {
//			System.out.println("기름 초과 !!!!!!!!");
//		} else {
//			System.out.println("주유 완료 !!!!!!!!");
//		}
//		return a;
//	}
	
	void colorful (String color) {
		this.color = color;
		System.out.println(color + "색상 선택완료!!!!");
	}
	
	int money(int price) {
		this.price = price;
		System.out.println("가격은 " + price + "$ 입니다 ");
		return price;
	}
	
	void rpm() {
//		this.oilmax = 100;
		if (this.oilmax > 0 ) {
			for (int i = 0; i <= this.oilmax; i+=10) {
				System.out.println("시속 : " + i + "km/h");
				this.oilmax-= 10;
				System.out.println(this.oilmax);
			}
		} else if (this.oilmax < 0){
			System.out.println("기름 앵꼬!!!!!!!!!!");
		}
	}
	
}
