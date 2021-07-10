package com.biskot.infra.repository;

import com.biskot.domain.model.Cart;
import com.biskot.domain.spi.CartPersistencePort;
import com.biskot.infra.repository.entity.CartEntity;
import com.biskot.infra.repository.mapper.CartMapper;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class InMemoryCartRepository implements CartPersistencePort {

  private final CartMapper cartMapper;

  private List<CartEntity> cartEntityList = new ArrayList<>();

  @Override
  public Optional<Cart> getCart(long id) {
    Optional<CartEntity> optionalCartEntity =
        cartEntityList.stream().filter(cartEntity -> cartEntity.getId() == id).findAny();

    return optionalCartEntity.map(cartMapper::entityToCart);
  }

  @Override
  public void saveCart(Cart cart) {
    CartEntity cartEntity = cartMapper.cartToEntity(cart);
    cartEntityList.add(cartEntity);
  }
}
