package com.asupranovich.expense.tracker.persistence.repository;

import com.asupranovich.expense.tracker.persistence.entity.CategoryEntity;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends CrudRepository<CategoryEntity, Long> {

    List<CategoryEntity> findByHouseholdIdIsNull();

    @Query("SELECT c FROM CategoryEntity c WHERE (c.householdId = ?1 OR c.householdId is null) AND c.isDeleted = false")
    List<CategoryEntity> findByHouseholdIdEqualsOrHouseholdIdIsNull(Long householdId);

}
