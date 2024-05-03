package cl.bootcamp.clase_56;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import cl.bootcamp.clase_56.dal.PetOwnerDAL;
import cl.bootcamp.clase_56.dal.PetOwnerDALImpl;
import cl.bootcamp.clase_56.db.ConeccionBD;
import cl.bootcamp.clase_56.model.Petowner;

/**
 * Servlet implementation class PetownerServletList
 */
public class PetownerServletList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ConeccionBD db=ConeccionBD.getInstance();
		PetOwnerDAL petOwnerDAL=new PetOwnerDALImpl(db);
		
		List<Petowner> list =petOwnerDAL.getListado();
		response.getWriter().print("<table style='border: 1px solid black'>");
		response.getWriter().print("<tr style='border: 1px solid black'>");
		response.getWriter().print("<td style='border: 1px solid black'>Id</td>");
		response.getWriter().print("<td style='border: 1px solid black'>Nombre</td>");
		response.getWriter().print("<td style='border: 1px solid black'>Apellido</td>");
		response.getWriter().print("<td style='border: 1px solid black'>Email</td>");
		response.getWriter().print("</tr>");
		for(Petowner po: list){
			
			int id=po.getId();
			String nombre=po.getNombre();
			String apellidos=po.getApellidos();
			String email=po.getEmail();
			
			
			response.getWriter().print("<tr style='border: 1px solid black'>");
			response.getWriter().print("<td style='border: 1px solid black'>"+id+"</td>");
			response.getWriter().print("<td style='border: 1px solid black'>"+nombre+"</td>");
			response.getWriter().print("<td style='border: 1px solid black'>"+apellidos+"</td>");
			response.getWriter().print("<td style='border: 1px solid black'>"+email+"</td>");
			response.getWriter().print("</tr>");
			
		}
		response.getWriter().println("<table>");
			
	}


}
