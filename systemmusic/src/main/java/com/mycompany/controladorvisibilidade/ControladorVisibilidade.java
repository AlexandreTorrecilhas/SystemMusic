package com.mycompany.controladorvisibilidade;

    import com.mycompany.mainpage.MainPage;
    import com.mycompany.telalogin.TelaLogin;
    import com.mycompany.mainpage.JCadastroAluno;
    import com.mycompany.controllers.*;

    import java.sql.Connection;

public class ControladorVisibilidade {
    
    protected TelaLogin telaLogin;
    protected MainPage mainPage;
    protected JCadastroAluno jCadastroAluno;
    
    protected LoginController loginController;
    protected ControladorPaginaPrincipal controladorPaginaPrincipal;
    
    protected Connection conn;
    
    public ControladorVisibilidade(){}
    
    public void InicializacaoTelaLogin(TelaLogin telaLogin){
        this.telaLogin = telaLogin;
        this.telaLogin.setVisible(true);
        this.loginController = new LoginController(telaLogin);
    }
    
    
    public void InicializacaoTelaPrincipal(MainPage mainPage){
        this.mainPage = mainPage;
        this.mainPage.setVisible(true);
        this.controladorPaginaPrincipal = new ControladorPaginaPrincipal(this.mainPage);
    }
}
