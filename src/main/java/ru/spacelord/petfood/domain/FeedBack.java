package ru.spacelord.petfood.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Entity
@Table(name = "feedback")
public class FeedBack {
    private static final String SEQ_NAME = "feedback_seq";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQ_NAME)
    @SequenceGenerator(name = SEQ_NAME, sequenceName = SEQ_NAME, allocationSize = 1)
    private Long id;
    private Long productId;
    private String name;
    private String dignities;
    private String disadvantages;
    private String comment;
    private int rating;
    private String createTime;
    private String userId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "feedback", fetch = FetchType.LAZY)
    private List<Images> images;
}
