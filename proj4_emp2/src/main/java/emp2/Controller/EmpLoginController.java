package emp2.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import emp2.dto.EmpDTO;
import emp2.service.EmpService;

@WebServlet("/login")
public class EmpLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// id, pw를 받아서 DB 조회 후 
	// 회원이면 list 페이지로 이동
	// 회원이 아니라면 로그인 페이지로 이동
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8;");
		
		try {
			String ename = request.getParameter("id");
			String empno = request.getParameter("pw");
			
			EmpDTO empdto = new EmpDTO();
			empdto.setEname(ename);
			empdto.setEmpno( Integer.parseInt(empno) );
			
			EmpService service = new EmpService();
			EmpDTO resultdto = service.loginCheck( empdto );
			
			// 세션에 넣고 
			if(resultdto != null) {
				HttpSession session = request.getSession();
				session.setAttribute("loginDTO", resultdto);
				
				// list 페이지로 sendRedirect
				response.sendRedirect( request.getContextPath() + "/emp" );
			} else {
				// login 페이지로 sendRedirect
				response.sendRedirect( request.getContextPath() + "/login.jsp?code=LO01" );
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
