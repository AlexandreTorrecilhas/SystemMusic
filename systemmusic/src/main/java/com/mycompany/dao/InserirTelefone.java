package com.mycompany.dao;

//Importing SQL packages
    import java.sql.Connection;
    import java.sql.PreparedStatement;
    
public class InserirTelefone {
    private final String sql = "INSET INTO telefone (rel_id_es, num_tel) " +
        "VALUES(?, ?)";
    private Connection conn;
    private String telefone;
    private int id_estudante;
    
    public InserirTelefone(Connection con, String telefone, int id_estudante){
        this.conn = conn;
        this.telefone = telefone;
        this.id_estudante = id_estudante;
    }
    
    public void inserirEstudante(){
        
    }
    
}
