package clientes;

import java.util.Scanner;

import banco.FactoriaFachadas;
import interfazFachada.InterfazAccesoCajeroFACHADA;

public class Cliente {

	public static void main(String[] args) {

		/*
		// Datos para acceder
		tuUsuario	= "juan";
		tuClave 	= 123;
		*/

		String tuUsuario	= "";
		int tuClave 	= 0;
		
		Scanner scanner = new Scanner(System.in);

		System.out.println("\n\nINTRODUCE TU USUARIO ... ");
		tuUsuario = scanner.nextLine();
		
		boolean repetir;
      
      do {
          
          repetir = false;    

          System.out.print("\n\nINTRODUCE TU CLAVE (numerico) ... ");
          
          try {
          	tuClave = Integer.parseInt(scanner.nextLine());
          } catch(NumberFormatException nfe) {
              System.out.println("ERROR. EL DATO INTRODUCIDO NO TIENE EL FORMATO CORRECTO.");
              repetir = true;
          }

      } while(repetir);


		
		InterfazAccesoCajeroFACHADA gestorAcceso = FactoriaFachadas.solicitarAccesoCajeroFACHADA();
	
		
		boolean siNo = gestorAcceso.accesoSINO(tuUsuario, tuClave);
		
		
		System.out.println(siNo ? "HOLA " + tuUsuario.toUpperCase() + "!!! PUEDES ACCEDER" : "USUARIO O CLAVE INCORRECTOS");
		
	}
	
}
