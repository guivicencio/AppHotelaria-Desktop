package dao;
import model.Clientes;
import util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class ClientesDAO {
    private Conexao conexao = new Conexao();
    public boolean inserirCliente(/*Clientes cliente*/) {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement novoCliente = conndb.prepareStatement("INSERT INTO Clientes" +
                    "(nome, telefone, cpf, email) VALUES (?, ?, ?, ?);");

            
            novoCliente.setString(1, "Guilherme");
            novoCliente.setString(2, "15999999999");
            novoCliente.setString(3, "11111111111");
            novoCliente.setString(4, "guilhermefva@gmail.com" );

            int LinhaAfetada = novoCliente.executeUpdate();
            return LinhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao inserir cliente:" + erro);
            return false;
        }
    }
}