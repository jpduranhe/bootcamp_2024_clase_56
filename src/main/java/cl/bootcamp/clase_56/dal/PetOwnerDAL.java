package cl.bootcamp.clase_56.dal;

import java.util.List;

import cl.bootcamp.clase_56.model.Petowner;

public interface PetOwnerDAL {
	
	int guardar(Petowner petowner);
	int update(Petowner petowner);
	Petowner obtener(int id);
	int borrar(int id);
	List<Petowner> getListado();
}
