/**
 * 
 */
package br.com.amil.kart.model;

import br.com.amil.kart.DTO.Corrida;
import br.com.amil.kart.DTO.DesempenhoIndividual;
import br.com.amil.kart.identificador.Cabecalho;
import br.com.amil.kart.utils.DateUtils;
import br.com.amil.kart.utils.FileUtils;

/**
 * @author marcos
 *
 */
public class OutPutModel {

	public String gerarOutPut (Corrida corrida) throws Exception{

		StringBuilder builder = new StringBuilder();

		if(corrida != null){

			if(corrida.getListaDesempenhoIndividual() != null && !corrida.getListaDesempenhoIndividual().isEmpty()){				
				builder.append(gerarCabecalho());
				builder.append("\n");
				
				for (DesempenhoIndividual desempenhoIndividual : corrida.getListaDesempenhoIndividual()) {

					builder.append(this.gerarItem(desempenhoIndividual.getPosicaoChegada(),Cabecalho.POSICAO));
					builder.append(this.gerarItem(desempenhoIndividual.getPiloto().getCodigoPiloto(),Cabecalho.CODIGO_PILOTO));							
					builder.append(this.gerarItem(desempenhoIndividual.getPiloto().getNomePiloto(), Cabecalho.NOME_DO_PILOTO));
					builder.append(this.gerarItem(String.valueOf(desempenhoIndividual.getVoltas().size()), Cabecalho.VOLTAS_COMPLETAS));
					builder.append(this.gerarItem(DateUtils.minutosFormatado(desempenhoIndividual.getMelhorVolta().getTempoVolta()), Cabecalho.MELHOR_VOLTA));
					builder.append(this.gerarItem(String.valueOf(desempenhoIndividual.getVelocidadeMedia()), Cabecalho.VELOCIDADE_MEDIA));
					builder.append(this.gerarItem(DateUtils.minutosFormatado(desempenhoIndividual.getTempoToltalProva()), Cabecalho.TEMPO_TOTAL_PROVA));
					if(desempenhoIndividual.getDiferencaLider() == null){			
						builder.append(this.gerarItem("--.---", Cabecalho.DIFERENCA_LIDER));
					}else{
						builder.append(this.gerarItem(desempenhoIndividual.getDiferencaLider(), Cabecalho.DIFERENCA_LIDER));
					}
					builder.append("\n");
				}
			}else{
				
				throw new Exception("Lista de desempenho individual vazia");				
			}

			if(corrida.getDesempenhoMelhorVoltaCorrida() != null){
				builder.append(gerarCabecalhoMelhorVolta());
				builder.append("\n");
				builder.append(this.gerarItem(corrida.getDesempenhoMelhorVoltaCorrida().getPiloto().getCodigoPiloto(),Cabecalho.CODIGO_PILOTO));							
				builder.append(this.gerarItem(corrida.getDesempenhoMelhorVoltaCorrida().getPiloto().getNomePiloto(), Cabecalho.NOME_DO_PILOTO));
				builder.append(this.gerarItem(DateUtils.minutosFormatado(corrida.getDesempenhoMelhorVoltaCorrida().getMelhorVolta().getTempoVolta()), Cabecalho.TEMPO_VOLTA));
				builder.append(this.gerarItem(String.valueOf(corrida.getDesempenhoMelhorVoltaCorrida().getMelhorVolta().getVelocidadeMediaVolta()),
						Cabecalho.VELOCIDADE_MEDIA));
				builder.append(this.gerarItem(String.valueOf(corrida.getDesempenhoMelhorVoltaCorrida().getMelhorVolta().getNumeroVolta()), Cabecalho.NUMERO_VOLTA));
				builder.append("\n");
			}
		}else{
			throw new Exception("Corrida vazia");
		}

		return builder.toString();
	}

	private String gerarCabecalho(){

		StringBuilder builder = new StringBuilder();
		FileUtils fileUtils = new FileUtils();
		String separacao = fileUtils.completaColuna(5);

		builder.append(Cabecalho.POSICAO.toString()+separacao);
		builder.append(Cabecalho.CODIGO_PILOTO.toString()+separacao);
		builder.append(Cabecalho.NOME_DO_PILOTO.toString()+separacao);
		builder.append(Cabecalho.VOLTAS_COMPLETAS.toString()+separacao);
		builder.append(Cabecalho.MELHOR_VOLTA.toString()+separacao);
		builder.append(Cabecalho.VELOCIDADE_MEDIA.toString()+separacao);
		builder.append(Cabecalho.TEMPO_TOTAL_PROVA.toString()+separacao);		
		builder.append(Cabecalho.DIFERENCA_LIDER.toString()+separacao);

		return builder.toString();
	}


	private String gerarCabecalhoMelhorVolta(){

		StringBuilder builder = new StringBuilder();
		FileUtils fileUtils = new FileUtils();
		String separacao = fileUtils.completaColuna(5);

		builder.append(fileUtils.criaLinha(144));
		builder.append("\n");
		builder.append("MELHOR VOLTA DA CORRIDA \n");
		builder.append(Cabecalho.CODIGO_PILOTO.toString()+separacao);
		builder.append(Cabecalho.NOME_DO_PILOTO.toString()+separacao);
		builder.append(Cabecalho.TEMPO_VOLTA.toString()+separacao);
		builder.append(Cabecalho.VELOCIDADE_MEDIA.toString()+separacao);
		builder.append(Cabecalho.NUMERO_VOLTA.toString()+separacao);

		return builder.toString();
	}

	private String gerarItem(String dado,Cabecalho cabecalho){

		FileUtils fileUtils = new FileUtils();

		String separacao = fileUtils.completaColuna(5);

		StringBuilder retorno = new StringBuilder(); 

		retorno.append(dado + fileUtils.completaColuna(cabecalho.toString().length() - 
				dado.length()) + separacao);

		return retorno.toString();
	}

}
