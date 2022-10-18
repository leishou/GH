// import {
//   login
// } from '../../api/login.js'

// const user = {
//   actions: {
//     //登录
//     //定义Login方法，在组件中使用语法this.$store.dispatch("Login")
//     Login({
//       commit
//     }, userInfo) {
//       //const username=userInfo.username.trim()//处理传递过来的数据
//       const {
//         list
//       } = userInfo
//       //封装一个 Promise
//       // console.log(list)
//       return new Promise((resolve, reject) => {
//         //使用 login 接口进行网络请求
//         login(list).then(response => {
//           commit('') //提交一个 mutation，通知状态改变
//           resolve(response) //将结果封装进 Promise
//         }).catch(error => {
//           reject(error)
//         })
//       })
//     },
//   }
// }
// export default user
