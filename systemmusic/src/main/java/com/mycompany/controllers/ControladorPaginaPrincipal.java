package com.mycompany.controllers;

    import com.mycompany.controladorvisibilidade.ControladorVisibilidade;
    import com.mycompany.mainpage.MainPage;
    import com.mycompany.user.DadosLogin;
    import com.mycompany.mainpage.JCadastroAluno;
    //importing javax
    import javax.swing.JOptionPane;
    import javax.swing.JButton;


public class ControladorPaginaPrincipal {
    
    private MainPage mainPage;
    private JCadastroAluno jCadastroAluno;
    private JButton btnCadastrar;
    private DadosLogin dadosLogin;
    private ControladorVisibilidade controladorVisibilidade = new ControladorVisibilidade();
    
    public ControladorPaginaPrincipal(MainPage mainPage, DadosLogin dadosLogin){
        this.mainPage = mainPage;
        this.dadosLogin = dadosLogin;
        btnCadastrar = this.mainPage.getBtnCadastrar();
        setLblLogin();
        abrirTelaCadastro();
    }
    
    protected void setLblLogin(){
        this.mainPage.getLblLogin().setText(dadosLogin.login());
    }
    
    protected void abrirTelaCadastro(){
        btnCadastrar.addActionListener(e ->{
            this.mainPage.dispose();
            this.jCadastroAluno = new JCadastroAluno();
            this.controladorVisibilidade.inicializacaoJCadastroAluno(jCadastroAluno, dadosLogin);
        });
    }
    
    
}
