package com.enem.model;

public class Questao {
    private int id;
    private int ano;
    private String corCaderno;
    private int numeroCaderno;
    private String questao;
    
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public int getAno() { return ano; }
    public void setAno(int ano) { this.ano = ano; }
    public String getCorCaderno() { return corCaderno; }
    public void setCorCaderno(String corCaderno) { this.corCaderno = corCaderno; }
    public int getNumeroCaderno() { return numeroCaderno; }
    public void setNumeroCaderno(int numeroCaderno) { this.numeroCaderno = numeroCaderno; }
    public String getQuestao() { return questao; }
    public void setQuestao(String questao) { this.questao = questao; }
}