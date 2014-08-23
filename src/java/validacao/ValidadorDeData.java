/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package validacao;

import conversao.ValidaDatas;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author viviano
 */
@FacesValidator("validacao.ValidadorDeData")
public class ValidadorDeData implements Validator{

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        if(!ValidaDatas.validaStringData((String) value)) throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Data Inválida!", "Informe uma data que obedeça ao padrão : dd/mm/yyyy"));
    }
    
}
