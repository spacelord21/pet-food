package ru.spacelord.petfood.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ContactDTO {
    private String name;
    private String phone;
    private List<String> communicationPlace;
}
