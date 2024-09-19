package emp;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/emp")
public class EmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("emp doGet 실행");
		
		EmpDAO dao = new EmpDAO();
		
		EmpDTO dto = new EmpDTO();
		
		List<EmpDTO> list = dao.selectEmp();
		
		System.out.println("List : " + list);
		request.setAttribute("list", list);
		
		List<Map> ListMap = (List<Map>) dao.selectAllEmpMap();
		System.out.println("ename : " + ListMap.get(0).get("ENAME"));
		
		dto = dao.selectOneEmp();
		System.out.println("EmpDTO : " + dto);
		
		int total = dao.selectTotalEmp();
		System.out.println("total : " + total);
		
		String ename = dao.selectEnameEmp();
		System.out.println("ename : " + ename);
		
		dto.setEmpno(7788);
		dto.setEname("ScoTT3");
		dto.setSal(3210);
		int result = dao.updateEmp(dto);
		System.out.println("update : " + result);
		
		EmpDTO empDTO = dao.selectEmpByEname("KING");
		System.out.println("ByEname : " + empDTO);
		
	}

}
