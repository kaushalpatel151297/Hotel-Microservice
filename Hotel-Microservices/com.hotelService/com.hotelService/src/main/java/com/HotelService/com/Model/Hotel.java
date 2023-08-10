package com.HotelService.com.Model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document
@AllArgsConstructor
@NoArgsConstructor

public class Hotel {
    @Id
    private  String hotelid;
    private  String name;
    private  String location;
    private  String about;
}

