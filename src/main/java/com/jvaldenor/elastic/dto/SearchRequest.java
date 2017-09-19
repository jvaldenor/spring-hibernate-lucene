package com.jvaldenor.elastic.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;

/**
 * Created by 81013534 on 13/09/2017.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchRequest {

    private String username;
    private String firstname;
    private String lastname;
    private int size;
    private int page;

}
