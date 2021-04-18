package edu.ifma.lpweb.imobiliaria.service.exceptions;

public class UnableToSendEmailException extends Exception {
    public UnableToSendEmailException() {
        super("Not possible to send email");
    }
}
