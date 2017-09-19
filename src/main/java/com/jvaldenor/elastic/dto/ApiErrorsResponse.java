package com.jvaldenor.elastic.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * Created by 81013534 on 11/09/2017.
 */
@Data
@AllArgsConstructor
public class ApiErrorsResponse {
    private List<ApiFieldError> fieldErrors;
    private List<ApiGlobalError> globalErrors;
}
