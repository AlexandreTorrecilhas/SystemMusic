package com.mycompany.controllers;

   //Importing classes from the project
    import com.mycompany.user.Estudante;
    import com.mycompany.mainpage.JCadastroAluno;
    import com.mycompany.mainpage.MainPage;
    import com.mycompany.controladorvisibilidade.ControladorVisibilidade;
    import com.mycompany.dao.InserirEstudante;
    import com.mycompany.dao.InserirTelefone;
    import com.mycompany.user.DadosLogin;
   //Importing swing classes
    import javax.swing.JOptionPane;
    import javax.swing.JButton;
    import javax.swing.JTextField;
    import javax.swing.JComboBox;
   //Importing SQL classes
    import java.sql.Date;
    import java.sql.Connection;

public class ContJCadastroAluno {
    
    private JCadastroAluno jCadastroAluno = new JCadastroAluno();
    private DadosLogin dadosLogin;
    private JButton btnCadastrar;
    
    public ContJCadastroAluno(JCadastroAluno jCadastroAluno, DadosLogin dadosLogin){
        this.jCadastroAluno = jCadastroAluno;
        this.dadosLogin = dadosLogin;
        this.btnCadastrar = this.jCadastroAluno.getBtnCadastrar();
    }
    
    private void cadastrarAluno(){
        btnCadastrar.addActionListener(e->{
            
        });
    }
}
