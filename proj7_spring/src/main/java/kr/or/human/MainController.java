package kr.or.human;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

// Controller Bean(즉 Spring이 생성할 수 있는 Class)으로 등록한다 
@Controller
// class에 붙은 @RequestMapping은 HandlerMapping이 처리한다 
// ip:port/context Path/sub/**
// 이 클래스에서 반복되는 첫 주소를 한 번에 지정할 때 사용
@RequestMapping("/sub")
public class MainController {

	// 메소드에 적용한 @RequestMapping은 HandlerAdapter가 처리한다
	@RequestMapping("/main1.do")
	public ModelAndView main1() {
		System.out.println("main1 실행");
		
		// ViewResover로 보내는 객체 
		ModelAndView mav = new ModelAndView();
		// jsp의 조합을 위한 이름
		// forward로 이동하게 됨 
		mav.setViewName("main");
		
		// ViewName을 생성자에 넣어도 됨 
//		ModelAndView mav = new ModelAndView("main");
		
		return mav;
		
	}
	
	@RequestMapping("/main2.do")
	public ModelAndView main2() {
		System.out.println("main2 실행");
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("main");
		
		// request.setAttribute처럼 담을 수 있는 방법
		mav.addObject("msg", "김승환");
		
		return mav;
		
	}
	
	// 전달인자가 value 하나 일때는 value라는 글씨를 생략할 수 있다
	// 두 개 이상의 값을 넣을 때는 {}안에 넣는다
	// value는 url 패턴을 뜻한다
	// method는 접근 방식 제안함
	// 		적은 것만 들어올 수 있음
	//		method를 생략하면 모든 방식 허용 
	@RequestMapping(
			value = {"/main/*/search", "/test/main4.do"},
			method = {RequestMethod.POST, RequestMethod.GET}
	)
	public ModelAndView main3() {
		System.out.println("main3 실행");
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("main");
		
		// request.setAttribute처럼 담을 수 있는 방법
		mav.addObject("msg", "main3 메소드 실행");
		
		return mav;
		
	}
	
	// url 주소가 같으면 부팅시 예외 발생
//	@RequestMapping("/test/main2.do")
//	public ModelAndView main4() {
//		System.out.println("main2 실행");
//		
//		ModelAndView mav = new ModelAndView();
//		mav.setViewName("main");
//		
//		// request.setAttribute처럼 담을 수 있는 방법
//		mav.addObject("msg", "김승환");
//		
//		return mav;
//		
//	}
	
//	@RequestMapping(value="/main5.do", method=RequestMethod.GET)
	@GetMapping("/main5.do")
	public ModelAndView main5() {
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("main");
		
		mav.addObject("msg", "김승환");
		
		return mav;
		
	}
	
//	@RequestMapping(value="/main5.do", method=RequestMethod.POST)
	@PostMapping("/main5.do")
	public ModelAndView main6() {
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("main");
		
		mav.addObject("msg", "김승환");
		
		return mav;
		
	}
	
//	RequestMapping(value="/main5.do", method=RequestMethod.PUT)
	// 위의 것을 생략한 버전
	@PutMapping("/main5.do")
	public ModelAndView main7() {
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("main");
		
		mav.addObject("msg", "김승환");
		
		return mav;
		
	}
	
	@DeleteMapping("/main5.do")
	public ModelAndView main8() {
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("main");
		
		mav.addObject("msg", "김승환");
		
		return mav;
		
	}
	
}
