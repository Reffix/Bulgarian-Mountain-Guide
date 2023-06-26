package com.mountain.project.repository;

import com.mountain.project.entity.FloraEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FloraRepository extends JpaRepository<FloraEntity, Long> {
}
