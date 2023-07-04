package com.mountain.project.mapper;

import com.mountain.project.entity.FaunaEntity;
import com.mountain.project.model.FaunaDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FaunaMapper {

    public FaunaDto convertFaunaEntityToFaunaDto(FaunaEntity faunaEntity) {
        FaunaDto faunaDto = new FaunaDto();
        faunaDto.setId(faunaEntity.getId());
        faunaDto.setName(faunaEntity.getName());
        faunaDto.setDescription(faunaEntity.getDescription());
        faunaDto.setDangerous(faunaEntity.isDangerous());
        faunaDto.setPicture(faunaEntity.getPicture());
        faunaDto.setMountain(faunaEntity.getMountain());
        return faunaDto;
    }

    public List<FaunaDto> convertListFaunaEntityToListFaunaDto(List<FaunaEntity> faunaEntities) {
        List<FaunaDto> faunaDtos = new ArrayList<>();
        for (FaunaEntity faunaEntity : faunaEntities) {
            faunaDtos.add(convertFaunaEntityToFaunaDto(faunaEntity));
        }
        return faunaDtos;
    }

    public FaunaEntity convertFaunaDtoToFaunaEntity(FaunaDto faunaDto) {
        FaunaEntity faunaEntity = new FaunaEntity();
        faunaEntity.setId(faunaDto.getId());
        faunaEntity.setName(faunaDto.getName());
        faunaEntity.setDescription(faunaDto.getDescription());
        faunaEntity.setDangerous(faunaDto.isDangerous());
        faunaEntity.setPicture(faunaDto.getPicture());
        faunaEntity.setMountain(faunaDto.getMountain());
        return faunaEntity;
    }

    public List<FaunaEntity> convertListFaunaDtoToListFaunaEntity(List<FaunaDto> faunaDtos) {
        List<FaunaEntity> faunaEntities = new ArrayList<>();
        for (FaunaDto faunaDto : faunaDtos) {
            faunaEntities.add(convertFaunaDtoToFaunaEntity(faunaDto));
        }
        return faunaEntities;
    }
}
