package estado;

import conexao.ConexaoOracle;
import java.util.ArrayList;

/**
 *
 * @author Gleydson Israel
 */
public class DaoEstado extends ConexaoOracle {

    public boolean insertEstado(ModelEstado pModelEstado) {
        try {
            this.conectar();
            String sql;
            sql = String.format(
                    "INSERT INTO estado ("
                    + "idpais, "
                    + "sigla, "
                    + "nome, "
                    + "codibge "
                    + ") VALUES ("
                    + "'%s', "
                    + "'%S', "
                    + "'%s', "
                    + "%s "
                    + ")",
                    pModelEstado.getIdPais(),
                    pModelEstado.getSigla(),
                    pModelEstado.getNome(),
                    pModelEstado.getCodIbge());
            return this.executarSQL(sql);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }
    }

    public int ultimoRegistro(ModelEstado pModelEstado) {
        try {
            int ultimoRegistro = 0;
            this.conectar();
            String sql;
            sql = "SELECT MAX(idestado) "
                    + "FROM estado";
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

    public boolean editEstado(ModelEstado pModelEstado) {
        try {
            this.conectar();
            String sql;
            sql = String.format(
                    "UPDATE estado SET "
                    + "sigla = '%S', "
                    + "nome = '%s', "
                    + "codibge = '%s', "
                    + "dataalteracao = SYSDATE "
                    + "WHERE idestado = %s",
                    pModelEstado.getSigla(),
                    pModelEstado.getNome(),
                    pModelEstado.getCodIbge(),
                    pModelEstado.getIdEstado());
            return this.executarSQL(sql);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }
    }

    public boolean deleteEstado(ModelEstado pModelEstado) {
        try {
            this.conectar();
            String sql;
            sql = String.format(
                    "DELETE "
                    + "FROM estado "
                    + "WHERE idestado = %s",
                    pModelEstado.getIdEstado());

            return this.executarSQL(sql);
        } catch (Exception e) {
            return false;
        } finally {
            this.fecharConexao();
        }
    }

    public ArrayList<ModelEstado> getListaEstado() {
        ArrayList<ModelEstado> listaModelEstado = new ArrayList();
        ModelEstado modelEstado = new ModelEstado();
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
                    + "e.dataalteracao "
                    + "FROM estado e JOIN pais p ON (e.idpais = p.idpais) "
                    + "ORDER BY "
                    + "e.idestado"
            );

            while (this.getResultSet().next()) {
                modelEstado = new ModelEstado();
                modelEstado.setIdEstado(this.getResultSet().getInt(1));
                modelEstado.setIdPais(this.getResultSet().getInt(2));
                modelEstado.setSigla(this.getResultSet().getString(3));
                modelEstado.setNome(this.getResultSet().getString(4));
                modelEstado.setCodIbge(this.getResultSet().getInt(5));
                modelEstado.setDataInclusao(this.getResultSet().getTimestamp(6));
                modelEstado.setDataAlteracao(this.getResultSet().getTimestamp(7));
                listaModelEstado.add(modelEstado);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listaModelEstado;
    }
}
