package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Cart;

import java.util.Optional;

@Repository
public interface ICartRepo extends JpaRepository<Cart, Long> {
    Optional<Cart> findByCustomerId(String customerId);
}

