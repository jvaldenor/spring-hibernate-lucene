package com.jvaldenor.elastic.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by 81013534 on 11/09/2017.
 */
@Data
@AllArgsConstructor
public class ApiGlobalError {
    private String code;
    private String message;
}
