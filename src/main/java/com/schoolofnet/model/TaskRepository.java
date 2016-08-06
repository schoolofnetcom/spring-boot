package com.schoolofnet.model;


import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface TaskRepository extends CrudRepository<Task, Long> {

    public Task findByName(String name);
    public Task findByNameIgnoreCase(String name);
    public Task findByNameAndId(String name, Long id);
    public List<Task> findAllByOrderByNameAsc();
}
