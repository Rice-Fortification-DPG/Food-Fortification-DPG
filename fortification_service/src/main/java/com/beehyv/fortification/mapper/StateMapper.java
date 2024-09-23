package com.beehyv.fortification.mapper;

import com.beehyv.fortification.dto.requestDto.StateRequestDto;
import com.beehyv.fortification.entity.State;
import com.beehyv.fortification.dto.responseDto.StateResponseDto;

public class StateMapper implements Mappable<StateResponseDto, StateRequestDto, State> {
    // Convert State JPA Entity into StateDto
    public StateResponseDto toDto(State entity) {
        if(entity == null) return null;
        return new StateResponseDto(
                entity.getId(),
                entity.getType(),
                entity.getActionType(),
                entity.getSequence(),
                entity.getName(),
                entity.getDisplayName(),
                entity.getActionName()
        );
    }

    // Convert StateDto into State JPA Entity
    public State toEntity(StateRequestDto dto) {
        return new State(
                dto.getId(),
                dto.getType(),
                dto.getActionType(),
                dto.getSequence(),
                dto.getName(),
                dto.getDisplayName(),
                dto.getActionName()
        );
    }
}
