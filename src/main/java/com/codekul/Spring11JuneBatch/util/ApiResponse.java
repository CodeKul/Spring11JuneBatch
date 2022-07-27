package com.codekul.Spring11JuneBatch.util;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiResponse<T> {
    private T result;
    private String message;
    private Integer status;
}
