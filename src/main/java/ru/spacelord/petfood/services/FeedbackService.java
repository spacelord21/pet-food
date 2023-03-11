package ru.spacelord.petfood.services;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.spacelord.petfood.dao.FeedbackRepository;
import ru.spacelord.petfood.dao.ImagesRepository;
import ru.spacelord.petfood.domain.FeedBack;
import ru.spacelord.petfood.domain.Images;
import ru.spacelord.petfood.dto.FeedbackDTO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class FeedbackService {
    private final FeedbackRepository feedbackRepository;
    private final ImagesRepository imagesRepository;

    @Autowired
    public FeedbackService(FeedbackRepository feedbackRepository, ImagesRepository imagesRepository) {
        this.feedbackRepository = feedbackRepository;
        this.imagesRepository = imagesRepository;
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
        feedBackDTO.getImagesUrl().forEach(image -> {
            images.add(Images.builder().url(image).feedback(feedBack).build());
        });
        feedbackRepository.save(feedBack);
        imagesRepository.saveAll(images);
    };

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
                .build();
    }
}
