package main.api.exceptions;

public class NoFirefightersFoundException extends Exception {
    public NoFirefightersFoundException() {
        super("There are no firefighters found in the city");
    }
}
