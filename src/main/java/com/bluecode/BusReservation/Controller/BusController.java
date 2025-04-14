package com.bluecode.BusReservation.Controller;

import com.bluecode.BusReservation.Model.Bus;
import com.bluecode.BusReservation.Service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/busreservation")
public class BusController {

    @Autowired
    BusService busService;

    @GetMapping("")
    public ResponseEntity<List<Bus>> getBusList(){
        return busService.getBusList();
    }

    @PostMapping("/addbus")
    public ResponseEntity<String> addBus(@RequestBody Bus bus){
       return busService.addbus(bus);
    }

    @DeleteMapping("/removebus")
    public ResponseEntity<String> removeBus(@RequestParam String vehicleNo){
        return busService.removeBus(vehicleNo);
    }

}
