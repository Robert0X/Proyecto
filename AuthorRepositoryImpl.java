import java.util.*;

public class AuthorRepositoryImpl implements AuthorRepository {
    private Map<Long, Author> authorsById;
    private Map<String, List<Author>> authorsByName;
    private Map<String, List<Author>> authorsByEmail;

    public AuthorRepositoryImpl() {
        authorsById = new HashMap<>();
        authorsByName = new HashMap<>();
        authorsByEmail = new HashMap<>();
    }

    @Override
    public List<Author> findAll() {
        return new ArrayList<>(authorsById.values());
    }

    @Override
    public Author findById(Long id) {
        return authorsById.get(id);
    }

    @Override
    public List<Author> findByName(String name) {
        return authorsByName.getOrDefault(name, new ArrayList<>());
    }

    @Override
    public List<Author> findByEmail(String email) {
        return authorsByEmail.getOrDefault(email, new ArrayList<>());
    }

    @Override
    public void save(Author author) {
        Long id = authorsById.size() + 1L;
        author.setId(id);
        authorsById.put(id, author);

        List<Author> authorsByNameList = authorsByName.getOrDefault(author.getName(), new ArrayList<>());
        authorsByNameList.add(author);
        authorsByName.put(author.getName(), authorsByNameList);

        List<Author> authorsByEmailList = authorsByEmail.getOrDefault(author.getEmail(), new ArrayList<>());
        authorsByEmailList.add(author);
        authorsByEmail.put(author.getEmail(), authorsByEmailList);
    }

    @Override
    public void deleteById(Long id) {
        Author author = authorsById.get(id);
        if (author != null) {
            authorsById.remove(id);

            authorsByName.get(author.getName()).remove(author);
            if (authorsByName.get(author.getName()).isEmpty()) {
                authorsByName.remove(author.getName());
            }

            authorsByEmail.get(author.getEmail()).remove(author);
            if (authorsByEmail.get(author.getEmail()).isEmpty()) {
                authorsByEmail.remove(author.getEmail());
            }
        }
    }
}