package com.beehyv.iam.dto.requestDto;

import com.beehyv.iam.enums.ManufacturerCategoryAction;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ManufacturerCategoryRequestDto extends BaseRequestDto{
    private Long id;
    private Long categoryId;
    private Boolean canSkipRawMaterials;
    private Long manufacturerId;
    private Boolean isEnabled;
    private ManufacturerCategoryAction action;
}
