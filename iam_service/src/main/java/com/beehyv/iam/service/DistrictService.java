package com.beehyv.iam.service;

import com.beehyv.iam.dto.requestDto.DistrictRequestDto;
import com.beehyv.iam.dto.responseDto.DistrictResponseDto;
import com.beehyv.iam.dto.responseDto.ListResponse;
import com.beehyv.iam.dto.responseDto.LocationResponseDto;
import com.beehyv.iam.manager.DistrictManager;
import com.beehyv.iam.model.District;
import com.beehyv.iam.utils.DtoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class DistrictService {
    private final DistrictManager districtManager;
    private final DtoMapper dtoMapper;

    public void create(DistrictRequestDto dto) {
        districtManager.create(dtoMapper.mapToEntity(dto));
    }

    public void update(DistrictRequestDto dto) {
        districtManager.update(dtoMapper.mapToEntity(dto));
    }

    public void delete(Long id) {
        districtManager.delete(id);
    }

    public DistrictResponseDto getById(Long id) {
        District district = districtManager.findById(id);
        return dtoMapper.mapToResponseDto(district);
    }

    public ListResponse<DistrictResponseDto> getAll(Integer pageNumber, Integer pageSize) {
        List<District> entities = districtManager.findAll(pageNumber, pageSize);
        Long count = districtManager.getCount(entities.size(), pageNumber, pageSize);
        return ListResponse.from(entities, dtoMapper::mapToResponseDto, count);
    }

    public ListResponse<LocationResponseDto> getAllDistrictsByStateId(Long stateId, String search, Integer pageNumber, Integer pageSize) {
        List<District> entities = districtManager.findAllByStateId(stateId, search, pageNumber, pageSize);
        Long count = districtManager.getCountByStateId(stateId, search);
        return ListResponse.from(entities, dtoMapper::mapToDto, count);
    }

    public List<DistrictResponseDto> getAllDistrictsByStateGeoId(String stateGeoId) {
        return districtManager.findAllByStateGeoId(stateGeoId)
                .stream()
                .map(d -> {
                    DistrictResponseDto dto = new DistrictResponseDto();
                    dto.setGeoId(d.getGeoId());
                    dto.setName(d.getName());
                    dto.setStateName(d.getState().getName());
                    return dto;
                })
                .toList();
    }

    public List<DistrictResponseDto> getAllByGeoIds(List<String> geoIds) {
        return districtManager.findAllByGeoIds(geoIds)
                .stream()
                .map(d -> {
                    DistrictResponseDto dto = new DistrictResponseDto();
                    dto.setGeoId(d.getGeoId());
                    dto.setName(d.getName());
                    dto.setStateName(d.getState().getName());
                    return dto;
                }).toList();

    }

}
