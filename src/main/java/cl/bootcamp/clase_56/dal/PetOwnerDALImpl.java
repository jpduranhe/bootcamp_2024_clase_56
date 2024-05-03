package cl.bootcamp.clase_56.dal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cl.bootcamp.clase_56.db.ConeccionBD;
import cl.bootcamp.clase_56.model.Petowner;

public class PetOwnerDALImpl implements PetOwnerDAL {
	
	
	private ConeccionBD db;
	
	public PetOwnerDALImpl(ConeccionBD db) {
		this.db=db;
	}
	

	@Override
	public int guardar(Petowner petowner) {
		try {
		
			String insert="insert into petowner (petowner_name,petowner_lastname,petowner_email)\n"
					+ "values('"+petowner.getNombre()+"','"+
								petowner.getApellidos()+"','"+
					            petowner.getEmail()+"')";
			int registroAfectados= db.getStament().executeUpdate(insert);
		return registroAfectados;
		}catch (SQLException e) {
			System.out.println(e.getMessage());
			return 0;
		}
	}	
	
	@Override
	public int update(Petowner petowner) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public Petowner obtener(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int borrar(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Petowner> getListado() {
		try {
			List<Petowner> listado= new ArrayList<Petowner>();
			String sql="select * from petowner";
			ResultSet rs= db.getStament().executeQuery(sql);
		
			while(rs.next()) {
				Petowner po= new Petowner();
				po.setId(rs.getInt("petowner_id"));
				po.setNombre(rs.getString("petowner_name"));
				po.setApellidos(rs.getString("petowner_lastname"));
				po.setEmail(rs.getString("petowner_email"));
				listado.add(po);
			}
			
			
			return listado;
		}catch (SQLException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

}
