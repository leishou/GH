import App from './App'
import ElementUI from 'element-ui';
import uView from "uview-ui";
import config from './utils/config.js'
import request from './utils/request.js'
import router from './router'
import axios from 'axios'
import store from './store'
Vue.use(ElementUI)
Vue.use(router)
Vue.config.productionTip = false
Vue.prototype.$axios = axios
// import 'element-ui/lib/theme-chalk/index.css';
Vue.use(uView);
//配置文件
Vue.prototype.$c = config;
//http配置
Vue.prototype.$H = request;
// #ifndef VUE3
import Vue from 'vue'
Vue.config.productionTip = false
App.mpType = 'app'
const app = new Vue({
  ...App,
  router,
  store,
  render: h => h(App) //递交实例
})
app.$mount()
// #endif

// #ifdef VUE3
import {
  createSSRApp
} from 'vue'
export function createApp() {
  const app = createSSRApp(App)
  return {
    app
  }
}
// #endif
