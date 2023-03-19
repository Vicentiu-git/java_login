package banco;

import interfazFachada.InterfazAccesoCajeroFACHADA;


class AccesoCajeroFACHADA implements InterfazAccesoCajeroFACHADA {

	private AccesoCajeroDAO accesoCajeroDAO;
	
	
	
	public AccesoCajeroFACHADA(AccesoCajeroDAO accesoCajeroDAO) {
		this.accesoCajeroDAO = accesoCajeroDAO;	
	}
	
	
	@Override
	public boolean accesoSINO(String usuario, int clave) {
		return accesoCajeroDAO.accesoSINO(usuario, clave);	
	}
	

}












