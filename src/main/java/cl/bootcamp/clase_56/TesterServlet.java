package cl.bootcamp.clase_56;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
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
			
			ResultSet rsl = stmt.executeQuery(sql);
			response.getWriter().print("<table style='border: 1px solid black'>");
			response.getWriter().print("<tr style='border: 1px solid black'>");
			response.getWriter().print("<td style='border: 1px solid black'>Id</td>");
			response.getWriter().print("<td style='border: 1px solid black'>Nombre</td>");
			response.getWriter().print("<td style='border: 1px solid black'>Apellido</td>");
			response.getWriter().print("<td style='border: 1px solid black'>Email</td>");
			response.getWriter().print("</tr>");
			while(rsl.next()){
				
				//petowner_name,petowner_lastname,petowner_email
				int id=rsl.getInt("petowner_id");
				String nombre=rsl.getString("petowner_name");
				String apellidos=rsl.getString("petowner_lastname");
				String email=rsl.getString("petowner_email");
				
				
				response.getWriter().print("<tr style='border: 1px solid black'>");
				response.getWriter().print("<td style='border: 1px solid black'>"+id+"</td>");
				response.getWriter().print("<td style='border: 1px solid black'>"+nombre+"</td>");
				response.getWriter().print("<td style='border: 1px solid black'>"+apellidos+"</td>");
				response.getWriter().print("<td style='border: 1px solid black'>"+email+"</td>");
				response.getWriter().print("</tr>");
				
			}
			response.getWriter().println("<table>");
			
		} catch (SQLException e) {
			System.out.print("Upps!! algo fallo");;
		}
		
		
		//response.sendRedirect("/clase_56/Testet2Servlet");
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
