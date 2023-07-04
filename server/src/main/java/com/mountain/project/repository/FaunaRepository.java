package com.mountain.project.repository;

import com.mountain.project.entity.FaunaEntity;
import com.mountain.project.enums.Mountain;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FaunaRepository extends JpaRepository<FaunaEntity, Long> {

    List<FaunaEntity> findAllByMountain(Mountain mountain, Pageable pageable);
}
