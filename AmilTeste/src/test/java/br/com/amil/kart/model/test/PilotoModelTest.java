/**
 * 
 */
package br.com.amil.kart.model.test;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import br.com.amil.kart.DTO.CamposMensagem;
import br.com.amil.kart.DTO.Piloto;
import br.com.amil.kart.model.PilotoModel;

/**
 * @author marcos
 *
 */
public class PilotoModelTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void criarPiloto() throws Exception{
		
		CamposMensagem camposMensagem = new CamposMensagem();
		camposMensagem.setNomePiloto("A.SENNA");
		camposMensagem.setCodigoPiloto("01");
		
		PilotoModel pilotoModel = new PilotoModel();
		
		Piloto piloto = pilotoModel.createPiloto(camposMensagem);
		
		assertEquals("01",piloto.getCodigoPiloto());
		assertEquals("A.SENNA",piloto.getNomePiloto());
	}
	
	@Test
	public void criarPilotoNull() throws Exception{
		
		thrown.expect(Exception.class);
		thrown.expectMessage("Campos Mensagem nulo");
		
		CamposMensagem camposMensagem = null;
		
		PilotoModel pilotoModel = new PilotoModel();
		
		pilotoModel.createPiloto(camposMensagem);		
	}
	
	
	
}
