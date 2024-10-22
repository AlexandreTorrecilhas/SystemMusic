package com.mycompany.controllers;

    import javax.swing.JOptionPane;
    import java.sql.Connection;
    import java.sql.SQLException;

    import com.mycompany.controladorvisibilidade.ControladorVisibilidade;
    import com.mycompany.telalogin.TelaLogin;
    import com.mycompany.mainpage.MainPage;
    import com.mycompany.connectionfactory.ConnectionFactory;
    import com.mycompany.user.DadosLogin;

public class LoginController {
    
    private Connection conn;
    private TelaLogin telaLogin;
    private MainPage mainPage;
    private DadosLogin dadosLogin;
    private ControladorVisibilidade controladorVisibilidade = new ControladorVisibilidade();
    private ConnectionFactory connectionFactory = new ConnectionFactory();
    
    public LoginController(TelaLogin telaLogin){
        this.telaLogin = telaLogin;
        
        this.telaLogin.btnLogin.addActionListener(
                e ->{
                    try{
                        this.dadosLogin = telaLogin.getDadosLogin();
                        this.conn = this.connectionFactory.getConexao(this.dadosLogin);
                        if(!conn.isClosed()){
                            this.mainPage = new MainPage(dadosLogin);
                            controladorVisibilidade.InicializacaoTelaPrincipal(this.mainPage);
                            this.telaLogin.dispose();
                        }
                     }catch(SQLException ex){
                         JOptionPane.showMessageDialog(null, "Não foi possível conectar-se ao banco");
                         throw new RuntimeException(ex);
                     }
                }
        );
    }
    
    
    
}
