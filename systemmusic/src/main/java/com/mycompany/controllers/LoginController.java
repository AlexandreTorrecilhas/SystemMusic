package com.mycompany.controllers;

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
        this.telaLogin.setVisible(true);
        
        this.telaLogin.btnLogin.addActionListener(
                e ->{
                    try{
                        this.dadosLogin = telaLogin.getDadosLogin();
                        this.conn = this.connectionFactory.getConexao(dadosLogin);
                        if(!conn.isClosed()){
                            this.mainPage = new MainPage(this.dadosLogin);
                            this.telaLogin.setVisible(false);
                            this.mainPage.setVisible(true);
                        }
                     }catch(SQLException ex){
                         JOptionPane.showMessageDialog(null, "Não foi possível conectar-se ao banco");
                         throw new RuntimeException(ex);
                     }
                }
        );
    }
    
    
    
}