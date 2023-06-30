package com.mountain.project.repository;

import com.mountain.project.entity.AttractionEntity;
import com.mountain.project.entity.HotelEntity;
import com.mountain.project.enums.Mountain;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttractionRepository extends JpaRepository<AttractionEntity, Long> {
    List<AttractionEntity> findAllByMountain(Mountain mountain, Pageable pageable);
}

