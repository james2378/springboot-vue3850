<template>
	<el-main class="bg">
		<el-form ref="form" :model="form" status-icon label-width="120px" v-if="is_view()">
			<el-col v-if="user_group === '管理员' || $check_field('get','competition_number') || $check_field('add','competition_number') || $check_field('set','competition_number')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="比赛编号" prop="competition_number">
					<el-input id="competition_number" v-model="form['competition_number']" placeholder="请输入比赛编号"
							  v-if="user_group === '管理员' || (form['event_id'] && $check_field('set','competition_number')) || (!form['event_id'] && $check_field('add','competition_number'))" :disabled="true"></el-input>
					<div v-else-if="$check_field('get','competition_number')">{{form['competition_number']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','competition_type') || $check_field('add','competition_type') || $check_field('set','competition_type')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="比赛类型" prop="competition_type">
					<el-select id="competition_type" v-model="form['competition_type']"
						v-if="user_group === '管理员' || (form['event_id'] && $check_field('set','competition_type')) || (!form['event_id'] && $check_field('add','competition_type'))">
						<el-option v-for="o in list_competition_type" :key="o['competition_type']" :label="o['competition_type']"
							:value="o['competition_type']">
						</el-option>
					</el-select>
					<div v-else-if="$check_field('get','competition_type')">{{form['competition_type']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','project_type') || $check_field('add','project_type') || $check_field('set','project_type')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="项目类型" prop="project_type">
					<el-select id="project_type" v-model="form['project_type']"
						v-if="user_group === '管理员' || (form['event_id'] && $check_field('set','project_type')) || (!form['event_id'] && $check_field('add','project_type'))">
						<el-option v-for="o in list_project_type" :key="o" :label="o" :value="o">
						</el-option>
					</el-select>
					<div v-else-if="$check_field('get','project_type')">{{form['project_type']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','site_name') || $check_field('add','site_name') || $check_field('set','site_name')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="场地名称" prop="site_name">
					<el-select id="site_name" v-model="form['site_name']"
						v-if="user_group === '管理员' || (form['event_id'] && $check_field('set','site_name')) || (!form['event_id'] && $check_field('add','site_name'))">
						<el-option v-for="o in list_site_name" :key="o['site_name']" :label="o['site_name']"
							:value="o['site_name']">
						</el-option>
					</el-select>
					<div v-else-if="$check_field('get','site_name')">{{form['site_name']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','game_time') || $check_field('add','game_time') || $check_field('set','game_time')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="比赛时间" prop="game_time">
					<el-input id="game_time" v-model="form['game_time']" placeholder="请输入比赛时间"
							  v-if="user_group === '管理员' || (form['event_id'] && $check_field('set','game_time')) || (!form['event_id'] && $check_field('add','game_time'))" :disabled="disabledObj['game_time_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','game_time')">{{form['game_time']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','number_of_matches') || $check_field('add','number_of_matches') || $check_field('set','number_of_matches')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="比赛人数" prop="number_of_matches">
					<el-input-number id="number_of_matches" v-model.number="form['number_of_matches']"
						v-if="user_group === '管理员' || (form['event_id'] && $check_field('set','number_of_matches')) || (!form['event_id'] && $check_field('add','number_of_matches'))"></el-input-number>
					<div v-else-if="$check_field('get','number_of_matches')">{{form['number_of_matches']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','cover') || $check_field('add','cover') || $check_field('set','cover')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="封面" prop="cover">
					<el-upload :disabled="disabledObj['cover_isDisabled']" id="cover" class="avatar-uploader" drag
						accept="image/gif, image/jpeg, image/png, image/jpg" action="" :http-request="upload_cover"
						:show-file-list="false" v-if="user_group === '管理员' || (form['event_id'] && $check_field('set','cover')) || (!form['event_id'] && $check_field('add','cover'))">
						<img v-if="form['cover']" :src="$fullUrl(form['cover'])" class="avatar">
						<i v-else class="el-icon-plus avatar-uploader-icon"></i>
					</el-upload>
					<el-image v-else-if="$check_field('get','cover')" style="width: 100px; height: 100px"
						:src="$fullUrl(form['cover'])" :preview-src-list="[$fullUrl(form['cover'])]">
						<div slot="error" class="image-slot">
							<img src="../../../public/img/error.png" style="width: 90px; height: 90px" />
						</div>
					</el-image>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','referee_name') || $check_field('add','referee_name') || $check_field('set','referee_name')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="裁判姓名" prop="referee_name">
					<el-input id="referee_name" v-model="form['referee_name']" placeholder="请输入裁判姓名"
							  v-if="user_group === '管理员' || (form['event_id'] && $check_field('set','referee_name')) || (!form['event_id'] && $check_field('add','referee_name'))" :disabled="disabledObj['referee_name_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','referee_name')">{{form['referee_name']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','competition_name') || $check_field('add','competition_name') || $check_field('set','competition_name')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="比赛名称" prop="competition_name">
					<el-input id="competition_name" v-model="form['competition_name']" placeholder="请输入比赛名称"
							  v-if="user_group === '管理员' || (form['event_id'] && $check_field('set','competition_name')) || (!form['event_id'] && $check_field('add','competition_name'))" :disabled="disabledObj['competition_name_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','competition_name')">{{form['competition_name']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','competition_requirements') || $check_field('add','competition_requirements') || $check_field('set','competition_requirements')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="比赛要求" prop="competition_requirements">
					<el-input type="textarea" id="competition_requirements" v-model="form['competition_requirements']" placeholder="请输入比赛要求"
						v-if="user_group === '管理员' || (form['event_id'] && $check_field('set','competition_requirements')) || (!form['event_id'] && $check_field('add','competition_requirements'))" :disabled="disabledObj['competition_requirements_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','competition_requirements')">{{form['competition_requirements']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','competition_reward') || $check_field('add','competition_reward') || $check_field('set','competition_reward')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="比赛奖励" prop="competition_reward">
					<el-input type="textarea" id="competition_reward" v-model="form['competition_reward']" placeholder="请输入比赛奖励"
						v-if="user_group === '管理员' || (form['event_id'] && $check_field('set','competition_reward')) || (!form['event_id'] && $check_field('add','competition_reward'))" :disabled="disabledObj['competition_reward_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','competition_reward')">{{form['competition_reward']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','referee_profile') || $check_field('add','referee_profile') || $check_field('set','referee_profile')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="裁判简介" prop="referee_profile">
					<el-input type="textarea" id="referee_profile" v-model="form['referee_profile']" placeholder="请输入裁判简介"
						v-if="user_group === '管理员' || (form['event_id'] && $check_field('set','referee_profile')) || (!form['event_id'] && $check_field('add','referee_profile'))" :disabled="disabledObj['referee_profile_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','referee_profile')">{{form['referee_profile']}}</div>
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
				field: "event_id",
				url_add: "~/api/event/add?",
				url_set: "~/api/event/set?",
				url_get_obj: "~/api/event/get_obj?",
				url_upload: "~/api/event/upload?",

				query: {
					"event_id": 0,
				},

				form: {
					"competition_number":this.$get_stamp(), // 比赛编号
					"competition_type":'', // 比赛类型
					"project_type":'', // 项目类型
					"site_name":'', // 场地名称
					"game_time":'', // 比赛时间
					"number_of_matches":0, // 比赛人数
					"cover":'', // 封面
					"referee_name":'', // 裁判姓名
					"competition_name":'', // 比赛名称
					"competition_requirements":'', // 比赛要求
					"competition_reward":'', // 比赛奖励
					"referee_profile":'', // 裁判简介
					"event_id": 0, // ID

				},
				disabledObj:{
					"competition_number_isDisabled": false,
					"competition_type_isDisabled": false,
					"project_type_isDisabled": false,
					"site_name_isDisabled": false,
					"game_time_isDisabled": false,
					"cover_isDisabled": false,
					"referee_name_isDisabled": false,
					"competition_name_isDisabled": false,
					"competition_requirements_isDisabled": false,
					"competition_reward_isDisabled": false,
					"referee_profile_isDisabled": false,
				},
				//比赛类型选项列表
				list_competition_type: [],
				//项目类型选项列表
				list_project_type: ['单人','团体'],
				//场地名称选项列表
				list_site_name: [],

			}
		},
		methods: {
			/**
			 * 获取比赛类型列表
			 */
			async get_list_competition_type() {
				var json = await this.$get("~/api/competition_classification/get_list?");
				if(json.result && json.result.list){
					this.list_competition_type = json.result.list;
				}
				else if(json.error){
					console.error(json.error);
				}
			},
			/**
			 * 获取场地名称列表
			 */
			async get_list_site_name() {
				var json = await this.$get("~/api/site_information/get_list?");
				if(json.result && json.result.list){
					this.list_site_name = json.result.list;
				}
				else if(json.error){
					console.error(json.error);
				}
			},
			/**
			 * 上传封面
			 * @param {Object} param图片参数
			 */
			upload_cover(param){
				this.uploadFile(param.file, "cover");
			},

			/**
			 * 获取对象之前
			 * @param {Object} param
			 */
			get_obj_before(param) {
				var form = "";
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
					bl = this.$check_action('/event/table','add');
					console.log(bl ? "你有表格添加权限视作有添加权限" : "你没有表格添加权限");
				}
				if(!bl){
					bl = this.$check_action('/event/table','set');
					console.log(bl ? "你有表格添加权限视作有修改权限" : "你没有表格修改权限");
				}
				if(!bl){
					bl = this.$check_action('/event/view','add');
					console.log(bl ? "你有视图添加权限视作有添加权限" : "你没有视图添加权限");
				}
				if(!bl){
					bl = this.$check_action('/event/view','set');
					console.log(bl ? "你有视图修改权限视作有修改权限" : "你没有视图修改权限");
				}
				if(!bl){
					bl = this.$check_action('/event/view','get');
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
			this.get_list_competition_type();
			this.get_list_site_name();
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
