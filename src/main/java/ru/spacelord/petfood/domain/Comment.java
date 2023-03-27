package ru.spacelord.petfood.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Entity
@Table(name = "comment")
public class Comment {
    private static final String SEQ_NAME = "comment_seq";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQ_NAME)
    @SequenceGenerator(name = SEQ_NAME, sequenceName = SEQ_NAME, allocationSize = 1)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "feedback_id")
    @JsonBackReference
    private FeedBack feedback;

    @Size(max = 2000)
    private String comment;
    private String name;
    private String userId;
    @JsonProperty("isAdmin")
    private boolean isAdmin;
    private String createTime;
    private int avatarId;
}
