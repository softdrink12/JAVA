package quiz;

public class StudentExam {

	public static void main(String[] args) {
		
		new StudentExam();

		Student s1 = new Student("현준수", 20);
		Student s2 = new Student("김승환",30);
		Student s3 = new Student("서수찬",40);
		
//		// 필드는 초기화 없는 경우 0, null, false로 new하는 순간 자동 초기화
//		System.out.println(s1.name);
//		System.out.println(s1.age);
////		System.out.println(s1.hasGlasses);
//		System.out.println(s2.name);
//		System.out.println(s2.age);
//		
//		s1.name = "김승환";
//		s1.age = 20;
//		s1.hasGlasses = true;
//		
//		System.out.println(s1.name);
//		System.out.println(s1.age);
//		System.out.println(s1.hasGlasses);
//		
//		// s1.name과 내 지역변수 name은 아무 관계 없음
//		String name = "아무거나";
//		
////		Student s2 = new Student();
//		System.out.println(s2.name);
//
//		s2.name = "차수";
//		s2.age = 50;
//		System.out.println(s2.name);
//		System.out.println(s2.age);
//		
//		System.out.println(s1.name);
//		
//		System.out.println(s1);
//		int intel = s1.study("java 클래스");
//		System.out.println("공부했더니 지식이 : " + intel);
//		
//		int h = s1.nyam("치킨");
//		System.out.println("치킨을 먹었더니 공복감이 : "+ h);
//		System.out.println(s1);
//		
//		int s = s1.sleep(10);
//		System.out.println("꿀잠을 잤더니 체력이 : " + s);
//		
//		s1.game("배그", 5);
//		System.out.println(s1);
//		
//		int y = s1.study("java", 2000);
//		System.out.println("스트레스 : " + y);
//		System.out.println(s1);
//		
//		view(s1);
		
		Academy ac = new Academy("천안");
		Academy ac2 = new Academy("수원");
		ac.join(s1);
		ac.join(s2);
		ac2.join(s3);
		ac.viewList();
		ac2.viewList();
	}

	static void view(Student s) {
		s.study("lol");
	}
	
}
