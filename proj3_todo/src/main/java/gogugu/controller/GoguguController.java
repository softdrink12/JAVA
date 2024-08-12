package gogugu.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gugu.dto.GuguDTO;
import gugu.service.GuguService;

@WebServlet("/gugu/go")
public class GoguguController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("gugu/ct 실행");
		
		int tx1 = Integer.parseInt( request.getParameter("tx") );
		
		GuguService guguservice = new GuguService();
		List<GuguDTO> list = guguservice.gugudan(tx1);
		
		request.setAttribute("gugulist", list);
		
		request.getRequestDispatcher("/WEB-INF/todo/gogugu.jsp").forward(request, response);
	}

}
