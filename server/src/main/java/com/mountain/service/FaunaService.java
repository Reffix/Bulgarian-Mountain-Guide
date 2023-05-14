package com.mountain.service;

import com.mountain.entity.FaunaEntity;
import com.mountain.mapper.FaunaMapper;
import com.mountain.model.FaunaDto;
import com.mountain.repository.FaunaRepository;
import java.util.List;
import java.util.Optional;
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
            throw new RuntimeException("Fauna with id " + id + " not found");
        }
        return faunaMapper.convertFaunaEntityToFaunaDto(faunaEntity.get());
    }

    public List<FaunaDto> getAllFaunas() {
        List<FaunaEntity> faunas = faunaRepository.findAll();
        return faunaMapper.convertListFaunaEntityToListFaunaDto(faunas);
    }
}
