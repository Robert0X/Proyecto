import java.util.*;

public class Administrator extends User {
    private final List<String> privileges;

    public Administrator(String email, String password, String address, List<String> privileges) {
        super(email, password, address);
        this.privileges = privileges != null ? privileges : new ArrayList<>();
    }

    public Administrator(String email, String password, String address) {
        this(email, password, address, new ArrayList<>());
    }

    public List<String> getPrivileges() {
        return privileges;
    }

    @Override
    public void validate() {
        List<String> errors = new ArrayList<>();
        if (!validateEmail(getEmail())) {
            errors.add("El correo electrónico no es válido");
        }
        if (!validatePassword(getPassword())) {
            errors.add("La contraseña debe tener al menos 8 caracteres");
        }
        if (getAddress() == null || getAddress().isEmpty()) {
            errors.add("La dirección no puede estar vacía");
        }
        if (privileges == null || privileges.isEmpty()) {
            errors.add("Los privilegios no pueden estar vacíos");
        }
        if (!errors.isEmpty()) {
            throw new IllegalArgumentException(String.join(", ", errors));
        }
    }

    private boolean validateEmail(String email) {
        String emailRegex = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
        return email.matches(emailRegex);
    }

    private boolean validatePassword(String password) {
        return password.length() >= 8;
    }
}