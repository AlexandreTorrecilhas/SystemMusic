package com.mycompany.controladorvisibilidade;

    import com.mycompany.telalogin.TelaLogin;
    import com.mycompany.mainpage.JCadastroAluno;
    import com.mycompany.controllers.*;
    import com.mycompany.mainpage.*;

    import java.sql.Connection;

public class ControladorVisibilidade {
    
    protected TelaLogin telaLogin;
    protected MainPage mainPage;
    protected JCadastroAluno jCadastroAluno;
    protected LoginController loginController;
    protected ControladorPaginaPrincipal controladorPaginaPrincipal;
    protected ContJCadastroAluno contJCadastroAluno;
    protected Connection conn;
    
    public ControladorVisibilidade(){}
    
    public void inicializacaoTelaLogin(TelaLogin telaLogin){
        this.telaLogin = telaLogin;
        this.telaLogin.setVisible(true);
        this.loginController = new LoginController(telaLogin);
    }
    
    
    public void inicializacaoTelaPrincipal(MainPage mainPage, Connection conn){
        this.mainPage = mainPage;
        this.conn = conn;
        this.mainPage.setVisible(true);
        this.controladorPaginaPrincipal = new ControladorPaginaPrincipal(this.mainPage, this.conn);
    }
    
    public void inicializacaoJCadastroAluno(JCadastroAluno jCadastroAluno, Connection conn){
        this.jCadastroAluno = jCadastroAluno;
        this.conn = conn;
        this.jCadastroAluno.setVisible(true);
        this.contJCadastroAluno = new ContJCadastroAluno();
    }
}
