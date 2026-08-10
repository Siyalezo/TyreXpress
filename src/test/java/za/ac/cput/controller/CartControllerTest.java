package za.ac.cput.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.Cart;
import za.ac.cput.domain.Customer;
import za.ac.cput.factory.CartFactory;
import za.ac.cput.factory.CustomerFactory;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CartControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private static Cart cart;
    private final String baseUrl = "/cart";

    @BeforeEach
    void setUp() {
        if (cart == null) {
            Customer customer = CustomerFactory.createCustomer("CUST-001", "John", "Doe");
            cart = CartFactory.createCart("CART-101", customer, new ArrayList<>(), 1500.00);
        }
    }

    @Test
    void getController() {
        assertNotNull(restTemplate);
    }

    @Test
    @Order(1)
    void create() {
        String url = baseUrl + "/create";
        ResponseEntity<Cart> response = restTemplate.postForEntity(url, cart, Cart.class);

        assertNotNull(response);
        assertNotNull(response.getBody());
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(cart.getCart_Id(), response.getBody().getCart_Id());
        System.out.println("Created Cart: " + response.getBody());
    }

    @Test
    @Order(2)
    void read() {
        String url = baseUrl + "/read/" + cart.getCart_Id();
        ResponseEntity<Cart> response = restTemplate.getForEntity(url, Cart.class);

        assertNotNull(response);
        assertNotNull(response.getBody());
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(cart.getCart_Id(), response.getBody().getCart_Id());
        System.out.println("Read Cart: " + response.getBody());
    }

    @Test
    @Order(3)
    void update() {
        Cart updatedCart = new Cart.Builder()
                .copy(cart)
                .setTotalPrice(2200.00)
                .build();

        String url = baseUrl + "/update";
        ResponseEntity<Cart> response = restTemplate.postForEntity(url, updatedCart, Cart.class);

        assertNotNull(response);
        assertNotNull(response.getBody());
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(2200.00, response.getBody().getTotalPrice());
        System.out.println("Updated Cart: " + response.getBody());
    }

    @Test
    @Order(4)
    void delete() {
        String url = baseUrl + "/delete/" + cart.getCart_Id();
        ResponseEntity<Void> response = restTemplate.exchange(
                url,
                HttpMethod.DELETE,
                HttpEntity.EMPTY,
                Void.class
        );

        assertNotNull(response);
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        System.out.println("Deleted Cart ID: " + cart.getCart_Id());
    }

    @Test
    @Order(5)
    void getAll() {
        String url = baseUrl + "/getAll";
        ResponseEntity<Cart[]> response = restTemplate.getForEntity(url, Cart[].class);

        assertNotNull(response);
        assertNotNull(response.getBody());
        assertEquals(HttpStatus.OK, response.getStatusCode());
        System.out.println("Get All Carts Count: " + response.getBody().length);
    }
}