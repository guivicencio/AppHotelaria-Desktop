package dao;

import model.Usuarios;
import util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class UsuariosDAO {
    //Objeto para instanciar classe Conexao para requisitar acesso ao DB.
    private Conexao conexao = new Conexao();
    public boolean inserirUsuario(/*Usuarios usuario*/) {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement novoUsuario = conndb.prepareStatement("INSERT INTO usuarios" +
                    "(nome, email, senha, fk_cargos) VALUES (?, ?, md5(?), ?);");
            //Setar os parâmetros.
            novoUsuario.setString(1, "Guilherme");
            novoUsuario.setString(2, "guilhermefva@gmail.com");
            novoUsuario.setString(3, "123");
            novoUsuario.setInt(4, 1);

            int LinhaAfetada = novoUsuario.executeUpdate();
            return LinhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao inserir usuario:" + erro);
            return false;
        }
    }
}