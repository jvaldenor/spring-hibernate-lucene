package com.jvaldenor.elastic.repository;

import com.jvaldenor.elastic.dto.SearchRequest;
import com.jvaldenor.elastic.dto.SearchResponse;
import com.jvaldenor.elastic.model.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * Created by 81013534 on 15/09/2017.
 */
public interface UserSearch {

    SearchResponse search(SearchRequest searchRequest);
}
