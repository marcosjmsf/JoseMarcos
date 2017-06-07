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

			String caminho = args[0];
			
			if(caminho != null && !caminho.equals("")){
				corridaControl.processaLog(caminho);
			}else{
				throw new Exception("Por favor informar o caminho do arquivo a ser processado.");
			}
		}catch(Exception e){
			System.out.println("Erro ao processar o log de mensagem: " + e.getMessage());			
		}
	}

}
