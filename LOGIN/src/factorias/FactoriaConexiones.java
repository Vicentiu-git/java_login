package factorias;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public abstract class FactoriaConexiones {

	final static String FQN_DRIVER_JDBC = "com.mysql.jdbc.Driver";
	final static String BD_MYSQL	= "jdbc:mysql://localhost:3306/banco_web";
	final static String USER_MYSQL = "root";
	final static String PASS_MYSQL = "master";
	
	
	static {
	
		try {
		
			Class.forName(FQN_DRIVER_JDBC);
		
		} catch(ClassNotFoundException cnfe) {
			throw new RuntimeException ("\n\t ERROR: NO SE HAN PODIDO CARGAR LOS DRIVERS JDBC EN MEMORIA");
		} 

	}

	
	
	public static Connection generarConexion() {
		
		
		Connection conexion;
		
		try {			
			
			 conexion = DriverManager.getConnection(BD_MYSQL, USER_MYSQL, PASS_MYSQL);

			 
		} catch(SQLException sqle) {
			throw new RuntimeException ("\\n\\t ERROR: NO SE HA PODIDO OBTENER CONEXION CON LA BASE DE DATOS");
		}
		
		return conexion;
		
	}
	
	
	
	public static void cerrarConexion(Connection conexion) {
		
		try {
		
			if(conexion != null && !conexion.isClosed()) {
				conexion.close();
			}
			
		} catch(SQLException sqle) {
			throw new RuntimeException ("\\n\\t ERROR: NO SE HA PODIDO CERRAR LA CONEXION ACTUAL .. " + conexion);
		}
		
	}
	
}
