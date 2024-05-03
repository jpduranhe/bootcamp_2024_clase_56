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

/**
 * Servlet implementation class Tester4Servlet
 */
public class Tester4Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			System.out.println("Ejecutando Servlet tester 3 ");
			ConeccionBD objConeccionBD= ConeccionBD.getInstance();
			Connection conn= objConeccionBD.getConnection();
			Statement stmt = conn.createStatement();
			
			String deletePetOwner="delete from petowner  where petowner_id=9";
			
			int registrosAfectado=stmt.executeUpdate(deletePetOwner);
			
			if(registrosAfectado==0){
				response.getWriter().print("<p> Eliminacion fallida</p>");
			}else {
				response.getWriter().print("<p> Eliminacion exitosa</p>");
			}
			
			
			
		} catch (SQLException e) {
			System.out.print("Upps!! algo fallo");
		}
	}

}
