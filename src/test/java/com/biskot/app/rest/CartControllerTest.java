package com.biskot.app.rest;

import com.biskot.domain.model.Cart;
import com.biskot.domain.model.Item;
import com.biskot.domain.service.CartService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.math.BigInteger;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@SpringBootTest
@DisplayName("Cart Controller Test")
class CartControllerTest {

  @Autowired private CartController cartController;

  @MockBean private CartService mockedCartService;

  @Nested
  @DisplayName("Given Request To Create Cart")
  class GivenRequestToCreateCart {

    @Nested
    @DisplayName("When Creating A Cart")
    class WhenCreatingACart {
      @BeforeEach
      void setUp() {
        doNothing().when(mockedCartService).createCart();
      }

      @Test
      @DisplayName("Should Create Cart And Return 200 Response")
      void shouldCreateCartAndReturn200Response() {
        ResponseEntity<Void> responseEntity = cartController.creatCart();
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
      }
    }
  }

  @Nested
  @DisplayName("Given Request To Retrieve Cart")
  class GivenRequestToRetrieveCart {
    private final Long CART_ID = 1L;
    private Item item1 = Item.builder().productId(1L).quantity(2).build();
    private Item item2 = Item.builder().productId(2L).quantity(1).build();
    private List<Item> itemList = List.of(item1, item2);
    private Cart cart =
        Cart.builder().id(CART_ID).totalPrice(BigInteger.TEN).items(itemList).build();

    @Nested
    @DisplayName("When Retrieving A Cart")
    class WhenRetrievingACart {
      @BeforeEach
      void setUp() {
        when(mockedCartService.getCart(anyLong())).thenReturn(cart);
      }

      @Test
      @DisplayName("Should Return Cart With 200 Response")
      void shouldReturnCartAndReturn200Response() {
        ResponseEntity<Cart> responseEntity = cartController.getCart(CART_ID);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());
        assertThat(responseEntity.getBody()).usingRecursiveComparison().isEqualTo(cart);
      }
    }

    @Nested
    @DisplayName("When Retrieving A Cart That Is Not Found")
    class WhenRetrievingACartThatIsNotFound {
      @BeforeEach
      void setUp() {
        when(mockedCartService.getCart(anyLong())).thenReturn(null);
      }

      @Test
      @DisplayName("Should Return 404 Response")
      void shouldReturnCartAndReturn200Response() {
        ResponseEntity<Cart> responseEntity = cartController.getCart(CART_ID);
        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
      }
    }
  }
}
