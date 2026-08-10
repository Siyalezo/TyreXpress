package za.ac.cput.controller;

import za.ac.cput.domain.CartItem;
import za.ac.cput.service.CartItemService;
import za.ac.cput.service.ICartItemService;

import java.util.List;

public class CartItemController {

    private static CartItemController controller = null;
    private final ICartItemService service;

    private CartItemController() {
        service = CartItemService.getService();
    }

    public static CartItemController getController() {
        if (controller == null) {
            controller = new CartItemController();
        }
        return controller;
    }

    public CartItem create(CartItem cartItem) {
        return service.create(cartItem);
    }

    public CartItem read(String cartItemID) {
        return service.read(cartItemID);
    }

    public CartItem update(CartItem cartItem) {
        return service.update(cartItem);
    }

    public boolean delete(String cartItemID) {
        return service.delete(cartItemID);
    }

    public List<CartItem> getAll() {
        return service.getAll();
    }
}