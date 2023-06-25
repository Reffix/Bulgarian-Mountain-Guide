package com.mountain.project.repository;

import com.mountain.project.entity.AttractionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttractionRepository extends JpaRepository<AttractionEntity, Long> {

}

