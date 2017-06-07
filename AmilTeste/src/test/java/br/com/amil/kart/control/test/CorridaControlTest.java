/**
 * 
 */
package br.com.amil.kart.control.test;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;


import br.com.amil.kart.control.CorridaControl;

/**
 * @author marcos
 *
 */
public class CorridaControlTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	
	@Test
	public void processaLogCaminhoEmpty () throws Exception{
	
		thrown.expect(Exception.class);
		thrown.expectMessage("Caminho nao informado");
	
		CorridaControl corridaControl = new CorridaControl();  
		
		String caminho = "";
		
		corridaControl.processaLog(caminho);
		
	}
	
	
	@Test
	public void processaLogCaminhoNull () throws Exception{
	
		thrown.expect(Exception.class);
		thrown.expectMessage("Caminho nao informado");
	
		CorridaControl corridaControl = new CorridaControl();  
		
		String caminho = null;
		
		corridaControl.processaLog(caminho);
		
	}
}
