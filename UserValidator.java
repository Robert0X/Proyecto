public class UserValidator {
    public String validate(String value, Validator<String> validator) {
        if (!validator.validate(value)) {
            return validator.getMessage();
        }
        return null;
    }

    public boolean validateEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        return email.matches(emailRegex);
    }

    public boolean validatePassword(String password) {
        return password.length() >= 8;
    }

    public boolean validateAddress(String address) {
        String addressRegex = "^[a-zA-Z0-9_+&*-]+(?:[a-zA-Z0-9_+&*-]+)*$";
        return address.matches(addressRegex);
    }
}