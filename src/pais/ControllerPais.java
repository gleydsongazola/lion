package pais;

import java.util.ArrayList;

/**
 *
 * @author Gleydson Israel
 */
public class ControllerPais {
    
    private DaoPais daoPais = new DaoPais();

    public boolean insertPais(ModelPais pModelPais){
        return this.daoPais.insertPais(pModelPais);
    }

    public boolean editPais(ModelPais pModelPais){
        return this.daoPais.editPais(pModelPais);
    }

    public boolean deletePais(ModelPais pModelPais){
        return this.daoPais.deletePais(pModelPais);
    }

    public int ultimoRegistro(ModelPais pModelPais){
        return this.daoPais.ultimoRegistro(pModelPais);
    }

    public ArrayList<ModelPais> getListaPais(){
        return this.daoPais.getListaPais();
    }
}
