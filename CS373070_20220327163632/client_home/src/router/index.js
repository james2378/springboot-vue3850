import Vue from 'vue';
import VueRouter from 'vue-router';
import index from '../views/index.vue'
import login from '../views/account/login.vue';

Vue.use(VueRouter)

const routes = [
	// 主页ss
	{
		path: '/',
		name: 'index',
		component: index
	},
	// 登录
	{
		path: '/account/login',
		name: 'login',
		component: login
	},
	// 忘记密码
	{
		path: '/account/forgot',
		name: 'forgot',
		component: () => import('../views/account/forgot.vue')
	},
	// 注册账号
	{
		path: '/account/register',
		name: 'register',
		component: () => import('../views/account/register.vue')
	},
	// 媒体图片
	{
		path: '/media/image',
		name: 'media_image',
		component: () => import('../views/media/image.vue')
	},
	// 音乐
	{
		path: '/media/music',
		name: 'media_music',
		component: () => import('../views/media/music.vue')
	},
	// 媒体视频
	{
		path: '/media/video',
		name: 'media_video',
		component: () => import('../views/media/video.vue')
	},
	// 文章路由
	{
		path: '/article/list',
		name: 'article_list',
		component: () => import('../views/article/list.vue')
	},
	{
		path: '/article/details',
		name: 'article_details',
		component: () => import('../views/article/details.vue')
	},
	// 浏览网站
	// 收藏路由
	{
		path: '/user/collect',
		name: 'collect_list',
		component: () => import('../views/user/collect.vue')
	},
	// 公告路由
	{
		path: '/notice/list',
		name: 'notice_list',
		component: () => import('../views/notice/list.vue')
	},
	{
		path: '/notice/details',
		name: 'notice_details',
		component: () => import('../views/notice/details.vue')
	},
	//场地信息列表路由
	{
		path: '/site_information/list',
		name: '/site_information_list',
		component: () => import('../views/site_information/list.vue')
	},
	//场地信息详情路由
	{
		path: '/site_information/details',
		name: '/site_information_details',
		component: () => import('../views/site_information/details.vue')
	},
	//比赛项目列表路由
	{
		path: '/event/list',
		name: '/event_list',
		component: () => import('../views/event/list.vue')
	},
	//比赛项目详情路由
	{
		path: '/event/details',
		name: '/event_details',
		component: () => import('../views/event/details.vue')
	},
	//比赛报名添加路由
	{
		path: '/competition_registration/edit',
		name: '/competition_registration_edit',
		component: () => import('../views/competition_registration/edit.vue')
	},
	//比赛成绩信息列表路由
	{
		path: '/competition_result_information/list',
		name: '/competition_result_information_list',
		component: () => import('../views/competition_result_information/list.vue')
	},
	//比赛成绩信息详情路由
	{
		path: '/competition_result_information/details',
		name: '/competition_result_information_details',
		component: () => import('../views/competition_result_information/details.vue')
	},

	// 用户路由
	{
		path: '/user/index',
		name: 'user_index',
		component: () => import('../views/user/index.vue')
	},
	// 基本信息
	{
		path: '/user/info',
		name: 'user_info',
		component: () => import('../views/user/info.vue')
	},
	// 找回密码
	{
		path: '/user/password',
		name: 'user_password',
		component: () => import('../views/user/password.vue')
	},

	// 搜索
	{
		path: '/search',
		name: 'search',
		component: () => import('../views/search/index.vue')
	},
	// 局部搜索
	{
		path: '/search/details',
		name: 'search_details',
		component: () => import('../views/search/details.vue')
	}
]

const router = new VueRouter({
	mode: 'history',
	base: process.env.BASE_URL,
	routes
})

router.afterEach((to, from, next) => {
	let title = "校园运动会管理系统-home";
	document.title = title;
	document.logo = "校园运动会管理系统"
})

export default router
