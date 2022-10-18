package com.cs.ghdemo.entity;
import com.mysql.cj.util.SaslPrep;
import lombok.Data;
@Data
public class Ticket {
    private String flightType;

    private String flightArea;

    private String seatType;

    private String peopleType;

    private String vipType;

    private double ticketPrice;

    public Ticket(String flightType,String flightArea,String seatType,String peopleType,String vipType,double ticketPrice){
        this.flightArea=flightArea;
        this.flightType=flightType;
        this.peopleType=peopleType;
        this.seatType=seatType;
        this.vipType=vipType;
        this.ticketPrice=ticketPrice;
    }
}
