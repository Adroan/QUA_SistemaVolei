/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Adroan
 */
public class Partida {
    private Equipe a;
    private Equipe b;
    
    private String horario;
    
    private List<String> historicoPont = new ArrayList<>();

    public Partida(Equipe a, Equipe b, String horario) {
        this.a = a;
        this.b = b;
        this.horario = horario;
    }

    public Equipe getA() {
        return a;
    }

    public void setA(Equipe a) {
        this.a = a;
    }

    public Equipe getB() {
        return b;
    }

    public void setB(Equipe b) {
        this.b = b;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public List<String> getHistoricoPont() {
        return historicoPont;
    }

    public void setHistoricoPont(List<String> historicoPont) {
        this.historicoPont = historicoPont;
    }

    
    public void addPontuacaoSet(String pontuacao){
       historicoPont.add(pontuacao);
    }
    
    
}
