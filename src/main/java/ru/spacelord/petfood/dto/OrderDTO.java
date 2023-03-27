package ru.spacelord.petfood.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {
    private List<ProductInBucketDTO> products;
    private int fullPrice;
    private ContactDTO contacts;
}
