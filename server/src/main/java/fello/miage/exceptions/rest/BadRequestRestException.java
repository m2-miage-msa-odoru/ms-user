package fello.miage.exceptions.rest;

public class BadRequestRestException extends RuntimeException {
    public BadRequestRestException(String message) {
        super(message);
    }
}
