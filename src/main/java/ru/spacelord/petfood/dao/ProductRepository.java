package ru.spacelord.petfood.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.spacelord.petfood.domain.Product;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
}
