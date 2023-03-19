package banco;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import factorias.FactoriaConexiones;
import gestor.GestorQueries;
import mapaHiloConexion.ConexionThread;



class AccesoCajeroDAO {

	public boolean accesoSINO(String usuario, int clave) {
		
		
		final Connection conexion = ConexionThread.solicitarConexionTL();
		final String query = "SELECT USUARIO FROM login WHERE USUARIO LIKE '" + usuario + "'" + 
				" AND CLAVE LIKE '" + clave + "';";
		PreparedStatement ps ;
		
				
		try {
		
			ps = conexion.prepareStatement(GestorQueries.consultarQuery("acceso"));
			ps.setString(1, usuario);
			ps.setLong(2, clave);
			ResultSet rs = ps.executeQuery();
			
		} catch(SQLException sqle) {
			System.out.println("\n\t ERROR: NO SE HA PODIDO OBTENER UN ELEMENTO SENTENCIA");
			System.out.println("---> " + sqle);
			return false;
		}
		
		
		System.out.println("SOLICITANDO ACCESO PARA: " + usuario + " \n... \n");

		
		try {
		
			return ps.executeQuery(query).next(); 
			
		} catch(SQLException sqle) {
			System.out.println("\n\t ERROR: NO SE HA PODIDO EJECUTAR LA SENTENCIA / QUERY");
			System.out.println("---> " + sqle);
			return false;			
		}
	
				
	}
	
}