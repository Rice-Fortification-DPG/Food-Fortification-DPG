package com.beehyv.fortification.controller;


import com.beehyv.fortification.dto.requestDto.DSLDto;
import com.beehyv.fortification.dto.requestDto.SearchListRequest;
import com.beehyv.fortification.dto.responseDto.BatchListResponseDTO;
import com.beehyv.fortification.dto.responseDto.CategoryResponseDto;
import com.beehyv.fortification.dto.responseDto.ListResponse;
import com.beehyv.fortification.dto.responseDto.LotListResponseDTO;
import com.beehyv.fortification.service.AdminService;
import com.beehyv.fortification.validation.HasAdminCategoryAccess;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@Tag(name = "Admin Controller")
@RequestMapping("/admin")
public class AdminController {

    private AdminService adminService;

    @PostMapping(value = "batches", produces = "application/json")
    @HasAdminCategoryAccess
    public ResponseEntity<ListResponse<BatchListResponseDTO>> getAllBatches(
            @RequestParam(required = false) Integer pageNumber,
            @RequestParam(required = false) Integer pageSize,
            @RequestBody SearchListRequest searchListRequest) {
        ListResponse<BatchListResponseDTO> batches = adminService.getAllBatches(pageNumber, pageSize, searchListRequest);
        return new ResponseEntity<>(batches, HttpStatus.OK);
    }

    @PostMapping("lots")
    @HasAdminCategoryAccess
    public ResponseEntity<ListResponse<LotListResponseDTO>> getAllLots(
            @RequestParam(required = false) Integer pageNumber,
            @RequestParam(required = false) Integer pageSize,
            @RequestBody(required = false) SearchListRequest searchListRequest) {
        ListResponse<LotListResponseDTO> lots = adminService.getAllLots(pageNumber, pageSize, searchListRequest);
        return new ResponseEntity<>(lots, HttpStatus.OK);
    }

    @GetMapping("/categories")
    public ResponseEntity<List<CategoryResponseDto>> getAllCategoriesForAdmin(@RequestParam(required = false) Integer pageNumber,
                                                                              @RequestParam(required = false) Integer pageSize) {
        return new ResponseEntity<>(adminService.getAllCategoriesForAdmin(pageNumber, pageSize), HttpStatus.OK);
    }

    @PostMapping("/dsl")
    public ResponseEntity<String> addDsl(@RequestBody DSLDto dslDto) {
        return new ResponseEntity<>(adminService.updateDSL(dslDto), HttpStatus.OK);
    }

}

