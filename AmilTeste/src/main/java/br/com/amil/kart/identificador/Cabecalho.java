/**
 * 
 */
package br.com.amil.kart.identificador;

/**
 * @author marcos
 *
 */
public enum Cabecalho {
	
	POSICAO("Posição"),
	CODIGO_PILOTO("Codigo do Piloto"),
	NOME_DO_PILOTO("Nome do Piloto"),
	VOLTAS_COMPLETAS("Voltas Completas"),
	MELHOR_VOLTA("Melhor Volta"),
	VELOCIDADE_MEDIA("Velocidade Media"),
	TEMPO_TOTAL_PROVA("Tempo Total de Prova"),
	DIFERENCA_LIDER("Diferença Lider"),
	TEMPO_VOLTA("Tempo Volta"),
	NUMERO_VOLTA("Numero Volta");
	
	
	private String value;
	
	private Cabecalho(String value) {
		this.value = value;
	}
	
	public String toString(){
		
		return this.value;
	}
	
}
