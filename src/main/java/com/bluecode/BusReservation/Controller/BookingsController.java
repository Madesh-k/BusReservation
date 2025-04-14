package com.bluecode.BusReservation.Controller;

import com.bluecode.BusReservation.Model.Bookings;
import com.bluecode.BusReservation.Service.BookingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/booking")
public class BookingsController{

    @Autowired
    BookingsService bookingsService;

    @GetMapping
    public ResponseEntity<List<Bookings>> getBooking(){
        return bookingsService.getBooking();
    }

    @PostMapping("/confirmbooking")
    public ResponseEntity<String> addBooking(@RequestBody Bookings booking){
       return bookingsService.addBooking(booking);
    }

}
