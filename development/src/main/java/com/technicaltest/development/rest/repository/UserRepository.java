package com.technicaltest.development.rest.repository;

import com.technicaltest.development.rest.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Page<User> findAll(Specification<User> specification, Pageable pageable);
    List<User> findAll(Specification<User> specification);
}
