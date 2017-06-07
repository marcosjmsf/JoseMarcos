/**
 * 
 */
package br.com.amil.kart.utils;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author marcos
 *
 */
public class DateUtils {


	public static Date gerarDataByHora(String hora) throws Exception{

		String horaFormato = "hh:mm:ss.SSS";

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(horaFormato);

		Date date = null;

		try{
			date = simpleDateFormat.parse(hora);			

		}catch(Exception e){

			new Exception("Formato de hora errado");
		}


		return date;		
	}

	public static Date gerarDataByMinuto(String minuto) throws Exception{

		String minutoFormato = "mm:ss.SSS";

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(minutoFormato);

		Date date = null;

		try{
			date = simpleDateFormat.parse(minuto);			

		}catch(Exception e){

			new Exception("Formato de minutagem errado");
		}


		return date;		
	}


	public static Date somaDateByMinuto(Date resultado,String minuto) throws Exception{

		if(resultado == null){
			resultado = gerarDataByMinuto(minuto);
		}else{			
			String [] split = minuto.split(":");
			String [] splitFinal = split[1].split("\\.");
			
			int minutoInt = Integer.parseInt(split[0]);
			int segundos = Integer.parseInt(splitFinal[0]);
			int milesimo = Integer.parseInt(splitFinal[1]);
			
			
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(resultado);
			calendar.add(Calendar.MILLISECOND, milesimo);
			calendar.add(Calendar.SECOND, segundos);
			calendar.add(Calendar.MINUTE, minutoInt);
			
			resultado = calendar.getTime();
		}
		return resultado;
	}
	
	public static String diferencaEntreDatas(Date primeiraData, Date segundaData){
		
		BigDecimal primeiraDataMili = new BigDecimal(String.valueOf(primeiraData.getTime()));
		BigDecimal segundaDataMili = new BigDecimal(String.valueOf(segundaData.getTime()));
		BigDecimal diferencaMili = segundaDataMili.subtract(primeiraDataMili);
		
		diferencaMili = diferencaMili.divide(new BigDecimal(1000));
		
		
		return diferencaMili.toString();
		
		
	}

	public static String minutosFormatado(Date date){
	
		SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss.SSS");
		
		return format.format(date);
	}

    


}
