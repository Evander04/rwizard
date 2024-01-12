package utils;

import lombok.Data;

@Data
public class Response {
    private Object body;
    private Integer code;
    private String message;
    private Exception exception;
}
