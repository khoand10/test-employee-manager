package com.codegym.employeemanager.repository;

import com.codegym.employeemanager.model.Group;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface GroupRepository extends PagingAndSortingRepository<Group , Long> {
}
