package com.bluecode.BusReservation.Service;

import com.bluecode.BusReservation.Model.Bus;
import com.bluecode.BusReservation.Repository.BusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class BusService {

    @Autowired
    BusRepository busRepository;

    public ResponseEntity<List<Bus>> getBusList() {
        return new ResponseEntity<>(busRepository.findAll(),HttpStatus.OK);
    }

    public ResponseEntity<String> addbus(Bus bus) {
       busRepository.save(bus);
       return new ResponseEntity<>("Successfully Added",HttpStatus.ACCEPTED);
    }

    public ResponseEntity<String> removeBus(String vehicleNo) {
        busRepository.removeBus(vehicleNo);
        return new ResponseEntity<>("Deleted",HttpStatus.ACCEPTED);
    }

}
