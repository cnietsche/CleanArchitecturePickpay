package br.com.cnietsche.core.exception;

public class TaxNumberException extends Exception {

    private String code;

    public TaxNumberException(String message, String code) {
        super(message);
        this.code = code;
    }
}
