package za.ac.cput.domain;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "carts")
public class Cart {

    @Id
    private String cart_Id;

    @OneToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CartItem> cartItems;

    private double totalPrice;

    protected Cart() {
    }

    private Cart(Builder builder) {
        this.cart_Id = builder.cart_Id;
        this.customer = builder.customer;
        this.cartItems = builder.cartItems;
        this.totalPrice = builder.totalPrice;
    }

    public String getCart_Id() {
        return cart_Id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cart cart = (Cart) o;
        return Double.compare(cart.totalPrice, totalPrice) == 0 &&
                Objects.equals(cart_Id, cart.cart_Id) &&
                Objects.equals(customer, cart.customer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cart_Id, customer, totalPrice);
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cart_Id='" + cart_Id + '\'' +
                ", customer=" + customer +
                ", totalPrice=" + totalPrice +
                '}';
    }

    public static class Builder {
        private String cart_Id;
        private Customer customer;
        private List<CartItem> cartItems = new ArrayList<>();
        private double totalPrice;

        public Builder setCart_Id(String cart_Id) {
            this.cart_Id = cart_Id;
            return this;
        }

        public Builder setCustomer(Customer customer) {
            this.customer = customer;
            return this;
        }

        public Builder setCartItems(List<CartItem> cartItems) {
            this.cartItems = cartItems;
            return this;
        }

        public Builder setTotalPrice(double totalPrice) {
            this.totalPrice = totalPrice;
            return this;
        }

        public Builder copy(Cart cart) {
            this.cart_Id = cart.getCart_Id();
            this.customer = cart.getCustomer();
            this.cartItems = cart.getCartItems();
            this.totalPrice = cart.getTotalPrice();
            return this;
        }

        public Cart build() {
            return new Cart(this);
        }
    }
}