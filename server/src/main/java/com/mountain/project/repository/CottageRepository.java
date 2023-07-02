package com.mountain.project.repository;

import com.mountain.project.entity.CottageEntity;
import com.mountain.project.enums.Mountain;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CottageRepository extends JpaRepository<CottageEntity, Long> {
    List<CottageEntity> findAllByMountain(Mountain mountain, Pageable pageable);
}
