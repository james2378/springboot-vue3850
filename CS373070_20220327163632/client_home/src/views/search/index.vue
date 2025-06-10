<template>
  <div class="page_search">
	<div class="warp">
	  <div class="container">
		<div class="row">
		  <div class="col-12">
			<div class="card_result_search">
			  <div class="title">搜索结果</div>
				<!-- 文章搜索结果 -->
			  <list_result_search
				:list="result_article"
				title="运动会资讯"
				source_table="article"
			  ></list_result_search>
			  <list_result_search
				v-if="$check_action('/volunteer/list', 'get')"
				:list="result_volunteer_gender"
				title="志愿者性别"
				source_table="volunteer"
			  ></list_result_search>
			  <list_result_search
				v-if="$check_action('/site_information/list', 'get')"
				:list="result_site_information_site_type"
				title="场地信息场地类型"
				source_table="site_information"
			  ></list_result_search>
			  <list_result_search
				v-if="$check_action('/site_information/list', 'get')"
				:list="result_site_information_site_name"
				title="场地信息场地名称"
				source_table="site_information"
			  ></list_result_search>
			  <list_result_search
				v-if="$check_action('/referee/list', 'get')"
				:list="result_referee_gender"
				title="裁判员性别"
				source_table="referee"
			  ></list_result_search>
			  <list_result_search
				v-if="$check_action('/athletes/list', 'get')"
				:list="result_athletes_gender"
				title="运动员性别"
				source_table="athletes"
			  ></list_result_search>
			  <list_result_search
				v-if="$check_action('/event/list', 'get')"
				:list="result_event_competition_type"
				title="比赛项目比赛类型"
				source_table="event"
			  ></list_result_search>
			  <list_result_search
				v-if="$check_action('/event/list', 'get')"
				:list="result_event_project_type"
				title="比赛项目项目类型"
				source_table="event"
			  ></list_result_search>
			  <list_result_search
				v-if="$check_action('/event/list', 'get')"
				:list="result_event_site_name"
				title="比赛项目场地名称"
				source_table="event"
			  ></list_result_search>
			  <list_result_search
				v-if="$check_action('/competition_registration/list', 'get')"
				:list="result_competition_registration_competition_type"
				title="比赛报名比赛类型"
				source_table="competition_registration"
			  ></list_result_search>
			  <list_result_search
				v-if="$check_action('/competition_registration/list', 'get')"
				:list="result_competition_registration_project_type"
				title="比赛报名项目类型"
				source_table="competition_registration"
			  ></list_result_search>
			  <list_result_search
				v-if="$check_action('/competition_registration/list', 'get')"
				:list="result_competition_registration_site_name"
				title="比赛报名场地名称"
				source_table="competition_registration"
			  ></list_result_search>
			  <list_result_search
				v-if="$check_action('/referee_allocation/list', 'get')"
				:list="result_referee_allocation_competition_type"
				title="裁判分配比赛类型"
				source_table="referee_allocation"
			  ></list_result_search>
			  <list_result_search
				v-if="$check_action('/referee_allocation/list', 'get')"
				:list="result_referee_allocation_project_type"
				title="裁判分配项目类型"
				source_table="referee_allocation"
			  ></list_result_search>
			  <list_result_search
				v-if="$check_action('/referee_allocation/list', 'get')"
				:list="result_referee_allocation_site_name"
				title="裁判分配场地名称"
				source_table="referee_allocation"
			  ></list_result_search>
			  <list_result_search
				v-if="$check_action('/competition_result_information/list', 'get')"
				:list="result_competition_result_information_competition_type"
				title="比赛成绩信息比赛类型"
				source_table="competition_result_information"
			  ></list_result_search>
			  <list_result_search
				v-if="$check_action('/competition_result_information/list', 'get')"
				:list="result_competition_result_information_competition_name"
				title="比赛成绩信息比赛名称"
				source_table="competition_result_information"
			  ></list_result_search>
			  <list_result_search
				v-if="$check_action('/competition_result_information/list', 'get')"
				:list="result_competition_result_information_site_name"
				title="比赛成绩信息场地名称"
				source_table="competition_result_information"
			  ></list_result_search>
			  <list_result_search
				v-if="$check_action('/volunteer_assignment/list', 'get')"
				:list="result_volunteer_assignment_competition_type"
				title="志愿者分配比赛类型"
				source_table="volunteer_assignment"
			  ></list_result_search>
			  <list_result_search
				v-if="$check_action('/volunteer_assignment/list', 'get')"
				:list="result_volunteer_assignment_project_type"
				title="志愿者分配项目类型"
				source_table="volunteer_assignment"
			  ></list_result_search>
			  <list_result_search
				v-if="$check_action('/volunteer_assignment/list', 'get')"
				:list="result_volunteer_assignment_site_name"
				title="志愿者分配场地名称"
				source_table="volunteer_assignment"
			  ></list_result_search>
			</div>
		  </div>
		</div>
	  </div>
	</div>
  </div>
</template>

<script>
import mixin from "../../mixins/page.js";
import list_result_search from "../../components/diy/list_result_search.vue";

export default {
  mixins: [mixin],
  data() {
	return {
	  "query": {
		word: "",
	  },
	  "result_article": [],
			"result_volunteer_gender":[],
			"result_site_information_site_type":[],
			"result_site_information_site_name":[],
			"result_referee_gender":[],
			"result_athletes_gender":[],
			"result_event_competition_type":[],
			"result_event_project_type":[],
			"result_event_site_name":[],
			"result_competition_registration_competition_type":[],
			"result_competition_registration_project_type":[],
			"result_competition_registration_site_name":[],
			"result_referee_allocation_competition_type":[],
			"result_referee_allocation_project_type":[],
			"result_referee_allocation_site_name":[],
			"result_competition_result_information_competition_type":[],
			"result_competition_result_information_competition_name":[],
			"result_competition_result_information_site_name":[],
			"result_volunteer_assignment_competition_type":[],
			"result_volunteer_assignment_project_type":[],
			"result_volunteer_assignment_site_name":[],
	};
  },
  methods: {
	/**
	 * 获取文章
	 */
	get_article() {
	  this.$get("~/api/article/get_list?like=0", { page: 1, size: 10, title: this.query.word }, (json) => {
		if (json.result) {
		  this.result_article = json.result.list;
		}
	  });
	},
	/**
	 * 获取gender
	 */
	get_volunteer_gender(){
		this.$get("~/api/volunteer/get_list?like=0", { page: 1, size: 10, "gender": this.query.word }, (json) => {
		  if (json.result) {
			var result_volunteer_gender = json.result.list;
			result_volunteer_gender.map(o => o.title = o['gender'])
	  			this.result_volunteer_gender = result_volunteer_gender
		 	}
		});
	},
	/**
	 * 获取site_type
	 */
	get_site_information_site_type(){
		this.$get("~/api/site_information/get_list?like=0", { page: 1, size: 10, "site_type": this.query.word }, (json) => {
		  if (json.result) {
			var result_site_information_site_type = json.result.list;
			result_site_information_site_type.map(o => o.title = o['site_type'])
	  			this.result_site_information_site_type = result_site_information_site_type
		 	}
		});
	},
	/**
	 * 获取site_name
	 */
	get_site_information_site_name(){
		this.$get("~/api/site_information/get_list?like=0", { page: 1, size: 10, "site_name": this.query.word }, (json) => {
		  if (json.result) {
			var result_site_information_site_name = json.result.list;
			result_site_information_site_name.map(o => o.title = o['site_name'])
	  			this.result_site_information_site_name = result_site_information_site_name
		 	}
		});
	},
	/**
	 * 获取gender
	 */
	get_referee_gender(){
		this.$get("~/api/referee/get_list?like=0", { page: 1, size: 10, "gender": this.query.word }, (json) => {
		  if (json.result) {
			var result_referee_gender = json.result.list;
			result_referee_gender.map(o => o.title = o['gender'])
	  			this.result_referee_gender = result_referee_gender
		 	}
		});
	},
	/**
	 * 获取gender
	 */
	get_athletes_gender(){
		this.$get("~/api/athletes/get_list?like=0", { page: 1, size: 10, "gender": this.query.word }, (json) => {
		  if (json.result) {
			var result_athletes_gender = json.result.list;
			result_athletes_gender.map(o => o.title = o['gender'])
	  			this.result_athletes_gender = result_athletes_gender
		 	}
		});
	},
	/**
	 * 获取competition_type
	 */
	get_event_competition_type(){
		this.$get("~/api/event/get_list?like=0", { page: 1, size: 10, "competition_type": this.query.word }, (json) => {
		  if (json.result) {
			var result_event_competition_type = json.result.list;
			result_event_competition_type.map(o => o.title = o['competition_type'])
	  			this.result_event_competition_type = result_event_competition_type
		 	}
		});
	},
	/**
	 * 获取project_type
	 */
	get_event_project_type(){
		this.$get("~/api/event/get_list?like=0", { page: 1, size: 10, "project_type": this.query.word }, (json) => {
		  if (json.result) {
			var result_event_project_type = json.result.list;
			result_event_project_type.map(o => o.title = o['project_type'])
	  			this.result_event_project_type = result_event_project_type
		 	}
		});
	},
	/**
	 * 获取site_name
	 */
	get_event_site_name(){
		this.$get("~/api/event/get_list?like=0", { page: 1, size: 10, "site_name": this.query.word }, (json) => {
		  if (json.result) {
			var result_event_site_name = json.result.list;
			result_event_site_name.map(o => o.title = o['site_name'])
	  			this.result_event_site_name = result_event_site_name
		 	}
		});
	},
	/**
	 * 获取competition_type
	 */
	get_competition_registration_competition_type(){
		this.$get("~/api/competition_registration/get_list?like=0", { page: 1, size: 10, "competition_type": this.query.word }, (json) => {
		  if (json.result) {
			var result_competition_registration_competition_type = json.result.list;
			result_competition_registration_competition_type.map(o => o.title = o['competition_type'])
	  			this.result_competition_registration_competition_type = result_competition_registration_competition_type
		 	}
		});
	},
	/**
	 * 获取project_type
	 */
	get_competition_registration_project_type(){
		this.$get("~/api/competition_registration/get_list?like=0", { page: 1, size: 10, "project_type": this.query.word }, (json) => {
		  if (json.result) {
			var result_competition_registration_project_type = json.result.list;
			result_competition_registration_project_type.map(o => o.title = o['project_type'])
	  			this.result_competition_registration_project_type = result_competition_registration_project_type
		 	}
		});
	},
	/**
	 * 获取site_name
	 */
	get_competition_registration_site_name(){
		this.$get("~/api/competition_registration/get_list?like=0", { page: 1, size: 10, "site_name": this.query.word }, (json) => {
		  if (json.result) {
			var result_competition_registration_site_name = json.result.list;
			result_competition_registration_site_name.map(o => o.title = o['site_name'])
	  			this.result_competition_registration_site_name = result_competition_registration_site_name
		 	}
		});
	},
	/**
	 * 获取competition_type
	 */
	get_referee_allocation_competition_type(){
		this.$get("~/api/referee_allocation/get_list?like=0", { page: 1, size: 10, "competition_type": this.query.word }, (json) => {
		  if (json.result) {
			var result_referee_allocation_competition_type = json.result.list;
			result_referee_allocation_competition_type.map(o => o.title = o['competition_type'])
	  			this.result_referee_allocation_competition_type = result_referee_allocation_competition_type
		 	}
		});
	},
	/**
	 * 获取project_type
	 */
	get_referee_allocation_project_type(){
		this.$get("~/api/referee_allocation/get_list?like=0", { page: 1, size: 10, "project_type": this.query.word }, (json) => {
		  if (json.result) {
			var result_referee_allocation_project_type = json.result.list;
			result_referee_allocation_project_type.map(o => o.title = o['project_type'])
	  			this.result_referee_allocation_project_type = result_referee_allocation_project_type
		 	}
		});
	},
	/**
	 * 获取site_name
	 */
	get_referee_allocation_site_name(){
		this.$get("~/api/referee_allocation/get_list?like=0", { page: 1, size: 10, "site_name": this.query.word }, (json) => {
		  if (json.result) {
			var result_referee_allocation_site_name = json.result.list;
			result_referee_allocation_site_name.map(o => o.title = o['site_name'])
	  			this.result_referee_allocation_site_name = result_referee_allocation_site_name
		 	}
		});
	},
	/**
	 * 获取competition_type
	 */
	get_competition_result_information_competition_type(){
		this.$get("~/api/competition_result_information/get_list?like=0", { page: 1, size: 10, "competition_type": this.query.word }, (json) => {
		  if (json.result) {
			var result_competition_result_information_competition_type = json.result.list;
			result_competition_result_information_competition_type.map(o => o.title = o['competition_type'])
	  			this.result_competition_result_information_competition_type = result_competition_result_information_competition_type
		 	}
		});
	},
	/**
	 * 获取competition_name
	 */
	get_competition_result_information_competition_name(){
		this.$get("~/api/competition_result_information/get_list?like=0", { page: 1, size: 10, "competition_name": this.query.word }, (json) => {
		  if (json.result) {
			var result_competition_result_information_competition_name = json.result.list;
			result_competition_result_information_competition_name.map(o => o.title = o['competition_name'])
	  			this.result_competition_result_information_competition_name = result_competition_result_information_competition_name
		 	}
		});
	},
	/**
	 * 获取site_name
	 */
	get_competition_result_information_site_name(){
		this.$get("~/api/competition_result_information/get_list?like=0", { page: 1, size: 10, "site_name": this.query.word }, (json) => {
		  if (json.result) {
			var result_competition_result_information_site_name = json.result.list;
			result_competition_result_information_site_name.map(o => o.title = o['site_name'])
	  			this.result_competition_result_information_site_name = result_competition_result_information_site_name
		 	}
		});
	},
	/**
	 * 获取competition_type
	 */
	get_volunteer_assignment_competition_type(){
		this.$get("~/api/volunteer_assignment/get_list?like=0", { page: 1, size: 10, "competition_type": this.query.word }, (json) => {
		  if (json.result) {
			var result_volunteer_assignment_competition_type = json.result.list;
			result_volunteer_assignment_competition_type.map(o => o.title = o['competition_type'])
	  			this.result_volunteer_assignment_competition_type = result_volunteer_assignment_competition_type
		 	}
		});
	},
	/**
	 * 获取project_type
	 */
	get_volunteer_assignment_project_type(){
		this.$get("~/api/volunteer_assignment/get_list?like=0", { page: 1, size: 10, "project_type": this.query.word }, (json) => {
		  if (json.result) {
			var result_volunteer_assignment_project_type = json.result.list;
			result_volunteer_assignment_project_type.map(o => o.title = o['project_type'])
	  			this.result_volunteer_assignment_project_type = result_volunteer_assignment_project_type
		 	}
		});
	},
	/**
	 * 获取site_name
	 */
	get_volunteer_assignment_site_name(){
		this.$get("~/api/volunteer_assignment/get_list?like=0", { page: 1, size: 10, "site_name": this.query.word }, (json) => {
		  if (json.result) {
			var result_volunteer_assignment_site_name = json.result.list;
			result_volunteer_assignment_site_name.map(o => o.title = o['site_name'])
	  			this.result_volunteer_assignment_site_name = result_volunteer_assignment_site_name
		 	}
		});
	},

  },
  components: { list_result_search },
	created(){
    this.query.word = this.$route.query.word || "";
  },
  mounted() {
	this.get_article();
		this.get_volunteer_gender();
		this.get_site_information_site_type();
		this.get_site_information_site_name();
		this.get_referee_gender();
		this.get_athletes_gender();
		this.get_event_competition_type();
		this.get_event_project_type();
		this.get_event_site_name();
		this.get_competition_registration_competition_type();
		this.get_competition_registration_project_type();
		this.get_competition_registration_site_name();
		this.get_referee_allocation_competition_type();
		this.get_referee_allocation_project_type();
		this.get_referee_allocation_site_name();
		this.get_competition_result_information_competition_type();
		this.get_competition_result_information_competition_name();
		this.get_competition_result_information_site_name();
		this.get_volunteer_assignment_competition_type();
		this.get_volunteer_assignment_project_type();
		this.get_volunteer_assignment_site_name();
  },
  watch: {
	$route() {
	  $.push(this.query, this.$route.query);
	  this.get_article();
	  this.get_volunteer_gender();
	  this.get_site_information_site_type();
	  this.get_site_information_site_name();
	  this.get_referee_gender();
	  this.get_athletes_gender();
	  this.get_event_competition_type();
	  this.get_event_project_type();
	  this.get_event_site_name();
	  this.get_competition_registration_competition_type();
	  this.get_competition_registration_project_type();
	  this.get_competition_registration_site_name();
	  this.get_referee_allocation_competition_type();
	  this.get_referee_allocation_project_type();
	  this.get_referee_allocation_site_name();
	  this.get_competition_result_information_competition_type();
	  this.get_competition_result_information_competition_name();
	  this.get_competition_result_information_site_name();
	  this.get_volunteer_assignment_competition_type();
	  this.get_volunteer_assignment_project_type();
	  this.get_volunteer_assignment_site_name();
	},
  },
};
</script>

<style scoped>
.card_search {
  text-align: center;
}
.card_result_search>.title {
  text-align: center;
  padding: 10px 0;
}
</style>
