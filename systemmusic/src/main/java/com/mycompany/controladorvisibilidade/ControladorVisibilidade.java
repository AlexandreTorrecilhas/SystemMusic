package com.mycompany.controladorvisibilidade;

    import com.mycompany.telalogin.TelaLogin;
    import com.mycompany.mainpage.JCadastroAluno;
    import com.mycompany.controllers.*;
    import com.mycompany.mainpage.*;

    import java.sql.Connection;

public class ControladorVisibilidade {
    
    public ControladorVisibilidade(){}
    
    public void inicializacaoTelaLogin(TelaLogin telaLogin){
        telaLogin.setVisible(true);
        new LoginController(telaLogin).fazerLogin();
    }
    
    
    public void inicializacaoTelaPrincipal(MainPage mainPage, Connection conn){
        mainPage.setVisible(true);
        new ControladorPaginaPrincipal(mainPage, conn);
    }
    
    public void inicializacaoJCadastroAluno(JCadastroAluno jCadastroAluno, Connection conn){
        jCadastroAluno.setVisible(true);
        new ContJCadastroAluno(jCadastroAluno, conn);
    }
}
