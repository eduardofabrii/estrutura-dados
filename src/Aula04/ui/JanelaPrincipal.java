package Aula04.ui;

import Aula04.modelo.Tabuleiro;
import javax.swing.*;
import java.awt.*;

public class JanelaPrincipal extends JFrame {

    private Tabuleiro tabuleiro;
    private PainelJogo painelJogo;
    private boolean usandoPilha = true;

    public JanelaPrincipal() {
        super("Flood Fill");
        tabuleiro = new Tabuleiro(600, 500);
        tabuleiro.salvarImagemInicial();

        painelJogo = new PainelJogo(tabuleiro, usandoPilha);

        JButton btnModo = new JButton("Modo: Pilha");
        btnModo.addActionListener(e -> {
            usandoPilha = !usandoPilha;
            painelJogo.setUsandoPilha(usandoPilha);
            btnModo.setText("Modo: " + (usandoPilha ? "Pilha" : "Fila"));
        });

        JButton btnReiniciar = new JButton("Reiniciar");
        btnReiniciar.addActionListener(e -> {
            tabuleiro.reiniciar();
            painelJogo.repaint();
        });

        JPanel painelBotoes = new JPanel();
        painelBotoes.add(btnModo);
        painelBotoes.add(btnReiniciar);

        setLayout(new BorderLayout());
        add(painelJogo, BorderLayout.CENTER);
        add(painelBotoes, BorderLayout.SOUTH);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}