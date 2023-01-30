package com.lewis.seasolutions.repositories;

import com.lewis.seasolutions.domain.entities.StateCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StateCodeRepository extends JpaRepository<StateCode, Long> {
}
