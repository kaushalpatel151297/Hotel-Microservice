package com.userservice.Model;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Hotel {

    private  String hotelid;
    private  String name;
    private  String location;
    private  String about;
}
