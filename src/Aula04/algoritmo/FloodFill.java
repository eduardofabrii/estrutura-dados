package Aula04.algoritmo;

import Aula04.estruturas.Fila;
import Aula04.estruturas.Pilha;
import Aula04.modelo.Pixel;
import Aula04.modelo.Tabuleiro;

import java.awt.Color;

public class FloodFill {

    private static final int[][] DIRECOES = {{0,-1},{0,1},{-1,0},{1,0}};

    public void executarComPilha(Tabuleiro tabuleiro, int x, int y, Color novaCor, Runnable aoMudarPixel) {
        int corFundo = tabuleiro.getRGB(x, y);
        int novaCorRGB = novaCor.getRGB();
        if (corFundo == novaCorRGB) return;

        Pilha<Pixel> pilha = new Pilha<>();
        pilha.push(new Pixel(x, y));

        while (!pilha.isEmpty()) {
            Pixel atual = pilha.pop();
            int px = atual.getX();
            int py = atual.getY();

            if (px < 0 || px >= tabuleiro.getLargura()) continue;
            if (py < 0 || py >= tabuleiro.getAltura()) continue;
            if (tabuleiro.getRGB(px, py) != corFundo) continue;

            tabuleiro.setRGB(px, py, novaCorRGB);
            tabuleiro.salvarFrame();
            if (aoMudarPixel != null) aoMudarPixel.run();

            for (int[] dir : DIRECOES)
                pilha.push(new Pixel(px + dir[0], py + dir[1]));
        }
    }

    public void executarComFila(Tabuleiro tabuleiro, int x, int y, Color novaCor, Runnable aoMudarPixel) {
        int corFundo = tabuleiro.getRGB(x, y);
        int novaCorRGB = novaCor.getRGB();
        if (corFundo == novaCorRGB) return;

        Fila<Pixel> fila = new Fila<>();
        fila.enqueue(new Pixel(x, y));

        while (!fila.isEmpty()) {
            Pixel atual = fila.front();
            fila.dequeue();
            int px = atual.getX();
            int py = atual.getY();

            if (px < 0 || px >= tabuleiro.getLargura()) continue;
            if (py < 0 || py >= tabuleiro.getAltura()) continue;
            if (tabuleiro.getRGB(px, py) != corFundo) continue;

            tabuleiro.setRGB(px, py, novaCorRGB);
            tabuleiro.salvarFrame();
            if (aoMudarPixel != null) aoMudarPixel.run();

            for (int[] dir : DIRECOES)
                fila.enqueue(new Pixel(px + dir[0], py + dir[1]));
        }
    }
}