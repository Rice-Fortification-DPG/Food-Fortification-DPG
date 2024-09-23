package com.beehyv.iam.dto.requestDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StatusRequestDto extends BaseRequestDto {
    private Long id;
    private String name;
    private String description;
}
