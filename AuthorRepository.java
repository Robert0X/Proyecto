import java.util.List;

public interface AuthorRepository {
    List<Author> findAll();

    Author findById(Long id);

    List<Author> findByName(String name);

    List<Author> findByEmail(String email);

    void save(Author author);

    void deleteById(Long id);
}