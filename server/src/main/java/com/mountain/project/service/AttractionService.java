package com.mountain.project.service;

import com.mountain.project.entity.AttractionEntity;
import com.mountain.project.entity.UserEntity;
import com.mountain.project.enums.Mountain;
import com.mountain.project.mapper.AttractionMapper;
import com.mountain.project.model.AttractionDto;
import com.mountain.project.repository.AttractionRepository;
import com.mountain.project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class AttractionService {

    private final AttractionRepository attractionRepository;
    private final AttractionMapper attractionMapper;
    private final UserRepository userRepository;

    @Autowired
    public AttractionService(AttractionRepository attractionRepository, AttractionMapper attractionMapper, UserRepository userRepository) {
        this.attractionRepository = attractionRepository;
        this.attractionMapper = attractionMapper;
        this.userRepository = userRepository;
    }

    public List<AttractionDto> getAllAttractionsForMountain(String mountain, int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("premium").descending());
        List<AttractionEntity> attractions = attractionRepository.findAllByMountain(Mountain.valueOf(mountain.toUpperCase()), pageable);
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

    @Transactional
    public void deleteAttraction(Long id) {
        if (!attractionRepository.existsById(id)) {
            throw new EntityNotFoundException("Attraction not found with ID: " + id);
        }

        AttractionEntity attractionEntity = attractionRepository.getById(id);
        List<UserEntity> userEntities = userRepository.findAllByFavouriteAttractionsContains(attractionEntity);

        for(UserEntity user : userEntities) {
            UserEntity userEntity = userRepository.getById(user.getId());
            userEntity.getFavouriteAttractions().remove(attractionEntity);
            userRepository.save(userEntity);
        }

        attractionRepository.deleteById(id);
    }
}
