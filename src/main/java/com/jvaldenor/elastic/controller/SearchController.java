package com.jvaldenor.elastic.controller;

import com.jvaldenor.elastic.dto.ApiErrorsResponse;
import com.jvaldenor.elastic.dto.SearchRequest;
import com.jvaldenor.elastic.dto.SearchResponse;
import com.jvaldenor.elastic.service.UserSearchService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 81013534 on 14/09/2017.
 */


@Api(value = "/", description = "the users API")
@RestController
public class SearchController {

    @Autowired
    private UserSearchService userSearch;

    @ApiOperation(value = "", notes = "", response = SearchResponse.class, tags = {"User"},
            authorizations = {@Authorization(value = "Authorization")})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "User details", response = SearchResponse.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 400, message = "Validation Error", response = ApiErrorsResponse.class),
            @ApiResponse(code = 500, message = "The server encountered an unexpected condition which prevented it from fulfilling the request.",
                    response = ApiErrorsResponse.class)})
    @RequestMapping(value = "search",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.POST)
    public ResponseEntity<SearchResponse> search(@ApiParam(name = "search", value = "Search parameters", required = true) @RequestBody SearchRequest searchRequest) {
//        SearchResponse response = new SearchResponse();
        SearchResponse response = userSearch.search(searchRequest);
//        response.setSearch(search);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


}
