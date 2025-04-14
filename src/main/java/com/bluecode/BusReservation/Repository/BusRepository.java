package com.bluecode.BusReservation.Repository;

import com.bluecode.BusReservation.Model.Bus;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BusRepository extends JpaRepository<Bus,Integer> {

    @Modifying
    @Transactional
    @Query(value = "delete from bus_list where upper(vehicle_no) = upper(:vehicleNo)",
    nativeQuery = true
    )
    void removeBus(String vehicleNo);

}

