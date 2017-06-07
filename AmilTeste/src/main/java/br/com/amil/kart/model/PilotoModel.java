/**
 * 
 */
package br.com.amil.kart.model;

import br.com.amil.kart.DTO.CamposMensagem;
import br.com.amil.kart.DTO.Piloto;

/**
 * @author marcos
 *
 */
public class PilotoModel {


	public Piloto createPiloto (CamposMensagem camposMensagem) throws Exception{

		Piloto piloto = new Piloto();		

		if(camposMensagem != null){

			piloto.setCodigoPiloto(camposMensagem.getCodigoPiloto());
			piloto.setNomePiloto(camposMensagem.getNomePiloto());
		}else{
			throw new Exception("Campos Mensagem nulo");
		}
		return piloto;
	}

}
