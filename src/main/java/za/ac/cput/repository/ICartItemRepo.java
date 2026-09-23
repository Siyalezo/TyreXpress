package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.CartItem;

import java.util.List;

@Repository
public interface ICartItemRepo extends JpaRepository<CartItem, Long> {
    List<CartItem> findByCartId(Long cartId);
}