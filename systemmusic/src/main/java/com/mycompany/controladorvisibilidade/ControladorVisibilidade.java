package com.mycompany.controladorvisibilidade;

    import com.mycompany.mainpage.MainPage;
    import com.mycompany.telalogin.TelaLogin;
    import com.mycompany.controllers.*;

public class ControladorVisibilidade {
    
    protected TelaLogin telaLogin;
    protected MainPage mainPage;
    protected LoginController loginController;
    
    public ControladorVisibilidade(){}
    
    public void InicializacaoTelaLogin(TelaLogin telaLogin, MainPage mainPage){
        this.telaLogin = telaLogin;
        this.mainPage = mainPage;
        this.loginController = new LoginController(telaLogin, mainPage);
    }
    
}
