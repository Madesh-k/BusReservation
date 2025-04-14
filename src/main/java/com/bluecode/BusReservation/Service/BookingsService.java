package com.bluecode.BusReservation.Service;

import com.bluecode.BusReservation.Model.Bookings;
import com.bluecode.BusReservation.Model.Bus;
import com.bluecode.BusReservation.Repository.BookingsRepository;
import com.bluecode.BusReservation.Repository.BusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

@Service
public class BookingsService{

    @Autowired
    BookingsRepository bookingsRepository;

    @Autowired
    BusRepository busRepository;

    public String formatDateToString(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(date);
    }



    public ResponseEntity<String> addBooking(Bookings booking) {

        int booked = 0;
        int busNo = booking.getBusNo();

        Optional<Bus> bus = busRepository.findById(busNo);
        int capacity = bus.get().getCapacity();

        List<Bookings> totalBookings  = bookingsRepository.findAll();

        for(Bookings b :totalBookings) {
            if (b.getBusNo() == busNo && formatDateToString(b.getDate()).equals(formatDateToString(booking.getDate()))) {
                booked++;
            }
        }

        if (booked < capacity){
            bookingsRepository.save(booking);
            return new ResponseEntity<>("Your Booking is SuccessFull", HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>("Sorry Booking is Full ",HttpStatus.NOT_ACCEPTABLE);
    }

    public ResponseEntity<List<Bookings>> getBooking() {
        return new ResponseEntity<>(bookingsRepository.findAll(),HttpStatus.OK);
    }
}
