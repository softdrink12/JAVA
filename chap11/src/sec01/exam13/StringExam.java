package sec01.exam13;

public class StringExam {

	public static void main(String[] args) {

		String s1 = "영일이삼사오육칠팔구";
		
		char c = s1.charAt(3);
		System.out.println("c: " + c);
		int i = s1.length();
		System.out.println("길이 :" + i);
		
		// indexOf
		int i2 = s1.indexOf("이");
		System.out.println("i2 : " + i2);
		// 정확하게 일치하는 것이 없으면 -1 돌려줌
		// 왼쪽에서부터 첫번째 일치하는 것의 인덱스를 돌려줌
		System.out.println("아 :" + s1.indexOf("아"));
		
		i2 = s1.indexOf("사오");
		System.out.println("i2 : " + i2);
		
		String blog = "blog.naver.com";
		String cafe = "cafe.naver.com";
		
		if(blog.indexOf("blog") != -1) {
			System.out.println("블로그 주소");
		} else {
			System.out.println("블로그 주소가 아님");
		}
		
		if(cafe.indexOf("blog") != -1) {
			System.out.println("카페 주소");
		} else {
			System.out.println("카페 주소가 아님");
		}
		
		// 이메일 점검
		// @와 . 이 없으면 이메일 주소 형식이 아님을 판단
//		System.out.println("이메일 주소를 입력받았습니다");
//		System.out.println("정확한 이메일 주소를 적어주세요");
		
		String email = "yaho@naver.com";
		String email2 = "yahonavercom";
		
		if(email.indexOf("@") != -1 && email.indexOf(".") != -1) {
			System.out.println("이메일 주소를 입력받았습니다");
		} else {
			System.out.println("정확한 이메일 주소를 적어주세요");
		}
		
		if(email2.indexOf("@") != -1 && email2.indexOf(".") != -1) {
			System.out.println("이메일 주소를 입력받았습니다");
		} else {
			System.out.println("정확한 이메일 주소를 적어주세요");
		}
		
		// indexOf 구현
		char c3 = 'o';
		boolean flag = false;
		for(int i3 = 0; i3 < email.length(); i3++) {
			char c2 = email.charAt(i3);
			if(c2 == c3) {
				flag = true;
				System.out.println(i3);
				break;
			}
		}
		if(!flag) {
			System.out.println(-1);
		}
		
		// replace를 사용해서 s1에 있는 "삼사"를 숫자 "34"로 바꿈 원본은 유지
		// replace: 첫번째 전달인자를 두번째 전달인자로 "모두" 바꿔줌
		String s2 = s1.replace("삼사", "34");
		System.out.println("s1 : " +s1);
		System.out.println("s2 : " +s2);
		
		String s3 = "123123123";
		System.out.println(s3.replace("12","다른글씨"));
		
		// 첫번째 인덱스부터 두번째 인덱스 바로 전까지 추출
		String s4 = s1.substring(1, 4);
		System.out.println("s4 :" + s4);
		
		String ssn = "213456-3123694";
//		String s5 = ssn.substring(7, 8);
		String s5 = ssn.substring(ssn.indexOf("-")+1, ssn.indexOf("-")+1 +1);
		if(s5.equals("1") || s5.equals("3")) {
			System.out.println("남자");
		} else {
			System.out.println("여자");
		}
		
		// 전달인자가 하나인 경우 끝까지
		System.out.println(ssn.substring(7));
//		System.out.println(ssn.substring(7, 100));	//java.lang.StringIndexOutOfBoundsException
		
		String oldStr = "  글씨   중간띄어쓰기   ";
		System.out.println("[" + oldStr.trim() + "]");
		
		String id = "      ";
		String trim_id = id.trim();
		if(trim_id.length() == 0) {
			System.out.println("아이디를 입력해주세요");
		}
		
		String menu = "마라탕,돼지국밥,제육볶음,냉면";
		String[] menus = menu.split(",");
		for(String m : menus) {
			System.out.println(m);
		}
		
		// 정규표현식으로 글씨를 잘라서 배열로 만들어준다 
		// .은 정규표현식에서 사용하는 예약문자라서
		// [.] \\.
		String[] urls = blog.split("\\.");
		System.out.println(urls.length);
		System.out.println(urls[1]);
		
		String search = "https://search.naver.com/search.naver?where=nexearch&sm=top_sug.pre&fbm=0&acr=1&acq=dlzp&qdt=0&ie=utf8&query=이케아";
		String[] params = search.split("&");
		System.out.println(params[2].split(":")[0] + " : " + params[2].split("=")[1]);
		
		int ss = search.indexOf("?");
		System.out.println(ss);
		String sc = search.substring(ss+1);
		System.out.println(sc);
		
		params = sc.split("&");
//		System.out.println(params);
		for (String p : params) {
			System.out.println(p.replace("=", ": "));
		}
		
		String ccc = "red big px";
		String target = "big";
		
		String[] c2 = ccc.split(" ");
		boolean isTarget = false;
		for(int i3 = 0; i3 < c2.length; i3++) {
			if(c2[i3].equals(target)) {
				isTarget = true;
				break;
			}
		}
		if(isTarget) {
			System.out.println("클래스가 있습니다");
		} else {
			System.out.println("클래스가 없습니다");
		}
		
		
		
		
		
		
	}
}
