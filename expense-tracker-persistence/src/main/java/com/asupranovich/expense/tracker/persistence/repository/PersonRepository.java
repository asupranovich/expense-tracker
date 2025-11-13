package com.asupranovich.expense.tracker.persistence.repository;

import com.asupranovich.expense.tracker.persistence.entity.PersonEntity;
import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CrudRepository<PersonEntity, Long> {

    Optional<PersonEntity> findByEmail(String email);

    List<PersonEntity> findByHouseholdId(Long householdId);

}
