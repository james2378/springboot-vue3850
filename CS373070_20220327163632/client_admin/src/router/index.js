import Vue from 'vue';
import VueRouter from 'vue-router';
import index from '../views/index.vue';
import login from '../views/login.vue';
import forgot from '../views/forgot.vue';
Vue.use(VueRouter)

const routes = [
	// 主页
	{
		path: '/',
		name: 'index',
		component: index,
		meta: {
			index: 0,
			title: '首页'
		}
	},

	// 登录
	{
		path: '/login',
		name: 'login',
		component: login,
		meta: {
			index: 0,
			title: '登录'
		}
	},

	// 忘记密码
	{
		path: '/forgot',
		name: "forgot",
		component: forgot,
		meta: {
			index: 0,
			title: '忘记密码'
		}
	},

	// 修改密码
	{
		path: '/user/password',
		name: "password",
		component: () => import("../views/user/password.vue"),
		meta: {
			index: 0,
			title: '修改密码'
		}
	},

	// 视频播放页
	{
		path: "/media/video",
		name: "video",
		component: () => import('../views/media/video.vue'),
		meta: {
			index: 0,
			title: "视频"
		}
	},

	// 音频播放页
	{
		path: "/media/audio",
		name: "audio",
		component: () => import('../views/media/audio.vue'),
		meta: {
			index: 0,
			title: "音频"
		}
	},
	// 权限路由
	{
		path: '/auth/table',
		name: 'auth_table',
		component: () => import('../views/nav/table.vue'),
		meta: {
			index: 0,
			title: '权限列表'
		}
	},
	{
		path: '/auth/view',
		name: 'auth_view',
		component: () => import('../views/nav/view.vue'),
		meta: {
			index: 0,
			title: '权限详情'
		}
	},

	// 友情链接路由
	// {
	// 	path: '/link/table',
	// 	name: 'link_table',
	// 	component: () => import('../views/link/table.vue'),
	// 	meta: {
	// 		index: 0,
	// 		title: '链接列表'
	// 	}
	// },
	// {
	// 	path: '/link/view',
	// 	name: 'link_view',
	// 	component: () => import('../views/link/view.vue'),
	// 	meta: {
	// 		index: 0,
	// 		title: '链接详情'
	// 	}
	// },

	// 轮播图路由
	{
		path: '/slides/table',
		name: 'slides_table',
		component: () => import('../views/slides/table.vue'),
		meta: {
			index: 0,
			title: '轮播图列表'
		}
	},
	{
		path: '/slides/view',
		name: 'slides_view',
		component: () => import('../views/slides/view.vue'),
		meta: {
			index: 0,
			title: '轮播图详情'
		}
	},
	// 文章路由
	{
		path: '/article/table',
		name: 'article_table',
		component: () => import('../views/article/table.vue'),
		meta: {
			index: 0,
			title: '文章列表'
		}
	},
	{
		path: '/article/view',
		name: 'article_view',
		component: () => import('../views/article/view.vue'),
		meta: {
			index: 0,
			title: '文章详情'
		}
	},

	// 文章分类路由
	{
		path: '/article_type/table',
		name: 'article_type_table',
		component: () => import('../views/article_type/table.vue'),
		meta: {
			index: 0,
			title: '文章分类列表'
		}
	},
	{
		path: '/article_type/view',
		name: 'article_type_view',
		component: () => import('../views/article_type/view.vue'),
		meta: {
			index: 0,
			title: '文章分类详情'
		}
	},

	// 广告路由
	// {
	// 	path: '/ad/table',
	// 	name: 'ad_table',
	// 	component: () => import('../views/ad/table.vue'),
	// 	meta: {
	// 		index: 0,
	// 		title: '广告列表'
	// 	}
	// },
	// {
	// 	path: '/ad/view',
	// 	name: 'ad_view',
	// 	component: () => import('../views/ad/view.vue'),
	// 	meta: {
	// 		index: 0,
	// 		title: '广告详情'
	// 	}
	// },
	// 公告路由
	{
		path: '/notice/table',
		name: 'notice_table',
		component: () => import('../views/notice/table.vue'),
		meta: {
			index: 0,
			title: '公告列表'
		}
	},
	{
		path: '/notice/view',
		name: 'notice_view',
		component: () => import('../views/notice/view.vue'),
		meta: {
			index: 0,
			title: '公告详情'
		}
	},
	// 评论路由
	{
		path: '/comment/table',
		name: 'comment_table',
		component: () => import('../views/comment/table.vue'),
		meta: {
			index: 0,
			title: '评论列表'
		}
	},
	{
		path: '/comment/view',
		name: 'comment_view',
		component: () => import('../views/comment/view.vue'),
		meta: {
			index: 0,
			title: '评论详情'
		}
	},
	// 志愿者路由
	{
		path: '/volunteer/table',
		name: 'volunteer_table',
		component: () => import('../views/volunteer/table.vue')
	},
	{
		path: '/volunteer/view',
		name: 'volunteer_view',
		component: () => import('../views/volunteer/view.vue')
	},
	// 场地信息路由
	{
		path: '/site_information/table',
		name: 'site_information_table',
		component: () => import('../views/site_information/table.vue')
	},
	{
		path: '/site_information/view',
		name: 'site_information_view',
		component: () => import('../views/site_information/view.vue')
	},
	// 裁判员路由
	{
		path: '/referee/table',
		name: 'referee_table',
		component: () => import('../views/referee/table.vue')
	},
	{
		path: '/referee/view',
		name: 'referee_view',
		component: () => import('../views/referee/view.vue')
	},
	// 运动员路由
	{
		path: '/athletes/table',
		name: 'athletes_table',
		component: () => import('../views/athletes/table.vue')
	},
	{
		path: '/athletes/view',
		name: 'athletes_view',
		component: () => import('../views/athletes/view.vue')
	},
	// 比赛分类路由
	{
		path: '/competition_classification/table',
		name: 'competition_classification_table',
		component: () => import('../views/competition_classification/table.vue')
	},
	{
		path: '/competition_classification/view',
		name: 'competition_classification_view',
		component: () => import('../views/competition_classification/view.vue')
	},
	// 比赛项目路由
	{
		path: '/event/table',
		name: 'event_table',
		component: () => import('../views/event/table.vue')
	},
	{
		path: '/event/view',
		name: 'event_view',
		component: () => import('../views/event/view.vue')
	},
	// 比赛报名路由
	{
		path: '/competition_registration/table',
		name: 'competition_registration_table',
		component: () => import('../views/competition_registration/table.vue')
	},
	{
		path: '/competition_registration/view',
		name: 'competition_registration_view',
		component: () => import('../views/competition_registration/view.vue')
	},
	// 裁判分配路由
	{
		path: '/referee_allocation/table',
		name: 'referee_allocation_table',
		component: () => import('../views/referee_allocation/table.vue')
	},
	{
		path: '/referee_allocation/view',
		name: 'referee_allocation_view',
		component: () => import('../views/referee_allocation/view.vue')
	},
	// 比赛成绩信息路由
	{
		path: '/competition_result_information/table',
		name: 'competition_result_information_table',
		component: () => import('../views/competition_result_information/table.vue')
	},
	{
		path: '/competition_result_information/view',
		name: 'competition_result_information_view',
		component: () => import('../views/competition_result_information/view.vue')
	},
	// 志愿者分配路由
	{
		path: '/volunteer_assignment/table',
		name: 'volunteer_assignment_table',
		component: () => import('../views/volunteer_assignment/table.vue')
	},
	{
		path: '/volunteer_assignment/view',
		name: 'volunteer_assignment_view',
		component: () => import('../views/volunteer_assignment/view.vue')
	},

	// 用户路由
	{
		path: '/user/table',
		name: 'user_table',
		component: () => import('../views/user/table.vue'),
		meta: {
			index: 0,
			title: '用户列表'
		}
	},
	{
		path: '/user/view',
		name: 'user_view',
		component: () => import('../views/user/view.vue'),
		meta: {
			index: 0,
			title: '用户详情'
		}
	},
	{
		path: '/user/info',
		name: 'user_info',
		component: () => import('../views/user/info.vue'),
		meta: {
			index: 0,
			title: '个人信息'
		}
	},
	// 用户组路由
	{
		path: '/user_group/table',
		name: 'user_group_table',
		component: () => import('../views/user_group/table.vue'),
		meta: {
			index: 0,
			title: '用户组列表'
		}
	},
	{
		path: '/user_group/view',
		name: 'user_group_view',
		component: () => import('../views/user_group/view.vue'),
		meta: {
			index: 0,
			title: '用户组详情'
		}
	}
]

const router = new VueRouter({
	mode: 'history',
	base: process.env.BASE_URL,
	routes
})

router.beforeEach((to, from, next) => {
	let token = to.query.token;
	if (token){
		$.db.set("token",token,120);
	}
	next();
})

router.afterEach((to, from, next) => {
	let title = "校园运动会管理系统-admin";
	document.title = title;
})

export default router
