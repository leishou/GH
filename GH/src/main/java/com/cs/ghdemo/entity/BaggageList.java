package com.cs.ghdemo.entity;

import lombok.Data;

import java.util.List;
@Data
public class BaggageList {
    private List<Baggage> baggageLists;
    public List<Baggage> getBaggageList() {
        return baggageLists;
    }
    public void setBaggageList(List<Baggage> baggageLists) {
        this.baggageLists = baggageLists;
    }
    public BaggageList(){}
    public BaggageList(List<Baggage> baggageLists) {
        super();
        this.baggageLists = baggageLists;
    }
}
