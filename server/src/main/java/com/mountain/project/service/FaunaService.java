package com.mountain.project.service;

import com.mountain.project.entity.FaunaEntity;
import com.mountain.project.enums.Mountain;
import com.mountain.project.mapper.FaunaMapper;
import com.mountain.project.model.FaunaDto;
import com.mountain.project.repository.FaunaRepository;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityNotFoundException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class FaunaService {

    private final FaunaRepository faunaRepository;
    private final FaunaMapper faunaMapper;

    public FaunaService(FaunaRepository faunaRepository, FaunaMapper faunaMapper) {
        this.faunaRepository = faunaRepository;
        this.faunaMapper = faunaMapper;
    }

    public FaunaDto getFaunaById(Long id) {
        Optional<FaunaEntity> faunaEntity = faunaRepository.findById(id);
        if (faunaEntity.isEmpty()) {
            throw new EntityNotFoundException("Fauna not found with ID: " + id);
        }
        return faunaMapper.convertFaunaEntityToFaunaDto(faunaEntity.get());
    }

    public List<FaunaDto> getAllFaunasForMountain(String mountain, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        List<FaunaEntity> faunaEntities = faunaRepository.findAllByMountain(Mountain.valueOf(mountain.toUpperCase()),
                pageable);
        return faunaMapper.convertListFaunaEntityToListFaunaDto(faunaEntities);
    }

    public FaunaDto createFauna(FaunaDto faunaDto) {
        FaunaEntity faunaEntity = faunaMapper.convertFaunaDtoToFaunaEntity(faunaDto);
        FaunaEntity savedFaunaEntity = faunaRepository.save(faunaEntity);
        return faunaMapper.convertFaunaEntityToFaunaDto(savedFaunaEntity);
    }

    public FaunaDto updateFauna(Long id, FaunaDto faunaDto) {
        Optional<FaunaEntity> faunaEntityOptional = faunaRepository.findById(id);
        if (faunaEntityOptional.isEmpty()) {
            throw new EntityNotFoundException("Fauna not found with ID: " + id);
        }
        FaunaEntity faunaEntity = faunaEntityOptional.get();
        faunaEntity.setName(faunaDto.getName());
        faunaEntity.setDescription(faunaDto.getDescription());
        faunaEntity.setDangerous(faunaDto.isDangerous());
        faunaEntity.setPicture(faunaDto.getPicture());

        FaunaEntity updatedFaunaEntity = faunaRepository.save(faunaEntity);
        return faunaMapper.convertFaunaEntityToFaunaDto(updatedFaunaEntity);
    }

    public void deleteFauna(Long id) {
        if (!faunaRepository.existsById(id)) {
            throw new EntityNotFoundException("Fauna not found with ID: " + id);
        }
        faunaRepository.deleteById(id);
    }
}

