package com.userservice.Model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Review {

    private String ratingId;
    private String userId;
    private String hotelid;
    private  int rating;
    private  String feedback;
    private Hotel hotel;
}
