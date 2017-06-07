/**
 * 
 */
package br.com.amil.kart.utils;

/**
 * @author marcos
 *
 */
public class FileUtils {
	
	public String completaColuna(int quantidade){
		
		StringBuilder complemento =new StringBuilder();
		int i = 0;
		
		while(quantidade > i){
			i++;
			complemento.append(" ");
		}
		
		return complemento.toString();
	}
	
	public String criaLinha(int quantidade){
		
		StringBuilder complemento =new StringBuilder();
		int i = 0;
		
		while(quantidade > i){
			i++;
			complemento.append("-");
		}
		
		return complemento.toString();
	}

}
