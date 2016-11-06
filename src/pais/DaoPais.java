package pais;

import conexao.ConexaoOracle;
import java.util.ArrayList;

/**
 *
 * @author Gleydson Israel
 */
public class DaoPais extends ConexaoOracle {

    public boolean insertPais(ModelPais pModelPais) {
        try {
            this.conectar();
            String sql;
            sql = String.format(
                    "INSERT INTO pais ("
                    + "nome, "
                    + "codbacen "
                    + ") VALUES ("
                    + "'%s', "
                    + "'%s' "
                    + ")",
                    pModelPais.getNome(),
                    pModelPais.getCodBacen());
            return this.executarSQL(sql);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }
    }

    public int ultimoRegistro(ModelPais pModelPais) {
        try {
            int ultimoRegistro = 0;
            this.conectar();
            String sql;
            sql = "SELECT MAX(idpais) "
                    + "FROM pais";
            executarSQL(sql);
            while (this.getResultSet().next()) {
                ultimoRegistro = this.getResultSet().getInt(1);
            }
            return ultimoRegistro;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        } finally {
            this.fecharConexao();
        }
    }

    public boolean editPais(ModelPais pModelPais) {
        try {
            this.conectar();
            String sql;
            sql = String.format(
                    "UPDATE pais SET "
                    + "nome = '%s', "
                    + "codbacen = '%s', "
                    + "dataalteracao = SYSDATE "
                    + "WHERE idpais = %s",
                    pModelPais.getNome(),
                    pModelPais.getCodBacen(),
                    pModelPais.getIdPais());
            return this.executarSQL(sql);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }
    }

    public boolean deletePais(ModelPais pModelPais) {
        try {
            this.conectar();
            String sql;
            sql = String.format(
                    "DELETE "
                    + "FROM pais "
                    + "WHERE idpais = %s",
                    pModelPais.getIdPais());
            
            return this.executarSQL(sql);
        } catch (Exception e) {
            return false;
        } finally {
            this.fecharConexao();
        }
    }

    public ArrayList<ModelPais> getListaPais() {
        ArrayList<ModelPais> listaModelPais = new ArrayList();
        ModelPais modelPais = new ModelPais();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "idpais, "
                    + "nome, "
                    + "codbacen, "
                    + "datainclusao, "
                    + "dataalteracao "
                    + "FROM "
                    + "pais "
                    + "ORDER BY "
                    + "idpais"
            );

            while (this.getResultSet().next()) {
                modelPais = new ModelPais();
                modelPais.setIdPais(this.getResultSet().getInt(1));
                modelPais.setNome(this.getResultSet().getString(2));
                modelPais.setCodBacen(this.getResultSet().getString(3));
                modelPais.setDataInclusao(this.getResultSet().getTimestamp(4));
                modelPais.setDataAlteracao(this.getResultSet().getTimestamp(5));
                listaModelPais.add(modelPais);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listaModelPais;
    }
}
