package cl.bootcamp.clase_56;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import cl.bootcamp.clase_56.db.ConeccionBD;


public class TesterServlet extends HttpServlet {
	private static final long serialVersionUID = 1000L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			System.out.println("Ejecutando Servlet tester 1 ");
		
			ConeccionBD objConeccionBD= ConeccionBD.getInstance();
			Connection conn= objConeccionBD.getConnection();
		
		
			Statement stmt = conn.createStatement();
			
			String sql="select *  from petowner";
			
			stmt.executeQuery(sql);
			
		} catch (SQLException e) {
			System.out.print("Upps!! algo fallo");;
		}
		
		
		//response.sendRedirect("/clase_56/Testet2Servlet");
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
