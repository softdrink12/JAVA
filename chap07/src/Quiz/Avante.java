package Quiz;

public class Avante extends Car {

	@Override
	public void drive() {
		System.out.println("아반떼!!!!!!!!!");
		System.out.println("운전을 한다!!!!!!!!!");
	}

	Avante() {

		System.out.println("Avante 차량 옵션!!!!!!");
		this.oilmax = 50;
		this.color = "AmazonGreen";
		this.price = 3100;

	}

}
