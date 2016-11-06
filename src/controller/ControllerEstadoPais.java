package controller;

import java.util.ArrayList;
import dao.DaoEstadoPais;
import model.ModelEstadoPais;

/**
 *
 * @author Gleydson Israel
 */
public class ControllerEstadoPais {
    
    private DaoEstadoPais daoEstadoPais = new DaoEstadoPais();
    
    public ControllerEstadoPais() {}
    
    public ArrayList<ModelEstadoPais> getListaEstadoPais(){
        return this.daoEstadoPais.getListaEstadoPais();
    }
}
