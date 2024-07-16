package Quiz;

public class TranslateExam {

	public static void main(String[] args) {

		Engtrans tr = new Engtrans();
		Jpntrans jp = new Jpntrans();
		
		tr.trans("우정");
		jp.trans("사랑");
		
	}

}
