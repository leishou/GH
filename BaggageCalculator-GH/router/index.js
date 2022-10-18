import Vue from 'vue'
import VueRouter from 'vue-router'
Vue.use(VueRouter)
export const constantRouterMap = [{
  path: '/',
  component: () => import('../pages/index/index')
}, ]

export default new VueRouter({

  scrollBehavior: () => ({
    y: 0
  }),
  routes: constantRouterMap //指定路由列表
});
