package coffee.quiz;

public class MeExam {

	public static void main(String[] args) {

		Twosome ts = new Twosome();
		Starbucks sb = new Starbucks();
		Me me = new Me();
		
		me.owner(sb);
		me.owner(ts);
		
	}

}
