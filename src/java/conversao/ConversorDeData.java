/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package conversao;

import java.util.Calendar;
import java.util.Date;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author viviano
 */
@FacesConverter("conversao.ConversorDeData")
public class ConversorDeData implements Converter{
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if(!ValidaDatas.validaStringData(value)) throw new ConverterException();
        Calendar calendar = Calendar.getInstance();
        calendar.set(new Integer(value.substring(6, 10)), (new Integer(value.substring(3, 5)) -1), new Integer(value.substring(0, 2)));
        return new Date(calendar.getTimeInMillis());
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        Calendar calendar = Calendar.getInstance();
        Date data = (Date) value;
        calendar.setTime(data);
        return calendar.get(Calendar.DAY_OF_MONTH) + "/" + (calendar.get(Calendar.MONTH) + 1)+ "/" + calendar.get(Calendar.YEAR);
    }
    
}
