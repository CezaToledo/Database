/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao; //parte do pacote dao
import java.sql.*; // importa a interface completa do SQL
import javax.swing.JOptionPane; // importa somente a função do painel sim ou não
/**
 *
 * @author samuel.toledo
 */
public class tables { // classe pública tables(tabelas)
    public static void main(String[] args) { //roda quando o programa começar a rodar
        Connection con = null; // inicializa as variáveis sem imputar um valor(como null)
        Statement st = null;
        try {
            con = ConnectionProvider.getCon(); // usa o ConnectionProvider para conseguir uma conexão para interagir com a database 
            st = con.createStatement(); // cria o statement(habilidade de executar código para o SQL pelo aplicativo)
//            st.executeUpdate("create table appuser(appuser_pk int AUTO_INCREMENT primary key,userRole varchar(50), name varchar(200), mobileNumber varchar(50), email varchar(200), password varchar(50), address varchar(200), status varchar(50))"); cria uma tabela de usuários, com seus parâmetros. Usa também o parâmetro varchar('número') para estabelecer um limite de caracteres para cada parâmetro, deixando assim mais fácil de controlá-los. Como a tabela já foi criada, deixei esta linha como comentário, só mudar se você quiser fuder o baghui Gustavo
            st.executeUpdate("insert into appuser (userRole,name,mobileNumber,email,password,address,status) values('SuperAdmin','Super Admin','12345','superadmin@testemail.com','admin','Brazil','Ativo')"); // executa uma atualização na tabela appuser para criar o login de admin
            JOptionPane.showMessageDialog(null,"Tabela criada com sucesso."); //mostra a mensagem de que a tabela foi criada quando executar este arquivo
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e); // mostra o erro se não conseguir a conexão nem criar a tabela
        }
        finally{
            try {
                con.close(); // usa o método de fechar(.close) para fechar a conexão e o statement
                st.close();
            } 
            catch (Exception e) {}
        }
    }
}
