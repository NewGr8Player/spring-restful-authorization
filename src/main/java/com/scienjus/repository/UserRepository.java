package com.scienjus.repository;

import com.scienjus.domain.User;
import org.springframework.data.repository.CrudRepository;

/**
 * 用户的CRUD基本操作
 *
 * @date 2017/10/06
 */
public interface UserRepository extends CrudRepository<User, String> {

    /**
     * 这个接口并没有明确的实现类，但仍然可以正常使用<br />
     *
     * @see <a href="https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repositories.query-methods.details"><b>Spring Data Jpa</b> - 3.4. Defining query methods</a>
     */
    User findByUsername(String username);
}
