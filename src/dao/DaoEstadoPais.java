/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import conexao.ConexaoOracle;
import java.util.ArrayList;
import model.ModelEstadoPais;
import estado.ModelEstado;
import pais.ModelPais;


/**
 *
 * @author gleyd_000
 */
public class DaoEstadoPais extends ConexaoOracle {
    
    
    public DaoEstadoPais() {}
    
    public ArrayList<ModelEstadoPais> getListaEstadoPais() {
        ArrayList<ModelEstadoPais> listaModelEstadoPais = new ArrayList();
        ModelEstadoPais modelEstadoPais = new ModelEstadoPais();
        ModelEstado modelEstado = new ModelEstado();
        ModelPais modelPais = new ModelPais();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "e.idestado, "
                    + "e.idpais, "
                    + "e.sigla, "
                    + "e.nome, "
                    + "e.codibge, "
                    + "e.datainclusao, "
                    + "e.dataalteracao, "
                    + "p.nome, "
                    + "p.codbacen, "
                    + "p.datainclusao, "
                    + "p.dataalteracao "
                    + "FROM estado e JOIN pais p ON (e.idpais = p.idpais) "
                    + "ORDER BY "
                    + "e.idpais, "
                    + "e.idestado"
            );
            
            while (this.getResultSet().next()) {
                modelEstado = new ModelEstado();
                modelPais = new ModelPais();
                modelEstadoPais = new ModelEstadoPais();

                modelEstado.setIdEstado(this.getResultSet().getInt(1));
                modelEstado.setIdPais(this.getResultSet().getInt(2));
                modelEstado.setSigla(this.getResultSet().getString(3));
                modelEstado.setNome(this.getResultSet().getString(4));
                modelEstado.setCodIbge(this.getResultSet().getInt(5));
                modelEstado.setDataInclusao(this.getResultSet().getTimestamp(6));
                modelEstado.setDataAlteracao(this.getResultSet().getTimestamp(7));
                
                modelPais.setIdPais(this.getResultSet().getInt(2));
                modelPais.setNome(this.getResultSet().getString(8));
                modelPais.setCodBacen(this.getResultSet().getString(9));
                modelPais.setDataInclusao(this.getResultSet().getTimestamp(10));
                modelPais.setDataAlteracao(this.getResultSet().getTimestamp(11));
                
                modelEstadoPais.setModelEstado(modelEstado);
                modelEstadoPais.setModelPais(modelPais);

                listaModelEstadoPais.add(modelEstadoPais);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listaModelEstadoPais;
    }
}
