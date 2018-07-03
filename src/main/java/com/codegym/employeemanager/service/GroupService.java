package com.codegym.employeemanager.service;

import com.codegym.employeemanager.model.Group;

public interface GroupService {

    Iterable<Group> getAll();

    Group findById(Long id);
}
