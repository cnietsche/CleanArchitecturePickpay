package br.com.cnietsche.core.exception.enums;

public enum ErrorCodeEnum {

    AU0001("There was an error during the user authentication", "AU-0001"),
    ON0001("Invalid tax number", "ON-0001"),
    ON0002("Unavailable tax number", "ON-0002"),
    ON0003("Unavailable email", "ON-0003"),
    ON0004("There was an error during the creation of the user", "ON-0004"),
    TR0001("Transfers are not allowed for shopkeeper users", "TR-0001"),
    TR0002("Insufficient balance", "TR-0002"),
    TR0003("There was an error during the transfer", "TR-0003"),
    TR0004("Unauthorized transfer", "TR-0004"),
    TP0001("Invalid PIN", "TP-0001"),
    WA0001("Wallet not found", "WA-0001"),
    NO0001("There was an error during the user notification", "NO-0001"),
    PN0001("Bloked transaction PIN", "PN-0001"),
    PN0002("Incorrect PIN, %d attempt(s) left", "PN-0002")
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

    public static String getPN0002Message(Integer attempt) {
        return String.format(PN0002.getMessage(), attempt);
    }
}
