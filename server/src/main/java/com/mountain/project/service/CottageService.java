package com.mountain.project.service;

import com.mountain.project.entity.CottageEntity;
import com.mountain.project.entity.UserEntity;
import com.mountain.project.enums.Mountain;
import com.mountain.project.mapper.CottageMapper;
import com.mountain.project.model.CottageDto;
import com.mountain.project.repository.CottageRepository;
import com.mountain.project.repository.UserRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class CottageService {

    private final CottageRepository cottageRepository;
    private final CottageMapper cottageMapper;
    private final UserRepository userRepository;

    public CottageService(CottageRepository cottageRepository, CottageMapper cottageMapper, UserRepository userRepository) {
        this.cottageRepository = cottageRepository;
        this.cottageMapper = cottageMapper;
        this.userRepository = userRepository;
    }

    public List<CottageDto> getAllCottagesForMountain(String mountain, int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("premium").descending());
        List<CottageEntity> cottageEntities = cottageRepository.findAllByMountain(Mountain.valueOf(mountain.toUpperCase()), pageable);
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

    @Transactional
    public void deleteCottage(Long id) {
        if (!cottageRepository.existsById(id)) {
            throw new EntityNotFoundException("Hotel not found with ID: " + id);
        }

        CottageEntity cottageEntity = cottageRepository.getById(id);
        List<UserEntity> userEntities = userRepository.findAllByFavouriteCottagesContains(cottageEntity);

        for(UserEntity user : userEntities) {
            UserEntity userEntity = userRepository.getById(user.getId());
            userEntity.getFavouriteCottages().remove(cottageEntity);
            userRepository.save(userEntity);
        }

        cottageRepository.deleteById(id);
    }
}
