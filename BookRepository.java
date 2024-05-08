import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class BookRepository {
    private List<Book> books;

    public BookRepository() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(Book book) {
        books.remove(book);
    }

    public List<Book> getBooks() {
        return new ArrayList<>(books);
    }

    public List<Book> getBooksByAuthor(Author author) {
        return getBooksByPredicate(book -> book.getAuthor().equals(author));
    }

    public List<Book> getBooksByGenre(Genre genre) {
        return getBooksByPredicate(book -> book.getGenre().equals(genre));
    }

    public List<Book> getBooksByTitle(String title) {
        return getBooksByPredicate(book -> book.getTitle().equals(title));
    }

    public Optional<Book> getBookByTitleAndAuthor(String title, Author author) {
        return books.stream()
                .filter(book -> book.getTitle().equals(title) && book.getAuthor().equals(author))
                .findFirst();
    }

    private List<Book> getBooksByPredicate(Predicate<Book> predicate) {
        List<Book> matchingBooks = new ArrayList<>();
        for (Book book : books) {
            if (predicate.test(book)) {
                matchingBooks.add(book);
            }
        }
        return matchingBooks;
    }
}