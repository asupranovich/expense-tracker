package com.asupranovich.expense.tracker.persistence.repository;

import com.asupranovich.expense.tracker.domain.model.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {

}
