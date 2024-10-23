package com.mycompany.controllers;

    import javax.swing.JOptionPane;
    import javax.swing.JButton;
    import com.mycompany.controladorvisibilidade.ControladorVisibilidade;
    import com.mycompany.mainpage.MainPage;
    import com.mycompany.mainpage.JCadastroAluno;

    import java.sql.Connection;

public class ControladorPaginaPrincipal {
    
    private MainPage mainPage;
    private JCadastroAluno jCadastroAluno;
    private JButton btnCadastrar;
    private Connection conn;
    private ControladorVisibilidade controladorVisibilidade = new ControladorVisibilidade();
    
    public ControladorPaginaPrincipal(MainPage mainPage, Connection conn){
        this.mainPage = mainPage;
        this.conn = conn;
        this.btnCadastrar = mainPage.getBtnCadastrar();
        
        this.btnCadastrar.addActionListener(
            e ->{
                this.mainPage.dispose();
                this.jCadastroAluno = new JCadastroAluno();
                this.controladorVisibilidade.inicializacaoJCadastroAluno(jCadastroAluno, conn);
            }
        );
    }
    
    
}
