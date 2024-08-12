package org.zerock.w1.todo.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ezrock.w1.todo.service.TodoService;
import org.zerock.w1.todo.dto.TodoDTO;

@WebServlet("/todo/read")
public class TodoReadController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("TodoReadController 실행");
		
		// 문자를 숫자로 String to int
		int tno = Integer.parseInt( request.getParameter("tno") );
		
		TodoService todoService = new TodoService();
		TodoDTO dto = todoService.get(tno);
		
		request.setAttribute("dto", dto);
		
		request.getRequestDispatcher("/WEB-INF/todo/read.jsp").forward(request, response);
	}

}
