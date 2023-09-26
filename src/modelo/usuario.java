package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import factory.conexionBase;

public class usuario {
	private String nombre;
	private String contraseña;
	
	public usuario(String nombre, String contraseña) {
		this.nombre = nombre;
		this.contraseña = contraseña;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public static boolean validarUsuario(String nombre, String contraseña) {
		conexionBase conexion = new conexionBase();
		Connection connection = null;
		PreparedStatement state = null;
		ResultSet result = null;
		try {
			connection = conexion.recuperarConexion();
			state = connection.prepareStatement("SELECT * FROM usuarios WHERE nombre = ? AND contraseña = ?");
			state.setString(1, nombre);
			state.setString(2, contraseña);
			result = state.executeQuery();
			return result.next();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}finally {
			try {
				if (result !=null)
					result.close();
				if (state !=null)
					state.close();
				if (connection !=null)
					connection.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		
		
		
	}

}
