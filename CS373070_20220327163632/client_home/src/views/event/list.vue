<template>
	<div class="diy_list page_event" id="event_list">
		<div class="warp">
			<div class="container diy_list_container">
				<div class="diy_list_title">
					<div class="col">
						<span class="title">比赛项目列表</span>
					</div>
				</div>
				<div class="row diy_list_search">
					<div class="col">
						<!-- 搜索栏 -->
						<div class="view">							
							<span class="diy_list_search_title">关键字搜索：</span>
							<b-form-input size="sm" class="mr-sm-2" placeholder="比赛类型搜索" v-model="query['competition_type']" />
							<b-form-input size="sm" class="mr-sm-2" placeholder="项目类型搜索" v-model="query['project_type']" />
							<b-form-input size="sm" class="mr-sm-2" placeholder="场地名称搜索" v-model="query['site_name']" />
							<b-button size="sm" @click="search_event()" >
								<b-icon icon="search"/>
							</b-button>
						</div>
						<!-- /搜索栏 -->
					</div>
				</div>
				<div class="diy_list_select_box">
					<span class="diy_list_select_title">下拉搜索：</span>
						<div class="diy_list_dropdown_box">
						<div class="col">
							<!-- 筛选 -->
							<div class="view">
								<b-dropdown text="比赛类型" variant="outline-dark" left>
									<b-dropdown-item @click="filter_set('全部','competition_type')">全部</b-dropdown-item>
										<b-dropdown-item v-for="(o, i) in list_competition_type" :key="i" @click="filter_set(o['competition_type'],'competition_type')" >
												{{ o['competition_type'] }}
										</b-dropdown-item>
								</b-dropdown>
								<b-dropdown :text="title" variant="outline-dark" left>
									<b-dropdown-item @click="filter_set('全部','project_type')">全部</b-dropdown-item>
										<b-dropdown-item v-for="(o,i) in list_project_type" @click="filter_set(o,'project_type')" >
										{{ o }}
										</b-dropdown-item>
								</b-dropdown>
								<b-dropdown text="场地名称" variant="outline-dark" left>
									<b-dropdown-item @click="filter_set('全部','site_name')">全部</b-dropdown-item>
										<b-dropdown-item v-for="(o, i) in list_site_name" :key="i" @click="filter_set(o['site_name'],'site_name')" >
												{{ o['site_name'] }}
										</b-dropdown-item>
								</b-dropdown>
							</div>
							<!-- /筛选 -->
						</div>
					</div>
					<div class="diy_list_sort_box">
						<div class="col">
							<!-- 排序 -->
							<div class="view">
								<b-dropdown text="排序" variant="outline-dark" left>
										<b-dropdown-item v-for="(o, i) in list_sort" :key="i" @click="set_sort(o)" >
												{{ o.name }}
										</b-dropdown-item>
								</b-dropdown>
							</div>
							<!--/排序 -->
						</div>
					</div>
				</div>
				<div class="row diy_list_box">
					<div class="col">
						<!-- tab -->
						<b-tabs content-class="mt-3">
							<b-tab v-for="(o, i) in list_type_competition_type" :title="o['competition_type']" :active="i===0" @click="tab_select(o['competition_type'])">
								<div class="row">
									<div class="col">
										<!-- tab -->
										<list_event :list="type_list[o['competition_type']]" />
										<!-- /tab -->
									</div>
								</div>
							</b-tab>
						</b-tabs>
						<!-- /tab -->
					</div>
				</div>
				<div class="row diy_list_page_box">
					<div class="col overflow-auto flex_cc">
						<!-- 分页器 -->
						<diy_pager v-model="query['page']" :size="query['size']" :count="count" v-on:toPage="toPage" v-on:toSize="toSize" ></diy_pager>
						<!-- /分页器 -->
					</div>
				</div>
			</div>
		</div>
	</div>
</template>

<script>
	import list_event from "@/components/diy/list_event.vue";
	import diy_pager from "@/components/diy/diy_pager";
	import mixin from "@/mixins/page.js";

	export default {
		mixins: [mixin],
		components: {
			diy_pager,
			list_event
		},
		data() {
			return {
				url_get_list: "~/api/event/get_list?like=0",

				// 查询条件
				query: {
					keyword: "",
					page: 1,
					size: 10,
					"competition_type": "", // 比赛类型
					"project_type": "", // 项目类型
					"site_name": "", // 场地名称
				},

				// 排序内容
				list_sort: [{
						name: "创建时间从高到低",
						value: "`create_time` desc",
					},
					{
						name: "创建时间从低到高",
						value: "`create_time` asc",
					},
					{
						name: "更新时间从高到低",
						value: "`update_time` desc",
					},
					{
						name: "更新时间从低到高",
						value: "`update_time` asc",
					},
					{
						name: "比赛类型正序",
						value: "`competition_type` asc",
					},
					{
						name: "比赛类型倒序",
						value: "`competition_type` desc",
					},
					{
						name: "项目类型正序",
						value: "`project_type` asc",
					},
					{
						name: "项目类型倒序",
						value: "`project_type` desc",
					},
					{
						name: "场地名称正序",
						value: "`site_name` asc",
					},
					{
						name: "场地名称倒序",
						value: "`site_name` desc",
					},
				],
				// 比赛类型列表
				"list_competition_type": [],
				// 项目类型列表
				"list_project_type": ['单人','团体'],
				// 场地名称列表
				"list_site_name": [],
				"list_type_competition_type": [],
				"type_list":{},
			}
		},
		methods: {
			/**
			 * 筛选选择
			 */
			filter_set(o,key) {
			    if (o == "全部") {
			        this.query[key] = "";
			    } else {
			        this.query[key] = o;
			    }
			    this.search();
			},

			/**
			 * 排序
			 */
			set_sort(o) {
			    this.query.orderby = o.value;
			    this.search();
			},
			async get_list_type_competition_type() {
				var json = await this.$get("~/api/event/get_list?groupby=competition_type");
				if (json.result) {
					this.list_type_competition_type = json.result.list;
					for (let i = 0;i<this.list_type_competition_type.length;i++){
						this.get_competition_type_type_list(this.list_type_competition_type[i].competition_type);
					}
					this.query.competition_type = this.list_type_competition_type[0].competition_type;
					this.get_list();
				} else if (json.error) {
					console.log(json.error);
				}
			},

			get_competition_type_type_list(type){
				let _this = this;
				this.$get("~/api/event/get_list?", {"competition_type":type}, (json) => {
					if (json.result) {
						_this.$set(_this.type_list,type, json.result.list);
					}
				});
			},
			tab_select(v){
				this.query.competition_type = v;
				this.get_list();
			},
			search_event(){
				let _this = this;
				this.$get("~/api/event/get_list?like=0", _this.query, (json) => {
					if (json.result) {
						_this.$set(_this.type_list,_this.query.competition_type, json.result.list);
						_this.get_list();
					}
				});
			},
			/**
			 * 获取比赛类型列表
			 */
			async get_list_competition_type() {
				var json = await this.$get("~/api/competition_classification/get_list?");
				if (json.result) {
					this.list_competition_type = json.result.list;
				} else if (json.error) {
					console.log(json.error);
				}
			},
			/**
			 * 获取场地名称列表
			 */
			async get_list_site_name() {
				var json = await this.$get("~/api/site_information/get_list?");
				if (json.result) {
					this.list_site_name = json.result.list;
				} else if (json.error) {
					console.log(json.error);
				}
			},

			/**
			 * 筛选
			 */
			filter_competition_type(o) {
				if (o == "全部") {
					this.query["competition_type"] = "";
				} else {
					this.query["competition_type"] = o;
				}
				this.search();
			},
			filter_project_type(o) {
				if (o == "全部") {
					this.query["project_type"] = "";
				} else {
					this.query["project_type"] = o;
				}
				this.search();
			},
			filter_site_name(o) {
				if (o == "全部") {
					this.query["site_name"] = "";
				} else {
					this.query["site_name"] = o;
				}
				this.search();
			},

			/**
			 * 重置
			 */
			reset() {
				this.query.competition_type = ""
				this.query.project_type = ""
				this.query.site_name = ""
				this.search();
			},

			// 返回条数
			toSize(i){
				this.query.size = i;
				this.first();
			},

			// 返回页数
			toPage(i){
				this.query.page = i;
				this.first();
			},
		},
		computed: {
		},
		created() {
			/**
			 * 获取比赛类型列表
			 */
			this.get_list_competition_type();
			/**
			 * 获取场地名称列表
			 */
			this.get_list_site_name();
			this.get_list_type_competition_type();
		}
	}
</script>

<style>
</style>
