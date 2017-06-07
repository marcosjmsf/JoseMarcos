/**
 * 
 */
package br.com.amil.kart.model.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import br.com.amil.kart.DTO.CamposMensagem;
import br.com.amil.kart.DTO.DesempenhoIndividual;
import br.com.amil.kart.DTO.Volta;
import br.com.amil.kart.model.DesempenhoIndividualModel;
import br.com.amil.kart.utils.DateUtils;

/**
 * @author marcos
 *
 */


public class DesempenhoIndividualModelTest{


	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void createDesempenhoIndividual() throws Exception{

		DesempenhoIndividualModel desempenhoIndividualModel = new DesempenhoIndividualModel();

		List<CamposMensagem> listCamposMensagem = new ArrayList<CamposMensagem>();

		CamposMensagem camposMensagem = new CamposMensagem();

		camposMensagem.setCodigoPiloto("043");
		camposMensagem.setHora("08:43:09.231");
		camposMensagem.setNomePiloto("A.SENNA");
		camposMensagem.setNumeroVolta("01");
		camposMensagem.setTempoVolta("01:02.988");
		camposMensagem.setVelocidadeMedia("43,09");

		listCamposMensagem.add(camposMensagem);

		camposMensagem = new CamposMensagem();

		camposMensagem.setCodigoPiloto("043");
		camposMensagem.setHora("08:44:14.299");
		camposMensagem.setNomePiloto("A.SENNA");
		camposMensagem.setNumeroVolta("02");
		camposMensagem.setTempoVolta("01:00.091");
		camposMensagem.setVelocidadeMedia("44,77");

		listCamposMensagem.add(camposMensagem);

		DesempenhoIndividual desempenho = desempenhoIndividualModel.createDesempenhoIndividual(listCamposMensagem);

		assertEquals(02,desempenho.getMelhorVolta().getNumeroVolta());
		assertEquals("043",desempenho.getPiloto().getCodigoPiloto());
		assertEquals("A.SENNA",desempenho.getPiloto().getNomePiloto());
		assertEquals("43.93",String.valueOf(desempenho.getVelocidadeMedia()));
		assertEquals(2,desempenho.getVoltas().size());
		assertEquals(false,desempenho.isProvaConcluida());
		

	}

	@Test
	public void createDesempenhoIndividualFail() throws Exception{

		thrown.expect(Exception.class);
		thrown.expectMessage("Lista de CamposMensagem esta vazia");

		List<CamposMensagem> listCamposMensagem = null;

		DesempenhoIndividualModel desempenhoIndividualModel = new DesempenhoIndividualModel();

		desempenhoIndividualModel.createDesempenhoIndividual(listCamposMensagem);

	}

	@Test
	public void definirMelhorVoltaCorrida () throws Exception{
		
		DesempenhoIndividualModel desempenhoIndividualModel = new DesempenhoIndividualModel();
		
		List<DesempenhoIndividual> listDesempenhoIndividual = new ArrayList<DesempenhoIndividual>();
		
		DesempenhoIndividual desempenho = new DesempenhoIndividual();

		DesempenhoIndividual desempenhoReturn = new DesempenhoIndividual();
		
		Volta volta = new Volta();
		
		volta.setTempoVolta(DateUtils.gerarDataByMinuto("01:04.191"));
		
		desempenho.setMelhorVolta(volta);
		
		listDesempenhoIndividual.add(desempenho);
		
		desempenho = new DesempenhoIndividual();
		
		volta = new Volta();
		
		volta.setTempoVolta(DateUtils.gerarDataByMinuto("01:01.191"));
		
		desempenho.setMelhorVolta(volta);
		
		listDesempenhoIndividual.add(desempenho);
				
		desempenhoReturn = desempenhoIndividualModel.definirMelhorVoltaCorrida(listDesempenhoIndividual);
		
		assertEquals(desempenho.getMelhorVolta().getTempoVolta(), desempenhoReturn.getMelhorVolta().getTempoVolta());
		
	}
	
	@Test
	public void definirMelhorVoltaCorridaNull () throws Exception{
		
		DesempenhoIndividualModel desempenhoIndividualModel = new DesempenhoIndividualModel();
		
		List<DesempenhoIndividual> listDesempenhoIndividual = null;
		
		desempenhoIndividualModel.definirMelhorVoltaCorrida(listDesempenhoIndividual);
		
	}
	
	@Test
	public void definirMelhorVoltaCorridaEmpty () throws Exception{
		
		DesempenhoIndividualModel desempenhoIndividualModel = new DesempenhoIndividualModel();
		
		List<DesempenhoIndividual> listDesempenhoIndividual = new ArrayList<DesempenhoIndividual>();
		
		desempenhoIndividualModel.definirMelhorVoltaCorrida(listDesempenhoIndividual);
		
	}
	
	@Test
	public void diferencaLider () throws Exception{
		
		DesempenhoIndividualModel desempenhoIndividualModel = new DesempenhoIndividualModel();
		
		List<DesempenhoIndividual> listDesempenhoIndividual = new ArrayList<DesempenhoIndividual>();
		
		DesempenhoIndividual desempenho = new DesempenhoIndividual();
		
		Volta volta = new Volta();
		
		volta.setHoraFimVolta(DateUtils.gerarDataByHora("23:00:04.002"));
		
		desempenho.getVoltas().add(volta);
		
		listDesempenhoIndividual.add(desempenho);
		
		desempenho = new DesempenhoIndividual();
		
		volta = new Volta();
		
		volta.setHoraFimVolta(DateUtils.gerarDataByHora("23:00:08.191"));
		
		desempenho.getVoltas().add(volta);

		desempenho.setProvaConcluida(true);
		
		listDesempenhoIndividual.add(desempenho);
				
		desempenhoIndividualModel.diferencaLider(listDesempenhoIndividual);
		
		assertEquals("4.189",listDesempenhoIndividual.get(1).getDiferencaLider());		
	}
	
	
	
	
	@Test
	public void diferencaLiderCorridaIncompleta () throws Exception{
		
		DesempenhoIndividualModel desempenhoIndividualModel = new DesempenhoIndividualModel();
		
		List<DesempenhoIndividual> listDesempenhoIndividual = new ArrayList<DesempenhoIndividual>();
		
		DesempenhoIndividual desempenho = new DesempenhoIndividual();
		
		Volta volta = new Volta();
		
		volta.setHoraFimVolta(DateUtils.gerarDataByMinuto("23:00:04.001"));
		
		desempenho.getVoltas().add(volta);
		
		listDesempenhoIndividual.add(desempenho);
		
		desempenho = new DesempenhoIndividual();
		
		volta = new Volta();
		
		volta.setHoraFimVolta(DateUtils.gerarDataByHora("23:00:08.191"));
		
		desempenho.getVoltas().add(volta);
		
		listDesempenhoIndividual.add(desempenho);
				
		desempenhoIndividualModel.diferencaLider(listDesempenhoIndividual);
		
		assertEquals("Parou na volta 1",listDesempenhoIndividual.get(1).getDiferencaLider());
		
	}
	
	@Test
	public void diferencaLiderFail () throws Exception{

		thrown.expect(Exception.class);
		thrown.expectMessage("Lista de desempenho vazia");
		
		DesempenhoIndividualModel desempenhoIndividualModel = new DesempenhoIndividualModel();
		
		List<DesempenhoIndividual> listDesempenhoIndividual = new ArrayList<DesempenhoIndividual>();
		
		desempenhoIndividualModel.diferencaLider(listDesempenhoIndividual);
		
	}
	
	@Test
	public void preencherPosicoes (){
		
		DesempenhoIndividualModel desempenhoIndividualModel = new DesempenhoIndividualModel();
		
		List<DesempenhoIndividual> listDesempenhoIndividual = new ArrayList<DesempenhoIndividual>();
		
		DesempenhoIndividual desempenho = new DesempenhoIndividual();
		
		listDesempenhoIndividual.add(desempenho);
		
		desempenho.setProvaConcluida(true);
		
		desempenho = new DesempenhoIndividual();
		
		listDesempenhoIndividual.add(desempenho);
				
		desempenhoIndividualModel.preencherPosicao(listDesempenhoIndividual);
		
		assertEquals("1º",listDesempenhoIndividual.get(0).getPosicaoChegada());
		assertEquals("--",listDesempenhoIndividual.get(1).getPosicaoChegada());		
	}
	
	@Test
	public void preencherPosicoesEmpty (){
		
		DesempenhoIndividualModel desempenhoIndividualModel = new DesempenhoIndividualModel();
		
		List<DesempenhoIndividual> listDesempenhoIndividual = new ArrayList<DesempenhoIndividual>();
				
		desempenhoIndividualModel.preencherPosicao(listDesempenhoIndividual);				
	}

}
