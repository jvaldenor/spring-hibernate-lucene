package com.jvaldenor.elastic.repository;

import com.jvaldenor.elastic.dto.SearchRequest;
import com.jvaldenor.elastic.dto.SearchResponse;
import com.jvaldenor.elastic.model.User;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang.StringUtils;
import org.apache.lucene.search.BooleanClause;
import org.apache.lucene.search.BooleanQuery;
import org.apache.lucene.search.Query;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.FullTextQuery;
import org.hibernate.search.jpa.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.time.ZoneId;

/**
 * Created by 81013534 on 15/09/2017.
 */
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserSearch {
    private static final ZoneId UTC = ZoneId.of("UTC");

    private final EntityManager entityManager;


    @Override
    @Transactional(readOnly = true)
    public SearchResponse search(SearchRequest request) {
        // Must be retrieved inside a transaction to take part of
        final FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(entityManager);

        // Prepare a search query builder
        QueryBuilder queryBuilder = fullTextEntityManager.getSearchFactory().buildQueryBuilder().forEntity(User.class).get();
        BooleanQuery bq = new BooleanQuery();

        if (!StringUtils.isBlank(request.getUsername())) {
            Query query = queryBuilder.keyword().wildcard().onField("username").matching(request.getUsername() + "*").createQuery();
            bq.add(new BooleanClause(query, BooleanClause.Occur.MUST));
        }
        if (!StringUtils.isBlank(request.getFirstname())) {
            Query query = queryBuilder.keyword().wildcard().onField("firstname").matching(request.getFirstname() + "*").createQuery();
            bq.add(new BooleanClause(query, BooleanClause.Occur.MUST));
        }
        if (!StringUtils.isBlank(request.getLastname())) {
            Query query = queryBuilder.keyword().wildcard().onField("lastname").matching(request.getLastname() + "*").createQuery();
            bq.add(new BooleanClause(query, BooleanClause.Occur.MUST));
        }
        FullTextQuery fullTextQuery = fullTextEntityManager.createFullTextQuery(bq, User.class);
        int size=1;
        if (0 != request.getSize()) {
            fullTextQuery.setMaxResults(request.getSize());
            size=request.getSize();
            int start = request.getSize() * request.getPage();
            fullTextQuery.setFirstResult(start);
        }

        SearchResponse response = new SearchResponse();
        int totalSize = fullTextQuery.getResultSize();
        response.setUsers(fullTextQuery.getResultList());
        response.setTotalResult(totalSize);
        response.setCurrentPage(request.getPage());
        response.setSize(request.getSize()==0?totalSize:request.getSize());
        response.setTotalPages(totalSize /size);
        return response;
    }


}
