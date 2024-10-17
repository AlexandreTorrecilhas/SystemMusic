package com.mycompany.connectionfactory;

    import com.mycompany.user.DadosLogin;

    import java.sql.DriverManager;
    import java.sql.Connection;
    import java.sql.SQLException;
    import java.sql.PreparedStatement;
    import java.sql.ResultSet;
    import javax.swing.JOptionPane;

public class ConnectionFactory {
    
    private final String DB_URL = "jdbc:mysql://localhost:3306/music_project";
    private String senha;
    
    DadosLogin dadosLogin;
    
    public ConnectionFactory(DadosLogin dadosLogin){
        this.dadosLogin = dadosLogin;
    }
    
    public Connection getConexao(){
               
        try{
            
            this.senha = new String(dadosLogin.senha());
            
            Connection conn = DriverManager.getConnection(DB_URL, this.dadosLogin.login(), this.senha);
            return conn;
          
        }catch(SQLException e){
            throw new RuntimeException(e);
        }finally{
            this.senha = null;
        }
        
    }
    
}
