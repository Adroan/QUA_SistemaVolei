/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import control.GerenciadorPartida;
import control.Observer;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Adroan
 */
public class TelaPartida extends JFrame implements Observer {

    //JLabels
    private JLabel jlNomeA, jlNomeB, jlX;
    //JButtons
    private JButton jbPontoA, jbPontoB;
    //JTextArea
    private JTextArea jtPontuacaoA, jtPontuacaoB, jtSetA, jtSetB, jtHorario, jtHistorico;
    //JTable
    private JTable tbHistorico;
    //JPanel
    private JPanel jpTimes, jpPontuacao, jpHistorico;
    //Layout
    private GridBagLayout layout;
    private GridBagConstraints constraints;

    GerenciadorPartida gPartida;

    private void initComponents() {
        constraints = new GridBagConstraints();
        layout = new GridBagLayout();

        jpTimes = new JPanel();
        jpTimes.setLayout(layout);

        jlNomeA = new JLabel();
        jlNomeA.setText(gPartida.getPartida().getA().getNome());
        jlNomeA.setFont(new Font("Calibri", 1, 60));
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 0;
        constraints.gridy = 0;
        jpTimes.add(jlNomeA, constraints);

        jlNomeB = new JLabel();
        jlNomeB.setText(gPartida.getPartida().getB().getNome());
        jlNomeB.setFont(new Font("Calibri", 1, 60));
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 2;
        constraints.gridy = 0;
        jpTimes.add(jlNomeB, constraints);

        jlX = new JLabel(new ImageIcon("src/utils/vs.png"));
//        jlX.setMaximumSize(new Dimension(30, 30));
        jlX.setSize(10, 10);
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 1;
        constraints.gridy = 0;
        jpTimes.add(jlX, constraints);

        jpPontuacao = new JPanel();
        jpPontuacao.setLayout(layout);

        jtSetA = new JTextArea(1, 1);
        jtSetA.setText("" + gPartida.getPartida().getA().getSets());
        jtSetA.setEditable(false);
        jtSetA.setFont(new Font("Calibri", 1, 50));
        constraints.gridx = 0;
        constraints.gridy = 0;
        jpPontuacao.add(jtSetA, constraints);

        jtPontuacaoA = new JTextArea(1, 1);
        jtPontuacaoA.setText("" + gPartida.getPartida().getA().getPontuacao());
        jtPontuacaoA.setEditable(false);
        jtPontuacaoA.setFont(new Font("Calibri", 1, 60));
        constraints.gridx = 1;
        constraints.gridy = 0;
        jpPontuacao.add(jtPontuacaoA, constraints);

        jtHorario = new JTextArea(1, 1);
        jtHorario.setText(gPartida.getPartida().getHorario());
        jtHorario.setEditable(false);
        jtHorario.setFont(new Font("Calibri", 1, 40));
        constraints.gridx = 2;
        constraints.gridy = 0;
        jpPontuacao.add(jtHorario, constraints);

        jtPontuacaoB = new JTextArea(1, 1);
        jtPontuacaoB.setText("" + gPartida.getPartida().getB().getPontuacao());
        jtPontuacaoB.setEditable(false);
        jtPontuacaoB.setFont(new Font("Calibri", 1, 60));
        constraints.gridx = 3;
        constraints.gridy = 0;

        jpPontuacao.add(jtPontuacaoB, constraints);

        jtSetB = new JTextArea(1, 1);
        jtSetB.setText("" + gPartida.getPartida().getB().getSets());
        jtSetB.setEditable(false);
        jtSetB.setFont(new Font("Calibri", 1, 50));
        constraints.gridx = 4;
        constraints.gridy = 0;
        jpPontuacao.add(jtSetB, constraints);

        jbPontoA = new JButton("Pontuar");
        jbPontoA.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gPartida.atualizarPontuacao("a");
            }
        });
        constraints.gridx = 1;
        constraints.gridy = 1;
        jpPontuacao.add(jbPontoA, constraints);

        jbPontoB = new JButton("Pontuar");
        jbPontoB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gPartida.atualizarPontuacao("b");
            }
        });
        constraints.gridx = 3;
        constraints.gridy = 1;
        jpPontuacao.add(jbPontoB, constraints);

        jpHistorico = new JPanel();
        jtHistorico = new JTextArea(5, 1);
        jtHistorico.setText(gPartida.getHistoricoSets());
        jtHistorico.setSize(333, 1000);
        constraints.gridx = 0;
        constraints.gridy = 0;
        jpHistorico.add(jtHistorico, constraints);

        constraints.fill = GridBagConstraints.HORIZONTAL;
        jpTimes.setSize(333, 1000);

        constraints.gridx = 0;
        constraints.gridy = 0;
        add(jpTimes, constraints);

        jpPontuacao.setSize(333, 1000);

        constraints.gridx = 0;
        constraints.gridy = 1;
        add(jpPontuacao, constraints);

        jpHistorico.setSize(333, 1000);

        constraints.gridx = 0;
        constraints.gridy = 20;
        add(jpHistorico, constraints);

    }

    public TelaPartida() {
        String timeA = "TimeA";
        String timeB = "TimeB";
        String hora = "00:00";
        String aux;
        aux = JOptionPane.showInputDialog("Digite o nome do time da Casa");
        if (!aux.isEmpty()) {
            timeA = aux;
            aux = "";
        }
        aux = JOptionPane.showInputDialog("Digite o nome do time visitante");
        if (!aux.isEmpty()) {
            timeB = aux;
            aux = "";
        }
        aux = JOptionPane.showInputDialog("Digite o horário de início do jogo");
        if (!aux.isEmpty()) {
            hora = aux;
            aux = "";
        }
        gPartida = new GerenciadorPartida(timeA, timeB, hora);
        gPartida.addObservadores(this);

        setTitle("Estádio Municipal");
        setBounds(200, 200, 1000, 1000);
        setSize(1000, 1000);
        setBackground(new Color(255, 255, 255));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setLayout(new GridBagLayout());

        initComponents();
        pack();

    }

    @Override
    public void notificarAVencedor() {
        jtPontuacaoA.setText("" + gPartida.getPartida().getA().getPontuacao());
        jtSetA.setText("" + gPartida.getPartida().getA().getSets());
        jtPontuacaoA.repaint();
        jtSetA.repaint();
        jtPontuacaoB.setText("" + gPartida.getPartida().getB().getPontuacao());
        jtSetB.setText("" + gPartida.getPartida().getB().getSets());
        jtPontuacaoB.repaint();
        jtSetB.repaint();
        jtHistorico.setText(gPartida.getHistoricoSets());
        jtHistorico.repaint();
        JOptionPane.showMessageDialog(null, "A equipe " + gPartida.getPartida().getA().getNome() + " ganhou o set!!");
    }

    @Override
    public void notificarBVencedor() {
        jtPontuacaoB.setText("" + gPartida.getPartida().getB().getPontuacao());
        jtSetB.setText("" + gPartida.getPartida().getB().getSets());
        jtPontuacaoB.repaint();
        jtSetB.repaint();
        jtPontuacaoA.setText("" + gPartida.getPartida().getA().getPontuacao());
        jtSetA.setText("" + gPartida.getPartida().getA().getSets());
        jtPontuacaoA.repaint();
        jtSetA.repaint();
        jtHistorico.setText(gPartida.getHistoricoSets());
        jtHistorico.repaint();
        JOptionPane.showMessageDialog(null, "A equipe " + gPartida.getPartida().getB().getNome() + " ganhou o set!!");
    }

    @Override
    public void notificarPartidaEncerrada() {
        JOptionPane.showMessageDialog(null, "Partida encerrada\n O time " + gPartida.getVencedor() + " venceu!!");
        System.exit(0);
    }

    @Override
    public void notificarApontuou() {
        jtPontuacaoA.setText("" + gPartida.getPartida().getA().getPontuacao());
        jtPontuacaoA.repaint();
    }

    @Override
    public void notificarBpontuou() {
        jtPontuacaoB.setText("" + gPartida.getPartida().getB().getPontuacao());
        jtPontuacaoB.repaint();
    }

    public static void main(String[] args) {
        try {
            TelaPartida t = new TelaPartida();
            t.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
