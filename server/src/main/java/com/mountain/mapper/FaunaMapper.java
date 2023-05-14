package com.mountain.mapper;

import com.mountain.entity.FaunaEntity;
import com.mountain.model.FaunaDto;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class FaunaMapper {

    public FaunaDto convertFaunaEntityToFaunaDto(FaunaEntity faunaEntity) {
        FaunaDto faunaDto = new FaunaDto();
        faunaDto.setId(faunaEntity.getId());
        faunaDto.setName(faunaEntity.getName());
        faunaDto.setDescription(faunaEntity.getDescription());
        faunaDto.setDangerous(faunaEntity.isDangerous());
        faunaDto.setPicture(faunaEntity.getPicture());
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
