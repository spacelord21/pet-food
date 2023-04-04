package ru.spacelord.petfood.services;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.spacelord.petfood.dao.CommentRepository;
import ru.spacelord.petfood.dao.FeedbackRepository;
import ru.spacelord.petfood.dao.ImagesRepository;
import ru.spacelord.petfood.dao.ProductRepository;
import ru.spacelord.petfood.domain.Comment;
import ru.spacelord.petfood.domain.FeedBack;
import ru.spacelord.petfood.domain.Images;
import ru.spacelord.petfood.dto.CommentDTO;
import ru.spacelord.petfood.dto.FeedbackDTO;

import java.util.ArrayList;
import java.util.List;

@Service
public class FeedbackService {
    private final FeedbackRepository feedbackRepository;
    private final CommentRepository commentRepository;
    private final ImagesRepository imagesRepository;
    private final ProductRepository productRepository;

    @Autowired
    public FeedbackService(FeedbackRepository feedbackRepository,
                           ImagesRepository imagesRepository,
                           ProductRepository productRepository,
                           CommentRepository commentRepository) {
        this.feedbackRepository = feedbackRepository;
        this.imagesRepository = imagesRepository;
        this.productRepository = productRepository;
        this.commentRepository = commentRepository;
    }


    public List<FeedbackDTO> getAllFeedbacksByProductId(Long productId) {
        List<FeedBack> feedBacks = feedbackRepository.findAllByProductId(productId);
        return feedBacks.stream().map(this::toDTO).toList();
    }

    @Transactional
    public void deleteFeedback(String userId, Long productId) {
        feedbackRepository.deleteByUserIdAndProductId(userId,productId);
    }

    public void saveNewFeedback(FeedbackDTO feedBackDTO) {
        FeedBack feedBack = FeedBack.builder()
                .userId(feedBackDTO.getUserId())
                .productId(feedBackDTO.getProductId())
                .name(feedBackDTO.getName())
                .comment(feedBackDTO.getComment())
                .createTime(feedBackDTO.getCreateTime())
                .disadvantages(feedBackDTO.getDisadvantages())
                .rating(feedBackDTO.getRating())
                .dignities(feedBackDTO.getDignities())
                .build();
        List<Images> images = new ArrayList<>();
        if(feedBackDTO.getImagesUrl() != null) {
            feedBackDTO.getImagesUrl().forEach(image -> {
                images.add(Images.builder().url(image).feedback(feedBack).build());
            });
        }
        feedbackRepository.save(feedBack);
        imagesRepository.saveAll(images);
    };

    public List<FeedbackDTO> getAll() {
        return feedbackRepository.findAll().stream().map(this::toDTO).toList();
    }

    private FeedbackDTO toDTO(FeedBack feedBack) {
        return FeedbackDTO.builder()
                .feedbackId(feedBack.getId())
                .name(feedBack.getName())
                .comment(feedBack.getComment())
                .createTime(feedBack.getCreateTime())
                .dignities(feedBack.getDignities())
                .disadvantages(feedBack.getDisadvantages())
                .productId(feedBack.getProductId())
                .rating(feedBack.getRating())
                .imagesUrl(feedBack.getImages().stream().map(Images::getUrl).toList())
                .userId(feedBack.getUserId())
                .comments(feedBack.getComments())
                .build();
    }

    public void saveComment(Long feedbackId, CommentDTO commentDTO) {
        FeedBack feedBack = feedbackRepository.findById(feedbackId).orElse(null);
        if(feedBack != null) {
            Comment comment = Comment.builder()
                    .isAdmin(commentDTO.getIsAdmin())
                    .createTime(commentDTO.getCreateTime())
                    .avatarId(commentDTO.getAvatarId())
                    .userId(commentDTO.getUserId())
                    .name(commentDTO.getName())
                    .comment(commentDTO.getComment())
                    .feedback(feedBack)
                    .build();
            commentRepository.save(comment);
        }
    }
    public void deleteComment(Long commentId) {
        commentRepository.deleteById(commentId);
    }
}
