/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author viviano
 */
@ManagedBean(name = "compraBean")
@RequestScoped
public class CompraBean {

    private Integer valor;
    private Date data;
    /**
     * Creates a new instance of CompraBean
     */
    public CompraBean() {
        
        
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
    
    public String parameter(){
        return "index.xhtml";
    }
}
