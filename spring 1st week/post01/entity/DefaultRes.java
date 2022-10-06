package com.sparta.post01.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class DefaultRes<T> {

    private int success;
    private String responseMessage;
    private T data;

    private String error;

    public DefaultRes(final int statusCode, final String responseMessage, final String error){
        this.success = statusCode;
        this.responseMessage = responseMessage;
        this.data = null;
        this.error = error;
    }

    public static<T> DefaultRes res(final int statusCode, final String responseMessage, final T t){
        return DefaultRes.<T>builder()
                .data(t)
                .success(statusCode)
                .responseMessage(responseMessage)
                .error(builder().error)
                .build();
    }
}
