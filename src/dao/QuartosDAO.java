package dao;
import model.Quartos;
import util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class QuartosDAO {
    private Conexao conexao = new Conexao();
    public boolean inserirQuarto(/*Quartos quarto*/) {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement novoQuarto = conndb.prepareStatement("INSERT INTO Quartos" +
                    "(nome, numero, qtd_cama_casal, qtd_cama_solteiro, preco, disponivel) VALUES (?, ?, ?, ?, ?, ?);");

            novoQuarto.setString(1, "Quarto família");
            novoQuarto.setString(2, "1001");
            novoQuarto.setInt(3, 1);
            novoQuarto.setInt(4,  2);
            novoQuarto.setDouble(5, 870.00);
            novoQuarto.setInt(6, 1);

            int LinhaAfetada = novoQuarto.executeUpdate();
            return LinhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao inserir usuario:" + erro);
            return false;
        }
    }
}