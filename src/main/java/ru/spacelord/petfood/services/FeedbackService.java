package ru.spacelord.petfood.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.spacelord.petfood.dao.FeedbackRepository;
import ru.spacelord.petfood.domain.FeedBack;

import java.util.List;

@Service
public class FeedbackService {
    private final FeedbackRepository feedbackRepository;

    @Autowired
    public FeedbackService(FeedbackRepository feedbackRepository) {
        this.feedbackRepository = feedbackRepository;
    }

    public List<FeedBack> getAllFeedbacksByProductId(Long productId) {
        return this.feedbackRepository.findAllByProductId(productId);
    }

    public void saveNewFeedback(FeedBack feedBack) {
        feedbackRepository.save(feedBack);
    }
}
