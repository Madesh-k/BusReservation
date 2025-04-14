package com.bluecode.BusReservation.Model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "all_bookings")
public class Bookings {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer busNo;
    private String name;
    @Temporal(TemporalType.DATE)
    private Date date;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBusNo() {
        return busNo;
    }

    public void setBusNo(Integer busNo) {
        this.busNo = busNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Bookings{" +
                "id=" + id +
                ", busNo=" + busNo +
                ", name='" + name + '\'' +
                ", date=" + date +
                '}';
    }
}
