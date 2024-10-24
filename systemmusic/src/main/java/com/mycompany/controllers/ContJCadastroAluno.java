package com.mycompany.controllers;

    import javax.swing.JOptionPane;

    import com.mycompany.user.Estudante;
    import com.mycompany.mainpage.JCadastroAluno;
    import javax.swing.JButton;
    import javax.swing.JTextField;
    import javax.swing.JComboBox;



public class ContJCadastroAluno {
    
    private Estudante estudante;
    private JCadastroAluno jCadastroAluno;
    private JButton btnCadastrar;
    //private JTextField txtNome = jCadastroAluno.getTxtNome();
    //private JTextField  txtDataNascimento = jCadastroAluno.getTxtDataNascimento();
    //private JTextField txtTelefone = jCadastroAluno.getTxtTelefone();
    //private JTextField txtEmail = jCadastroAluno.getTxtEmail();
    //private JComboBox cBoxInstrumento = jCadastroAluno.getcBoxInstrumento();
    
    public ContJCadastroAluno(JCadastroAluno jCadastroAluno){
        
        this.jCadastroAluno = jCadastroAluno;
        this.btnCadastrar = jCadastroAluno.getBtnCadastrar();
        
        this.btnCadastrar.addActionListener(e ->{
            JOptionPane.showMessageDialog(null, "Worked");
        });
        
    }
}
