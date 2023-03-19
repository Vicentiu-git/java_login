package banco;


public abstract class FactoriaFachadas {

	public static AccesoCajeroFACHADA solicitarAccesoCajeroFACHADA() {
		
		return new AccesoCajeroFACHADA(new AccesoCajeroDAO());
		
	} 
	
}
