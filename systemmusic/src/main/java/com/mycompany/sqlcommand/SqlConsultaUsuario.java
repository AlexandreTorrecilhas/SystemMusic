package com.mycompany.sqlcommand;

    import com.mycompany.connectionfactory.ConnectionFactory;
    import com.mycompany.user.DadosLogin;
    import javax.swing.JOptionPane;

    import java.sql.DriverManager;
    import java.sql.Connection;
    import java.sql.SQLException;
    import java.sql.PreparedStatement;
    import java.sql.ResultSet;

public class SqlConsultaUsuario {
    String login = " ";
    String senha = " ";
    String sql = "SELECT login, user_password FROM student_login " +
            "WHERE login = ? " +
            "AND user_password = ?";
    ResultSet resultSet = null;
    
    
    public SqlConsultaUsuario(DadosLogin dadosLogin){
        this.login = dadosLogin.login();
        this.senha = dadosLogin.senha();
    }
    
    public void consultaUsuario(){
        try{
            ConnectionFactory connectionFactory = new ConnectionFactory(this.login, this.senha);
            Connection conn = connectionFactory.getConexao();
        
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, this.login);
            preparedStatement.setString(2, this.senha);
            
            resultSet = preparedStatement.executeQuery();
            
            if(resultSet.next()){
                 JOptionPane.showMessageDialog(null, "Worked");
            }
            
            
        }catch(SQLException e){
            throw new RuntimeException (e);
        }
    }
}
