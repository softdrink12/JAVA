package org.zerock.w1.todo.controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ezrock.w1.todo.service.TodoService;
import org.zerock.w1.todo.dto.TodoDTO;

@WebServlet("/todo/update")
public class TodoUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("/todo/update doGet 실행");
		
		int tno = Integer.parseInt( request.getParameter("tno") );
		
		TodoService todoService = new TodoService();
		TodoDTO dto = todoService.get(tno);
		
		request.setAttribute("dto", dto);
		
		request.getRequestDispatcher("/WEB-INF/todo/update.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("/todo/update doPost 실행");
		
		request.setCharacterEncoding("utf-8");
	    response.setContentType("text/html; charset=utf-8;");
		
		String title = request.getParameter("title");
		String dueDate = request.getParameter("dueDate");
		String finished = request.getParameter("finished");
		int tno = Integer.parseInt( request.getParameter("tno") );
		
		
		TodoDTO todoDTO = new TodoDTO();
		todoDTO.setTitle(title);
		todoDTO.setDueDate( LocalDate.parse(dueDate) );
		if( "N".equals(finished) ) {
			todoDTO.setFinished(false);
		} else {
			todoDTO.setFinished(true);
		}
		todoDTO.setTno(tno);
		
		System.out.println(todoDTO);
		
		// db의 insert까지 실행
		TodoService todoService = new TodoService();
		int result = todoService.update(todoDTO);
		System.out.println("insert 결과 : " + result);
		
		// 목록으로 보내기
		response.sendRedirect("/proj3_todo/todo/list");
	}

}
