package com.todolist.services.helpers;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;

public class Response<T> extends HttpEntity {

    private T responseObject;
    private String responseMessage;
    private HttpStatus status;

    public Response(T responseObject, HttpStatus status) {
        super(responseObject);
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }
}
