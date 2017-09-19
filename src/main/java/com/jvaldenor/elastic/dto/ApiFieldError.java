package com.jvaldenor.elastic.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by 81013534 on 11/09/2017.
 */
@Data
@AllArgsConstructor
public class ApiFieldError {
    private String field;
    private String code;
    private Object rejectedValue;
    private String message;
}
