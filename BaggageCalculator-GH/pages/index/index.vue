<template>
  <view class="index">
    <view class="header">国航托运行李计算器</view>
    <view class="ticketView">
      <uni-forms-item label="航线类型" placeholder="请选择航线">
        <uni-combox :candidates="candidates" v-model="ticket.flightType"></uni-combox>
      </uni-forms-item>
      <uni-forms-item label="航线区域" placeholder="请选择航线区域">
        <uni-combox :candidates="towheres" v-model="ticket.flightArea"></uni-combox>
      </uni-forms-item>
      <uni-forms-item label="机舱类型" placeholder="请选择机舱类型">
        <uni-combox :candidates="planetypes" v-model="ticket.seatType"></uni-combox>
      </uni-forms-item>
      <uni-forms-item label="乘客类型" placeholder="请选择乘客类型">
        <uni-combox :candidates="paytypes" v-model="ticket.peopleType"></uni-combox>
      </uni-forms-item>
      <uni-forms-item label="VIP类型" placeholder="请选择VIP类型">
        <uni-combox :candidates="viptypes" v-model="ticket.vipType"></uni-combox>
      </uni-forms-item>
      <uni-forms-item label="单价" required type="digit">
        <uni-combox required type="digit" v-model="ticket.ticketPrice" placeholder="价格" emptyTips=""></uni-combox>
      </uni-forms-item>
      <button @click="calculate0()">计算</button>
    </view>
    <uni-forms>

    </uni-forms>
    <view class="baggageView">
      <uni-table class="baggagetable" emptyText="">
        <uni-tr>
          <uni-th align="center">行李类型</uni-th>
          <uni-th align="a">长（厘米）</uni-th>
          <uni-th align="b">宽（厘米）</uni-th>
          <uni-th align="h">高（厘米）</uni-th>
          <uni-th align="weight">重量（千克））</uni-th>
          <uni-th>
            <button type="primary" @click="addItem()">新增</button>
          </uni-th>
        </uni-tr>
        <uni-tbody v-for="(item, index) in list" :key="index" :value="item">
          <uni-td>
            <uni-combox :border="false" :candidates="bagtypes" v-model="item.baggageType"></uni-combox>
          </uni-td>
          <uni-td>
            <view class="uni-form-item uni-tr">
              <input class="uni-input" required type="digit" v-model="item.a" placeholder="长" />
            </view>
          </uni-td>
          <uni-td>
            <view class="uni-form-item uni-tr">
              <input class="uni-input" required type="digit" v-model="item.b" placeholder="宽" />
            </view>
          </uni-td>
          <uni-td>
            <view class="uni-form-item uni-column">
              <input class="uni-input" required type="digit" v-model="item.h" placeholder="高" />
            </view>
          </uni-td>
          <uni-td>
            <view class="uni-form-item uni-column">
              <input class="uni-input" required type="digit" v-model="item.w" placeholder="重" />
            </view>
          </uni-td>
          <uni-td>
            <button v-if="index>=0" type="primary" @click="delItem(index)">取消</button>
          </uni-td>
        </uni-tbody>

      </uni-table>
    </view>
  </view>
</template>

<script>
  import request from '../../utils/request.js'
  export default {
    data() {
      return {
        title: '测试',
        candidates: ['国内航线', '国际、地区航线'],
        towheres: ['0', '1', '2', '3', '4', '5'],
        planetypes: ['头等舱', '公务舱', '悦享经济舱 超级经济舱', '经济舱'],
        paytypes: ['成人票', '儿童票', '婴儿票'],
        viptypes: ['无', '凤凰知音终身白金卡、白金卡', '凤凰知音金卡、银卡', '星空联盟金卡'],
        bagtypes: ['普通行李', '手动轮椅', '电动轮椅', '婴儿车或摇篮', '导盲犬', '骨灰', '自行车', '皮划艇', '撑杆', '睡袋', '小型电器或仪器', '可作为行李运输的枪支',
          '可作为行李运输的弹药', '小动物'
        ],
        ticket: {
          flightType: '',
          flightArea: '',
          seatType: '',
          peopleType: '',
          vipType: '',
          ticketPrice: '',
        },
        id: 1,
        price: 0,
        list: [],
        pos: {
          ticket: {
            flightType: '',
            flightArea: '',
            seatType: '',
            peopleType: '',
            vipType: '',
            ticketPrice: '',
          },
          baggageList: []
        }
      }
    },


    onLoad() {

    },
    methods: {
      calculate() {
        // console.log(this.a)
        let i = 0;
        // 航线类型
        let flightType = this.dest;

        // 航线区域
        let flightArea = this.region;
        // console.log(flightArea);

        // 机舱类型
        let seatType = this.planetype;
        // console.log(seatType);

        // 乘客类型
        let peopleType = this.paytype;

        // vip类型
        let vipType = this.vipType;
        // console.log(vipType);

        // 机票价格
        let ticketPrice = this.ticketPrice;
        // console.log(ticketPrice);

        // 是否残疾
        let isDisability = this.isDisability ? true : false;
        // console.log(isDisability);
        let baggage = {
          'a': this.a,
          'b': this.b,
          'c': this.h,
          'w': this.w,
          'baggageType': this.baggageType,
        }
        console.log(baggage.type)
        let result = {
          'message': '',
          'price': this.price,
        };
        console.log(flightType)
        console.log(seatType)
        console.log(peopleType)
        if (flightType === '国内航线') {
          // 计算免费托运额度
          let weightLimit = 0;
          // 计算随身行李限额
          let carryOnLimit = 0;

          // 成人或儿童
          if (peopleType === '成人票' || peopleType === '儿童票') {
            console.log(seatType)
            switch (seatType) {
              case '头等舱':
                weightLimit = 40;
                carryOnLimit = 2;
                break;
              case '公务舱':
                weightLimit = 30;
                carryOnLimit = 2;
                break;
              case '悦享经济舱 超级经济舱':
                weightLimit = 20;
                carryOnLimit = 1;
                break;
              case '经济舱':
                weightLimit = 20;
                carryOnLimit = 1;
                break;
            }


          }
          // 婴儿
          else if (peopleType === '婴儿票') {
            weightLimit = 10;
            switch (seatType) {
              case '头等舱':
              case '公务舱':
                carryOnLimit = 2;
                break;
              case '经济舱':
                carryOnLimit = 1;
                break;
            }
          }
          // vip类型
          switch (vipType) {
            case '凤凰知音终身白金卡、白金卡':
              weightLimit += 30;
              break;
            case '凤凰知音金卡、银卡':
            case '星空联盟金卡':
              weightLimit += 20;
              break;
          }
          let baggageWeight = 0;
          // 检查普通行李尺寸是否超标
          if (baggage.length > 100 || baggage.width > 60 || baggage.height > 40) {
            result.message += '行李[' + (i + 1) + ']存在尺寸超标的情况，请合理划分\n';
          }

          // 判断是否可以作为随身行李
          if (baggage.length <= 55 && baggage.width <= 40 && baggage.height <= 20 && carryOnLimit > 0 && baggage
            .type ===
            '普通行李') {
            if ((seatType === '头等舱' || seatType === '公务舱') && baggage.weight <= 8) {
              carryOnLimit--;
              result.message += '行李[' + (i + 1) + ']可以作为随身行李携带，不参与计算\n';

            } else if (seatType === '经济舱' && baggage.weight <= 5) {
              carryOnLimit--;
              result.message += '行李[' + (i + 1) + ']可以作为随身行李携带，不参与计算\n';

            }

          }

          // 累加重量
          baggageWeight += baggage.weight;
          this.price = baggageWeight > weightLimit ? (baggageWeight - weightLimit) * ticketPrice * 0.015 : 0;
          // result.price = baggageWeight > weightLimit ? (baggageWeight - weightLimit) * ticketPrice * 0.015 : 0;
          // console.log(result.price)
        }

        uni.showModal({
          title: '票价为',
          content: this.price.toLocaleString(),
          showCancel: false,
        });
      },
      addItem() {
        this.list.push({
          baggageType: '',
          a: '',
          b: '',
          h: '',
          w: '',
        })
        // console.log(this.list)
      },
      delItem(index) {
        this.list.splice(index, 1);
      },
      calculate0() {
        this.pos.baggageList = this.list
        this.pos.ticket = this.ticket
        uni.request({
          url: '/api',
          method: 'POST',
          data: {
            ticket: this.ticket,
            baggageList: this.list,
          },
          header: {
            'content-type': 'application/json',
          },
          success(res) {
            if (res.statusCode == 200) {
              if (res.data.message != '操作成功') {
                uni.showModal({
                  title: '请根据提示修改填写信息',
                  content: res.data.message,
                  showCancel: false,
                });
              } else {
                this.price = res.data.data
                uni.showModal({
                  title: '票价为',
                  content: this.price.toLocaleString(),
                  showCancel: false,
                });
              }
            }
          }
        })


      }
    },



  }
</script>

<style>
  .index {
    height: 100vh;
    width: 100%;
    display: -webkit-flex;
    display: flex;
    flex-wrap: wrap;
    justify-content: center;
    align-items: flex-start;
    align-content: flex-start;
  }

  .header {
    align-items: center;
  }

  .example-body {
    padding: 12px;
    background-color: #FFFFFF;
  }

  .ticketView {

    flex: 1;
    width: 60%;
    height: 45vh;
    overflow: auto;
  }

  .baggageView {
    flex: 2;
  }

  .addBtn {
    display: flex;
    flex: 2;
  }
</style>
