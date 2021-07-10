package com.biskot.infra.repository.mapper;

import com.biskot.domain.model.Item;
import com.biskot.infra.repository.entity.ItemEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper
public interface ItemMapper {

     Item entityToItem(ItemEntity itemEntity);

     @InheritInverseConfiguration
     ItemEntity itemToEntity(Item item);
}
