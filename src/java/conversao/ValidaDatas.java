/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package conversao;

import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author viviano
 */
public class ValidaDatas {
    
    public static Boolean validaStringData(String data){
        Boolean resposta = true;
        String[] split;
        split = data.split("/");
        if(split.length != 3){
            resposta = false;
        }
        
        if((split[0].toCharArray().length != 2) || (split[1].toCharArray().length != 2) || (split[2].toCharArray().length != 4)){
            resposta = false;
        }
        Integer dia;
        Integer mes;
        Integer ano;
      try{
        dia = new Integer(split[0]);
        mes = new Integer(split[1]);
        ano = new Integer(split[2]);
        
        if( ((dia <= 0) || (dia > getMaximoDias(mes, ano))) || ((mes <= 0) || (mes > 12)) || (ano <= 0) ){
            resposta = false;
        }
      }catch(Exception e){
          resposta = false;
      }
        return resposta;
        
    }
    
  public static Boolean RetornarBisexto (Integer ano){
      return new GregorianCalendar().isLeapYear(ano);
  }
  
  public static Integer getMaximoDias(Integer mes, Integer ano){
      Integer maximoDias = 0;
      Map<Integer, Integer> meses = new HashMap<Integer, Integer>();
      meses.put(1, 31);
      meses.put(2, 28);
      meses.put(3, 31);
      meses.put(4, 30);
      meses.put(5, 31);
      meses.put(6, 30);
      meses.put(7, 31);
      meses.put(8, 31); 
      meses.put(9, 30);
      meses.put(10,31);
      meses.put(11,30);
      meses.put(12,31);
      maximoDias = meses.get(mes);
      if((RetornarBisexto(ano) == true) && (mes == 2)) {
         maximoDias = maximoDias + 1;
      }
      return maximoDias;
      
  }
  
    public static void main(String[] args) {
//        System.out.println(validaStringData("17/12/1992"));
        System.out.println(convertDataSQLString(new Date(Calendar.getInstance().getTimeInMillis())));
    }
    
    public static String convertDataSQLString(Date data){
        String dat = new String();
        String[] array = data.toString().split("-");
        dat = array[2] + "/" + array[1] + "/" + array[0];
        return dat;
    }
}
