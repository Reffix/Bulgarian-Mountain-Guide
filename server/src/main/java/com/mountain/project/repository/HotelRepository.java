package com.mountain.project.repository;

import com.mountain.project.entity.HotelEntity;
import com.mountain.project.enums.Mountain;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelRepository extends JpaRepository<HotelEntity, Long> {
    List<HotelEntity> findAllByMountain(Mountain mountain, Pageable pageable);
}
