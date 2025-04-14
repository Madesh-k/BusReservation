package com.bluecode.BusReservation.Repository;

import com.bluecode.BusReservation.Model.Bookings;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingsRepository extends JpaRepository<Bookings,Integer> {

}
