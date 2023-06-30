package com.mountain.project.service;

import com.mountain.project.entity.HotelEntity;
import com.mountain.project.entity.RouteEntity;
import com.mountain.project.mapper.RouteMapper;
import com.mountain.project.model.RouteDto;
import com.mountain.project.repository.RouteRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class RouteService {

    private final RouteRepository routeRepository;
    private final RouteMapper routeMapper;

    public RouteService(RouteRepository routeRepository, RouteMapper routeMapper) {
        this.routeRepository = routeRepository;
        this.routeMapper = routeMapper;
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

    public boolean deleteRoute(Long id) {
        if (routeRepository.existsById(id)) {
            routeRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

