package Aula04.modelo;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Tabuleiro {
    private BufferedImage imagem;
    private int largura;
    private int altura;
    private int frameCount = 0;
    private String pastaFrames = "frames/";

    public Tabuleiro(int largura, int altura) {
        this.largura = largura;
        this.altura = altura;
        this.imagem = gerarImagem(largura, altura);
        new File(pastaFrames).mkdirs();
    }

    private BufferedImage gerarImagem(int w, int h) {
        BufferedImage img = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = img.createGraphics();

        // Fundo branco
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, w, h);

        int esp = 3;

        // Borda externa
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, w, esp);
        g.fillRect(0, h - esp, w, esp);
        g.fillRect(0, 0, esp, h);
        g.fillRect(w - esp, 0, esp, h);

        // Casa
        int casaX = 60;
        int casaY = 200;
        int casaW = 180;
        int casaH = 160;

        // Corpo da casa
        desenharRetangulo(g, casaX, casaY, casaW, casaH, esp);

        // Telhado (triângulo)
        int[] txs = {casaX, casaX + casaW / 2, casaX + casaW};
        int[] tys = {casaY, casaY - 60, casaY};
        desenharTriangulo(g, txs, tys, esp);

        // Porta da casa
        desenharRetangulo(g, casaX + 70, casaY + 80, 40, 80, esp);

        // Janela esquerda
        desenharRetangulo(g, casaX + 15, casaY + 30, 45, 45, esp);

        // Janela direita
        desenharRetangulo(g, casaX + casaW - 60, casaY + 30, 45, 45, esp);

        // Prédio
        int predioX = 340;
        int predioY = 80;
        int predioW = 180;
        int predioH = 340;

        // Corpo do prédio
        desenharRetangulo(g, predioX, predioY, predioW, predioH, esp);

        // Janelas do prédio (3 colunas x 4 linhas)
        int janelaW = 30;
        int janelaH = 30;
        int espacoX = (predioW - 3 * janelaW) / 4;
        int espacoY = (predioH - 4 * janelaH) / 5;

        for (int col = 0; col < 3; col++) {
            for (int row = 0; row < 4; row++) {
                int jx = predioX + espacoX + col * (janelaW + espacoX);
                int jy = predioY + espacoY + row * (janelaH + espacoY);
                desenharRetangulo(g, jx, jy, janelaW, janelaH, esp);
            }
        }

        // Porta do prédio
        desenharRetangulo(g, predioX + predioW / 2 - 20, predioY + predioH - 60, 40, 60, esp);

        // Chão
        g.setColor(Color.BLACK);
        g.fillRect(0, h - 80, w, esp);

        g.dispose();
        return img;
    }

    private void desenharRetangulo(Graphics2D g, int x, int y, int w, int h, int esp) {
        g.setColor(Color.BLACK);
        g.fillRect(x, y, w, h);
        g.setColor(Color.WHITE);
        g.fillRect(x + esp, y + esp, w - esp * 2, h - esp * 2);
    }

    private void desenharTriangulo(Graphics2D g, int[] xs, int[] ys, int esp) {
        g.setColor(Color.BLACK);
        g.fillPolygon(xs, ys, 3);

        int[] xsInt = {xs[0] + esp * 3, xs[1], xs[2] - esp * 3};
        int[] ysInt = {ys[0], ys[1] + esp * 4, ys[2]};
        g.setColor(Color.WHITE);
        g.fillPolygon(xsInt, ysInt, 3);
    }

    public void reiniciar() {
        this.imagem = gerarImagem(largura, altura);
        this.frameCount = 0;
    }

    public void salvarImagemInicial() {
        salvarArquivo("imagem_original.png");
    }

    public void salvarFrame() {
        frameCount++;
        salvarArquivo(String.format(pastaFrames + "frame_%05d.png", frameCount));
    }

    private void salvarArquivo(String caminho) {
        try {
            ImageIO.write(imagem, "PNG", new File(caminho));
        } catch (IOException e) {
            System.err.println("Erro ao salvar: " + e.getMessage());
        }
    }

    public int getRGB(int x, int y) { return imagem.getRGB(x, y); }

    public void setRGB(int x, int y, int rgb) { imagem.setRGB(x, y, rgb); }

    public int getLargura() { return largura; }

    public int getAltura() { return altura; }

    public BufferedImage getImagem() { return imagem; }
}