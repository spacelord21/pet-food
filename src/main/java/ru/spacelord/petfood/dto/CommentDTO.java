package ru.spacelord.petfood.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CommentDTO {
    private String name;
    private String comment;
    @JsonProperty("isAdmin")
    private boolean isAdmin;
    private String userId;
    private String createTime;
    private int avatarId;
    @JsonProperty("isAdmin")
    public boolean getIsAdmin(){
        return this.isAdmin;
    }

}
