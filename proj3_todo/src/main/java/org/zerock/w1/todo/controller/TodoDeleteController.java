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

@WebServlet("/todo/delete")
public class TodoDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("/toto/delete 실행");
		
		int tno = Integer.parseInt( request.getParameter("tno") );
		TodoDTO todoDTO = new TodoDTO();
		todoDTO.setTno(tno);
		
		TodoService todoService = new TodoService();
		int result = todoService.delete(todoDTO);
		System.out.println("result : " + result);
		
		response.sendRedirect("list");
	}


}
