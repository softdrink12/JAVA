package org.zerock.w1.todo.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.zerock.w1.todo.dto.TodoDTO;

@WebServlet("/one")
public class TodoOneController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("/one doGet 실행");
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		out.println("<h1>h");
		out.print("e");
		out.append("ll");
		out.write("o</h1>");
		
		// 브라우저에서 보낸 파라메터를 받는다 
		// id의 값 출력하기 
		String 아이디 = request.getParameter("id");
		System.out.println("아이디 : " + 아이디);
		
		// pw의 값 출력하기 
		String 패스워드 = request.getParameter("pw");
		System.out.println("패스워드 : " + 패스워드);
		
		out.println("id : " + 아이디 + ", pw : " + 패스워드);
		
		out.println("<hr>");
		
		// service 클래스에서 했던 일
		List<TodoDTO> list = new ArrayList<TodoDTO>();
		for(int i = 1; i <= 10; i++) {
			
			TodoDTO dto1 = new TodoDTO();
			dto1.setTno(i);
			dto1.setTitle("할 일" + i);
			if (i % 3 == 0) {
				dto1.setFinished(true);
			}
			list.add(dto1);
		}
		
		// JSP에서 했던 일
		for(int i = 0; i < list.size(); i++) {
			
			TodoDTO dto2 = list.get(i);
			
			out.println("<div>");
			out.println( " <input type='checkbox' " );
			if( dto2.isFinished() ) {	
				out.println( " checked='checked' " );
			}
			out.println( ">" );
			
			out.println( "tno : " + dto2.getTno() );
			out.println( ", title : " + dto2.getTitle() );
			out.println("</div>");
			
		}
		
		
	}

}
