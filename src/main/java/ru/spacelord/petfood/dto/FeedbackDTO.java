package ru.spacelord.petfood.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FeedbackDTO {
    private Long feedbackId;
    private Long productId;
    private String comment;
    private String dignities;
    private String disadvantages;
    private String name;
    private int rating;
    private List<String> imagesUrl;
    private String createTime;
    private String userId;
}
