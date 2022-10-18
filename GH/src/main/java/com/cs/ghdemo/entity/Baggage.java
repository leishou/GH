package com.cs.ghdemo.entity;

import lombok.Data;
import org.apache.ibatis.annotations.Mapper;

@Data
public class Baggage {

 private String baggageType;

 private double a;

 private double b;

 private double h;

 private double w;
 public Baggage(String baggageType,double a,double b,double h,double w){
  this.baggageType=baggageType;
  this.a=a;
  this.b=b;
  this.h=h;
  this.w=w;
 }
}

