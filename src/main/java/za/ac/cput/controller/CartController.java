package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Cart;
import za.ac.cput.factory.CartFactory; // <-- Required import
import za.ac.cput.service.ICartService;

import java.util.List;

@RestController
@RequestMapping("/cart")
@CrossOrigin(origins = "http://localhost:4200")
public class CartController {

    private final ICartService cartService;

    @Autowired
    public CartController(ICartService cartService) {
        this.cartService = cartService;
    }

    // Standard JSON object creation
    @PostMapping("/create")
    public ResponseEntity<Cart> create(@RequestBody Cart cart) {
        Cart createdCart = cartService.create(cart);
        if (createdCart != null) {
            return new ResponseEntity<>(createdCart, HttpStatus.CREATED);
        }
        return ResponseEntity.badRequest().build();
    }

    // Endpoint called by Angular CartService: POST /cart/create/{customerId}
    @PostMapping("/create/{customerId}")
    public ResponseEntity<Cart> createByCustomerId(@PathVariable String customerId) {
        Cart existingCart = cartService.findByCustomerId(customerId);
        if (existingCart != null) {
            return ResponseEntity.ok(existingCart);
        }

        try {
            // Replaced 'new Cart()' with CartFactory
            Cart cart = CartFactory.createCart(customerId);
            Cart createdCart = cartService.create(cart);

            if (createdCart != null) {
                return new ResponseEntity<>(createdCart, HttpStatus.CREATED);
            }
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/read/{id}")
    public ResponseEntity<Cart> read(@PathVariable Long id) {
        Cart cart = cartService.read(id);
        if (cart != null) {
            return ResponseEntity.ok(cart);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/update")
    public ResponseEntity<Cart> update(@RequestBody Cart cart) {
        Cart updatedCart = cartService.update(cart);
        if (updatedCart != null) {
            return ResponseEntity.ok(updatedCart);
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        boolean deleted = cartService.delete(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Cart>> getAll() {
        List<Cart> carts = cartService.getAll();
        return ResponseEntity.ok(carts);
    }
}