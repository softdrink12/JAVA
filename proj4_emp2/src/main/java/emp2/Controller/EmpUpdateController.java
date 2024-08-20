package emp2.Controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import emp2.dto.EmpDTO;
import emp2.service.EmpService;

@WebServlet("/emp/update")
public class EmpUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("/emp/update doGet 실행");
		
		int empno = Integer.parseInt( request.getParameter("empno") );
		
		EmpService empService = new EmpService();
		EmpDTO empdto = empService.get(empno);
		
		request.setAttribute("update", empdto);
		
		request.getRequestDispatcher("/WEB-INF/views/update.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("/emp/update doPost 실행");
		
		request.setCharacterEncoding("utf-8");
	    response.setContentType("text/html; charset=utf-8;");
		
		
		String empno = request.getParameter("empno");
		String ename = request.getParameter("ename");
		String job = request.getParameter("job");
		String mgr = request.getParameter("mgr");
		String hireDate = request.getParameter("hireDate");
		String sal = request.getParameter("sal");
		String comm = request.getParameter("comm");
		String deptno = request.getParameter("deptno");
		
		EmpDTO empdto = new EmpDTO();
		empdto.setEmpno( Integer.parseInt(empno) );
		empdto.setEname(ename);
		empdto.setJob(job);
		empdto.setMgr( Integer.parseInt(mgr) );
		empdto.setHireDate( Date.valueOf(hireDate) );
		empdto.setSal( Integer.parseInt(sal) );
		empdto.setComm( Integer.parseInt(comm) );
		empdto.setDeptno( Integer.parseInt(deptno) );
		
		EmpService empservice = new EmpService();
		int result = empservice.update(empdto);
		System.out.println("insert : " + result);
		
		response.sendRedirect("/proj4_emp2/emp");
	}

}
