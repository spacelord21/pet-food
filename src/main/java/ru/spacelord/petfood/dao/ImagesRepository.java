package ru.spacelord.petfood.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.spacelord.petfood.domain.Images;

@Repository
public interface ImagesRepository extends JpaRepository<Images,Long> {
}
