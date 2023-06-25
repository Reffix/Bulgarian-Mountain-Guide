package com.mountain.project.repository;

import com.mountain.project.entity.LandmarkEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LandmarkRepository extends JpaRepository<LandmarkEntity, Long> {

}
