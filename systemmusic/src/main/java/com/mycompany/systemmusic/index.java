package com.mycompany.systemmusic;

    import com.mycompany.user.DadosLogin;
    import com.mycompany.connectionfactory.ConnectionFactory;

    import java.util.Scanner;
    import java.sql.Connection;

public class index {


    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        String login = " ";
        String senha = " ";
        
        System.out.print("Usuario: ");
        login = entrada.nextLine();
        System.out.print("Informe a senha: ");
        senha = entrada.nextLine();
        
        ConnectionFactory connectionFactory = new ConnectionFactory(login, senha);
        
        Connection conn = connectionFactory.getConexao();
    }
    
}
