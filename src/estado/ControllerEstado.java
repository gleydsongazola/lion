package estado;

import java.util.ArrayList;

/**
 *
 * @author Gleydson Israel
 */
public class ControllerEstado {
    
    private DaoEstado daoEstado = new DaoEstado();

    public boolean insertEstado(ModelEstado pModelEstado){
        return this.daoEstado.insertEstado(pModelEstado);
    }

    public boolean editEstado(ModelEstado pModelEstado){
        return this.daoEstado.editEstado(pModelEstado);
    }

    public boolean deleteEstado(ModelEstado pModelEstado){
        return this.daoEstado.deleteEstado(pModelEstado);
    }

    public int ultimoRegistro(ModelEstado pModelEstado){
        return this.daoEstado.ultimoRegistro(pModelEstado);
    }

    public ArrayList<ModelEstado> getListaEstado(){
        return this.daoEstado.getListaEstado();
    }
}
