package br.com.cnietsche.core.exception;

public class TransferException extends Exception {

    private String code;

    public TransferException(String message, String code) {
        super(message);
        this.code = code;
    }
}
