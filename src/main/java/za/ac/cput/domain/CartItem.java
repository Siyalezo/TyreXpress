package za.ac.cput.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "cart_items")
public class CartItem {

    @Id
    private String cartItemId;

    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private int quantity;
    private double unitPrice;

    public CartItem() {
    }

    public CartItem(Builder builder) {
        this.cartItemId = builder.cartItemId;
        this.cart = builder.cart;
        this.product = builder.product;
        this.quantity = builder.quantity;
        this.unitPrice = builder.unitPrice;
    }

    public String getCartItemId() {
        return cartItemId;
    }

    public Cart getCart() {
        return cart;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "cartItemId='" + cartItemId + '\'' +
                ", cart=" + (cart != null ? cart.getCart_Id() : null) +
                ", product=" + product +
                ", quantity=" + quantity +
                ", unitPrice=" + unitPrice +
                '}';
    }

    public static class Builder {
        private String cartItemId;
        private Cart cart;
        private Product product;
        private int quantity;
        private double unitPrice;

        public Builder setCartItemId(String cartItemId) {
            this.cartItemId = cartItemId;
            return this;
        }

        public Builder setCart(Cart cart) {
            this.cart = cart;
            return this;
        }

        public Builder setProduct(Product product) {
            this.product = product;
            return this;
        }

        public Builder setQuantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        public Builder setUnitPrice(double unitPrice) {
            this.unitPrice = unitPrice;
            return this;
        }

        public Builder copy(CartItem cartItem) {
            this.cartItemId = cartItem.getCartItemId();
            this.cart = cartItem.getCart();
            this.product = cartItem.getProduct();
            this.quantity = cartItem.getQuantity();
            this.unitPrice = cartItem.getUnitPrice();
            return this;
        }

        public CartItem build() {
            return new CartItem(this);
        }
    }
}