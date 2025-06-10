<template>
	<el-main class="bg">
		<el-form ref="form" :model="form" status-icon label-width="120px" v-if="is_view()">
			<el-col v-if="user_group === '管理员' || $check_field('get','competition_number') || $check_field('add','competition_number') || $check_field('set','competition_number')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="比赛编号" prop="competition_number">
					<el-input id="competition_number" v-model="form['competition_number']" placeholder="请输入比赛编号"
							  v-if="user_group === '管理员' || (form['referee_allocation_id'] && $check_field('set','competition_number')) || (!form['referee_allocation_id'] && $check_field('add','competition_number'))" :disabled="disabledObj['competition_number_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','competition_number')">{{form['competition_number']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','competition_type') || $check_field('add','competition_type') || $check_field('set','competition_type')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="比赛类型" prop="competition_type">
					<el-input id="competition_type" v-model="form['competition_type']" placeholder="请输入比赛类型"
							  v-if="user_group === '管理员' || (form['referee_allocation_id'] && $check_field('set','competition_type')) || (!form['referee_allocation_id'] && $check_field('add','competition_type'))" :disabled="disabledObj['competition_type_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','competition_type')">{{form['competition_type']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','project_type') || $check_field('add','project_type') || $check_field('set','project_type')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="项目类型" prop="project_type">
					<el-input id="project_type" v-model="form['project_type']" placeholder="请输入项目类型"
							  v-if="user_group === '管理员' || (form['referee_allocation_id'] && $check_field('set','project_type')) || (!form['referee_allocation_id'] && $check_field('add','project_type'))" :disabled="disabledObj['project_type_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','project_type')">{{form['project_type']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','site_name') || $check_field('add','site_name') || $check_field('set','site_name')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="场地名称" prop="site_name">
					<el-input id="site_name" v-model="form['site_name']" placeholder="请输入场地名称"
							  v-if="user_group === '管理员' || (form['referee_allocation_id'] && $check_field('set','site_name')) || (!form['referee_allocation_id'] && $check_field('add','site_name'))" :disabled="disabledObj['site_name_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','site_name')">{{form['site_name']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','game_time') || $check_field('add','game_time') || $check_field('set','game_time')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="比赛时间" prop="game_time">
					<el-input id="game_time" v-model="form['game_time']" placeholder="请输入比赛时间"
							  v-if="user_group === '管理员' || (form['referee_allocation_id'] && $check_field('set','game_time')) || (!form['referee_allocation_id'] && $check_field('add','game_time'))" :disabled="disabledObj['game_time_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','game_time')">{{form['game_time']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','arrival_time') || $check_field('add','arrival_time') || $check_field('set','arrival_time')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="到位时间" prop="arrival_time">
					<el-input id="arrival_time" v-model="form['arrival_time']" placeholder="请输入到位时间"
							  v-if="user_group === '管理员' || (form['referee_allocation_id'] && $check_field('set','arrival_time')) || (!form['referee_allocation_id'] && $check_field('add','arrival_time'))" :disabled="disabledObj['arrival_time_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','arrival_time')">{{form['arrival_time']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','referee') || $check_field('add','referee') || $check_field('set','referee')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="裁判员" prop="referee">
						<el-select v-if="user_group === '管理员' || (form['referee_allocation_id'] && $check_field('set','referee')) || (!form['referee_allocation_id'] && $check_field('add','referee'))" id="referee" v-model="form['referee']" :disabled="disabledObj['referee_isDisabled']">
							<el-option v-for="o in list_user_referee" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
									   :value="o['user_id']">
							</el-option>
						</el-select>
						<el-select v-else-if="$check_field('get','referee')" id="referee" v-model="form['referee']" :disabled="true">
							<el-option v-for="o in list_user_referee" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
									   :value="o['user_id']">
							</el-option>
						</el-select>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','competition_name') || $check_field('add','competition_name') || $check_field('set','competition_name')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="比赛名称" prop="competition_name">
					<el-input id="competition_name" v-model="form['competition_name']" placeholder="请输入比赛名称"
							  v-if="user_group === '管理员' || (form['referee_allocation_id'] && $check_field('set','competition_name')) || (!form['referee_allocation_id'] && $check_field('add','competition_name'))" :disabled="disabledObj['competition_name_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','competition_name')">{{form['competition_name']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','matters_needing_attention') || $check_field('add','matters_needing_attention') || $check_field('set','matters_needing_attention')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="注意事项" prop="matters_needing_attention">
					<el-input type="textarea" id="matters_needing_attention" v-model="form['matters_needing_attention']" placeholder="请输入注意事项"
						v-if="user_group === '管理员' || (form['referee_allocation_id'] && $check_field('set','matters_needing_attention')) || (!form['referee_allocation_id'] && $check_field('add','matters_needing_attention'))" :disabled="disabledObj['matters_needing_attention_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','matters_needing_attention')">{{form['matters_needing_attention']}}</div>
				</el-form-item>
			</el-col>
			<el-col :xs="24" :sm="12" :lg="8">
				<el-form-item>
					<el-button type="primary" @click="submit()">提交</el-button>
					<el-button @click="cancel()">取消</el-button>
				</el-form-item>
			</el-col>

		</el-form>
	</el-main>
</template>

<script>
	import mixin from "@/mixins/page.js";

	export default {
		mixins: [mixin],
		data() {
			return {
				field: "referee_allocation_id",
				url_add: "~/api/referee_allocation/add?",
				url_set: "~/api/referee_allocation/set?",
				url_get_obj: "~/api/referee_allocation/get_obj?",
				url_upload: "~/api/referee_allocation/upload?",

				query: {
					"referee_allocation_id": 0,
				},

				form: {
					"competition_number":'', // 比赛编号
					"competition_type":'', // 比赛类型
					"project_type":'', // 项目类型
					"site_name":'', // 场地名称
					"game_time":'', // 比赛时间
					"arrival_time":'', // 到位时间
					"referee": 0, // 裁判员
					"competition_name":'', // 比赛名称
					"matters_needing_attention":'', // 注意事项
					"referee_allocation_id": 0, // ID

				},
				disabledObj:{
					"competition_number_isDisabled": false,
					"competition_type_isDisabled": false,
					"project_type_isDisabled": false,
					"site_name_isDisabled": false,
					"game_time_isDisabled": false,
					"arrival_time_isDisabled": false,
					"referee_isDisabled": false,
					"competition_name_isDisabled": false,
					"matters_needing_attention_isDisabled": false,
				},
				// 用户列表
				list_user_referee: [],

			}
		},
		methods: {
			/**
			 * 获取裁判员用户列表
			 */
			async get_list_user_referee() {
                // if(this.user_group !== "管理员" && this.form["referee"] === 0) {
                //     this.form["referee"] = this.user.user_id;
                // }
                var json = await this.$get("~/api/user/get_list?user_group=裁判员");
                if(json.result && json.result.list){
                    this.list_user_referee = json.result.list;
                }
                else if(json.error){
                    console.error(json.error);
                }
			},
			get_user_referee(id){
				var obj = this.list_user_referee.getObj({"user_id":id});
				var ret = "";
				if(obj){
					if(obj.nickname){
						ret = obj.nickname;}
					else{
						ret = obj.username;
					}
				}
				return ret;
			},

			/**
			 * 获取对象之前
			 * @param {Object} param
			 */
			get_obj_before(param) {
				var form = "";
				// 获取缓存数据附加
				form = $.db.get("form");
				$.push(this.form ,form);
				/**
				* 请求列表前
				* @param {Object} param
				*/
				var user_group = this.user.user_group;
				if (user_group !== "管理员") {
					switch (user_group) {
						case "裁判员":
							if(param["referee"] > 0){
								param["referee"] = this.user.user_id;
							}
							break;
					}
				}
				if(this.form && form){
					Object.keys(this.form).forEach(key => {
						Object.keys(form).forEach(dbKey => {
							// if(dbKey === "charging_standard"){
							// 	this.form['charging_rules'] = form[dbKey];
							// 	this.disabledObj['charging_rules_isDisabled'] = true;
							// };
							if(key === dbKey){
								this.disabledObj[key+'_isDisabled'] = true;
							}
						})
					})
				}
				$.db.del("form");
				return param;
			},

			/**
			 * 获取对象之后
			 * @param {Object} json
			 * @param {Object} func
			 */
			get_obj_after(json, func){

			},

			is_view(){
				var bl = this.user_group == "管理员";

				if(!bl){
					bl = this.$check_action('/referee_allocation/table','add');
					console.log(bl ? "你有表格添加权限视作有添加权限" : "你没有表格添加权限");
				}
				if(!bl){
					bl = this.$check_action('/referee_allocation/table','set');
					console.log(bl ? "你有表格添加权限视作有修改权限" : "你没有表格修改权限");
				}
				if(!bl){
					bl = this.$check_action('/referee_allocation/view','add');
					console.log(bl ? "你有视图添加权限视作有添加权限" : "你没有视图添加权限");
				}
				if(!bl){
					bl = this.$check_action('/referee_allocation/view','set');
					console.log(bl ? "你有视图修改权限视作有修改权限" : "你没有视图修改权限");
				}
				if(!bl){
					bl = this.$check_action('/referee_allocation/view','get');
					console.log(bl ? "你有视图查询权限视作有查询权限" : "你没有视图查询权限");
				}

				console.log(bl ? "具有当前页面的查看权，请注意这不代表你有字段的查看权" : "无权查看当前页，请注意即便有字段查询权限没有页面查询权限也不行");

				return bl;
			},
			/**
			 * 上传文件
			 * @param {Object} param
			 */
			uploadimg(param) {
				this.uploadFile(param.file, "avatar");
			},

		},
		created() {
			this.get_list_user_referee();
		}
	}
</script>

<style>
	.avatar-uploader .el-upload {
		border: 1px dashed #d9d9d9;
		border-radius: 6px;
		cursor: pointer;
		position: relative;
		overflow: hidden;
	}

	.avatar-uploader .el-upload:hover {
		border-color: #409EFF;
	}

	.avatar-uploader-icon {
		font-size: 28px;
		color: #8c939d;
		width: 178px;
		height: 178px;
		line-height: 178px;
		text-align: center;
	}

	.avatar {
		width: 178px;
		height: 178px;
		display: block;
	}
</style>
