package com.cs.ghdemo.entity;

import com.cs.ghdemo.api.CommonResult;
import com.cs.ghdemo.api.Result;
import lombok.Data;

import java.util.*;

import static java.lang.Integer.parseInt;

@Data
public class Info {
    private Ticket ticket;
    private List<Baggage> baggageList;

    public Info(Ticket ticket, List<Baggage> baggageList) {
        this.ticket = ticket;
        this.baggageList = baggageList;
    }
    public double calculate(Info info) {
        List baggageList = info.getBaggageList();
        Integer num = baggageList.size();
        Result result = new Result();
        List<String>freeSpecialBaggage1 =  Arrays.asList(new String[]{"手动轮椅", "电动轮椅", "..."});
        List<String>freeSpecialBaggage2 = Arrays.asList(new String[]{"婴儿车或摇篮", "..."});
        List<String>freeSpecialBaggage3 = Arrays.asList(new String[]{"导盲犬", "骨灰", "..."});
        List<String>sportsSpecialBaggage1 = Arrays.asList(new String[]{"自行车", "..."});
        List<String>sportsSpecialBaggage2 = Arrays.asList(new String[]{"皮划艇", "..."});
        List<String>sportsSpecialBaggage3 = Arrays.asList(new String[]{"撑杆", "..."});
        List<String>othersSpecialBaggage1 = Arrays.asList(new String[]{"睡袋", "..."});
        List<String>othersSpecialBaggage2 = Arrays.asList(new String[]{"小型电器或仪器", "..."});
        List<String>othersSpecialBaggage3 = Arrays.asList(new String[]{"可作为行李运输的枪支", "..."});
        List<String>othersSpecialBaggage4 = Arrays.asList(new String[]{"可作为行李运输的弹药", "..."});
        List<String>othersSpecialBaggage5 = Arrays.asList(new String[]{"小动物", "..."});
        
        List<Baggage> baggageNormalList= new ArrayList<>();
//        baggageNormalList.addAll(baggageList);
        List<Baggage> baggageSpecialList=new ArrayList<>();
//        baggageSpecialList.addAll(baggageList);
        
        String flightType = ticket.getFlightType();
        String flightArea = ticket.getFlightArea();
        String seatType = ticket.getSeatType();
        String peopleType = ticket.getPeopleType();
        String vipType = ticket.getVipType();
        Double ticketPrice = ticket.getTicketPrice();

        for (int i = 0, cnt = 0; i < 50; i++) {
//            String type =baggageList;
            Baggage baggage = (Baggage) baggageList.get(i);
            String type =baggage.getBaggageType();
            // 普通行李，或是按照普通行李类型收费的特殊行李
            if (Objects.equals(type, "普通行李") || sportsSpecialBaggage1.contains(type) || othersSpecialBaggage1.contains(type)) {
//                baggageDetail.normal.push(createBaggage(i));
                  baggageNormalList.add(baggage);
                cnt++;
            }
            // 非残疾和非婴儿旅客托运 轮椅或婴儿床，按普通行李收费
            else if ((!Objects.equals(peopleType, "婴儿票")) && (freeSpecialBaggage1.contains(type) || freeSpecialBaggage2.contains(type))) {
//                baggageDetail.normal.push(createBaggage(i));
                baggageNormalList.add(baggage);
                cnt++;
            }
            // 其余类型的特殊行李
            else if (!Objects.equals(type, "普通行李")) {
//                baggageDetail.special.push(createBaggage(i));
                baggageSpecialList.add(baggage);
                cnt++;
            }
            if (cnt >= num) {
                break;
            }
        }
//        System.out.println(baggageNormalList.toString());
//        System.out.println(baggageSpecialList.toString());
//        System.out.println(1991);

//        for(int i=0;i<num;i++){
//            Baggage baggage = (Baggage) baggageList.get(i);
//            if(Objects.equals(baggage.getBaggageType(), "普通行李"))
//            {
//                baggageSpecialList.remove(baggage);
//            }
//            else{
//                baggageNormalList.remove(baggage);
//            }
//        }
//
        Double price = 0.0;
        System.out.println(10);
        Integer carryOnLimit;
       
        if (Objects.equals(flightType, "国内航线")) {
            System.out.println(11);
            // 计算免费托运额度
            Integer wLimit = 0;
            // 计算随身行李限额
            carryOnLimit = 0;

            // 成人或儿童
            if (Objects.equals(peopleType, "成人票") || Objects.equals(peopleType, "儿童票")) {
                System.out.println(12);
                switch (seatType) {
                    case "头等舱":
                        wLimit = 40;
                        carryOnLimit = 2;
                        break;
                    case "公务舱":
                        wLimit = 30;
                        carryOnLimit = 2;
                        break;
                    case "悦享经济舱 超级经济舱":
                        wLimit = 20;
                        carryOnLimit = 1;
                        break;
                    case "经济舱":
                        wLimit = 20;
                        carryOnLimit = 1;
                        break;
                }
            }
            // 婴儿
            else if (Objects.equals(peopleType, "婴儿票")) {
                wLimit = 10;
                switch (seatType) {
                    case "头等舱":
                    case "公务舱":
                        carryOnLimit = 2;
                        break;
                    case "悦享经济舱 超级经济舱":
                        carryOnLimit = 1;
                        break;
                }
            }
            // vip类型
            switch (vipType) {

                case "凤凰知音终身白金卡、白金卡":
                    wLimit += 30;
                    break;
                case "凤凰知音金卡、银卡":
                case "星空联盟金卡":
                    wLimit += 20;
                    break;
            }
            System.out.println(13);
            // 计算收费价格
            Double baggageWeight = 0.0;
            for (int i = 0; i < baggageNormalList.size(); i++) {
                System.out.println(14);
                Baggage baggage = (Baggage) baggageNormalList.get(i);
                Double a = baggage.getA();
                Double b = baggage.getB();
                Double h = baggage.getH();
                Double w = baggage.getW();
//                System.out.println(a);
//                System.out.println(b);
//                System.out.println(h);
//                System.out.println(w);
////        System.out.println(baggageType);
                String baggageType = baggage.getBaggageType();

                // 检查普通行李尺寸是否超标
                if (baggage.getA() > 100 || baggage.getB() > 60 || baggage.getH() > 40) {

                    System.out.println(23333);
//                    return 0.0;
                }

                // 判断是否可以作为随身行李
                if (baggage.getA() <= 55 && baggage.getB() <= 40 && baggage.getH() <= 20 && carryOnLimit > 0 && Objects.equals(baggage.getBaggageType(), "普通行李")) {
                    if ((Objects.equals(seatType, "头等舱") || Objects.equals(seatType, "公务舱")) && baggage.getW() <= 8) {
                        carryOnLimit--;
                        continue;
//                        return 0.0;
//                        CommonResult.success(0,"行李"+ "可以作为随身行李携带，不参与计算\n") ;

                    } else if (Objects.equals(seatType, "经济舱") && baggage.getW() <= 5) {
                        carryOnLimit--;
                        continue;
//                        return 0.0;
//                        CommonResult.success(0,"行李[" + (i + 1) + "]可以作为随身行李携带，不参与计算\n");

                    }

                }


                // 累加重量
                baggageWeight += baggage.getW();
//                System.out.println(baggageWeight);
//                System.out.println(wLimit);

            }
//            System.out.println(wLimit);
//            System.out.println(21);
//            System.out.println(baggageWeight);

            price = baggageWeight > wLimit ? (baggageWeight - wLimit) * ticketPrice * 0.015 : 0;
            for (int i = 0, len = baggageSpecialList.size(); i < len; i++) {
                Baggage baggage = (Baggage) baggageSpecialList.get(i);
                // ---------------- 可免费托运的行李 -----------------
                if ((freeSpecialBaggage1.contains(baggage.getBaggageType())) ||
                (Objects.equals(peopleType, "婴儿票") && freeSpecialBaggage2.contains(baggage.getBaggageType())) ||
                        (freeSpecialBaggage3.contains(baggage.getBaggageType()))){
                    continue;
                }
                // 非残疾或婴儿旅客托运 轮椅或婴儿床
                else
                if ((!Objects.equals(peopleType, "婴儿票")) && (freeSpecialBaggage1.contains(baggage.getBaggageType()) || freeSpecialBaggage2.contains(baggage.getBaggageType()))) {
                    // 已经按照普通行李进行计算了
                }
                // ---------------- 运动器械器具，计入免费额度 -----------------
                else if (sportsSpecialBaggage1.contains(baggage.getBaggageType())) {
                    // 计入免费额度的特殊行李已经被当作普通行李计算过了
                }
                // ---------------- 运动器械器具，不计入免费额度 -----------------
                else if (sportsSpecialBaggage2.contains(baggage.getBaggageType()) || sportsSpecialBaggage3.contains(baggage.getBaggageType())) {
                    // 根据实际重量收费
                    price += baggage.getW() * ticketPrice * 0.015;
                }
                // ---------------- 其他类型的特殊行李，计入免费额度 -----------------
                else if (othersSpecialBaggage1.contains(baggage.getBaggageType())) {
                    // 计入免费额度的特殊行李已经被当作普通行李计算过了
                }
                // ---------------- 其他类型的特殊行李，不计入免费额度 -----------------
                else if (othersSpecialBaggage2.contains(baggage.getBaggageType()) ||
                        othersSpecialBaggage3.contains(baggage.getBaggageType()) ||
                        othersSpecialBaggage4.contains(baggage.getBaggageType()) ||
                        othersSpecialBaggage5.contains(baggage.getBaggageType())) {
                    // 根据实际重量收费
                    price += baggage.getW() * ticketPrice * 0.015;
                }
            }
        }
        else {
            System.out.println(913);
            // 五个区域 超重且超尺寸 收费情况
            int[] weightAndSize = new int[]{0, 1400, 1100, 520, 2050, 830};
            // 五个区域 不超重但超尺寸 收费情况
            int[] noWeightButSize = new int[]{0, 980, 690, 520, 1040, 520};
            // 五个区域 超重量(28, 32]但不超尺寸 收费情况
            int[] weight28To32ButNoSize = {0, 980, 690, 520, 1040, 520};
            // 五个区域 超重量(23, 28]但不超尺寸 收费情况
            int[] weight23To28ButNoSize = {0, 380, 280, 520, 690, 210};
            // 五个区域 行李件数超出 收费情况
            double[][] exceedBaggage = {
                    // 超出的第一件行李 收费情况
                    {0, 1400, 1100, 1170, 1380, 830},
                    // 超出的第二件行李 收费情况
                    {0, 2000, 1100, 1170, 1380, 1100},
                    // 超出的第三件行李 收费情况
                    {0, 3000, 1590, 1590, 1590, 1590}
            };

            // 计算随身行李限额
            carryOnLimit = 0;
            if (Objects.equals(seatType, "头等舱") || Objects.equals(seatType, "公务舱")) {
                carryOnLimit = 2;
            } else {
                carryOnLimit = 1;
            }

            // 遍历行李，检查 重量和尺寸 是否需要收费
            for (int i = 0, len = num; i < len; i++) {
                Baggage baggage = (Baggage) baggageList.get(i);
//                baggage = baggageDetail.normal[i];
                double baggageSize = baggage.getA() + baggage.getB() + baggage.getH();

                // 检查普通行李尺寸或重量是否合理
                if (baggageSize < 60 || baggageSize > 203 || baggage.getW() < 2 || baggage.getW() > 32) {
                    if (Objects.equals(baggage.getBaggageType(), "普通行李")) {
//                        price+=0.0;//"行李[" + (i + 1) + "]存在尺寸或重量不合理的情况，请合理划分\n";
//                        result.message += "行李[" + (i + 1) + "]存在尺寸或重量不合理的情况，请合理划分\n";
//                      return price;
                    }
                }

                // 判断是否可以作为随身行李
                if (baggage.getA() <= 55 && baggage.getB() <= 40 && baggage.getH() <= 20 && carryOnLimit > 0 && Objects.equals(baggage.getBaggageType(), "普通行李")) {
                    if (Objects.equals(seatType, "头等舱") || Objects.equals(seatType, "公务舱") && baggage.getW() <= 8) {
                        carryOnLimit--;
//                         price+=0.0;//"行李[" + (i + 1) + "]可以作为随身行李携带，不参与计算\n";

//                        result.message += "行李[" + (i + 1) + "]可以作为随身行李携带，不参与计算\n";
                        continue;
                    } else if (baggage.getW() <= 5) {
                        carryOnLimit--;
//                        price+=0.0;//"行李[" + (i + 1) + "]可以作为随身行李携带，不参与计算\n";
//                        return price;
//                        result.message += "行李[" + (i + 1) + "]可以作为随身行李携带，不参与计算\n";
                        continue;
                    }
                }

                // 检查 重量和尺寸 是否需要收费
                if (baggageSize > 158 && Objects.equals(baggage.getBaggageType(), "普通行李")) {
                    // 超尺寸
                    if (baggage.getW() > 23 && !Objects.equals(seatType, "头等舱") && !Objects.equals(seatType, "公务舱")) {       // 超重
                        price += weightAndSize[parseInt(flightArea)];
                    } else {  // 没有超重
                        price += noWeightButSize[parseInt(flightArea)];
                    }
                } else {
                    // 没有超尺寸
                    if (baggage.getW() > 28 && !Objects.equals(seatType, "头等舱") && !Objects.equals(seatType, "公务舱")) {       // 超重 (28, 32]
                        price += weight28To32ButNoSize[parseInt(flightArea)];
                    } else if (baggage.getW() > 23 && !Objects.equals(seatType, "头等舱") && !Objects.equals(seatType, "公务舱")) {  // 超重 (23, 28]
                        price += weight28To32ButNoSize[parseInt(flightArea)];
                    }
                }

            } // !行李遍历for循环结束

            // 检查 件数 是否需要收费
            int baggageNumLimit = 0;
            if (Objects.equals(seatType, "头等舱") || Objects.equals(seatType, "公务舱")) {
                if (Objects.equals(peopleType, "成人票") || Objects.equals(peopleType, "儿童票")) {
                    baggageNumLimit = 2;
                }
            } else if (Objects.equals(seatType, "悦享经济舱 超级经济舱")) {
                baggageNumLimit = 2;
            } else if (Objects.equals(seatType, "经济舱")) {
                baggageNumLimit = 1;//改成1了
            } else {
                baggageNumLimit = 0;
            }

            int num0 = baggageNormalList.size() - baggageNumLimit;
            for (int i = 0; i < num0; i++) {
                if (i < exceedBaggage.length) {
                    // 首先确定这是超出的第几件，然后确定区域
                    price += exceedBaggage[i][parseInt(flightArea)];
                } else {
                    // 超出三件以上，按照最高的标准收费
                    price += exceedBaggage[exceedBaggage.length - 1][parseInt(flightArea)];
                }
            }


            // 计算特殊行李费用
            for (int i = 0, len = baggageSpecialList.size(); i < len; i++) {
                Baggage baggage = (Baggage) baggageSpecialList.get(i);
                // ---------------- 可免费托运的行李 -----------------
                if ((freeSpecialBaggage1.contains(baggage.getBaggageType())) ||
                        (Objects.equals(peopleType, "婴儿票") && freeSpecialBaggage2.contains(baggage.getBaggageType())) ||
                        (freeSpecialBaggage3.contains(baggage.getBaggageType()))) {
                    continue;
                }
                // 非残疾或婴儿旅客托运 轮椅或婴儿床
                else if ((!Objects.equals(peopleType, "婴儿票")) && (freeSpecialBaggage1.contains(baggage.getBaggageType()) || freeSpecialBaggage2.contains(baggage.getBaggageType()))) {
                    // 已经按照普通行李进行计算了
                }
                // ---------------- 运动器械器具，计入免费额度 -----------------
                else if (sportsSpecialBaggage1.contains(baggage.getBaggageType())) {
                    // 计入免费额度的特殊行李已经被当作普通行李计算过了
                }
                // ---------------- 运动器械器具，不计入免费额度 -----------------
                else if (sportsSpecialBaggage2.contains(baggage.getBaggageType())) {
                    if (baggage.getW() < 2) {//                            message += "行李[" + (i + 1) + "]存在重量不合理的情况，请合理划分\n";
                    } else if (baggage.getW() > 45 || true == baggage.getW() > 32) {//                            result.message += "行李[" + (i + 1) + "]存在重量不合理的情况，请合理划分\n";

                        price += 5200;
                    } else if (baggage.getW() > 23) {
                        price += 3900;
                    } else if (baggage.getW() >= 2) {
                        price += 2600;
                    }
                } else if (sportsSpecialBaggage3.contains(baggage.getBaggageType())) {
                    if (baggage.getW() < 2) {//                            result.message += "行李[" + (i + 1) + "]存在重量不合理的情况，请合理划分\n";
                    } else if (baggage.getW() > 45 || baggage.getW() > 32) {//                            result.message += "行李[" + (i + 1) + "]存在重量不合理的情况，请合理划分\n";

                        price += 3900;
                    } else if (baggage.getW() > 23) {
                        price += 2600;
                    } else if (baggage.getW() >= 2) {
                        price += 1300;
                    }
                }
                // ---------------- 其他类型的特殊行李，计入免费额度 -----------------
                else if (othersSpecialBaggage1.contains(baggage.getBaggageType())) {
                    // 计入免费额度的特殊行李已经被当作普通行李计算过了
                }
                // ---------------- 其他类型的特殊行李，不计入免费额度 -----------------
                else if (othersSpecialBaggage2.contains(baggage.getBaggageType())) {
                    if (baggage.getW() < 2) {
                        result.message += "行李[" + (i + 1) + "]存在重量不合理的情况，请合理划分\n";
                    } else if (baggage.getW() > 32) {
                        result.message += "行李[" + (i + 1) + "]存在重量不合理的情况，请合理划分\n";

                        price += 3900;
                    } else if (baggage.getW() > 23) {
                        price += 3900;
                    } else if (baggage.getW() >= 2) {
                        price += 490;
                    }
                } else if (othersSpecialBaggage3.contains(baggage.getBaggageType())) {
                    if (baggage.getW() < 2) {
                        result.message += "行李[" + (i + 1) + "]存在重量不合理的情况，请合理划分\n";
                    } else if (baggage.getW() > 32) {
                        result.message += "行李[" + (i + 1) + "]存在重量不合理的情况，请合理划分\n";

                        price += 2600;
                    } else if (baggage.getW() > 23) {
                        price += 2600;
                    } else if (baggage.getW() >= 2) {
                        price += 1300;
                    }
                } else if (othersSpecialBaggage4.contains(baggage.getBaggageType())) {
                    if (true == baggage.getW() < 2) {
                        result.message += "行李[" + (i + 1) + "]存在重量不合理的情况，请合理划分\n";
                    } else if (true == baggage.getW() > 5) {
                        result.message += "行李[" + (i + 1) + "]存在重量不合理的情况，请合理划分\n";

                        price += 1300;
                    } else if (true == baggage.getW() >= 2) {
                        price += 1300;
                    }
                } else if (othersSpecialBaggage5.contains(baggage.getBaggageType())) {
                    if (true == baggage.getW() < 2) {
                        result.message += "行李[" + (i + 1) + "]存在重量不合理的情况，请合理划分\n";
                    } else if (true == baggage.getW() > 32) {
                        result.message += "行李[" + (i + 1) + "]存在重量不合理的情况，请合理划分\n";

                        price += 7800;
                    } else if (true == baggage.getW() > 23) {
                        price += 7800;
                    } else if (true == baggage.getW() > 8) {
                        price += 5200;
                    } else if (true == baggage.getW() >= 2) {
                        price += 3900;
                    }
                }
            } // !特殊行李for循环结束

        } // !国际、地区计算结束
        result.price=price;
        // 返回计算结果

        return price;
    }
}


