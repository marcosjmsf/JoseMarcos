/**
 * 
 */
package br.com.amil.kart.DTO;

/**
 * @author marcos
 *
 */
public class CamposMensagem implements Comparable<CamposMensagem>{

	private String hora;
	private String codigoPiloto;
	private String nomePiloto;
	private String numeroVolta;
	private String tempoVolta;
	private String velocidadeMedia;
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public String getNomePiloto() {
		return nomePiloto;
	}
	public void setNomePiloto(String nomePiloto) {
		this.nomePiloto = nomePiloto;
	}
	public String getNumeroVolta() {
		return numeroVolta;
	}
	public void setNumeroVolta(String numeroVolta) {
		this.numeroVolta = numeroVolta;
	}
	public String getTempoVolta() {
		return tempoVolta;
	}
	public void setTempoVolta(String tempoVolta) {
		this.tempoVolta = tempoVolta;
	}
	public String getVelocidadeMedia() {
		return velocidadeMedia;
	}
	public void setVelocidadeMedia(String velocidadeMedia) {
		this.velocidadeMedia = velocidadeMedia;
	}	
	public String getCodigoPiloto() {
		return codigoPiloto;
	}
	public void setCodigoPiloto(String codigoPiloto) {
		this.codigoPiloto = codigoPiloto;
	}
	
	public int compareTo(CamposMensagem o) {

		if(Integer.parseInt(this.codigoPiloto) > Integer.parseInt(o.codigoPiloto)){
			return 1;
		}
		if(Integer.parseInt(this.codigoPiloto) < Integer.parseInt(o.codigoPiloto)){
			return -1;
		}
		return 0;
	}
	
	
}
