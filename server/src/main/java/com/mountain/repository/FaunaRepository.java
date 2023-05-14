package com.mountain.repository;

import com.mountain.entity.FaunaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FaunaRepository extends JpaRepository<FaunaEntity, Long> {
}
