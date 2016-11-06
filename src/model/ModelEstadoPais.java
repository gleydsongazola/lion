/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import estado.ModelEstado;
import pais.ModelPais;

/**
 *
 * @author gleyd_000
 */
public class ModelEstadoPais {
    
    private ModelEstado modelEstado;
    private ModelPais modelPais;
    
    public ModelEstadoPais() {}
    
    public ModelEstado getModelEstado() {
        return this.modelEstado;
    }
    
    public void setModelEstado (ModelEstado pModelEstado) {
        this.modelEstado = pModelEstado;
    }
    
    public ModelPais getModelPais() {
        return this.modelPais;
    }
    
    public void setModelPais (ModelPais pModelPais) {
        this.modelPais = pModelPais;
    }

    @Override
    public String toString(){
        return "ModelCidadeEstado {" + 
                "::modelEstado = " + this.modelEstado + 
                "::modelPais = " + this.modelPais + 
                "}";
    }
}
