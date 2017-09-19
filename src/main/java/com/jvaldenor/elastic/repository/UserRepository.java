package com.jvaldenor.elastic.repository;

import com.jvaldenor.elastic.model.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by 81013534 on 15/09/2017.
 */
@Repository
public interface UserRepository extends PagingAndSortingRepository<User,Long>,UserSearch {
}
