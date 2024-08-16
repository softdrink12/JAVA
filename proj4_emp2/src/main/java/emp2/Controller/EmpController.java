package emp2.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import emp2.service.EmpService;

@WebServlet("/emp")
public class EmpController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("/emp doGet 실행");
		
		String empnoo =  request.getParameter("empnoo");
		System.out.println("empno: " + empnoo);
		
		String enamee =  request.getParameter("enamee");
		System.out.println("ename: " + enamee);
		
		EmpService empService = new EmpService();
		List list = empService.getEmp(empnoo, enamee);
		
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("/WEB-INF/views/empList.jsp").forward(request, response);
	}

}
