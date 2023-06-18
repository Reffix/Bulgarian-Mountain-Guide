package com.mountain.service;

import com.mountain.entity.AttractionEntity;
import com.mountain.enums.Mountain;
import com.mountain.mapper.AttractionMapper;
import com.mountain.model.AttractionDto;
import com.mountain.repository.AttractionRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class AttractionService {

    private final AttractionRepository attractionRepository;
    private final AttractionMapper attractionMapper;

    public AttractionService(AttractionRepository attractionRepository, AttractionMapper attractionMapper) {
        this.attractionRepository = attractionRepository;
        this.attractionMapper = attractionMapper;
    }

    public AttractionDto getAttractionById(Long id) {
        Optional<AttractionEntity> attractionEntity = attractionRepository.findById(id);
        if (attractionEntity.isEmpty()) {
            throw new RuntimeException("Attraction with id " + id + " not found");
        }
        return attractionMapper.convertAttractionEntityToAttractionDto(attractionEntity.get());
    }

    public List<AttractionDto> getAllAttractionsForMountain(Mountain mountain) {
        List<AttractionEntity> attractions = attractionRepository.findAll().stream()
                .filter(attractionEntity -> attractionEntity.getMountain().equals(mountain))
                .collect(Collectors.toList());
        
        return attractionMapper.convertListAttractionEntityToListAttractionDto(attractions);
    }
}
