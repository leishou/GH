package com.cs.ghdemo.controller;

import com.cs.ghdemo.api.CommonResult;
import com.cs.ghdemo.entity.Baggage;
//import com.cs.ghdemo.service.BaggageService;
//import com.cs.ghdemo.entity.BaggageList;
import com.cs.ghdemo.entity.BaggageList;
import com.cs.ghdemo.entity.Info;
import com.cs.ghdemo.entity.Ticket;
import net.sf.jsqlparser.expression.TimeKeyExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@ResponseBody
@RestController
@RequestMapping("")
public class CalController {
//    @Autowired
//    BaggageService baggageService;
    @ResponseBody
    @PostMapping
    public CommonResult login(@RequestBody Info info) {

        System.out.println(info);
        double price=0;
        price=info.calculate(info);

//        Ticket ticket=info.getTicket();
//        List baggageList=info.getBaggageList();
//        Integer num=baggageList.size();
//        System.out.println(num);
////        return CommonResult.success(2);
//        String flightType=ticket.getFlightType();
//        String filghtArea=ticket.getFlightArea();
//        String seatType=ticket.getSeatType();
//        String peopleType=ticket.getPeopleType();
//        String vipType= ticket.getVipType();
//        Double ticketPrice=ticket.getTicketPrice();
////
//
////        System.out.println(filghtArea);
////        System.out.println(flightType);
////        System.out.println(seatType);
////        System.out.println(peopleType);
////        System.out.println(vipType);
////        System.out.println(ticketPrice);
////        Baggage baggage= (Baggage) baggageList.get(0);
////        Double a=baggage.getA();
////        Double b=baggage.getB();
////        Double h=baggage.getH();
////        Double w=baggage.getW();
////        String baggageType= baggage.getBaggageType();
//
////        System.out.println(a);
////        System.out.println(b);
////        System.out.println(h);
////        System.out.println(w);
////        System.out.println(baggageType);
//        Double price=0.0;
//        System.out.println(10);
//        if (Objects.equals(flightType, "????????????")) {
//            System.out.println(11);
//            // ????????????????????????
//            Integer wLimit = 0;
//            // ????????????????????????
//            Integer carryOnLimit = 0;
//
//            // ???????????????
//            if (Objects.equals(peopleType, "?????????") || Objects.equals(peopleType, "?????????")) {
//                System.out.println(12);
//                switch (seatType) {
//                    case "?????????":
//                        wLimit = 40;
//                        carryOnLimit = 2;
//                        break;
//                    case "?????????":
//                        wLimit = 30;
//                        carryOnLimit = 2;
//                        break;
//                    case "??????????????? ???????????????":
//                        wLimit = 20;
//                        carryOnLimit = 1;
//                        break;
//
//                }
//            }
//            // ??????
//            else if (Objects.equals(peopleType, "?????????")) {
//                wLimit = 10;
//                switch (seatType) {
//                    case "?????????":
//                    case "?????????":
//                        carryOnLimit = 2;
//                        break;
//                    case "??????????????? ???????????????":
//                        carryOnLimit = 1;
//                        break;
//                }
//            }
//            // vip??????
//            switch (vipType) {
//
//                case "???????????????????????????????????????":
//                    wLimit += 30;
//                    break;
//                case "???????????????????????????":
//                case "??????????????????":
//                    wLimit += 20;
//                    break;
//            }
//            System.out.println(13);
//            // ??????????????????
//            Double baggageWeight = 0.0;
//            Baggage baggage = (Baggage) baggageList.get(0);
//            Double a=baggage.getA();
//            Double b=baggage.getB();
//            Double h=baggage.getH();
//            Double w=baggage.getW();
//            System.out.println(a);
//            System.out.println(b);
//            System.out.println(h);
//            System.out.println(w);
//            for (int i = 0; i < num; i++) {
//                System.out.println(14);
//
////            Double a=baggage.getA();
////            Double b=baggage.getB();
////            Double h=baggage.getH();
////            Double w=baggage.getW();
////            System.out.println(a);
////        System.out.println(b);
////        System.out.println(h);
////        System.out.println(w);
////        System.out.println(baggageType);
////                String baggageType = baggage.getBaggageType();
//
//                // ????????????????????????????????????
//                if (baggage.getA() > 100 || baggage.getB() > 60 || baggage.getH() > 40) {
//
//                System.out.println(23333);
//                return  CommonResult.success(0,"??????[" + (i + 1) + "]?????????????????????????????????????????????\n");
//                }
//
//                // ????????????????????????????????????
//                if (baggage.getA() <= 55 && baggage.getB() <= 40 && baggage.getH() <= 20 && carryOnLimit > 0 && Objects.equals(baggage.getBaggageType(), "????????????")) {
//                    if ((Objects.equals(seatType, "?????????") || Objects.equals(seatType, "?????????")) && baggage.getW() <= 8) {
//                        carryOnLimit--;
//                    CommonResult.success(0,"??????"+ "????????????????????????????????????????????????\n") ;
//
//                    } else if (Objects.equals(seatType, "?????????") && baggage.getW() <= 5) {
//                        carryOnLimit--;
//                    CommonResult.success(0,"??????[" + (i + 1) + "]????????????????????????????????????????????????\n");
//
//                    }
//
//                }
//                // ????????????
//                baggageWeight += baggage.getW();
//                System.out.println(baggageWeight);
//                System.out.println(wLimit);
//                price = baggageWeight > wLimit ? (baggageWeight - wLimit) * ticketPrice * 0.015 : 0;
//            }
//        }
//        System.out.println(price);
        return CommonResult.success(price);
    }
}
