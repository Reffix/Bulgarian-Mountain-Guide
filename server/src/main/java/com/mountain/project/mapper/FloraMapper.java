package com.mountain.project.mapper;

import com.mountain.project.entity.FloraEntity;
import com.mountain.project.model.FloraDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FloraMapper {

    public FloraDto convertFloraEntityToFloraDto(FloraEntity floraEntity) {
        FloraDto floraDto = new FloraDto();
        floraDto.setId(floraEntity.getId());
        floraDto.setName(floraEntity.getName());
        floraDto.setDescription(floraEntity.getDescription());
        floraDto.setEdible(floraEntity.getEdible());
        floraDto.setPicture(floraEntity.getPicture());
        floraDto.setMountain(floraEntity.getMountain());
        return floraDto;
    }

    public List<FloraDto> convertListFloraEntityToListFloraDto(List<FloraEntity> floraEntities) {
        List<FloraDto> floraDtos = new ArrayList<>();
        for (FloraEntity floraEntity : floraEntities) {
            floraDtos.add(convertFloraEntityToFloraDto(floraEntity));
        }
        return floraDtos;
    }

    public FloraEntity convertFloraDtoToFloraEntity(FloraDto floraDto) {
        FloraEntity floraEntity = new FloraEntity();
        floraEntity.setName(floraDto.getName());
        floraEntity.setDescription(floraDto.getDescription());
        floraEntity.setEdible(floraDto.getEdible());
        floraEntity.setPicture(floraDto.getPicture());
        floraEntity.setMountain(floraDto.getMountain());
        return floraEntity;
    }

    public List<FloraEntity> convertListFloraDtoToListFloraEntity(List<FloraDto> floraDtos) {
        List<FloraEntity> floraEntities = new ArrayList<>();
        for (FloraDto floraDto : floraDtos) {
            floraEntities.add(convertFloraDtoToFloraEntity(floraDto));
        }
        return floraEntities;
    }

}
