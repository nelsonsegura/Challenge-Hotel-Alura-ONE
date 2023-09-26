package controladores;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

import CRUD.HuespedCRUD;
import factory.conexionBase;
import modelo.Huespedes;

public class huespedControlador {
	private HuespedCRUD huespedCrud;
	
	
	public huespedControlador() {
		Connection connection = new conexionBase().recuperarConexion();
		this.huespedCrud = new HuespedCRUD(connection);
	}
	
	public void guardar(Huespedes huespedes) {
		this.huespedCrud.guardar(huespedes);
	}
	
	public  List<Huespedes> buscarHuespedes(){
		return this.huespedCrud.buscar();
	}
	
	public  List<Huespedes> buscarHuespedesId(String id){
		return this.huespedCrud.buscarId(id);
	}
	
	public void actualizar(String nombre, String apellido, Date fechaNacimiento, String nacionalidad, String telefono,Integer id_reserva) {
		this.huespedCrud.Actualizar(nombre, apellido, fechaNacimiento, nacionalidad, telefono, id_reserva, id_reserva);
	}
	 
	public void Eliminar(Integer idReserva) {
		this.huespedCrud.Eliminar(idReserva);
	}
	
	
}
