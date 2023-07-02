package com.mountain.project.service;

import com.mountain.project.entity.LandmarkEntity;
import com.mountain.project.mapper.LandmarkMapper;
import com.mountain.project.model.LandmarkDto;
import com.mountain.project.repository.LandmarkRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

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
            throw new EntityNotFoundException("Landmark not found with ID: " + id);
        }
        return landmarkMapper.convertLandmarkEntityToLandmarkDto(landmarkEntity.get());
    }

    public List<LandmarkDto> getAllLandmarksForMountain(String mountain) {
        List<LandmarkEntity> landmarkEntities = landmarkRepository.findAll().stream()
                .filter(landmarkEntity -> landmarkEntity.getMountain().name().equals(mountain.toUpperCase()))
                .toList();
        return landmarkMapper.convertListLandmarkEntityToListLandmarkDto(landmarkEntities);
    }

    public LandmarkDto createLandmark(LandmarkDto landmarkDto) {
        LandmarkEntity landmarkEntity = landmarkMapper.convertLandmarkDtoToLandmarkEntity(landmarkDto);
        LandmarkEntity savedLandmarkEntity = landmarkRepository.save(landmarkEntity);
        return landmarkMapper.convertLandmarkEntityToLandmarkDto(savedLandmarkEntity);
    }

    public LandmarkDto updateLandmark(Long id, LandmarkDto landmarkDto) {
        Optional<LandmarkEntity> landmarkEntityOptional = landmarkRepository.findById(id);
        if (landmarkEntityOptional.isEmpty()) {
            throw new EntityNotFoundException("Landmark not found with ID: " + id);
        }
        LandmarkEntity landmarkEntity = landmarkEntityOptional.get();
        landmarkEntity.setName(landmarkDto.getName());
        landmarkEntity.setDescription(landmarkDto.getDescription());
        landmarkEntity.setLocation(landmarkDto.getLocation());

        LandmarkEntity updatedLandmarkEntity = landmarkRepository.save(landmarkEntity);
        return landmarkMapper.convertLandmarkEntityToLandmarkDto(updatedLandmarkEntity);
    }

    public void deleteLandmark(Long id) {
        if (!landmarkRepository.existsById(id)) {
            throw new EntityNotFoundException("Landmark not found with ID: " + id);
        }
        landmarkRepository.deleteById(id);
    }
}

