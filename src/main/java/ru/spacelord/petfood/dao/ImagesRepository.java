package ru.spacelord.petfood.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.spacelord.petfood.domain.Images;

public interface ImagesRepository extends JpaRepository<Images,Long> {
}
