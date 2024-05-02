package cl.bootcamp.clase_56;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import cl.bootcamp.clase_56.db.ConeccionBD;


public class TesterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("Ejecutando Servlet tester 1 ");
		ConeccionBD objConeccionBD= ConeccionBD.getInstance();
		
		
		
		response.sendRedirect("/clase_56/Testet2Servlet");
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
