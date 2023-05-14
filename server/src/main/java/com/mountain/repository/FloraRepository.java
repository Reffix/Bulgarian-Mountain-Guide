package com.mountain.repository;

import com.mountain.entity.FloraEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FloraRepository extends JpaRepository<FloraEntity, Long> {
}
