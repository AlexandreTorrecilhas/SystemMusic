package com.mycompany.controllers;

    //Importing classes from the project
    import com.mycompany.user.Estudante;
    import com.mycompany.mainpage.JCadastroAluno;
    //Importing swing classes
    import javax.swing.JOptionPane;
    import javax.swing.JButton;
    import javax.swing.JTextField;
    import javax.swing.JComboBox;
    //Importing SQL classes
    import java.sql.Date;


public class ContJCadastroAluno {
    
    private Estudante estudante;
    private JCadastroAluno jCadastroAluno;
    private JButton btnCadastrar;
    private JTextField txtNome;
    private JTextField  txtDataNascimento;
    private JTextField txtTelefone;
    private JTextField txtEmail;
    private JComboBox cBoxInstrumento;
    
    public ContJCadastroAluno(JCadastroAluno jCadastroAluno){
        
        this.jCadastroAluno = jCadastroAluno;
        this.btnCadastrar = jCadastroAluno.getBtnCadastrar();
        this.txtNome = jCadastroAluno.getTxtNome();
        this.txtDataNascimento = jCadastroAluno.getTxtDataNascimento();
        this.txtTelefone = jCadastroAluno.getTxtTelefone();
        this.txtEmail = jCadastroAluno.getTxtEmail();
        this.cBoxInstrumento = jCadastroAluno.getcBoxInstrumento();
        
        this.btnCadastrar.addActionListener(e ->{
            
            Date date = new Date();
            
            this.estudante = new Estudante(txtNome.getText(), new Date(txtDataNascimento.getText(),cBoxInstrumento.getSelectedItem(), txtTelefone.getText(), txtEmail.getText()));
            //String nome, Date dataNascimento, String instrumentoDesejado, String telefone ,String email
        });
        
    }
}
