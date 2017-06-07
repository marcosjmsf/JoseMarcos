/**
 * 
 */
package br.com.amil.kart.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import br.com.amil.kart.DTO.CamposMensagem;
import br.com.amil.kart.DTO.DesempenhoIndividual;
import br.com.amil.kart.DTO.Piloto;
import br.com.amil.kart.DTO.Volta;
import br.com.amil.kart.utils.DateUtils;

/**
 * @author marcos
 *
 */
public class DesempenhoIndividualModel {


	public DesempenhoIndividual createDesempenhoIndividual (List<CamposMensagem> listCamposMensagem) throws Exception{

		DesempenhoIndividual desempenhoIndividual = new DesempenhoIndividual();

		if(listCamposMensagem != null &&
				listCamposMensagem.size() > 0){

			VoltaModel voltaModel = new VoltaModel();
			PilotoModel pilotoModel = new PilotoModel();

			Date tempoTotal = null;
			double velocidadeMedia = 0;

			Piloto piloto = pilotoModel.createPiloto(listCamposMensagem.get(0));
			desempenhoIndividual.setPiloto(piloto);

			for (CamposMensagem camposMensagem : listCamposMensagem) {

				Volta volta = voltaModel.createVolta(camposMensagem);

				desempenhoIndividual.getVoltas().add(volta);

				tempoTotal = DateUtils.somaDateByMinuto(tempoTotal,camposMensagem.getTempoVolta());

				velocidadeMedia += Double.parseDouble(camposMensagem.getVelocidadeMedia().replace(",", "."));
			}

			desempenhoIndividual.setTempoToltalProva(tempoTotal);

			DateUtils.diferencaEntreDatas(desempenhoIndividual.getVoltas().get(0).getHoraFimVolta(), desempenhoIndividual.getVoltas().get(1).getHoraFimVolta());

			BigDecimal calculo = new BigDecimal(String.valueOf(velocidadeMedia)).divide(new BigDecimal(listCamposMensagem.size()),RoundingMode.DOWN);

			desempenhoIndividual.setVelocidadeMedia(calculo.setScale(2, RoundingMode.DOWN).doubleValue());

			Volta melhorVolta = voltaModel.definirMelhorVolta(desempenhoIndividual.getVoltas());

			desempenhoIndividual.setMelhorVolta(melhorVolta);

			if(listCamposMensagem.size() >= 4){
				desempenhoIndividual.setProvaConcluida(true);
			}else{
				desempenhoIndividual.setProvaConcluida(false);
			}			
		}else{

			throw new Exception("Lista de CamposMensagem esta vazia");
		}

		Collections.sort(desempenhoIndividual.getVoltas());

		return desempenhoIndividual;
	}

	public DesempenhoIndividual definirMelhorVoltaCorrida (List<DesempenhoIndividual> listDesempenhoIndividual){		

		DesempenhoIndividual desempenhoIndividualAux = null;

		if(listDesempenhoIndividual != null){
			for (DesempenhoIndividual desempenhoIndividual : listDesempenhoIndividual) {

				if(desempenhoIndividualAux == null){

					desempenhoIndividualAux = desempenhoIndividual;
				}else{
					if(desempenhoIndividualAux.getMelhorVolta().getTempoVolta().after(desempenhoIndividual.getMelhorVolta().getTempoVolta())){
						desempenhoIndividualAux = desempenhoIndividual;
					}								
				}			
			}
		}
		return desempenhoIndividualAux;
	}

	public void diferencaLider (List<DesempenhoIndividual> listDesempenhoIndividual) throws Exception{

		DesempenhoIndividual aux = null;

		if(listDesempenhoIndividual != null && !listDesempenhoIndividual.isEmpty()){

			for (DesempenhoIndividual desempenhoIndividual : listDesempenhoIndividual) {

				if(aux == null){

					aux = desempenhoIndividual;
				}else{

					if(desempenhoIndividual.isProvaConcluida()){
						desempenhoIndividual.setDiferencaLider(DateUtils.diferencaEntreDatas
								(aux.getVoltas().get(0).getHoraFimVolta(),
										desempenhoIndividual.getVoltas().get(0).getHoraFimVolta()));
					}else{
						desempenhoIndividual.setDiferencaLider("Parou na volta "+desempenhoIndividual.getVoltas().size());
					}
				}

			}
		}else{

			throw new Exception("Lista de desempenho vazia");			
		}
	}

	public void preencherPosicao(List<DesempenhoIndividual> listDesempenhoIndividual){

		if(listDesempenhoIndividual != null && !listDesempenhoIndividual.isEmpty()){

			int i = 0;

			for (DesempenhoIndividual desempenhoIndividual : listDesempenhoIndividual) {
				i++;			
				if(desempenhoIndividual.isProvaConcluida()){
					desempenhoIndividual.setPosicaoChegada(i+"º");
				}else{
					desempenhoIndividual.setPosicaoChegada("--");
				}
			}

		}

	}


}
