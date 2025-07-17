package br.com.cnietsche.core.exception.enums;

public enum ErrorCodeEnum {

    ON0001("Invalid Tax Number", "ON-0001"),
    TR0001("Transfers are not allowed for shopkeeper users", "TR-0001"),
    TR0002("Insufficient balance", "TR-0002"),
    TP0001("Invalid PIN", "TP-0001")
    ;

    private String message;
    private String code;

    ErrorCodeEnum(String message, String code) {
        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
