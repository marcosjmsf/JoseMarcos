/**
 * 
 */
package br.com.amil.kart.model;

import java.util.List;

import br.com.amil.kart.DTO.CamposMensagem;
import br.com.amil.kart.DTO.Volta;
import br.com.amil.kart.utils.DateUtils;

/**
 * @author marcos
 *
 */
public class VoltaModel {
	
	
	public Volta definirMelhorVolta(List<Volta> voltas) throws Exception{

		Volta melhorVolta = null;
		
		if(voltas != null){
		
		for (Volta volta : voltas) {
		
			if(melhorVolta == null){
				melhorVolta = volta;
			}else{				
				if(melhorVolta.getTempoVolta().after(volta.getTempoVolta())){
					melhorVolta = volta;
				}				
			}
			
		}
		}else{
			throw new Exception("Lista de voltas nula");
		}
		return melhorVolta;
	}
	
	
	public Volta createVolta (CamposMensagem camposMensagem) throws Exception{
				
		
		Volta volta = new Volta();
		
		if(camposMensagem != null){
			volta.setHoraFimVolta(DateUtils.gerarDataByHora(camposMensagem.getHora()));
			volta.setNumeroVolta(Integer.parseInt(camposMensagem.getNumeroVolta()));
			volta.setTempoVolta(DateUtils.gerarDataByMinuto(camposMensagem.getTempoVolta()));
			volta.setVelocidadeMediaVolta(Double.parseDouble(camposMensagem.getVelocidadeMedia().replace(",", ".")));
		}else{
			throw new Exception("CamposMensagem esta vazio");
		}
		return volta;
	}
	

}
