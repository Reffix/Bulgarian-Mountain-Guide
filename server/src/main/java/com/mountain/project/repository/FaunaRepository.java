package com.mountain.project.repository;

import com.mountain.project.entity.FaunaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FaunaRepository extends JpaRepository<FaunaEntity, Long> {
}
