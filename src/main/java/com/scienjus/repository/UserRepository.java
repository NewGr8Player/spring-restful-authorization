package com.scienjus.repository;

import com.scienjus.domain.User;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @since 2017/10/06
 * */
public interface UserRepository extends CrudRepository<User, String> {

    User findByUsername(String username);
}
