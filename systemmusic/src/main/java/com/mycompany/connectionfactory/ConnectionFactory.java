package com.mycompany.connectionfactory;

    import com.mycompany.user.DadosLogin;

    import java.sql.DriverManager;
    import java.sql.Connection;
    import java.sql.SQLException;
    import javax.swing.JOptionPane;

public class ConnectionFactory {
    
    private final String DB_URL = "jdbc:mysql://localhost:3306/music_project";
    private Connection conn;
    private String login = " ";
    private String senha = " ";
    
    public ConnectionFactory(){
    
    }
    
    public Connection getConexao(DadosLogin dadosLogin){

        Connection conn;
        String login = dadosLogin.login();
        String senha = new String(dadosLogin.senha());
        System.out.println(senha);

        this.login = dadosLogin.login();
        this.senha = new String(dadosLogin.senha());

        
        try{
            this.conn = DriverManager.getConnection(DB_URL, this.login, this.senha);
            JOptionPane.showMessageDialog(null, "Login feito com sucesso");
            return this.conn;
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "O usuário não tem permissão para login");
            throw new RuntimeException (e);
        }finally{
            this.senha = null;
        }
    }
}
