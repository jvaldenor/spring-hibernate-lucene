package com.jvaldenor.elastic.service;

import com.jvaldenor.elastic.dto.SearchRequest;
import com.jvaldenor.elastic.dto.SearchResponse;
import com.jvaldenor.elastic.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 81013534 on 14/09/2017.
 */
@Service
public class UserSearchService {
    @Autowired
    private UserRepository repository;

    public SearchResponse search(SearchRequest request) {
        return repository.search(request);
    }
}