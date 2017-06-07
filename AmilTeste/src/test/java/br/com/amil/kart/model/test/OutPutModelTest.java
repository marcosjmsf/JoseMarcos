/**
 * 
 */
package br.com.amil.kart.model.test;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import br.com.amil.kart.DTO.Corrida;
import br.com.amil.kart.DTO.DesempenhoIndividual;
import br.com.amil.kart.DTO.Piloto;
import br.com.amil.kart.DTO.Volta;
import br.com.amil.kart.model.OutPutModel;
import br.com.amil.kart.utils.DateUtils;

/**
 * @author marcos
 *
 */
public class OutPutModelTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void gerarOutPut () throws Exception{

		OutPutModel outPutModel = new OutPutModel();

		DesempenhoIndividual desempenhoIndividual = new DesempenhoIndividual();

		desempenhoIndividual.setDiferencaLider(null);

		Volta volta = new Volta();
		volta.setTempoVolta(DateUtils.gerarDataByMinuto("01:12.445"));

		desempenhoIndividual.setMelhorVolta(volta);

		Piloto piloto = new Piloto();

		piloto.setCodigoPiloto("99");
		piloto.setNomePiloto("H.CASTRO");
		desempenhoIndividual.setPiloto(piloto);

		desempenhoIndividual.setPosicaoChegada("1º");
		desempenhoIndividual.setProvaConcluida(true);
		desempenhoIndividual.setTempoToltalProva(DateUtils.gerarDataByMinuto("01:12.455"));
		desempenhoIndividual.setVelocidadeMedia(44.30);

		Corrida corrida = new Corrida();

		corrida.getListaDesempenhoIndividual().add(desempenhoIndividual);
		corrida.setDesempenhoMelhorVoltaCorrida(desempenhoIndividual);
		
		assertNotSame("",outPutModel.gerarOutPut(corrida));
		
	}
	
	
	@Test
	public void gerarOutPutNull () throws Exception{

		thrown.expect(Exception.class);
		thrown.expectMessage("Corrida vazia");
		
		OutPutModel outPutModel = new OutPutModel();

		Corrida corrida = null;		
		outPutModel.gerarOutPut(corrida);	
	}
	
	@Test
	public void gerarOutPutListaDesempenhoEmpty () throws Exception{

		thrown.expect(Exception.class);
		thrown.expectMessage("Lista de desempenho individual vazia");
		
		OutPutModel outPutModel = new OutPutModel();

		Corrida corrida = new Corrida();		
		outPutModel.gerarOutPut(corrida);	
	}
	
	
	
}