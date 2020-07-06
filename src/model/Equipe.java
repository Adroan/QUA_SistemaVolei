/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Adroan
 */
public class Equipe {
    private String nome;
    private int pontuacao;
    private int sets;

    public Equipe(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }


    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    public int getSets() {
        return sets;
    }

    public void setSets(int sets) {
        this.sets = sets;
    }
    
    public void addPontuacao(){
        this.pontuacao = pontuacao + 1;
    }
    public void zerarP(){
        this.pontuacao= 0;
    }
    
    public void addSet(){
        this.sets = sets+1;
    }
    public void zerarSet(){
        this.sets = 0;
    }
    
}
