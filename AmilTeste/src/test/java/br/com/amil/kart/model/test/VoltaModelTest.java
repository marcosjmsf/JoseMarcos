/**
 * 
 */
package br.com.amil.kart.model.test;

import static org.junit.Assert.assertEquals;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import br.com.amil.kart.DTO.CamposMensagem;
import br.com.amil.kart.DTO.Volta;
import br.com.amil.kart.model.VoltaModel;
import br.com.amil.kart.utils.DateUtils;

/**
 * @author marcos
 *
 */
public class VoltaModelTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void createVolta() throws Exception{

		VoltaModel voltaModel = new VoltaModel();
		CamposMensagem camposMensagem = new CamposMensagem();

		SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm:ss.SSS");
		SimpleDateFormat formatoMinuto = new SimpleDateFormat("mm:ss.SSS");

		camposMensagem.setCodigoPiloto("043");
		camposMensagem.setHora("08:43:09.231");
		camposMensagem.setNomePiloto("A.SENNA");
		camposMensagem.setNumeroVolta("01");
		camposMensagem.setTempoVolta("01:02.988");
		camposMensagem.setVelocidadeMedia("43,09");

		Volta volta = voltaModel.createVolta(camposMensagem);

		assertEquals("08:43:09.231", formatoHora.format(volta.getHoraFimVolta()));
		assertEquals(01, volta.getNumeroVolta());
		assertEquals("01:02.988",formatoMinuto.format(volta.getTempoVolta()));
		assertEquals("43.09", String.valueOf(volta.getVelocidadeMediaVolta()));

	}

	@Test
	public void createVoltaEmpty() throws Exception{

		VoltaModel voltaModel = new VoltaModel();
		CamposMensagem camposMensagem = null;

		thrown.expect(Exception.class);
		thrown.expectMessage("CamposMensagem esta vazio");

		voltaModel.createVolta(camposMensagem);

	}

	@Test
	public void definirMelhorVolta() throws Exception{

		VoltaModel voltaModel = new VoltaModel();
		List<Volta> listVolta =  new ArrayList<Volta>();
		
		
		Volta volta = new Volta();
		volta.setTempoVolta(DateUtils.gerarDataByMinuto("01:04.191"));
		volta.setNumeroVolta(01);
		listVolta.add(volta);
		
		
		volta = new Volta();
		
		volta.setNumeroVolta(02);
		volta.setTempoVolta(DateUtils.gerarDataByMinuto("01:03.191"));
		listVolta.add(volta);
		
		Volta melhor = new Volta();
		
		melhor = voltaModel.definirMelhorVolta(listVolta);
		
		assertEquals(volta.getNumeroVolta(), melhor.getNumeroVolta());
	}
	
	@Test
	public void definirMelhorVoltaEmpty() throws Exception{

		VoltaModel voltaModel = new VoltaModel();
		List<Volta> listVolta =  null;
	
		thrown.expect(Exception.class);
		thrown.expectMessage("Lista de voltas nula");

		voltaModel.definirMelhorVolta(listVolta);
	
	}
	
}
