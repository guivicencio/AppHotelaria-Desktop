package util;
import dao.AdicionaisDAO;
import dao.ClientesDAO;
import dao.QuartosDAO;
import dao.UsuariosDAO;

/*Classe criada apenas para testar a requisição de conexão ao banco
de dados, de modo a verificar se o SGBD MySQl está rodando na porta 3306,
se os parâmetros como endereço IP do servidor, nome de usuário,
senha e nome do banco de dados estão corretos, utilizando-se
o driver JDBC para MySQL*/

import java.sql.Connection;
public class TesteConexaoDB {
    public static void main(String[] args) {
        Conexao conexao = new Conexao();
        Connection condb = conexao.conectar();
        if (condb != null) {
            System.out.println("Conexão estabelecida com sucesso!");
            try {
                /*AdicionaisDAO adicionaisDAO = new AdicionaisDAO();
                adicionaisDAO.inserirAdicional();
                System.out.println("Adicional inserido com sucesso!");*/

                ClientesDAO clientesDAO = new ClientesDAO();
                clientesDAO.inserirCliente();
                System.out.println("Cliente inserido com sucesso!");

                /*QuartosDAO quartosDAO = new QuartosDAO();
                quartosDAO.inserirQuarto();
                System.out.printf("Quarto inserido com sucesso!");

                UsuariosDAO usuariosDAO = new UsuariosDAO();
                usuariosDAO.inserirUsuario();
                System.out.println("Usuario inserido com sucesso!");*/

                condb.close();
                System.out.println("Conexão encerrada!");
            } catch (Exception erro) {
                System.out.println("Erro ao encerrar a conexão: " + erro.getMessage());
            }
        } else {
            System.out.println("Falha ao conectar ao banco de dados!");
        }
    }
}