package emp2.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import emp2.dto.EmpDTO;
import emp2.service.EmpService;

@WebServlet("/emp/read")
public class EmpReadController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("/emp/read doGet 실행");
		
		int empno = Integer.parseInt( request.getParameter("empno") );
		
		EmpService empService = new EmpService();
		EmpDTO empdto = empService.get(empno);
		
		request.setAttribute("reading", empdto);
		
		request.getRequestDispatcher("/WEB-INF/views/read.jsp").forward(request, response);
	}

}
