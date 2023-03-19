package gestor;


import java.util.ResourceBundle;


public abstract class GestorQueries {

	private static final String fichero = "properties.queries";
			
	private static final ResourceBundle rb;
	
	
	static {		
		rb = ResourceBundle.getBundle(fichero);
	}
	
	
	//RECUPERACIÓN DE LA QUERY:
	
	public static String consultarQuery(String clave) {		
		return rb.getString(clave);
	}
	
}
