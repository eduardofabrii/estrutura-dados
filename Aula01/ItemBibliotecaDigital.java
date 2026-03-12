package Aula01;
public abstract class ItemBibliotecaDigital {
    private String titulo;
    private String autor;

    public ItemBibliotecaDigital(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
    }

    public abstract String descricao();

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }
}