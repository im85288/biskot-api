package com.biskot.infra.repository.mapper;

import com.biskot.domain.model.Cart;
import com.biskot.infra.repository.entity.CartEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper
public interface CartMapper {

     Cart entityToCart(CartEntity cartEntity);

     @InheritInverseConfiguration
     CartEntity cartToEntity(Cart cart);
}
