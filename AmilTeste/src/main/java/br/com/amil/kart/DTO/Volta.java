/**
 * 
 */
package br.com.amil.kart.DTO;

import java.util.Date;

/**
 * @author marcos
 *
 */
public class Volta implements Comparable<Volta>{

	private Date horaFimVolta;
	private int numeroVolta;
	private Date tempoVolta;
	private double velocidadeMediaVolta;
	
	

	public int getNumeroVolta() {
		return numeroVolta;
	}
	public void setNumeroVolta(int numeroVolta) {
		this.numeroVolta = numeroVolta;
	}

	public Date getTempoVolta() {
		return tempoVolta;
	}
	public void setTempoVolta(Date tempoVolta) {
		this.tempoVolta = tempoVolta;
	}
	public Date getHoraFimVolta() {
		return horaFimVolta;
	}
	public void setHoraFimVolta(Date horaFimVolta) {
		this.horaFimVolta = horaFimVolta;
	}
	public double getVelocidadeMediaVolta() {
		return velocidadeMediaVolta;
	}
	public void setVelocidadeMediaVolta(double velocidadeMediaVolta) {
		this.velocidadeMediaVolta = velocidadeMediaVolta;
	}
	
	public int compareTo(Volta o) {

		if(this.numeroVolta > o.getNumeroVolta()){
			return -1;
		}
		if(this.numeroVolta > o.getNumeroVolta()){
			return 1;
		}
		return 0;
	}
	
}
