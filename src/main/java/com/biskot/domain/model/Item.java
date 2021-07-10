package com.biskot.domain.model;

import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Item {

  @NotNull
  private Long productId;

  @Min(1)
  private Integer quantity;
}
