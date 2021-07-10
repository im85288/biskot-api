package com.biskot.infra.repository.entity;

import com.biskot.domain.model.Item;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CartEntity {
    private Long id;
    private List<Item> items;
    private BigInteger totalPrice;
}
