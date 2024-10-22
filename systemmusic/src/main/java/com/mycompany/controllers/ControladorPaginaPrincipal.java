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
    
    public ControladorPaginaPrincipal(MainPage mainPage, JCadastroAluno jCadastroAluno, Connection conn){
        this.mainPage = mainPage;
        this.jCadastroAluno = jCadastroAluno;
        this.conn = conn;
        this.btnCadastrar = jCadastroAluno.getBtnCadastrar();
    }
    
    public void teste(){
        this.btnCadastrar.addActionListener(
            e -> {
                JOptionPane.showMessageDialog(null, "Worked");
            }
        );
    }
}
