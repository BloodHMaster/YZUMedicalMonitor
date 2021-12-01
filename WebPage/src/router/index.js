import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

/* Layout */
import Layout from '@/layout'

/**
 * Note: sub-menu only appear when route children.length >= 1
 * Detail see: https://panjiachen.github.io/vue-element-admin-site/guide/essentials/router-and-nav.html
 *
 * hidden: true                   if set true, item will not show in the sidebar(default is false)
 * alwaysShow: true               if set true, will always show the root menu
 *                                if not set alwaysShow, when item has more than one children route,
 *                                it will becomes nested mode, otherwise not show the root menu
 * redirect: noRedirect           if set noRedirect will no redirect in the breadcrumb
 * name:'router-name'             the name is used by <keep-alive> (must set!!!)
 * meta : {
    roles: ['admin','editor']    control the page roles (you can set multiple roles)
    title: 'title'               the name show in sidebar and breadcrumb (recommend set)
    icon: 'svg-name'/'el-icon-x' the icon show in the sidebar
    breadcrumb: false            if set false, the item will hidden in breadcrumb(default is true)
    activeMenu: '/example/list'  if set path, the sidebar will highlight the path you set
  }
 */

/**
 * constantRoutes
 * a base page that does not have permission requirements
 * all roles can be accessed
 */
export const constantRoutes = [
  {
    path: '/login',
    component: () => import('@/views/login/index'),
    hidden: true
  },

  {
    path: '/404',
    component: () => import('@/views/404'),
    hidden: true
  },

  {
    path: '/',
    component: Layout,
    redirect: '/home',
    children: [
      {
        path: 'home',
        name: '首页',
        component: () => import('@/views/home/index'),
        meta: { title: '首页', icon: 'el-icon-s-home' }
      },
    ]
  },

  
  
  {
    path: '/diagnosis',
    component: Layout,
    name: '诊断服务',
    meta: { title: '诊断服务', icon: 'el-icon-video-play' },
    children:[
      {
        path: 'diagnosis1',
        name: '医师推荐',
        component: () => import('@/views/diagnosis/diagnosis1'),
        meta: { title: '医师推荐', icon: 'el-icon-s-custom' }
      },
      {
        path: 'diagnosis2',
        name: '药物推荐',
        component: () => import('@/views/diagnosis/diagnosis2'),
        meta: { title: '药物推荐', icon: 'el-icon-s-goods' }
      }
    ]
  },

  {
    path: '/user',
    component: Layout,
    redirect: '/user/userInfo',
    name: '个人中心',
    meta: { title: '个人中心', icon: 'el-icon-user' },
    children: [
      {
        path: '/password',
        name: '修改密码',
        component: () => import('@/views/user/password'),
        meta: { title: '修改密码', icon: 'tree' }
      },

      {
        path:'/favoritefolders',
        name:'收藏夹',
        component: () => import('@/views/favoritefolders/index'),
        meta: { title: '收藏夹', icon: 'el-icon-folder-opened' },
      },
    ]
  },
 
  {
    path: '/',
    component: Layout,
    children: [
      {
        path: '/feedback',
        name: '用户反馈',
        component: () => import('@/views/feedback/index'),
        meta: { title: '用户反馈', icon: 'el-icon-chat-line-square' }
      },
    ]

  },
  // 404 page must be placed at the end !!!
  { path: '*', redirect: '/404', hidden: true }
]

const createRouter = () => new Router({
  // mode: 'history', // require service support
  scrollBehavior: () => ({ y: 0 }),
  routes: constantRoutes
})

const router = createRouter()

// Detail see: https://github.com/vuejs/vue-router/issues/1234#issuecomment-357941465
export function resetRouter() {
  const newRouter = createRouter()
  router.matcher = newRouter.matcher // reset router
}

export default router
