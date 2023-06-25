package com.mountain.project.repository;

import com.mountain.project.entity.CottageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CottageRepository extends JpaRepository<CottageEntity, Long> {

}
