package com.mycompany.systemmusic;

    import com.mycompany.telalogin.TelaLogin;
    import com.mycompany.mainpage.MainPage;
    import com.mycompany.controladorvisibilidade.ControladorVisibilidade;

public class index {


    public static void main(String[] args) {
        
        ControladorVisibilidade controladorVisibilidade = new ControladorVisibilidade();
        
        TelaLogin telaLogin = new TelaLogin();
        MainPage mainPage = new MainPage();
        controladorVisibilidade.inicializacaoTelaLogin(telaLogin);
        
    }
    
}
