package ru.spacelord.petfood.dao;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.spacelord.petfood.domain.FeedBack;

import java.util.List;

public interface FeedbackRepository extends JpaRepository<FeedBack, Long> {
    List<FeedBack> findAllByProductId(Long id);
    void deleteByUserIdAndProductId(String userId, Long productId);

//    @Transactional
//    @Modifying
//    @Query(value = "insert into feedbacks(id,productId,name,dignities,disadvantages, comment, rating) values (:id,:productId,:name,:dignities,:disadvantages,:comment,:rating)", nativeQuery = true)
//    void addFeedback(@Param("id") Long id,
//                     @Param("productId") Long productId,
//                     @Param("name") String name,
//                     @Param("dignities") String dignities,
//                     @Param("disadvantages") String disadvantages,
//                     @Param("comment") String comment,
//                     @Param("rating") float rating);


}
