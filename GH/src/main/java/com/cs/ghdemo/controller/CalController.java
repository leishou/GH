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
//        if (Objects.equals(flightType, "国内航线")) {
//            System.out.println(11);
//            // 计算免费托运额度
//            Integer wLimit = 0;
//            // 计算随身行李限额
//            Integer carryOnLimit = 0;
//
//            // 成人或儿童
//            if (Objects.equals(peopleType, "成人票") || Objects.equals(peopleType, "儿童票")) {
//                System.out.println(12);
//                switch (seatType) {
//                    case "头等舱":
//                        wLimit = 40;
//                        carryOnLimit = 2;
//                        break;
//                    case "公务舱":
//                        wLimit = 30;
//                        carryOnLimit = 2;
//                        break;
//                    case "悦享经济舱 超级经济舱":
//                        wLimit = 20;
//                        carryOnLimit = 1;
//                        break;
//
//                }
//            }
//            // 婴儿
//            else if (Objects.equals(peopleType, "婴儿票")) {
//                wLimit = 10;
//                switch (seatType) {
//                    case "头等舱":
//                    case "公务舱":
//                        carryOnLimit = 2;
//                        break;
//                    case "悦享经济舱 超级经济舱":
//                        carryOnLimit = 1;
//                        break;
//                }
//            }
//            // vip类型
//            switch (vipType) {
//
//                case "凤凰知音终身白金卡、白金卡":
//                    wLimit += 30;
//                    break;
//                case "凤凰知音金卡、银卡":
//                case "星空联盟金卡":
//                    wLimit += 20;
//                    break;
//            }
//            System.out.println(13);
//            // 计算收费价格
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
//                // 检查普通行李尺寸是否超标
//                if (baggage.getA() > 100 || baggage.getB() > 60 || baggage.getH() > 40) {
//
//                System.out.println(23333);
//                return  CommonResult.success(0,"行李[" + (i + 1) + "]存在尺寸超标的情况，请合理划分\n");
//                }
//
//                // 判断是否可以作为随身行李
//                if (baggage.getA() <= 55 && baggage.getB() <= 40 && baggage.getH() <= 20 && carryOnLimit > 0 && Objects.equals(baggage.getBaggageType(), "普通行李")) {
//                    if ((Objects.equals(seatType, "头等舱") || Objects.equals(seatType, "公务舱")) && baggage.getW() <= 8) {
//                        carryOnLimit--;
//                    CommonResult.success(0,"行李"+ "可以作为随身行李携带，不参与计算\n") ;
//
//                    } else if (Objects.equals(seatType, "经济舱") && baggage.getW() <= 5) {
//                        carryOnLimit--;
//                    CommonResult.success(0,"行李[" + (i + 1) + "]可以作为随身行李携带，不参与计算\n");
//
//                    }
//
//                }
//                // 累加重量
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
