package Aula01;
public class VideoDigital extends ItemBibliotecaDigital implements Baixavel, Visualizavel {
    private int duracao;
    private String resolucao;

    public VideoDigital(String titulo, String autor, int duracao, String resolucao) {
        super(titulo, autor);
        this.duracao = duracao;
        this.resolucao = resolucao;
    }

    public int getDuracao() {
        return duracao;
    }

    public String getResolucao() {
        return resolucao;
    }

    @Override
    public String descricao() {
        return "Vídeo Digital: " + getTitulo() + " - Autor: " + getAutor() + " (Duração: " + duracao + " min, Resolução: " + resolucao + ")";
    }

    @Override
    public void baixar() {
        System.out.println("Baixando Vídeo: " + getTitulo() + " em " + resolucao);
    }

    @Override
    public void visualizar() {
        System.out.println("Reproduzindo Vídeo: " + getTitulo() + " (Duração: " + duracao + " minutos)");
    }
}
