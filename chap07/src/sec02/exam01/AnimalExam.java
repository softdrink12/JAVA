package sec02.exam01;

public class AnimalExam {

	public static void main(String[] args) {

		Cat cat = new Cat();
		Dog dog = new Dog();
		
		dog.walk();
		
//		dog = cat;
		
		Animal aCat = new Cat();
		Animal aDog = new Dog();
		
		// 같은 타입이기 때문에 가능
//		aDog = aCat;
		
		aDog.eat();
		aCat.sound();
		aDog.sound();
//		aCat.walk();
		
	}

}
