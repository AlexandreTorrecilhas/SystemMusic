package com.mycompany.controllers;

    import javax.swing.JOptionPane;
    import javax.swing.JButton;
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
        this.telaLogin.getBtnLogin().addActionListener(e->{
            fazerLogin();
        });
    }
    
    public void fazerLogin(){
        DadosLogin dadosLogin = telaLogin.getDadosLogin();
        Connection conn = this.connectionFactory.getConexao(dadosLogin);
        try{
            if(!conn.isClosed()){
                this.mainPage = new MainPage(dadosLogin);
                controladorVisibilidade.inicializacaoTelaPrincipal(this.mainPage, conn);
                this.telaLogin.dispose();                    
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Não foi possível conectar-se ao banco");
            throw new RuntimeException(ex);
        }
    }
}
