package sec06.exam02.pack1;

import sec06.exam02.pack2.Receipt_3;

public class Receipt_2 {

	String str;
	
	Receipt_2(){
		// 다른 패키지의 클래스를 찾을 때 
		// 1. 내 패키지에 있는가?
		// 2. java.lang 패키지에 있는가?	// java 실행시 자동으로 import
		// 3. import한 곳에 있는가?
		
		// 내 패키지에 있어서 *로 로딩해도 내것을 찾아감
		// 명확히 import 해준 경우 pack2의 Receipt_1 사용 가능
		Receipt_1 r1 = new Receipt_1();	
		Receipt_3 r3 = new Receipt_3();
		r3.a = 8;
		
		// pack1의 Receipt_1을 사용하고 싶다면?
		// 다른 패키지의 클래스를 가져오는 두 번째 방법
		// 패키지 정보와 클래스 정보를 한 번에 쓰기
		// 하지만 귀찮아서 import 사용한다
		// 부득이한 경우 사용할 수 있다는 것을 알아두자 
		sec06.exam02.pack1.Receipt_1 r1_1 = new sec06.exam02.pack1.Receipt_1();
	}
	
}
