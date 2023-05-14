package com.mountain.service;

import com.mountain.entity.FloraEntity;
import com.mountain.mapper.FloraMapper;
import com.mountain.model.FloraDto;
import com.mountain.repository.FloraRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
            throw new RuntimeException("Flora with id " + id + " not found");
        }
        return floraMapper.convertFloraEntityToFloraDto(floraEntity.get());
    }

    public List<FloraDto> getAllFloras() {
        List<FloraEntity> floras = floraRepository.findAll();
        return floraMapper.convertListFloraEntityToListFloraDto(floras);
    }
}
