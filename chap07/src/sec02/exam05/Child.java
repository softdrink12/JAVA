package sec02.exam05;

public class Child extends Parent{
	public String field1 = "Child의 field1";
	
	@Override
	public void method1(String field1) {
		System.out.println("Child의 method1 실행");
		
		this.field1 = field1;
		System.out.println("전달인자 field1 :" + field1);
		System.out.println("필드 field1 :" + this.field1);
		// p.field1은 부모 클래스의 필드를 가르킨다
		// Override는 메소드만 가능하다
	}

}
