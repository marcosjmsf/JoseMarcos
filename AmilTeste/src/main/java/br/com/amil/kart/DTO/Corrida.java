/**
 * 
 */
package br.com.amil.kart.DTO;

import java.util.ArrayList;
import java.util.List;

/**
 * @author marcos
 *
 */
public class Corrida {

	private List<DesempenhoIndividual> listaDesempenhoIndividual;
	private DesempenhoIndividual desempenhoMelhorVoltaCorrida;

	
	public List<DesempenhoIndividual> getListaDesempenhoIndividual() {
		if(this.listaDesempenhoIndividual == null)
			this.listaDesempenhoIndividual = new ArrayList<DesempenhoIndividual>();
		
		return listaDesempenhoIndividual;
	}
	public void setListaDesempenhoIndividual(List<DesempenhoIndividual> listaDesempenhoIndividual) {
		this.listaDesempenhoIndividual = listaDesempenhoIndividual;
	}
	public DesempenhoIndividual getDesempenhoMelhorVoltaCorrida() {
		return desempenhoMelhorVoltaCorrida;
	}
	public void setDesempenhoMelhorVoltaCorrida(DesempenhoIndividual desempenhoMelhorVoltaCorrida) {
		this.desempenhoMelhorVoltaCorrida = desempenhoMelhorVoltaCorrida;
	}
	
	
}


