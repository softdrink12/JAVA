package sec01.exam01;

public class Child extends Parent{
	
	// 부모의 필드를 가리는 현상 
	// overshadow
	// 부모와 같은 변수를 가지고 있을 때 내 클래스의 변수가 우선이다 
	String name = "Child의 name";
	
	public Child () {
		// 부모 생성자를 호출하는 것 
		// 맨 첫줄에 있어야만 한다 
		super("");
	}

//	Child() {
//		System.out.println("Child 기본 생성자");
//	}
	
	// 부모의 name을 변경하는 메소드 
	void setName(String name) {
		this.name = name;
	}
	void setName2(String n) {
		name = n;
	}
	
	// 전달인자가 필드를 가리는 현상
	// shadow
	void setName3(String name) {
		this.name = name;
	}
	
	void printName() {
		System.out.println("this.name :" + this.name);
		System.out.println("super.name :" + super.name);
	}
	
}
