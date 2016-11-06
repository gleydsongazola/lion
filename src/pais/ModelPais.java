package pais;

import java.sql.Timestamp;

/**
 *
 * @author Gleydson Israel
 */
public class ModelPais {

    int idPais;
    String nome;
    String codBacen;
    Timestamp dataInclusao;
    Timestamp dataAlteracao;

    public ModelPais() {
    }

    public int getIdPais(){
        return this.idPais;
    }
    
    public void setIdPais(int pIdPais) {
        this.idPais = pIdPais;
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public void setNome(String pNome) {
        this.nome = pNome;
    }

    public String getCodBacen(){
        return this.codBacen;
    }
    
    public void setCodBacen(String pCodBacen) {
        this.codBacen = pCodBacen;
    }

    public Timestamp getDataInclusao(){
        return this.dataInclusao;
    }
    
    public void setDataInclusao(Timestamp pDataInclusao) {
        this.dataInclusao = pDataInclusao;
    }

    public Timestamp getDataAlteracao(){
        return this.dataAlteracao;
    }
    
    public void setDataAlteracao(Timestamp pDataAlteracao) {
        this.dataAlteracao = pDataAlteracao;
    }

    @Override
    public String toString() {
        return "ModelPais {" + 
                "::idPais = " + this.idPais + 
                "::nome = " + this.nome + 
                "::codBacen = " + this.codBacen +
                "::dataInclusao = " + this.dataInclusao +
                "::dataAlteracao = " + this.dataAlteracao +
                "}";
    }
}
