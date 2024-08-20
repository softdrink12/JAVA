package emp2.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import emp2.dto.EmpDTO;
import emp2.service.EmpService;

@WebServlet("/emp/delete")
public class EmpDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("/emp/delete doGet 실행");
		
		int empno = Integer.parseInt( request.getParameter("empno") );
		EmpDTO empdto = new EmpDTO();
		empdto.setEmpno(empno);
		
		EmpService empservice = new EmpService();
		int result = empservice.delete(empdto);
		System.out.println("result : " + result);
		
		response.sendRedirect("/proj4_emp2/emp");
	}

}
