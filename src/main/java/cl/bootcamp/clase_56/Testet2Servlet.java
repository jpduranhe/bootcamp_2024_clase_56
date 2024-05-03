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


public class Testet2Servlet extends HttpServlet {
	private static final long serialVersionUID = 10000L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			System.out.println("Ejecutando Servlet tester 2 ");
			ConeccionBD objConeccionBD= ConeccionBD.getInstance();
			Connection conn= objConeccionBD.getConnection();
			Statement stmt = conn.createStatement();
			
			String insertPetOwner="insert into petowner (petowner_name,petowner_lastname,petowner_email)\n"
								+ "values('Aaron','Rojas','aaron@mail.com')";
			
			int registrosAfectado=stmt.executeUpdate(insertPetOwner);
			
			if(registrosAfectado==0){
				response.getWriter().print("<p> Registro No insertado</p>");
			}else {
				response.getWriter().print("<p> Registro Guardado exitosamente</p>");
			}
			
			
			
		} catch (SQLException e) {
			System.out.print("Upps!! algo fallo");;
		}
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
