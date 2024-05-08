import java.util.*;

public class RegularUser {
    private String email;
    private String password;
    private String address;

    public RegularUser() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void validate() {
        ConsoleReader consoleReader = new ConsoleReader();
        UserValidator userValidator = new UserValidator();

        Validator<String> emailValidator = new Validator<String>() {
            @Override
            public boolean validate(String value) {
                return userValidator.validateEmail(value);
            }

            @Override
            public String getMessage() {
                return "El email ingresado no es válido.";
            }

            @Override
            public String fromString(String value) {
                return value;
            }
        };

        Validator<String> passwordValidator = new Validator<String>() {
            @Override
            public boolean validate(String value) {
                return userValidator.validatePassword(value);
            }

            @Override
            public String getMessage() {
                return "La contraseña ingresada no es válida.";
            }

            @Override
            public String fromString(String value) {
                return value;
            }
        };

        Validator<String> addressValidator = new Validator<String>() {
            @Override
            public boolean validate(String value) {
                return userValidator.validateAddress(value);
            }

            @Override
            public String getMessage() {
                return "La dirección ingresada no es válida.";
            }

            @Override
            public String fromString(String value) {
                return value;
            }
        };

        String validationError = userValidator.validate(this.getEmail(), emailValidator);

        if (validationError != null) {
            System.out.println(validationError);
            this.setEmail(consoleReader.readForm(emailValidator));
        }

        validationError = userValidator.validate(this.getPassword(), passwordValidator);

        if (validationError != null) {
            System.out.println(validationError);
            this.setPassword(consoleReader.readForm(passwordValidator));
        }

        validationError = userValidator.validate(this.getAddress(), addressValidator);

        if (validationError != null) {
            System.out.println(validationError);
            this.setAddress(consoleReader.readForm(addressValidator));
        }
    }
}