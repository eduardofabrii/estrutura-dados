package Aula04.ui;

import Aula04.algoritmo.FloodFill;
import Aula04.modelo.Tabuleiro;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PainelJogo extends JPanel {

    private Tabuleiro tabuleiro;
    private FloodFill floodFill;
    private boolean usandoPilha;
    private boolean pintando = false;

    private static final Color[] CORES = {
            new Color(220, 60, 60),
            new Color(60, 130, 220),
            new Color(60, 180, 60),
            new Color(220, 160, 0),
            new Color(160, 60, 220),
            new Color(0, 180, 180),
    };

    private int indiceCor = 0;

    public PainelJogo(Tabuleiro tabuleiro, boolean usandoPilha) {
        this.tabuleiro = tabuleiro;
        this.floodFill = new FloodFill();
        this.usandoPilha = usandoPilha;

        setPreferredSize(new Dimension(tabuleiro.getLargura(), tabuleiro.getAltura()));

        addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (pintando) return;
                processarClique(e.getX(), e.getY());
            }
        });
    }

    private void processarClique(int x, int y) {
        if (x < 0 || x >= tabuleiro.getLargura()) return;
        if (y < 0 || y >= tabuleiro.getAltura()) return;

        int corClicada = tabuleiro.getRGB(x, y);
        if (corClicada != Color.WHITE.getRGB()) return;

        Color cor = CORES[indiceCor % CORES.length];
        indiceCor++;
        pintando = true;

        Thread thread = new Thread(() -> {
            Runnable aoMudarPixel = () -> {
                repaint();
                try { Thread.sleep(2); } catch (InterruptedException ignored) {}
            };

            if (usandoPilha) {
                floodFill.executarComPilha(tabuleiro, x, y, cor, aoMudarPixel);
            } else {
                floodFill.executarComFila(tabuleiro, x, y, cor, aoMudarPixel);
            }

            pintando = false;
            repaint();
        });

        thread.start();
    }

    public void setUsandoPilha(boolean usandoPilha) {
        this.usandoPilha = usandoPilha;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(tabuleiro.getImagem(), 0, 0, this);
    }
}