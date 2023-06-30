package com.mountain.project.mapper;

import com.mountain.project.entity.RouteEntity;
import com.mountain.project.model.RouteDto;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class RouteMapper {

    public RouteDto convertRouteEntityToRouteDto(RouteEntity routeEntity) {
        RouteDto routeDto = new RouteDto();
        routeDto.setId(routeEntity.getId());
        routeDto.setType(routeEntity.getType());
        routeDto.setStartPoint(routeEntity.getStartPoint());
        routeDto.setEndPoint(routeEntity.getEndPoint());
        routeDto.setDistance(routeEntity.getDistance());
        routeDto.setDenivelation(routeEntity.getDenivelation());
        routeDto.setMountain(routeEntity.getMountain());
        return routeDto;
    }

    public List<RouteDto> convertListRouteEntityToListRouteDto(List<RouteEntity> routeEntities) {
        List<RouteDto> routeDtos = new ArrayList<>();
        for (RouteEntity routeEntity : routeEntities) {
            routeDtos.add(convertRouteEntityToRouteDto(routeEntity));
        }
        return routeDtos;
    }

    public RouteEntity convertRouteDtoToRouteEntity(RouteDto routeDto) {
        RouteEntity routeEntity = new RouteEntity();
        routeEntity.setId(routeDto.getId());
        routeEntity.setType(routeDto.getType());
        routeEntity.setStartPoint(routeDto.getStartPoint());
        routeEntity.setEndPoint(routeDto.getEndPoint());
        routeEntity.setDistance(routeDto.getDistance());
        routeEntity.setDenivelation(routeDto.getDenivelation());
        routeEntity.setMountain(routeDto.getMountain());
        return routeEntity;
    }

    public List<RouteEntity> convertListRouteDtoToListRouteEntity(List<RouteDto> routeDtos) {
        List<RouteEntity> routeEntities = new ArrayList<>();
        for (RouteDto routeDto : routeDtos) {
            routeEntities.add(convertRouteDtoToRouteEntity(routeDto));
        }
        return routeEntities;
    }
}

