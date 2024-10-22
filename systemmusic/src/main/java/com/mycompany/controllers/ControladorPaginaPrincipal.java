package com.mycompany.controllers;

    import javax.swing.JOptionPane;
    import javax.swing.JButton;

    import com.mycompany.mainpage.MainPage;
    import com.mycompany.mainpage.JCadastroAluno;

    import java.sql.Connection;

public class ControladorPaginaPrincipal {
    
    MainPage mainPage;
    JCadastroAluno jCadastroAluno;
    JButton btnCadastrar;
    Connection conn;
    
    public ControladorPaginaPrincipal(MainPage mainPage){
        this.mainPage = mainPage;
        
    }
    
    
}
