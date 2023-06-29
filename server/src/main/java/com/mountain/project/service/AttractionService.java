package com.mountain.project.service;

import com.mountain.project.entity.AttractionEntity;
import com.mountain.project.enums.Mountain;
import com.mountain.project.mapper.AttractionMapper;
import com.mountain.project.model.AttractionDto;
import com.mountain.project.repository.AttractionRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AttractionService {

    private final AttractionRepository attractionRepository;
    private final AttractionMapper attractionMapper;

    @Autowired
    public AttractionService(AttractionRepository attractionRepository, AttractionMapper attractionMapper) {
        this.attractionRepository = attractionRepository;
        this.attractionMapper = attractionMapper;
    }

    public List<AttractionDto> getAllAttractionsForMountain(String mountain) {
        List<AttractionEntity> attractions = attractionRepository.findAll().stream()
                .filter(attractionEntity -> attractionEntity.getMountain().name().equals(mountain.toUpperCase()))
                .toList();

        return attractionMapper.convertListEntityToDto(attractions);
    }

    public AttractionDto getAttractionById(Long id) {
        Optional<AttractionEntity> attractionEntityOptional = attractionRepository.findById(id);
        return attractionEntityOptional.map(attractionMapper::convertAttractionEntityToDto).orElse(null);
    }

    public AttractionDto createAttraction(AttractionDto attractionDto) {
        AttractionEntity attractionEntity = attractionMapper.convertDtoToAttractionEntity(attractionDto);
        AttractionEntity savedAttractionEntity = attractionRepository.save(attractionEntity);
        return attractionMapper.convertAttractionEntityToDto(savedAttractionEntity);
    }

    public AttractionDto updateAttraction(Long id, AttractionDto attractionDto) {
        Optional<AttractionEntity> attractionEntityOptional = attractionRepository.findById(id);
        if (attractionEntityOptional.isPresent()) {
            AttractionEntity attractionEntity = attractionEntityOptional.get();
            attractionEntity.setName(attractionDto.getName());
            attractionEntity.setDescription(attractionDto.getDescription());
            attractionEntity.setLocation(attractionDto.getLocation());
            attractionEntity.setPremium(attractionDto.isPremium());

            AttractionEntity updatedAttractionEntity = attractionRepository.save(attractionEntity);
            return attractionMapper.convertAttractionEntityToDto(updatedAttractionEntity);
        }
        return null;
    }

    public void deleteAttraction(Long id) {
        attractionRepository.deleteById(id);
    }
}
