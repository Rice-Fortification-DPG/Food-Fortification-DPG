package com.beehyv.fortification.mapper;

import com.beehyv.fortification.dto.requestDto.CategoryDocRequestDto;
import com.beehyv.fortification.dto.requestDto.StateRequestDto;
import com.beehyv.fortification.dto.responseDto.CategoryDocResponseDto;
import com.beehyv.fortification.dto.responseDto.StateResponseDto;
import com.beehyv.fortification.entity.*;
import com.beehyv.fortification.dto.requestDto.BatchDocRequestDto;
import com.beehyv.fortification.dto.responseDto.BatchDocResponseDto;

public class BatchDocMapper implements Mappable<BatchDocResponseDto, BatchDocRequestDto, BatchDoc>{
    private final BaseMapper<CategoryDocResponseDto, CategoryDocRequestDto, CategoryDoc> categoryDocMapper = BaseMapper.getForClass(CategoryDocMapper.class);

    @Override
    public BatchDocResponseDto toDto(BatchDoc entity) {
        BatchDocResponseDto dto = new BatchDocResponseDto();
        dto.setId(entity.getId());
        if(entity.getCategoryDoc() != null) dto.setCategoryDoc(categoryDocMapper.toDto(entity.getCategoryDoc()));
//        if(entity.getBatch() != null) dto.setBatchId(entity.getBatch().getId());
        dto.setName(entity.getName());
        dto.setPath(entity.getPath());
        dto.setExpiry(entity.getExpiry());
        return dto;
    }

    @Override
    public BatchDoc toEntity(BatchDocRequestDto dto) {
        BatchDoc entity = new BatchDoc();
        entity.setId(dto.getId());
        entity.setPath(dto.getPath());
        entity.setName(dto.getName());
        entity.setExpiry(dto.getExpiry());
        if(dto.getCategoryDocId() != null) {
            entity.setCategoryDoc(new CategoryDoc(dto.getCategoryDocId()));
        }
        if(dto.getBatchId() != null) {
            entity.setBatch(new Batch(dto.getBatchId()));
        }
        return entity;
    }
}
