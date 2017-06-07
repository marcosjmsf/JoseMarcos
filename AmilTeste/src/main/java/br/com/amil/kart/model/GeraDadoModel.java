/**
 * 
 */
package br.com.amil.kart.model;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.amil.kart.DTO.CamposMensagem;
import br.com.amil.kart.DTO.DesempenhoIndividual;

/**
 * @author marcos
 *
 */
public class GeraDadoModel {

		
	public List<DesempenhoIndividual> gerarDado(String caminho){

		List <CamposMensagem>listCamposMensagem = new ArrayList<CamposMensagem>();		
		
		List<DesempenhoIndividual> listDesempenho = new ArrayList<DesempenhoIndividual>();
		
		try { 
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(caminho), "UTF-8"));
	
			while(bufferedReader.ready()){				
				String line = bufferedReader.readLine();								
				listCamposMensagem.add(this.preencheCamposMensagem(line));			
			}

			bufferedReader.close();
			
			if(!listCamposMensagem.isEmpty()){
				Collections.sort(listCamposMensagem);
				listDesempenho = this.analisarDesempenhos(listCamposMensagem);
			}else{
				throw new Exception("Arquivo Vazio");
			}
			
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listDesempenho;
	}
	
	private CamposMensagem preencheCamposMensagem (String line){
		
		CamposMensagem camposMensagem = new CamposMensagem();		
		int aux = 18;
		
		line = line.replace("\t", "");
		line = line.replace(" ", "");

		camposMensagem.setHora(line.substring(0, 12));
		camposMensagem.setCodigoPiloto(line.substring(12, 15));
		
		while(Character.isAlphabetic(line.charAt(aux)) || line.charAt(aux) == '.'){			
			aux++;			
		}
		
		camposMensagem.setNomePiloto(line.substring(16,aux));
		camposMensagem.setNumeroVolta(line.substring(aux,aux+1));
		camposMensagem.setTempoVolta(line.substring(aux+1, aux+9));
		camposMensagem.setVelocidadeMedia(line.substring(aux+9));
		
		return camposMensagem;		
	}
	
	//Esse metodo recebe uma lista de CamposMensagem ordenada pelo codigo do Piloto
	private List<DesempenhoIndividual> analisarDesempenhos(List<CamposMensagem>listCamposMensagem) throws Exception{

		DesempenhoIndividualModel desempenhoIndividualModel = new DesempenhoIndividualModel(); 
		
		int aux = 0;
		
		List<DesempenhoIndividual> listDesempenho = new ArrayList<DesempenhoIndividual>();
		
		List<CamposMensagem> listAux = new ArrayList<CamposMensagem>();
		
		
		while(aux <= listCamposMensagem.size()){
			
			if(aux == 0){
				listAux.add(listCamposMensagem.get(aux));
			}else if(aux == listCamposMensagem.size()){
				listDesempenho.add(desempenhoIndividualModel.createDesempenhoIndividual(listAux));
			}
			else if (listCamposMensagem.get(aux-1).getCodigoPiloto().
					equals(listCamposMensagem.get(aux).getCodigoPiloto())){
				listAux.add(listCamposMensagem.get(aux));
			}else{
				listDesempenho.add(desempenhoIndividualModel.createDesempenhoIndividual(listAux));
				listAux.clear();
				listAux.add(listCamposMensagem.get(aux));
			}
			
			aux++;
		}
		return listDesempenho;
	}

}
