package ru.spacelord.petfood.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.spacelord.petfood.domain.Comment;
import ru.spacelord.petfood.domain.Images;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Long> {
}
