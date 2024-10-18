package com.mycompany.connectionfactory;

    import com.mycompany.user.DadosLogin;
    import org.mindrot.jbcrypt.BCrypt;

    import java.sql.DriverManager;
    import java.sql.Connection;
    import java.sql.SQLException;
    import java.sql.PreparedStatement;
    import java.sql.ResultSet;
    import javax.swing.JOptionPane;

public class ConnectionFactory {
    
    public ConnectionFactory(){};
    final String DB_URL = "jdbc:mysql://localhost:3306/music_project";
    
    public Connection getConexao(DadosLogin dadosLogin){
        Connection conn;
        String login = dadosLogin.login();
        String senha = new String(dadosLogin.senha());
        System.out.println(senha);
        
        try{
            conn = DriverManager.getConnection(DB_URL, login, senha);
            JOptionPane.showMessageDialog(null, "Conexão feita com sucesso");
            return conn;
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Você não tem permissão para conectar-se ao sistema");
            throw new RuntimeException (e);
        }
        finally{
            
        }
    };
}
