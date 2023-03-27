package ru.spacelord.petfood.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
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
    @Size(max = 3000)
    private String dignities;
    @Size(max = 3000)
    private String disadvantages;
    @Size(max = 3000)
    private String comment;
    private int rating;
    private String createTime;
    private String userId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "feedback", fetch = FetchType.LAZY)
    private List<Images> images;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "feedback", fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Comment> comments;
}
