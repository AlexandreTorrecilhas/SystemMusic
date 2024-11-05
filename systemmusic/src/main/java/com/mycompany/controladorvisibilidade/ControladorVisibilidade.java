package com.mycompany.controladorvisibilidade;

    import com.mycompany.telalogin.TelaLogin;
    import com.mycompany.mainpage.JCadastroAluno;
    import com.mycompany.controllers.*;
    import com.mycompany.mainpage.*;
    import com.mycompany.user.*;

    import java.sql.Connection;

public class ControladorVisibilidade {
    
    public ControladorVisibilidade(){}
    
    public void inicializacaoTelaLogin(TelaLogin telaLogin){
        telaLogin.setVisible(true);
        new LoginController(telaLogin);
    }
    
    
    public void inicializacaoTelaPrincipal(MainPage mainPage, DadosLogin dadosLogin){
        mainPage.setVisible(true);
        new ControladorPaginaPrincipal(mainPage, dadosLogin);
    }
    
    public void inicializacaoJCadastroAluno(JCadastroAluno jCadastroAluno, DadosLogin dadosLogin){
        jCadastroAluno.setVisible(true);
        new ContJCadastroAluno(jCadastroAluno, dadosLogin);
    }
}
