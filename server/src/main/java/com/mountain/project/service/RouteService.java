package com.mountain.project.service;

import com.mountain.project.entity.RouteEntity;
import com.mountain.project.entity.UserEntity;
import com.mountain.project.mapper.RouteMapper;
import com.mountain.project.model.RouteDto;
import com.mountain.project.repository.RouteRepository;
import com.mountain.project.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class RouteService {

    private final RouteRepository routeRepository;
    private final RouteMapper routeMapper;
    private final UserRepository userRepository;

    public RouteService(RouteRepository routeRepository, RouteMapper routeMapper, UserRepository userRepository) {
        this.routeRepository = routeRepository;
        this.routeMapper = routeMapper;
        this.userRepository = userRepository;
    }

    public List<RouteDto> getAllRoutesForMountain(String mountain) {
        List<RouteEntity> routeEntities = routeRepository.findAll().stream()
                .filter(routeEntity -> routeEntity.getMountain().name().equals(mountain.toUpperCase()))
                .toList();
        return routeMapper.convertListRouteEntityToListRouteDto(routeEntities);
    }

    public RouteDto getRouteById(Long id) {
        Optional<RouteEntity> routeEntityOptional = routeRepository.findById(id);
        return routeEntityOptional.map(routeMapper::convertRouteEntityToRouteDto).orElse(null);
    }

    public RouteDto createRoute(RouteDto routeDto) {
        RouteEntity routeEntity = routeMapper.convertRouteDtoToRouteEntity(routeDto);
        RouteEntity savedRouteEntity = routeRepository.save(routeEntity);
        return routeMapper.convertRouteEntityToRouteDto(savedRouteEntity);
    }

    public RouteDto updateRoute(Long id, RouteDto routeDto) {
        Optional<RouteEntity> routeEntityOptional = routeRepository.findById(id);
        if (routeEntityOptional.isPresent()) {
            RouteEntity routeEntity = routeEntityOptional.get();
            routeEntity.setType(routeDto.getType());
            routeEntity.setStartPoint(routeDto.getStartPoint());
            routeEntity.setEndPoint(routeDto.getEndPoint());
            routeEntity.setDistance(routeDto.getDistance());
            routeEntity.setDenivelation(routeDto.getDenivelation());

            RouteEntity updatedRouteEntity = routeRepository.save(routeEntity);
            return routeMapper.convertRouteEntityToRouteDto(updatedRouteEntity);
        }
        return null;
    }

    @Transactional
    public void deleteRoute(Long id) {
        if (!routeRepository.existsById(id)) {
            throw new EntityNotFoundException("Route not found with ID: " + id);
        }

        RouteEntity routeEntity = routeRepository.getById(id);
        List<UserEntity> userEntities = userRepository.findAllByFavouriteRoutesContains(routeEntity);

        for(UserEntity user : userEntities) {
            UserEntity userEntity = userRepository.getById(user.getId());
            userEntity.getFavouriteRoutes().remove(routeEntity);
            userRepository.save(userEntity);
        }

        routeRepository.deleteById(id);

    }
}

