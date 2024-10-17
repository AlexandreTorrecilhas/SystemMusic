package com.mycompany.telalogin;

    import com.mycompany.user.DadosLogin;
    import com.mycompany.connectionfactory.ConnectionFactory;

    import java.sql.Connection;
    import java.sql.SQLException;

public class GerenciadorDeVisibilidade {
    
    private DadosLogin dadosLogin;
    private Connection conn;
    private ConnectionFactory connectionFactory;
    
    public GerenciadorDeVisibilidade(DadosLogin dadosLogin){
        this.dadosLogin = dadosLogin;
        this.connectionFactory = new ConnectionFactory(dadosLogin);
    }
    
    public boolean definiVisibilidade(){
        
        try{
            conn = connectionFactory.getConexao();
            
            if(!conn.isClosed()){
                return true;
            }
            else{
                return false;
            }
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
    
}
