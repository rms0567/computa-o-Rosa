package com.enem.ui;

import com.enem.dao.QuestaoDAO;
import com.enem.model.Questao;
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class TelaPrincipal extends JFrame {
    private QuestaoDAO dao = new QuestaoDAO();
    private JTextField txtAno = new JTextField(10);
    private JTextField txtCor = new JTextField(10);
    private JTextField txtNumero = new JTextField(10);
    private JTextArea txtQuestao = new JTextArea(5, 30);
    
    public TelaPrincipal() {
        setTitle("Cadastro ENEM");
        setSize(400, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        // Campos
        panel.add(new JLabel("Ano:"));
        panel.add(txtAno);
        panel.add(Box.createVerticalStrut(5));
        
        panel.add(new JLabel("Cor do Caderno:"));
        panel.add(txtCor);
        panel.add(Box.createVerticalStrut(5));
        
        panel.add(new JLabel("Número:"));
        panel.add(txtNumero);
        panel.add(Box.createVerticalStrut(5));
        
        panel.add(new JLabel("Questão:"));
        panel.add(new JScrollPane(txtQuestao));
        panel.add(Box.createVerticalStrut(10));
        
        // Botões
        JButton btnSalvar = new JButton("Salvar");
        JButton btnListar = new JButton("Listar");
        
        btnSalvar.addActionListener(e -> salvar());
        btnListar.addActionListener(e -> listar());
        
        JPanel botoes = new JPanel();
        botoes.add(btnSalvar);
        botoes.add(btnListar);
        panel.add(botoes);
        
        add(panel);
        setVisible(true);
    }
    
    private void salvar() {
        try {
            Questao q = new Questao();
            q.setAno(Integer.parseInt(txtAno.getText()));
            q.setCorCaderno(txtCor.getText());
            q.setNumeroCaderno(Integer.parseInt(txtNumero.getText()));
            q.setQuestao(txtQuestao.getText());
            
            dao.salvar(q);
            JOptionPane.showMessageDialog(this, "Salvo!");
            limpar();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro!");
        }
    }
    
    private void listar() {
        List<Questao> lista = dao.listar();
        StringBuilder sb = new StringBuilder();
        
        for (Questao q : lista) {
            sb.append("ID: ").append(q.getId())
              .append(" | Ano: ").append(q.getAno())
              .append(" | ").append(q.getCorCaderno())
              .append(" - ").append(q.getNumeroCaderno())
              .append("\n").append(q.getQuestao())
              .append("\n\n");
        }
        
        JTextArea area = new JTextArea(sb.toString());
        JScrollPane scroll = new JScrollPane(area);
        scroll.setPreferredSize(new Dimension(500, 400));
        JOptionPane.showMessageDialog(this, scroll);
    }
    
    private void limpar() {
        txtAno.setText("");
        txtCor.setText("");
        txtNumero.setText("");
        txtQuestao.setText("");
    }
    
    public static void main(String[] args) {
        new TelaPrincipal();
    }
}