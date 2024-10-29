package com.mycompany.dao;

//Importing SQL
    import java.sql.Connection;
    import java.sql.PreparedStatement;
    import java.sql.SQLException;
    import java.sql.ResultSet;
//Importing from this project
    import com.mycompany.user.Estudante;
    import java.sql.Statement;
    import javax.swing.JOptionPane;
    import com.mycompany.dao.InserirTelefone;

public class InserirEstudante {
    private final String sql = "INSERT INTO estudante(nome, dtnasc, instrumento, email) " +
            "VALUES (?, ?, ?, ?)";
    private Estudante estudante;
    private Connection conn;
    //Variáveis id_estudante
    private ResultSet resultSet;
    private InserirTelefone inserirTelefone;
    private int idEstudante;
        
    public InserirEstudante(Estudante estudante, Connection conn){
        this.estudante = estudante;
        this.conn = conn;
        try{
            PreparedStatement preparedStatement = this.conn.prepareStatement(this.sql, Statement.RETURN_GENERATED_KEYS);
            
            preparedStatement.setString(1, estudante.getNome());
            preparedStatement.setDate(2, estudante.getDataNascimento());
            preparedStatement.setString(3, estudante.getInstrumentoDesejado());
            preparedStatement.setString(4, estudante.getEmail());
            preparedStatement.execute();
            resultSet = preparedStatement.getGeneratedKeys();
            JOptionPane.showMessageDialog(null, "Estudante cadastrado com sucesso");
            
            if(resultSet.next()){
                this.idEstudante = resultSet.getInt(1);
                inserirTelefone = new InserirTelefone(this.conn, this.estudante.getTelefone(), idEstudante);
            }else{}

        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Não foi possível cadastrar o estudante");
            throw new RuntimeException(e);
        }        
    }
    
}
