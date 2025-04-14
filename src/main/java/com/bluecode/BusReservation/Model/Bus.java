package com.bluecode.BusReservation.Model;

import jakarta.persistence.*;

@Entity
@Table(
        name = "bus_list",
        uniqueConstraints = @UniqueConstraint(
                name = "vehicle_unique",
                columnNames = "vehicleNo"
        )
)
public class Bus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer busNo;
    private String vehicleNo;
    private boolean ac;
    private int capacity ;

    public Integer getBusNo() {
        return busNo;
    }

    public void setBusNo(Integer busNo) {
        this.busNo = busNo;
    }

    public String getVehicleNo() {
        return vehicleNo;
    }

    public void setVehicleNo(String vehicleNo) {
        this.vehicleNo = vehicleNo;
    }

    public boolean isAc() {
        return ac;
    }

    public void setAc(boolean ac) {
        this.ac = ac;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Bus{" +
                "busNo=" + busNo +
                ", vehicleNo='" + vehicleNo + '\'' +
                ", ac=" + ac +
                ", capacity=" + capacity +
                '}';
    }
}
