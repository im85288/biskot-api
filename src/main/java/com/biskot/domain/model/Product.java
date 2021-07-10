package com.biskot.domain.model;

import lombok.*;

import java.math.BigInteger;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
  private Long id;
  private String label;
  private BigInteger unitPrice;
  private Integer quantityInStock;
}
