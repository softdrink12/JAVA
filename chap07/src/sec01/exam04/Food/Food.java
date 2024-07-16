package sec01.exam04.Food;

public class Food {

	Food() {
		System.out.println("Food 생성자 실행");
	}
	
	String name;
	int price;
	String recipe;
	String type;
	
	int eat() {
		System.out.println(this.name + " 먹는다");
		return (int)(Math.random()*5)+1;
	}
	
	/**
	 * 주문 기능
	 * @param int money 지불하는 금액
	 * @return int 거스름돈
	 */
	int order(int money) {
		int change = 0;	// 거스름돈
		
		if(money < this.price) {
			System.out.println(this.name + " 금액 부족으로 주문 취소합니다");
		} else {			
			System.out.println(this.name + " 주문한다");
			change = money - this.price;
		}
		return change;
	}
	
	/**
	 * 
	 * @param int master 요리 숙련도
	 * @return String 조리 결과
	 */
	String cook(int master) {
		if(master > 7) {
			return "기가 막히게 잘 됨";
		} else if (master > 4) {
			return "먹을만 함";
		} else {
			return "버리자";
		}
	}
	
}
