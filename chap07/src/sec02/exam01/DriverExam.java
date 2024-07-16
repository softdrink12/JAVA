package sec02.exam01;

public class DriverExam {

	public static void main(String[] args) {

		Avante avante = new Avante();
		
		Driver driver = new Driver();
//		Car car = (Car)avante;	<= 이렇게 사용도 가능
		driver.run(avante);
		
		Spark spark = new Spark();
		driver.run(spark);
		
		
		
	}

}
