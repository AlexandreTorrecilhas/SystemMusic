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
        String senha =  hashSenha(dadosLogin.senha());
        
        try{
            conn = DriverManager.getConnection(DB_URL, login, senha);
            JOptionPane.showMessageDialog(null, "Conexão feita com sucesso");
            return conn;
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Você não tem permissão para conectar-se ao sistema");
            throw new RuntimeException (e);
        }
    };
    
    public String hashSenha(char[] senhaOriginal){
        String senha = new String(senhaOriginal);
        String hashSenha = BCrypt.hashpw(senha, BCrypt.gensalt());
        senha = null;
        System.out.println(hashSenha);
        return hashSenha;
    }
}
