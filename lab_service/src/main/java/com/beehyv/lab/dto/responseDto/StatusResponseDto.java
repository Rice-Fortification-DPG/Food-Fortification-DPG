package com.beehyv.lab.dto.responseDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StatusResponseDto extends BaseResponseDTO {
  private Long id;
  private String name;
  private String description;
}
