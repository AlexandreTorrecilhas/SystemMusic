package com.mycompany.user;

    import java.sql.Date;

public class Estudante {
    
    protected boolean situacao = true;
    String nome;
    Date dataNascimento;
    String instrumentoDesejado;
    String telefone;
    String email;
    
    public Estudante(String nome, Date dataNascimento, String instrumentoDesejado, String telefone ,String email){
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.instrumentoDesejado = instrumentoDesejado;
        this.telefone = telefone;
        this.email = email;
    }
    
    public void setSituacao(boolean situacao){
        this.situacao = situacao;
    }
    
    public boolean getSituacao(){
        return this.situacao;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public void setDataNascimento(Date dataNascimento){
        this.dataNascimento = dataNascimento;
    }
    
    public Date getDataNascimento(){
        return this.dataNascimento;
    }
    
    public void setInstrumentoDesejado(String instrumentoDesejado){
        this.instrumentoDesejado = instrumentoDesejado;
    }
    
    public String getInstrumentoDesejado(){
        return this.instrumentoDesejado;
    }
    
    public void setTelefone(String telefone){
        this.telefone = telefone;
    }
    
    public String getTelefone(){
        return this.telefone;
    }
    
    public void setEmail(String email){
        this.email = email;
    }
    
   public String getEmail(){
       return this.email;
   }
}
