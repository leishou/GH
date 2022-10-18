import axios from 'axios';
import router from '../router';
// import baseUrl from "@/api/baseUrl";
//import baseUrl from '../api/baseUrl'使用环境变量 + 模式的方式定义基础URL
// axios.defaults.withCredentials = true; //true允许跨域
// axios.interceptors.response.use(success => {
//   //业务逻辑错误
//   if (success.status && success.status == 200) {
//     if (success.data.code == 500 || success.data.code == 401 || success.data.code == 403) {
//       Message.error({
//         message: success.data.message
//       });
//       return;
//     }
//     if (success.data.message) {
//       Message.success({
//         message: success.data.message
//       })
//     }
//     return success.data;
//   }
// });
// const service = axios.create({
//   baseURL: '',
//   timeout: 15000,
// })
const request = axios.create({
  baseURL: "",
  timeout: 5000,
})
request.interceptors.request.use(config => {
  config.headers['Content-Type'] = 'application/json;charset=utf-8';
  return config
})
export default request
