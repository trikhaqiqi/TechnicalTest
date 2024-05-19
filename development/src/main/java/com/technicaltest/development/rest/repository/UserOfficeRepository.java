package com.technicaltest.development.rest.repository;

import com.technicaltest.development.rest.model.UserOffice;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserOfficeRepository extends JpaRepository<UserOffice, Integer> {
    Page<UserOffice> findAll(Specification<UserOffice> specification, Pageable pageable);
    List<UserOffice> findAll(Specification<UserOffice> specification);
}
