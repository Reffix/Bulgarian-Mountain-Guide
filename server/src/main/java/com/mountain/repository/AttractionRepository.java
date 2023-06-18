package com.mountain.repository;

import com.mountain.entity.AttractionEntity;
import com.mountain.entity.LandmarkEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttractionRepository extends JpaRepository<AttractionEntity, Long> {

}
