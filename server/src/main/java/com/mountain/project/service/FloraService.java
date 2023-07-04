package com.mountain.project.service;

import com.mountain.project.entity.FaunaEntity;
import com.mountain.project.entity.FloraEntity;
import com.mountain.project.enums.Mountain;
import com.mountain.project.mapper.FloraMapper;
import com.mountain.project.model.FloraDto;
import com.mountain.project.repository.FloraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class FloraService {
    private final FloraRepository floraRepository;
    private final FloraMapper floraMapper;

    @Autowired
    public FloraService(FloraRepository floraRepository, FloraMapper floraMapper) {
        this.floraRepository = floraRepository;
        this.floraMapper = floraMapper;
    }

    public FloraDto getFloraById(Long id) {
        Optional<FloraEntity> floraEntity = floraRepository.findById(id);
        if (floraEntity.isEmpty()) {
            throw new EntityNotFoundException("Flora not found with ID: " + id);
        }
        return floraMapper.convertFloraEntityToFloraDto(floraEntity.get());
    }

    public List<FloraDto> getAllFlorasForMountain(String mountain, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        List<FloraEntity> floras = floraRepository.findAllByMountain(Mountain.valueOf(mountain.toUpperCase()),
                pageable);
        return floraMapper.convertListFloraEntityToListFloraDto(floras);
    }

    public FloraDto createFlora(FloraDto floraDto) {
        FloraEntity floraEntity = floraMapper.convertFloraDtoToFloraEntity(floraDto);
        FloraEntity savedFloraEntity = floraRepository.save(floraEntity);
        return floraMapper.convertFloraEntityToFloraDto(savedFloraEntity);
    }

    public FloraDto updateFlora(Long id, FloraDto floraDto) {
        Optional<FloraEntity> floraEntityOptional = floraRepository.findById(id);
        if (floraEntityOptional.isEmpty()) {
            throw new EntityNotFoundException("Flora not found with ID: " + id);
        }
        FloraEntity floraEntity = floraEntityOptional.get();
        floraEntity.setName(floraDto.getName());
        floraEntity.setDescription(floraDto.getDescription());
        floraEntity.setEdible(floraDto.getEdible());
        floraEntity.setPicture(floraDto.getPicture());

        FloraEntity updatedFloraEntity = floraRepository.save(floraEntity);
        return floraMapper.convertFloraEntityToFloraDto(updatedFloraEntity);
    }

    public void deleteFlora(Long id) {
        if (!floraRepository.existsById(id)) {
            throw new EntityNotFoundException("Flora not found with ID: " + id);
        }
        floraRepository.deleteById(id);
    }
}
