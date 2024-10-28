package com.mycompany.controllers;

   //Importing classes from the project
    import com.mycompany.user.Estudante;
    import com.mycompany.mainpage.JCadastroAluno;
    import com.mycompany.mainpage.MainPage;
    import com.mycompany.controladorvisibilidade.ControladorVisibilidade;
    import com.mycompany.dao.InserirEstudante;
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
    
    private InserirEstudante inserirEstudante;
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
    
    public ContJCadastroAluno(JCadastroAluno jCadastroAluno, Connection conn){
        
        this.jCadastroAluno = jCadastroAluno;
        this.jCadastroAluno = jCadastroAluno;
        this.conn = conn;
        this.btnCadastrar = this.jCadastroAluno.getBtnCadastrar();
        this.btnMenuPrincipal = this.jCadastroAluno.getBtnMenuPrincipal();
            
        this.btnCadastrar.addActionListener(e ->{
            this.btnCadastrar = jCadastroAluno.getBtnCadastrar();
            this.txtNome = jCadastroAluno.getTxtNome();
            this.txtDataNascimento = jCadastroAluno.getTxtDataNascimento();
            this.txtTelefone = jCadastroAluno.getTxtTelefone();
            this.txtEmail = jCadastroAluno.getTxtEmail();
            this.cBoxInstrumento = jCadastroAluno.getcBoxInstrumento();
            
            try{
                this.localDate = LocalDate.parse(txtDataNascimento.getText(), formato);
                this.dataNascimento = Date.valueOf(localDate);
            }catch(DateTimeParseException formatoData){
                JOptionPane.showMessageDialog(null, "Por favor, informe a data no seguinte formato ex: 01/01/1990");
                throw new RuntimeException (formatoData);
            }
            
            this.estudante = new Estudante(txtNome.getText(), this.dataNascimento, cBoxInstrumento.getSelectedItem().toString(), txtTelefone.getText(), txtEmail.getText());
            
            try{
                this.inserirEstudante = new InserirEstudante(this.estudante, this.conn);
            }catch(RuntimeException inserirEstudante){
                throw new RuntimeException(inserirEstudante);
            }finally{
                this.txtNome.setText("");
                this.txtDataNascimento.setText("");
                this.txtTelefone.setText("");
                this.txtEmail.setText("");
                this.cBoxInstrumento.setSelectedIndex(0);
            }
        });
        
        this.btnMenuPrincipal.addActionListener(e ->{
            this.jCadastroAluno.dispose();
            this.controladorVisibilidade.inicializacaoTelaPrincipal(this.mainPage, this.conn);
        });
    }
}
