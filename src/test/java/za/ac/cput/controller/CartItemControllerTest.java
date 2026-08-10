package za.ac.cput.controller;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.CartItem;
import za.ac.cput.factory.CartItemFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CartItemControllerTest {

    private static final CartItemController controller = CartItemController.getController();

    private static CartItem cartItem = CartItemFactory.createCartItem(
            "CI-01",
            "C1001",
            "P002",
            2,
            3999.99
    );

    @Test
    @Order(1)
    void getController() {
        assertNotNull(controller);
    }

    @Test
    @Order(2)
    void create() {
        CartItem created = controller.create(cartItem);
        assertNotNull(created);
        assertEquals(cartItem.getCartItemID(), created.getCartItemID());
        System.out.println("Created: " + created);
    }

    @Test
    @Order(3)
    void read() {
        CartItem read = controller.read(cartItem.getCartItemID());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    @Order(4)
    void update() {
        CartItem updated = CartItemFactory.createCartItem(
                "CI-01",
                "C1001",
                "P002",
                3,
                3999.99
        );
        CartItem result = controller.update(updated);
        assertNotNull(result);
        assertEquals(3, result.getQuantity());
        System.out.println("Updated: " + result);
    }

    @Test
    @Order(5)
    void getAll() {
        assertFalse(controller.getAll().isEmpty());
        System.out.println("All CartItems: " + controller.getAll());
    }

    @Test
    @Order(6)
    void delete() {
        boolean success = controller.delete(cartItem.getCartItemID());
        assertTrue(success);
        System.out.println("Deleted CartItem ID: " + cartItem.getCartItemID());
    }
}