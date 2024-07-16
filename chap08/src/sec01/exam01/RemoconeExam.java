package sec01.exam01;

import java.util.ArrayList;
import java.util.List;

public class RemoconeExam {

	public static void main(String[] args) {

		RemoteControl tv = new Tv();
		Audio ad = new Audio();
		RemoteControl ad2 = ad;
		
		tv.turnOn();
		ad.setVolume(12);
		
		List list = new ArrayList();
		
	}

}
