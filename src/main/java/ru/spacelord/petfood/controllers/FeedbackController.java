package ru.spacelord.petfood.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.spacelord.petfood.domain.FeedBack;
import ru.spacelord.petfood.services.FeedbackService;

import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/feedbacks")
public class FeedbackController {
    private final FeedbackService feedbackService;

    @Autowired
    public FeedbackController(FeedbackService feedbackService){
        this.feedbackService = feedbackService;
    }

    @GetMapping("/get-feedback={productId}")
    public List<FeedBack> getFeedbacks(@PathVariable("productId") Long productId) {
        return feedbackService.getAllFeedbacksByProductId(productId);
    }

    @PostMapping("/add-feedback")
    public void addNewFeedback(@RequestBody FeedBack feedBack) {
        feedbackService.saveNewFeedback(feedBack);
    }
}
