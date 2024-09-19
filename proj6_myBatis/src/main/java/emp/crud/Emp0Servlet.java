package emp.crud;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/emp0")
public class Emp0Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private boolean _DEBUG = true;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("emp0 doGet 실행");
		
		String cmd = request.getParameter("cmd");
		
		if(cmd == null) {
			EmpDAO empDAO = new EmpDAO();
			List<EmpDTO> emplist = empDAO.selectEmp();
			request.setAttribute("emplist", emplist);
			
			request.getRequestDispatcher("/WEB-INF/views/emp.jsp").forward(request, response);
		} else if ("join".equals(cmd)) {
			request.getRequestDispatcher("/WEB-INF/views/empJoin.jsp").forward(request, response);
		} else if ("edit".equals(cmd)) {
			
			int empno = Integer.parseInt(request.getParameter("empno"));
			
			EmpDTO empDTO = new EmpDTO();
			empDTO.setEmpno(empno);
			
			EmpDAO empDAO = new EmpDAO();
			EmpDTO dto =  empDAO.selectOneEmp(empDTO);
			System.out.println("dto : " + dto);
			
			request.setAttribute("emplist", dto);
			
			request.getRequestDispatcher("/WEB-INF/views/empEdit.jsp").forward(request, response);
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("emp0 doPost 실행");
		
		String cmd = request.getParameter("cmd");
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8;");
		if(cmd == null) {
			String strEmpno = request.getParameter("empno");
			String ename = request.getParameter("ename");
			String strHireDate = request.getParameter("hireDate");
			
			try {
				int empno = Integer.parseInt(strEmpno);
				Date hireDate = Date.valueOf(strHireDate);
				
				EmpDTO empDTO = new EmpDTO();
				empDTO.setEmpno(empno);
				empDTO.setEname(ename);
				empDTO.setHireDate(hireDate);
				System.out.println(empDTO);
				
				// insert 실행
				EmpDAO empDAO = new EmpDAO();
				empDAO.insertEmp(empDTO);
				
			}catch (Exception e) {
				if(_DEBUG) {
					e.printStackTrace();
				}
			}
			
		} else if("edit".equals(cmd)) {
			String strEmpno = request.getParameter("empno");
			String ename = request.getParameter("ename");
			String strHireDate = request.getParameter("hireDate");
			
			try {
				int empno = Integer.parseInt(strEmpno);
				Date hireDate = Date.valueOf(strHireDate);
				
				EmpDTO empDTO = new EmpDTO();
				empDTO.setEmpno(empno);
				empDTO.setEname(ename);
				empDTO.setHireDate(hireDate);
				System.out.println(empDTO);
				
				// insert 실행
				EmpDAO empDAO = new EmpDAO();
				int result = empDAO.updateEmp(empDTO);
				System.out.println(result);
				
			}catch (Exception e) {
				if(_DEBUG) {
					e.printStackTrace();
				}
			}
			
		} else if("delete".equals(cmd)) {
			String strEmpno = request.getParameter("empno");
			
			try {
				int empno = Integer.parseInt(strEmpno);
				
				EmpDTO empDTO = new EmpDTO();
				empDTO.setEmpno(empno);
				System.out.println(empDTO);
				
				// insert 실행
				EmpDAO empDAO = new EmpDAO();
				int result = empDAO.deleteEmp(empDTO);
				System.out.println(result);
				
			}catch (Exception e) {
				if(_DEBUG) {
					e.printStackTrace();
				}
			}
		}
		
		response.sendRedirect("emp0");
		
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("emp0 doPut 실행");
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("emp0 doDelete 실행");
	}

}
