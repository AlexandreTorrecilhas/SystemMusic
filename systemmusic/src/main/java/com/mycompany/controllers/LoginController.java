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
    
    private TelaLogin telaLogin;
    private MainPage mainPage;
    private ControladorVisibilidade controladorVisibilidade = new ControladorVisibilidade();
    private ConnectionFactory connectionFactory = new ConnectionFactory();
    
    public LoginController(TelaLogin telaLogin){
        this.telaLogin = telaLogin;
        fazerLogin();
    }
    
    public void fazerLogin(){
        this.telaLogin.getBtnLogin().addActionListener(e->{
            try{
                DadosLogin dadosLogin = this.telaLogin.getDadosLogin();
                Connection conn = this.connectionFactory.getConexao(dadosLogin);
                if(!conn.isClosed()){
                    conn.close();
                    this.mainPage = new MainPage();
                    controladorVisibilidade.inicializacaoTelaPrincipal(this.mainPage, dadosLogin);
                    this.telaLogin.dispose();                    
                }
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, "Não foi possível conectar-se ao banco");
                throw new RuntimeException(ex);
            }
        });
    }
}
