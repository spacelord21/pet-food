package ru.spacelord.petfood.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AdminDTO {
    private String login;
    private String password;
}
