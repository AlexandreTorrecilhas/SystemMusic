package com.mycompany.systemmusic;

    import com.mycompany.telalogin.TelaLogin;
    import com.mycompany.mainpage.MainPage;
    import com.mycompany.controllers.LoginController;

public class index {


    public static void main(String[] args) {
        TelaLogin telaLogin = new TelaLogin();
        MainPage mainPage = new MainPage();
        LoginController loginController = new LoginController(telaLogin, mainPage);
        
    }
    
}
