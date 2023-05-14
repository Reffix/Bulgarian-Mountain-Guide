package com.mountain.service;

import com.mountain.entity.LandmarkEntity;
import com.mountain.mapper.LandmarkMapper;
import com.mountain.model.LandmarkDto;
import com.mountain.repository.LandmarkRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class LandmarkService {

    private final LandmarkRepository landmarkRepository;
    private final LandmarkMapper landmarkMapper;

    public LandmarkService(LandmarkRepository landmarkRepository, LandmarkMapper landmarkMapper) {
        this.landmarkRepository = landmarkRepository;
        this.landmarkMapper = landmarkMapper;
    }

    public LandmarkDto getLandmarkById(Long id) {
        Optional<LandmarkEntity> landmarkEntity = landmarkRepository.findById(id);
        if (landmarkEntity.isEmpty()) {
            throw new RuntimeException("Landmark with id " + id + " not found");
        }
        return landmarkMapper.convertLandmarkEntityToLandmarkDto(landmarkEntity.get());
    }

    public List<LandmarkDto> getAllLandmarks() {
        List<LandmarkEntity> landmarks = landmarkRepository.findAll();
        return landmarkMapper.convertListLandmarkEntityToListLandmarkDto(landmarks);
    }
}
