package com.biskot.domain.model;

import lombok.*;

import java.math.BigInteger;
import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cart {
    private Long id;
    private List<Item> items;
    private BigInteger totalPrice;
}
