package estado;

import java.sql.Timestamp;

/**
 *
 * @author Gleydson Israel
 */
public class ModelEstado {

    int idEstado;
    int idPais;
    String sigla;
    String nome;
    Integer codIbge;
    Timestamp dataInclusao;
    Timestamp dataAlteracao;

    public ModelEstado() {
    }

    public int getIdEstado(){
        return this.idEstado;
    }
    
    public void setIdEstado(int pIdEstado) {
        this.idEstado = pIdEstado;
    }

    public int getIdPais(){
        return this.idPais;
    }
    
    public void setIdPais(int pIdPais) {
        this.idPais = pIdPais;
    }
    
    public String getSigla(){
        return this.sigla;
    }
    
    public void setSigla(String pSigla) {
        this.sigla = pSigla;
    }

    public String getNome(){
        return this.nome;
    }
    
    public void setNome(String pNome) {
        this.nome = pNome;
    }

    public Integer getCodIbge(){
        return this.codIbge;
    }
    
    public void setCodIbge(Integer pCodIbge) {
        this.codIbge = pCodIbge;
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
        return "ModelEstado {" + 
                "::idEstado = " + this.idEstado + 
                "::idPais = " + this.idPais + 
                "::sigla = " + this.sigla + 
                "::nome = " + this.nome + 
                "::codIbge = " + this.codIbge +
                "::dataInclusao = " + this.dataInclusao +
                "::dataAlteracao = " + this.dataAlteracao +
                "}";
    }
}
