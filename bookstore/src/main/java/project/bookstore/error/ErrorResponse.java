package project.bookstore.error;

import org.springframework.http.HttpStatus;

public class ErrorResponse {
    private HttpStatus status;
    private Integer code;
    private String message;

    public ErrorResponse(HttpStatus status, Integer code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public Integer getCode() { return  code; }

    public String getMessage() {
        return message;
    }
}
