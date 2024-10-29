package com.mycompany.dao;

//Importing SQL packages
    import java.sql.Connection;
    import java.sql.PreparedStatement;
    import java.sql.SQLException;
    
public class InserirTelefone {
    private final String sql = "INSET INTO telefone (rel_id_es, num_tel) " +
        "VALUES(?, ?)";
    private Connection conn;
    private String telefone;
    private int id_estudante;
    
    public InserirTelefone(Connection conn, String telefone, int id_estudante){
        this.conn = conn;
        this.telefone = telefone;
        this.id_estudante = id_estudante;
        inserirTelefone();
    }
    
    public void inserirTelefone(){
        try{
            PreparedStatement preparedStatement = this.conn.prepareStatement(this.sql);
            preparedStatement.execute();
        }catch(SQLException erroInserirTelefone){
            throw new RuntimeException(erroInserirTelefone);
        }
    }
    
}
