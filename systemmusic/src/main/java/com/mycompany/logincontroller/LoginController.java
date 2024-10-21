package com.mycompany.logincontroller;

    import javax.swing.JOptionPane;
    import java.sql.Connection;
    import java.sql.SQLException;

    import com.mycompany.telalogin.TelaLogin;
    import com.mycompany.mainpage.MainPage;
    import com.mycompany.connectionfactory.ConnectionFactory;
    import com.mycompany.user.DadosLogin;

public class LoginController {
    
    private Connection conn;
    private TelaLogin telaLogin;
    private MainPage mainPage;
    private DadosLogin dadosLogin;
    private ConnectionFactory connectionFactory = new ConnectionFactory();
    
    public LoginController(TelaLogin telaLogin, MainPage mainPage){
        this.telaLogin = telaLogin;
        this.mainPage = mainPage;
        this.telaLogin.setVisible(true);
        
        this.telaLogin.btnLogin.addActionListener(
                e ->{
                     this.dadosLogin = telaLogin.getDadosLogin();
                     this.conn = this.connectionFactory.getConexao(dadosLogin);
                     try{
                         if(!conn.isClosed()){
                         JOptionPane.showMessageDialog(null, "Worked");
                        }
                     }catch(SQLException ex){
                         JOptionPane.showMessageDialog(null, "Não foi possível conectar-se ao banco");
                         throw new RuntimeException(ex);
                     }
                }
        );
    }
    
    
    
}
