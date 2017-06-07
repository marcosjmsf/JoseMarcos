/**
 * 
 */
package br.com.amil.kart.main;

import br.com.amil.kart.control.CorridaControl;

/**
 * @author marcos
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		try{
			CorridaControl corridaControl = new CorridaControl();

			corridaControl.processaLog(args[0]);

		}catch(Exception e){
			System.out.println("Erro ao processar o log de mensagem: " + e.getMessage());			
		}
	}

}
