package Aula01;
public class Ebook extends ItemBibliotecaDigital implements Baixavel {
    public Ebook(String titulo, String autor) {
        super(titulo, autor);
    }

    @Override
    public String descricao() {
        return "Ebook: " + getTitulo() + " - Autor: " + getAutor();
    }

    @Override
    public void baixar() {
        System.out.println("Baixando Ebook: " + getTitulo());
    }
}
