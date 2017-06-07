/**
 * 
 */
package br.com.amil.kart.DTO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author marcos
 *
 */
public class DesempenhoIndividual implements Comparable<DesempenhoIndividual>{
	
	private Piloto piloto;
	private List<Volta> voltas;
	private String posicaoChegada;
	private Date tempoToltalProva;
	private boolean provaConcluida;
	private Volta melhorVolta;
	private double velocidadeMedia;
	private String diferencaLider;
	
	public Piloto getPiloto() {
		return piloto;
	}
	public void setPiloto(Piloto piloto) {
		this.piloto = piloto;
	}
	public List<Volta> getVoltas() {
		if(this.voltas == null)
			this.voltas = new ArrayList<Volta>();		
		return voltas;
	}
	public void setVoltas(List<Volta> voltas) {
		this.voltas = voltas;
	}
	public boolean isProvaConcluida() {
		return provaConcluida;
	}
	public void setProvaConcluida(boolean provaConcluida) {
		this.provaConcluida = provaConcluida;
	}
	public Date getTempoToltalProva() {
		return tempoToltalProva;
	}
	public void setTempoToltalProva(Date tempoToltalProva) {
		this.tempoToltalProva = tempoToltalProva;
	}
	public Volta getMelhorVolta() {
		return melhorVolta;
	}
	public void setMelhorVolta(Volta melhorVolta) {
		this.melhorVolta = melhorVolta;
	}
	
	public int compareTo(DesempenhoIndividual o) {

		if(!this.provaConcluida && o.provaConcluida){
			return 1;
		}
		if(this.tempoToltalProva.after(o.tempoToltalProva)){
			return 1;
		}
		if(this.tempoToltalProva.before(o.tempoToltalProva)){
			return -1;
		}
		return 0;
	}
	public double getVelocidadeMedia() {
		return velocidadeMedia;
	}
	public void setVelocidadeMedia(double velocidadeMedia) {
		this.velocidadeMedia = velocidadeMedia;
	}
	public String getDiferencaLider() {
		return diferencaLider;
	}
	public void setDiferencaLider(String diferencaLider) {
		this.diferencaLider = diferencaLider;
	}
	public String getPosicaoChegada() {
		return posicaoChegada;
	}
	public void setPosicaoChegada(String posicaoChegada) {
		this.posicaoChegada = posicaoChegada;
	}
}
