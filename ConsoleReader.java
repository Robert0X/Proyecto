import java.util.Scanner;

public class ConsoleReader {
    private Scanner scanner;

    public ConsoleReader() {
        this.scanner = new Scanner(System.in);
    }

    public <T> T readForm(Validator<T> validator) {
        String input;
        T value;
        boolean isValid;

        do {
            System.out.print("Ingrese un valor: ");
            input = scanner.nextLine();
            value = validator.fromString(input);
            isValid = validator.validate(value);

            if (!isValid) {
                System.out.println(validator.getMessage());
            }
        } while (!isValid);

        return value;
    }
}