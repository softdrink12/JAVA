package sec03.exam02;

public class AnimalExam {

	public static void main(String[] args) {

		Dog dog = new Dog();
		dog.sound();
		dog.breathe();
		
		Animal a = dog;
		a.sound();
		
		// abstract 클래스는 new가 불가능하다 
//		Animal a2 = new Animal();
		
	}

}
