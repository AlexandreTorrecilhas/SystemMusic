package com.mycompany.logincontroller;

    import javax.swing.JOptionPane;

    import com.mycompany.telalogin.TelaLogin;
    import com.mycompany.mainpage.MainPage;

public class LoginController {
    
    private TelaLogin telaLogin;
    private MainPage mainPage;
    
    public LoginController(TelaLogin telaLogin, MainPage mainPage){
        this.telaLogin = telaLogin;
        this.mainPage = mainPage;
        this.telaLogin.setVisible(true);
        
        this.telaLogin.btnLogin.addActionListener(
                e ->{
                    JOptionPane.showMessageDialog(null, "WORKED");
                }
        );
    }
    
    
    
}
