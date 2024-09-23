package com.beehyv.fortification.mapper;

import com.beehyv.fortification.dto.requestDto.StatusRequestDto;
import com.beehyv.fortification.entity.Status;
import com.beehyv.fortification.dto.responseDto.StatusResponseDto;
import org.springframework.beans.BeanUtils;

public class StatusMapper implements Mappable<StatusResponseDto, StatusRequestDto, Status> {
    // Convert User JPA Entity into StatusDto
    public StatusResponseDto toDto(Status entity) {
        if(entity == null) return null;
        StatusResponseDto dto = new StatusResponseDto();
        BeanUtils.copyProperties(entity, dto);
        if(entity.getUuid() != null) dto.setUuid(entity.getUuid().toString());
        return dto;
    }

    // Convert StatusDto into Status JPA Entity
    public Status toEntity(StatusRequestDto dto) {
        Status entity = new Status();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }
}
