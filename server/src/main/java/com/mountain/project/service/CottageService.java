package com.mountain.project.service;

import com.mountain.project.entity.CottageEntity;
import com.mountain.project.mapper.CottageMapper;
import com.mountain.project.model.CottageDto;
import com.mountain.project.repository.CottageRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class CottageService {

    private final CottageRepository cottageRepository;
    private final CottageMapper cottageMapper;

    public CottageService(CottageRepository cottageRepository, CottageMapper cottageMapper) {
        this.cottageRepository = cottageRepository;
        this.cottageMapper = cottageMapper;
    }

    public List<CottageDto> getAllCottages() {
        List<CottageEntity> cottageEntities = cottageRepository.findAll();
        return cottageMapper.convertListCottageEntityToListCottageDto(cottageEntities);
    }

    public CottageDto getCottageById(Long id) {
        Optional<CottageEntity> cottageEntityOptional = cottageRepository.findById(id);
        return cottageEntityOptional.map(cottageMapper::convertCottageEntityToCottageDto).orElse(null);
    }

    public CottageDto createCottage(CottageDto cottageDto) {
        CottageEntity cottageEntity = cottageMapper.convertCottageDtoToCottageEntity(cottageDto);
        CottageEntity savedCottageEntity = cottageRepository.save(cottageEntity);
        return cottageMapper.convertCottageEntityToCottageDto(savedCottageEntity);
    }

    public CottageDto updateCottage(Long id, CottageDto cottageDto) {
        Optional<CottageEntity> cottageEntityOptional = cottageRepository.findById(id);
        if (cottageEntityOptional.isPresent()) {
            CottageEntity cottageEntity = cottageEntityOptional.get();
            cottageEntity.setName(cottageDto.getName());
            cottageEntity.setDescription(cottageDto.getDescription());
            cottageEntity.setPremium(cottageDto.getPremium());
            CottageEntity updatedCottageEntity = cottageRepository.save(cottageEntity);
            return cottageMapper.convertCottageEntityToCottageDto(updatedCottageEntity);
        }
        return null;
    }

    public boolean deleteCottage(Long id) {
        Optional<CottageEntity> cottageEntityOptional = cottageRepository.findById(id);
        if (cottageEntityOptional.isPresent()) {
            cottageRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
