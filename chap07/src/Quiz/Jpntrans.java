package Quiz;

public class Jpntrans extends Translate {

	String[] tr1 = {"아이", "요조우", "흐갸갹"};
	
	String trrr;
	
	String trans(String word){
		for(int i = 0; i < tr.length; i++) {
			if(word.equals(tr[i])) {
				System.out.println(tr1[i]);
			}
		}
		return trrr;
	}
	
}
