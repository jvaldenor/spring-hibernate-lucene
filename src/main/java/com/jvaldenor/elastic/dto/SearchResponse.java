package com.jvaldenor.elastic.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 81013534 on 13/09/2017.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchResponse {

    private List<UserDTO> users = new ArrayList<>();
    private int size;
    private int totalResult;
    private int currentPage;
    private int totalPages;

}
