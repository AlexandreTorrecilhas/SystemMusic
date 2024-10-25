package com.mycompany.dao;

//Importing SQL
    import java.sql.Connection;
    import java.sql.PreparedStatement;
    import java.sql.SQLException;
//Importing from this project
    import com.mycompany.user.Estudante;
import javax.swing.JOptionPane;

public class InserirEstudante {
    private final String sql = "INSERT INTO estudante(nome, dtnasc, instrumento, email) " +
            "VALUES (?, ?, ?, ?)";
    private Estudante estudante;
    private Connection conn;
    
    public InserirEstudante(Estudante estudante, Connection conn){
        this.estudante = estudante;
        this.conn = conn;
        try{
            PreparedStatement preparedStatement = this.conn.prepareStatement(this.sql);
            preparedStatement.setString(1, estudante.getNome());
            preparedStatement.setDate(2, estudante.getDataNascimento());
            preparedStatement.setString(3, estudante.getInstrumentoDesejado());
            preparedStatement.setString(4, estudante.getEmail());
            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Estudante cadastrado com sucesso");
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Não foi possível cadastrar o estudante");
            throw new RuntimeException(e);
        }        
    }
    
}
