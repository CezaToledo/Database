/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao; // diz que faz parte do pacote dao

import java.sql.Connection; // representa uma conexão a interface SQL
import java.sql.DriverManager; // lista de drivers e interface que gere a conexão com a interface SQL
/**
 *
 * @author samuel.toledo
 */
public class ConnectionProvider { // cria a classe ConnectionProvider(provedor de conexão)
    public static Connection getCon() { //cria o método Público getCon dentro da mesma
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // carrega a classe de driver MySql JDBC. Registra o driver no DriverManager. Usa o MySQL Connector/j 8.0
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/estoque?userSSL=false","root","123456"); 
            
            /* URL: "jdbc:mysql://localhost:3306/estoque?userSSL=false"
    jdbc:mysql://: Indica o uso do MySQL com o driver chamado JBDC.
    localhost: O server é local.
    3306: O número porta(este é o número padrão que o MySQL provê).
    estoque: Nome da database(do banco de dados).
    userSSL=false: Desativa o SSL. */
            
            return con; // retorna um valor de conexão para ser referido
        } catch(Exception e) { //captura um erro
            System.out.println(e);
            return null;
        }
    }
}
