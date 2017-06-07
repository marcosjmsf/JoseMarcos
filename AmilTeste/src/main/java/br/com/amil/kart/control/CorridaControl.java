package br.com.amil.kart.control;

import java.util.Collections;
import java.util.List;

import br.com.amil.kart.DTO.Corrida;
import br.com.amil.kart.DTO.DesempenhoIndividual;
import br.com.amil.kart.model.DesempenhoIndividualModel;
import br.com.amil.kart.model.GeraDadoModel;
import br.com.amil.kart.model.OutPutModel;

public class CorridaControl {

	public void processaLog (String caminho) throws Exception{

		OutPutModel outPutModel = new OutPutModel(); 
		DesempenhoIndividualModel desempenhoIndividualModel = new DesempenhoIndividualModel();
		GeraDadoModel geraDado= new GeraDadoModel();

		Corrida corrida = new Corrida();

		if(caminho != null && !caminho.equals("")){

			List<DesempenhoIndividual> listaDesempenho = geraDado.gerarDado(caminho);

			if(listaDesempenho != null && !listaDesempenho.isEmpty()){

				Collections.sort(listaDesempenho);
				desempenhoIndividualModel.diferencaLider(listaDesempenho);
				desempenhoIndividualModel.preencherPosicao(listaDesempenho);
				corrida.setListaDesempenhoIndividual(listaDesempenho);

				DesempenhoIndividual desempenhoMelhorVoltaCorrida = desempenhoIndividualModel.definirMelhorVoltaCorrida(listaDesempenho);
				corrida.setDesempenhoMelhorVoltaCorrida(desempenhoMelhorVoltaCorrida);

				System.out.println(outPutModel.gerarOutPut(corrida));

			}else{

				throw new Exception("Nenhum dado foi gerado.");
			}

		}else{
			throw new Exception("Caminho nao informado");
		}
	}
}
