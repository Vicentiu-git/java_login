package mapaHiloConexion;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;


import factorias.FactoriaConexiones;

public class ConexionThread {
	private static final Map<Thread, Connection> mapaHilosConexiones;

	static {
		mapaHilosConexiones = new HashMap<Thread, Connection>();
	}

	
	public static synchronized Connection solicitarConexionTL()  {

		Thread hiloActual = Thread.currentThread();

		System.out.println("\n ¿QUE HILO ESTA AHORA PIDIENDO CONEXION? ... " + hiloActual.getName() + "\n");

		Connection conexion = mapaHilosConexiones.get(hiloActual);

		try {
			
		
		if (conexion == null || conexion.isClosed()) {

			System.out.println("\nCONEXION EN EL MAPA CERRADA O NULA " + " ... FABRICANDO UNA NUEVA\n");

			conexion = FactoriaConexiones.generarConexion();

			mapaHilosConexiones.put(hiloActual, conexion);

		
		} else {

			System.out.println("\n  EL HILO " + hiloActual.getName()
					+ " YA TIENE CONEXION Y ES VALIDA ... REUTILIZAR -> " + +conexion.hashCode() + " !!! \n");
		}
		}catch(SQLException e) {
			System.out.println("Error de la conexión actual");
		}

	

		return conexion;

	}

	
}
