package Aula01;
public class Main {
    public static void main(String[] args) {
        Ebook ebook1 = new Ebook("Clean Code", "Eduardo");
        Ebook ebook2 = new Ebook("O programador maluco", "Davi");

        VideoDigital video1 = new VideoDigital("Java", "João", 120, "1080p");
        VideoDigital video2 = new VideoDigital("Database", "Joana", 90, "720p");

        System.out.println("===== DESCRIÇÕES =====\n");
        System.out.println(ebook1.descricao());
        System.out.println(ebook2.descricao());
        System.out.println(video1.descricao());
        System.out.println(video2.descricao());

        System.out.println("\n===== DOWNLOADS =====\n");
        ebook1.baixar();
        ebook2.baixar();
        video1.baixar();
        video2.baixar();

        System.out.println("\n===== VISUALIZAÇÕES =====\n");
        video1.visualizar();
        video2.visualizar();
    }
}
