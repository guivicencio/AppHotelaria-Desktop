package dao;
import model.Adicionais;
import util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class AdicionaisDAO {
    private Conexao conexao = new Conexao();
    public boolean inserirAdicional(/*Adicionais adicionais*/) {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement novoAdicional = conndb.prepareStatement("INSERT INTO Adicionais" +
                    "(nome, preco) VALUES (?, ?);");

            novoAdicional.setString(1, "Geladeira");
            novoAdicional.setDouble(2, 100.00);

            int LinhaAfetada = novoAdicional.executeUpdate();
            return LinhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao inserir usuario:" + erro);
            return false;
        }
    }
}