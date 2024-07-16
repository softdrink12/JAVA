package Quiz;

public class Engtrans extends Translate {
	
	String[] tr1 = {"love", "friendship", "null"};
	
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
