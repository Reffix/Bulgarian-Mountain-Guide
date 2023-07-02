package com.mountain.project.repository;

import com.mountain.project.entity.AttractionEntity;
import com.mountain.project.enums.Mountain;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AttractionRepository extends JpaRepository<AttractionEntity, Long> {
    List<AttractionEntity> findAllByMountain(Mountain mountain, Pageable pageable);
}

