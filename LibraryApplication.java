import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LibraryApplication {
    public static void main(String[] args) {
        // Crear autores
        Author author1 = new Author("George Orwell", "george.orwell@example.com");
        Author author2 = new Author("Aldous Huxley", "aldous.huxley@example.com");

        // Crear géneros
        Genre genre1 = new Genre("Ciencia ficción");
        Genre genre2 = new Genre("Distopía");

        // Crear libros
        Book book1 = new Book("1984", author1, genre2, LocalDate.of(1949, 6, 8));
        Book book2 = new Book("Fahrenheit 451", author2, genre1, LocalDate.of(1953, 10, 19));

        // Agregar libros a la biblioteca
        List<Book> library = new ArrayList<>();
        library.add(book1);
        library.add(book2);

        // Imprimir detalles de la biblioteca
        System.out.println("Biblioteca:");
        for (Book book : library) {
            System.out.println(book.toString());
        }

        // Buscar libros por autor
        System.out.println("\nLibros de George Orwell:");
        for (Book book : library) {
            if (book.getAuthor().equals(author1)) {
                System.out.println(book.toString());
            }
        }

        // Buscar libros por género
        System.out.println("\nLibros de género Ciencia ficción:");
        for (Book book : library) {
            if (book.getGenre().equals(genre1)) {
                System.out.println(book.toString());
            }
        }

        // Buscar libros publicados antes de una fecha
        LocalDate publicationDateThreshold = LocalDate.of(1950, 1, 1);
        System.out.println("\nLibros publicados antes del 1 de enero de 1950:");
        for (Book book : library) {
            if (book.getPublicationDate().compareTo(publicationDateThreshold) < 0) {
                System.out.println(book.toString());
            }
        }
    }
}