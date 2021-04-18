package edu.ifma.lpweb.imobiliaria.service.exceptions;

public class UnableToCreateException extends Throwable {
    public UnableToCreateException(String message) {
        super("Unable to insert new instance due to: " + message);
    }
}
