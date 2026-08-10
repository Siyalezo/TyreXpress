package za.ac.cput.factory;

import za.ac.cput.domain.Cart;
import za.ac.cput.domain.CartItem;
import za.ac.cput.domain.Product;
import za.ac.cput.util.Helper;

public class CartItemFactory {

    public static CartItem createCartItem(String cartItemId, Cart cart, Product product, int quantity, double unitPrice) {
        if (product == null || quantity <= 0 || unitPrice < 0) {
            return null;
        }

        if (Helper.isNullOrEmpty(cartItemId)) {
            cartItemId = Helper.generateId();
        }

        return new CartItem.Builder()
                .setCartItemId(cartItemId)
                .setCart(cart)
                .setProduct(product)
                .setQuantity(quantity)
                .setUnitPrice(unitPrice)
                .build();
    }
}