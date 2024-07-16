package coffee.quiz;

public class Me {
	
	void owner(Coffee c) {
		
		if(c.isDT()) {
			System.out.println("드라이브스루 이용");
			c.order("따아");
		} else {
			System.out.println("주자창이나 찾아 ");
		}
		
	}

}
