package com.HotelService.com.Controller;

import com.HotelService.com.Model.Hotel;
import com.HotelService.com.Service.HotelService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/v1/hotel")
public class HotelController {

    public final HotelService hotelService;

    public HotelController(HotelService hotelService)
    {
        this.hotelService = hotelService;
    }
    @PostMapping("/")
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel)
    {
        Hotel hotelSaved = this.hotelService.createHotel(hotel);
        return  ResponseEntity.status(HttpStatus.CREATED).body(hotelSaved);
    }
    @PutMapping("/update/{hotelid}")
    public ResponseEntity<Hotel> updateHotel(@RequestBody Hotel hotel,@PathVariable String hotelid)
    {
        Hotel UpdatedHotel = this.hotelService.updateHotel(hotel,hotelid);
        return ResponseEntity.status(HttpStatus.OK).body(UpdatedHotel);
    }
    @GetMapping("/listHotels")
    public ResponseEntity<List<Hotel>> getallHotels()
    {
        List<Hotel> allHotel = this.hotelService.getAllHotel();
        return ResponseEntity.status(HttpStatus.OK).body(allHotel);
    }
    @GetMapping("/{hotelid}")
    public ResponseEntity<Hotel> getHotel(@PathVariable String hotelid)
    {
        Hotel getHotelByID = this.hotelService.getHotel(hotelid);
        return ResponseEntity.status(HttpStatus.OK).body(getHotelByID);
    }
    @DeleteMapping("/{hotelid}")
    public ResponseEntity<String> deleteHotel(@PathVariable("hotelid") String hotelid)
    {
        this.hotelService.deleteHotel(hotelid);
        return ResponseEntity.status(HttpStatus.OK).body("DATA IS DELETED!");
    }

}
