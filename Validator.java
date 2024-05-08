public interface Validator<T> {
    T fromString(String input);

    boolean validate(T value);

    String getMessage();
}