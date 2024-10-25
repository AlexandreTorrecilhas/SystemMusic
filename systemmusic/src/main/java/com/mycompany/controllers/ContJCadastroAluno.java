package com.mycompany.controllers;

   //Importing classes from the project
    import com.mycompany.user.Estudante;
    import com.mycompany.mainpage.JCadastroAluno;
    import com.mycompany.mainpage.MainPage;
    import com.mycompany.controladorvisibilidade.ControladorVisibilidade;
   //Importing swing classes
    import javax.swing.JOptionPane;
    import javax.swing.JButton;
    import javax.swing.JTextField;
    import javax.swing.JComboBox;
   //Importing SQL classes
    import java.sql.Date;
    import java.sql.Connection;
   //Importing Date from Java
    import java.time.LocalDate;
    import java.time.format.DateTimeFormatter;
    import java.time.format.DateTimeParseException;


public class ContJCadastroAluno {
    
    private ControladorVisibilidade controladorVisibilidade = new ControladorVisibilidade();
    private MainPage mainPage = new MainPage();
    private Connection conn;
    private Estudante estudante;
    private JCadastroAluno jCadastroAluno;
    private JButton btnMenuPrincipal;
    private JButton btnCadastrar;
    private JTextField txtNome;
    private JTextField  txtDataNascimento;
    private JTextField txtTelefone;
    private JTextField txtEmail;
    private JComboBox cBoxInstrumento;
    private Date dataNascimento;
    private LocalDate localDate;
    private DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    
    public ContJCadastroAluno(JCadastroAluno jCadastroAluno){
        
        this.btnCadastrar = jCadastroAluno.getBtnCadastrar();
        this.jCadastroAluno = jCadastroAluno;
        this.btnMenuPrincipal = jCadastroAluno.getBtnMenuPrincipal();
        
        this.btnCadastrar.addActionListener(e ->{
            
            this.btnCadastrar = jCadastroAluno.getBtnCadastrar();
            this.txtNome = jCadastroAluno.getTxtNome();
            this.txtDataNascimento = jCadastroAluno.getTxtDataNascimento();
            this.txtTelefone = jCadastroAluno.getTxtTelefone();
            this.txtEmail = jCadastroAluno.getTxtEmail();
            this.cBoxInstrumento = jCadastroAluno.getcBoxInstrumento();
            this.localDate = LocalDate.parse(txtDataNascimento.getText(), formato);
            this.dataNascimento = Date.valueOf(localDate);
            
            this.estudante = new Estudante(txtNome.getText(), this.dataNascimento, cBoxInstrumento.getSelectedItem().toString(), txtTelefone.getText(), txtEmail.getText());
            JOptionPane.showMessageDialog(null, this.estudante.getNome());
        });
        
        this.btnMenuPrincipal.addActionListener(e ->{
            JOptionPane.showMessageDialog(null, "Worked");
            this.jCadastroAluno.dispose();
            this.controladorVisibilidade.inicializacaoTelaPrincipal(this.mainPage, this.conn);
        });
        
    }
}
