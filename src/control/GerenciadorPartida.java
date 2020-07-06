/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.Equipe;
import model.Partida;

/**
 *
 * @author Adroan
 */
public class GerenciadorPartida {

    private Partida partida;
    private int numSet;
    private String vencedor;
    private boolean aVence;
    private List<Observer> observadores = new ArrayList<>();

    public GerenciadorPartida(String timeA,String timeB, String horario) {
        iniciarJogo(timeA, timeB, horario);
    }

    public void iniciarJogo(String timeA, String timeB, String horario) {
        this.partida = new Partida(new Equipe(timeA), new Equipe(timeB), horario);
        this.numSet = 1;
    }

    public void atualizarPontuacao(String time) {
        if (time.equals("a")) {
            partida.getA().addPontuacao();
            for (Observer obs : observadores) {
                obs.notificarApontuou();
            }
        } else if(time.equals("b")) {
            partida.getB().addPontuacao();
            for (Observer obs : observadores) {
                obs.notificarBpontuou();
            }
        }
        if (isAVecedorSet()) {
            aVence = true;
            for (Observer obs : observadores) {
                obs.notificarAVencedor();
            }
        } else if (isBVencedorSet()) {
            aVence=false;
            for (Observer obs : observadores) {
                obs.notificarBVencedor();
            }
        }

        if (partida.getA().getSets()== 3 || partida.getB().getSets()== 3) {
            if(partida.getA().getSets()== 3){
                vencedor = partida.getA().getNome();
            }else if (partida.getB().getSets()==3) {
                vencedor = partida.getB().getNome();
            }
            encerrarPartida();
        }
        System.out.println("Pontuação A: "+ partida.getA().getPontuacao()+"\nPontuação B: "+ partida.getB().getPontuacao());
        System.out.println("Set A: "+ partida.getA().getSets()+"\nSet B: "+ partida.getB().getSets());
    }

    public void fecharSet() {
        partida.addPontuacaoSet(partida.getA().getNome()+"\t" + partida.getA().getPontuacao() + " X " + partida.getB().getPontuacao()+"\t" +partida.getB().getNome());
        partida.getA().setPontuacao(0);
        partida.getB().setPontuacao(0);
    }

    public boolean isAVecedorSet() {
        if (numSet<5) {
            if (partida.getA().getPontuacao() >= 25 && (partida.getA().getPontuacao() - partida.getB().getPontuacao() >= 2)) {
                fecharSet();
                numSet++;
                partida.getA().addSet();
                return true;
            }
        } else {
            if (partida.getA().getPontuacao() >= 15 && (partida.getA().getPontuacao() - partida.getB().getPontuacao() >= 2)) {
                fecharSet();
                partida.getA().addSet();
                numSet++;
                return true;
            }
        }
        return false;
    }

    public boolean isBVencedorSet() {
        if (numSet<5) {
            if (partida.getB().getPontuacao() >= 25 && (partida.getB().getPontuacao() - partida.getA().getPontuacao() >= 2)) {
                fecharSet();
                numSet++;
                partida.getB().addSet();
                return true;
            }
        } else {
            if (partida.getB().getPontuacao() >= 15 && (partida.getB().getPontuacao() - partida.getA().getPontuacao() >= 2)) {
                fecharSet();
                partida.getB().addSet();
                numSet++;
                return true;
            }
        }
        return false;
    }

    private void encerrarPartida() {
        for (Observer obs : observadores) {
            obs.notificarPartidaEncerrada();
        }
    }

    public void addObservadores(Observer obs) {
        this.observadores.add(obs);
    }

    public String getHistoricoSets() {
        String s="";
        for (String his: partida.getHistoricoPont()) {
            s=his+"\n"+s;
        }
        return s;
    }

    public Partida getPartida() {
        return partida;
    }

    public int getNumSet() {
        return numSet;
    }

    public String getVencedor() {
        return vencedor;
    }

    public boolean isaVence() {
        return aVence;
    }
    
}
