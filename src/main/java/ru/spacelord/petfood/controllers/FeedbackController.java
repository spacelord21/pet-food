package ru.spacelord.petfood.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.spacelord.petfood.domain.FeedBack;
import ru.spacelord.petfood.dto.CommentDTO;
import ru.spacelord.petfood.dto.FeedbackDTO;
import ru.spacelord.petfood.services.FeedbackService;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = {"http://localhost:3000", "http://45.80.69.21:3000/"})
@RestController
@RequestMapping("/api/v1/feedbacks")
public class FeedbackController {
    private final FeedbackService feedbackService;

    @Autowired
    public FeedbackController(FeedbackService feedbackService){
        this.feedbackService = feedbackService;
    }

    @GetMapping("/get-feedback={productId}")
    public List<FeedbackDTO> getFeedbacks(@PathVariable("productId") Long productId) {
        return feedbackService.getAllFeedbacksByProductId(productId);
    }

    @PostMapping("/add-feedback")
    public void addNewFeedback(@RequestBody FeedbackDTO feedBackDTO) {
        feedbackService.saveNewFeedback(feedBackDTO);
    }

    @PostMapping("/delete-feedback")
    public void deleteFeedback(@RequestParam Map<String, String> params) {
        feedbackService.deleteFeedback(params.get("userId"),Long.parseLong(params.get("productId")));
    }

    @GetMapping("/get-all")
    public List<FeedbackDTO> getAllFeedbacks() {
        return feedbackService.getAll();
    }

    @PostMapping("/save-comment={feedbackId}")
    public void saveComment(@RequestBody CommentDTO commentDTO, @PathVariable Long feedbackId) {
        feedbackService.saveComment(feedbackId, commentDTO);
    }

    @PostMapping("/delete-comment={commentId}")
    public void deleteComment(@PathVariable Long commentId) {
        feedbackService.deleteComment(commentId);
    }

}
