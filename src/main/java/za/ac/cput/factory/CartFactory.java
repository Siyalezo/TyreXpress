package za.ac.cput.factory;

import za.ac.cput.domain.Cart;
import za.ac.cput.domain.CartItem;
import za.ac.cput.domain.Customer;
import za.ac.cput.util.Helper;

import java.util.List;

public class CartFactory {

    public static Cart createCart(String cart_Id, Customer customer, List<CartItem> cartItems, double totalPrice) {
        if (customer == null || totalPrice < 0) {
            return null;
        }

        if (Helper.isNullOrEmpty(cart_Id)) {
            cart_Id = Helper.generateId();
        }

        return new Cart.Builder()
                .setCart_Id(cart_Id)
                .setCustomer(customer)
                .setCartItems(cartItems)
                .setTotalPrice(totalPrice)
                .build();
    }
}