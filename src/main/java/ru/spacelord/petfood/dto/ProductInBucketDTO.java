package ru.spacelord.petfood.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductInBucketDTO {
    private int size;
    private int price;
    private String title;
}
