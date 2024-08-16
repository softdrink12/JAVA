package emp2.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import emp2.dto.EmpDTO;

@WebServlet("/emp2")
public class Emp2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("/emp doGet 실행");
		
		String no = request.getParameter("no");
		System.out.println("no : " + no);
		
		String empnoo =  request.getParameter("empnoo");
		System.out.println("empno: " + empnoo);
		
		String enamee =  request.getParameter("enamee");
		System.out.println("ename: " + enamee);
		
		try {
			// # DB에서 emp2 조회하기 
			
			// ## DB 접속 
			
			// JNDI 방식
			// Servers 폴더의 context.xml 중 Resource 태그(노드)를 가져온다
			// 거기에는 DB 정보가 있다 
			// 그걸로 DateSource 만든다
			// DateSource가 커넥션풀 이라고 생각하면 된다 
			Context ctx = new InitialContext();
			DataSource dateSource = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
			
			// 커넥션풀에서 접속 정보를 가져오기
			Connection con = dateSource.getConnection();
			// ## DB 접속 끝
			
			// SQL 준비
			String query = null;
			PreparedStatement ps = null;
			
//			if( empnoo != null ){
//				query = "SELECT * from emp2 where empno = ?";
//				ps = con.prepareStatement(query);
//				ps.setInt( 1, Integer.parseInt(empnoo) );
//			} else if (enamee != null){
//				query = "SELECT * from emp2 where ename = ?";
//				ps = con.prepareStatement(query);
//				ps.setString(1, enamee);
//			} else {
//				query = "SELECT * from emp2";
//				ps = con.prepareStatement(query);
//			}
				
			if ( empnoo != null && enamee != null ) {
				query = "select from emp2 where empno = ? or ename = ?";
				ps = con.prepareStatement(query);
				ps.setInt( 1, Integer.parseInt(empnoo) );
				ps.setString(2, enamee);
			} else {
				query = "SELECT * from emp2";
				ps = con.prepareStatement(query);
			}
			
			
			// SQL 실행 및 결과확보
			//			executeQuery : select문 실행
			//			ResultSet : select문 조회 결과 전체 : excel처럼 테이블 느낌
			ResultSet rs = ps.executeQuery();
			
			// 결과 활용
			// 한 줄 한 줄을 DTO에 넣기 
			// 그렇게 만들어진 DTO를 List에 넣기 
			
			List list = new ArrayList();
			// rs.next()
			// 다음 줄이 있다면 true를, 없으면 false를 돌려줌
			// 다음줄이 있으면 rs는 다음줄 덩어리 : table의 tr 한 줄, 1차원 배열
			while ( rs.next() ) {
				EmpDTO empDTO = new EmpDTO();
				
				// 이번줄에서 empno 컬럼의 값을 int로 형변환해서 가져옴
				int empno = rs.getInt("empno");
				empDTO.setEmpno(empno);
				
				String ename = rs.getString("ename");
				empDTO.setEname(ename);
				
				String job = rs.getString("job");
				empDTO.setJob(job);
				
				int mgr = rs.getInt("mgr");
				empDTO.setMgr(mgr);
				
				java.sql.Date hireDate = rs.getDate("hireDate");
				empDTO.setHireDate(hireDate);
				
				int sal = rs.getInt("sal");
				empDTO.setSal(sal);
				
				int comm = rs.getInt("comm");
				empDTO.setComm(comm);
				
				int deptno = rs.getInt("deptno");
				empDTO.setDeptno(deptno);	
				
				list.add(empDTO);
			}
			
			// request 자체는 브라우저에서 서버로 요청한 모든 정보가 있는 곳
			// 거기에 list도 담아두기 
			request.setAttribute("list", list);
			
			// # JSP로 보여주기
			// forward 방식은 request도 전달해줌
			// 그래서 list를 request에 넣었음
			request.getRequestDispatcher("/WEB-INF/views/empList.jsp").forward(request, response);
			
//			rs.close();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("/emp doPost 실행");
	}

}
