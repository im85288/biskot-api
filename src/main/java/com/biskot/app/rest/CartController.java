package com.biskot.app.rest;

import com.biskot.domain.model.Cart;
import com.biskot.domain.model.Item;
import com.biskot.domain.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Objects;

@RequiredArgsConstructor
@RestController
@RequestMapping("/carts")
public class CartController {

  private final CartService cartService;

  @GetMapping("/{cartId}")
  public ResponseEntity<Cart> getCart(@PathVariable("cartId") Long cartId) {
    Cart cart = cartService.getCart(cartId);
    return Objects.nonNull(cart) ? ResponseEntity.ok(cart) : ResponseEntity.notFound().build();
  }

  @PostMapping
  public ResponseEntity<Void> creatCart() {
    cartService.createCart();
    return ResponseEntity.ok().build();
  }

  @PutMapping("/{cartId}/items")
  public ResponseEntity<Void> updateCartItems(@PathVariable("cartId") Long cartId, @Valid @RequestBody Item item){
    cartService.addItemToCart(cartId, item.getProductId(), item.getQuantity());
    return ResponseEntity.ok().build();
  }
}
