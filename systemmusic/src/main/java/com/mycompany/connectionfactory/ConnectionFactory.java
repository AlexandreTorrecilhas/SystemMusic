package com.mycompany.connectionfactory;

    import java.sql.DriverManager;
    import java.sql.Connection;
    import java.sql.SQLException;
    import java.sql.PreparedStatement;
    import java.sql.ResultSet;

public class ConnectionFactory {
    
    final String DB_URL = "jdbc:mysql://localhost:3306/music_project";
    
    String login = " ";
    String senha = " ";
    
    public ConnectionFactory(String login, String senha){
        this.login = login;
        this.senha = senha;
    }
    
    public Connection getConexao(){
        
        try{
            Connection conn = DriverManager.getConnection(DB_URL, this.login, this.senha);
            return conn;
          
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
        
    }
    
}
