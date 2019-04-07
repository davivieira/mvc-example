package com.todolist.services.helpers;

import org.springframework.http.HttpStatus;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class ResponseBuilder {

    private Object responseObject;
    private String responseMessage;
    private HttpStatus httpStatus;

    private Response<?> build() {

        ResponseMap<String, Object> responseMap = new ResponseMap<>();
        responseMap.put("response", responseObject);
        responseMap.put("message", responseMessage);

        return new Response<>(responseMap, this.httpStatus);
    }

    private ResponseBuilder withResponseObject(@Nullable Object responseObject) {
        this.responseObject = responseObject;
        return this;
    }

    private ResponseBuilder withResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
        return this;
    }

    private ResponseBuilder withHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
        return this;
    }

    public Response getResponseContent(Object body, String successMessage, String failureMessage) {
        if (body == null) {
            this.withResponseMessage(failureMessage)
                    .withHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
            this.withResponseMessage(successMessage)
                    .withResponseObject(body)
                    .withHttpStatus(HttpStatus.OK);
        }

        return this.build();
    }

    public Response getResponseContent(boolean wasSuccessful, String message) {
        if (wasSuccessful) {
            this.withResponseMessage(message)
                    .withHttpStatus(HttpStatus.OK);
        } else {
            this.withResponseMessage(message)
                    .withHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return this.build();
    }
}
