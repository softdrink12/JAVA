package quiz;

import java.util.Scanner;

public class Student {

	Student(String name, int age){
		this.name = name;
		this.age = age;
	}
	
	Student(String name) {
		this(name, 0);
	}
	
	// 값
	// 이름, 나이, 주소, 성별, 전공, 안경유무 
	String name;
	int age;
	String addr;
	int gender;
	String major;
	boolean hasGlasses;
	
	
	int intel = 0;	// 지식
	int stress = 0;	// 스트레스 수치 
	int hp = 100;	// 체력 
	int hungry = 0;	// 공복감

	
	// 행동
	// 공부, 식사, 수면, 게임 
	
	// 공부
	// 공부한 내용을 출력하고 
	// 지식이 높아지고 
	// 스트레스 높아지고
	// 체력 낮아지고 
	// 공복감 높아지고 
	
	// 전달인자 : String 공부한 내용 
	// 리턴타입 : 없음
	
	int study(String subject) {
		System.out.println(subject + "을(를) 공부했다");
		
		intel += 5;
		stress += 10;
		hp--;
		hungry++;
		
		// intel을 리턴하는 코드를 완성해라 
		return intel;
	}
	
	int study(String subject, int x) {
		System.out.println(subject + "을(를) 공부했다");
		stress = x;
		return x;
	}
	
	// 식사
	// 먹은 음식을 출력하고
	// 체력 조금 올라가고 
	// 스트레스 조금 낮아지고 
	// 공복감 많이 낮아지고 
	// 전달인자 : Strign 음식
	// 리턴타입 : int 공복감
	int nyam (String food) {
		System.out.println(food + "을(를) 먹었다");
		hp += 3;
		stress -= 5;
		hungry -= 10;
		
		return hungry;
	}
	
	// 수면 메소드 완성
	int sleep (int x) {
		System.out.println(x + "시간을 꿀잠");
		
		hp += 20;
		stress -= 20;
		hungry -= 10;
		
		return hp;
		
	}
	
	Scanner scan = new Scanner(System.in);
	
	// 게임 메소드 완성 
	// 단, 게임 하면서 게임 공부도 했다치고 
	// study 메소드 활용 
	int game (String lol, int hour) {
		System.out.println(lol + "을(를) 재미있게 했당 근데 " + hour + "시간만 하자 ㅠ");
		
		// 방어코딩
		// hour가 0 이하인 경우 다시 입력해달라고 
		if(hour <= 0) {
			System.out.println("다시 입력해주세요");
//			return 0;
		} else {
			for(int i = 0; i < hour; i++) {
				System.out.println(i+"시간밖에 안지났으니 한 번만 더 하자");
			}
			
			for(double i = 0; i < hour; i += 0.5) {
				System.out.println(i+"시간밖에 안지났으니 한 번만 더 하자");
			}
		}
		
		// 반복문 연습
		// 시간이 정상인 경우 시간당 한 번씩 "한 번만 더 하자" 출력 
		// 30분에 한 번씩 출력. 단, syso 두 번 사용하지 말고 (0.5)
		
//		for (int i = 0; i <= hour; i++) {
//			if (i % 1 == 0) {
//				System.out.println("한 판만 더 하자 ");
//			}if (i <= 2 && i > 0 ) {
//				stress += 5;
//				System.out.println("오늘 겜 안되네, 그만하자" );
//			}  if (i <= 4 && i > 2) {
//				System.out.println("적당하게 한 겜 했네" );
//				stress -= 10;
//			}  if (i > 4) {
//				System.out.println("오늘 재밌었다");
//				stress -= 20;
//			} if (i < 1) {
//				System.out.println("게임 무조건 해야지 다시 써라 ");
//			} 
//		}
		
//		while (true) {
//			hour = scan.nextInt();
//			if (hour <= 2 && hour > 0 ) {
//				stress += 5;
//				System.out.println("오늘 겜 안되네, 그만하자" );
//			}  if (hour <= 4 && hour > 2) {
//				System.out.println("적당하게 한 겜 했네" );
//				stress -= 10;
//			}  if (hour > 4) {
//				System.out.println("오늘 재밌었다");
//				stress -= 20;
//			} if (hour < 1) {
//				System.out.println("게임 무조건 해야지 다시 써라 ");
//				continue;
//			} if ( hour % 1 == 0) {
//				System.out.println("한 판만 더 하자 ");
//			}
//			break;
//		}
		
		// 조건문 연습
		// 2시간 이하 - 오늘 좀 안된다 그만하자, 스트레스 + 5
		// 4시간 이하 - 간단하게 한 게임 했다, 스트레스 -10
		// 4시간 초과 - 오늘 신났다, 스트레스 -20
		
		
		study(lol);
		
		hp -= 10;
		stress += 30;	// 위 조건에 따라 수치 변동 
		hungry += 20;
		
		return stress;
	}
	
	
	

	// 내 정보 보기 
	// 마우스 우클릭 source => generate toString
	@Override
	public String toString() {
		return "승환정보 [name=" + name + ", age=" + age + ", addr=" + addr + ", gender=" + gender + ", major=" + major
				+ ", hasGlasses=" + hasGlasses + ", intel=" + intel + ", stress=" + stress + ", hp=" + hp + ", hungry="
				+ hungry + "]";
	}
	
	
	
	
	
}
