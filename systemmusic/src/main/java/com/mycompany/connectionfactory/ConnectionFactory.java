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
            
            String sql = "SELECT login, user_password FROM student_login " +
                    "WHERE login = ? " +
                    "AND user_password = ?;";
            
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, this.login);
            preparedStatement.setString(2, this.senha);
            
            ResultSet resultSet = preparedStatement.executeQuery();
            
            if(resultSet.next()){
                return conn;
            }
            else{
                throw new RuntimeException("Não existe um usuario com esses dados");
            }
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
        
    }
    
}
