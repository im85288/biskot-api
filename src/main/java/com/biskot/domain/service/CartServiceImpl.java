package com.biskot.domain.service;

import com.biskot.domain.model.Cart;
import com.biskot.domain.spi.CartPersistencePort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CartServiceImpl implements CartService {

    private CartPersistencePort cartPersistencePort;

    @Override
    public void createCart() {
        // TODO: to be implemented
    }

    @Override
    public Cart getCart(long cartId) {
        // TODO: to be implemented
        return null;
    }

    @Override
    public void addItemToCart(long cartId, long productId, int quantityToAdd) {
        // TODO: to be implemented
    }
}
