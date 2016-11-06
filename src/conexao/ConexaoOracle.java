package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Gleydson Israel
 */
public class ConexaoOracle {

    private boolean status = false;
    private Connection con = null;
    private Statement statement;
    private ResultSet resultSet;


    private String servidor = "jdbc:oracle:thin:@localhost:1521:xe";
    private String usuario = "MYBIGSYSTEM";
    private String senha = "Davi0105";
    
    public ConexaoOracle(){}
    
    public ConexaoOracle(String pServidor, String pUsuario, String pSenha){
        this.servidor = pServidor;
        this.usuario = pUsuario;
        this.senha = pSenha;
    }

    public Connection conectar(){
        try {
            //Driver do Oracle
            Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();

            //local do banco, nome do banco, usuario e senha
            con = DriverManager.getConnection(servidor, usuario, senha);

            //se ocorrer tudo bem, ou seja, se conectar a linha a segui é executada
            this.status = true;
        }
        catch(ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
        return this.getCon();
    }

    public boolean fecharConexao(){
       try {
           if((this.getResultSet() != null) && (this.statement != null)){
               this.getResultSet().close();
               this.statement.close();
           }
           this.getCon().close();
           return true;
       } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
       }
       return false;
    }

    public boolean executarSQL(String pSQL) {
        try {
            //createStatement de con para criar o Statement
            this.setStatement(getCon().createStatement());

            // Definido o Statement, executamos a query no banco de dados
            this.setResultSet(getStatement().executeQuery(pSQL));
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    public boolean isStatus() {
        return this.status;
    }

    public Statement getStatement() {
        return statement;
    }

    public ResultSet getResultSet() {
        return resultSet;
    }

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    public void setStatement(Statement statement) {
        this.statement = statement;
    }

    public void setResultSet(ResultSet resultSet) {
        this.resultSet = resultSet;
    }

    public String getServidor() {
        return servidor;
    }

    public void setServidor(String servidor) {
        this.servidor = servidor;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}