package com.enem.dao;

import com.enem.model.Questao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class QuestaoDAO {
    private Connection con;
    
    public QuestaoDAO() {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/enem", "root", "escola");
            Statement stmt = con.createStatement();
            stmt.execute("CREATE TABLE IF NOT EXISTS questao (id INT AUTO_INCREMENT PRIMARY KEY, ano INT, cor_caderno VARCHAR(50), numero_caderno INT, questao TEXT)");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void salvar(Questao q) {
        try {
            PreparedStatement stmt = con.prepareStatement("INSERT INTO questao (ano, cor_caderno, numero_caderno, questao) VALUES (?,?,?,?)");
            stmt.setInt(1, q.getAno());
            stmt.setString(2, q.getCorCaderno());
            stmt.setInt(3, q.getNumeroCaderno());
            stmt.setString(4, q.getQuestao());
            stmt.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public List<Questao> listar() {
        List<Questao> lista = new ArrayList<>();
        try {
            ResultSet rs = con.createStatement().executeQuery("SELECT * FROM questao");
            while (rs.next()) {
                Questao q = new Questao();
                q.setId(rs.getInt("id"));
                q.setAno(rs.getInt("ano"));
                q.setCorCaderno(rs.getString("cor_caderno"));
                q.setNumeroCaderno(rs.getInt("numero_caderno"));
                q.setQuestao(rs.getString("questao"));
                lista.add(q);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }
}