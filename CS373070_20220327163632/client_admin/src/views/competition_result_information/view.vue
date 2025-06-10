<template>
	<el-main class="bg">
		<el-form ref="form" :model="form" status-icon label-width="120px" v-if="is_view()">
			<el-col v-if="user_group === '管理员' || $check_field('get','competition_number') || $check_field('add','competition_number') || $check_field('set','competition_number')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="比赛编号" prop="competition_number">
					<el-input id="competition_number" v-model="form['competition_number']" placeholder="请输入比赛编号"
							  v-if="user_group === '管理员' || (form['competition_result_information_id'] && $check_field('set','competition_number')) || (!form['competition_result_information_id'] && $check_field('add','competition_number'))" :disabled="disabledObj['competition_number_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','competition_number')">{{form['competition_number']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','competition_type') || $check_field('add','competition_type') || $check_field('set','competition_type')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="比赛类型" prop="competition_type">
					<el-input id="competition_type" v-model="form['competition_type']" placeholder="请输入比赛类型"
							  v-if="user_group === '管理员' || (form['competition_result_information_id'] && $check_field('set','competition_type')) || (!form['competition_result_information_id'] && $check_field('add','competition_type'))" :disabled="disabledObj['competition_type_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','competition_type')">{{form['competition_type']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','competition_name') || $check_field('add','competition_name') || $check_field('set','competition_name')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="比赛名称" prop="competition_name">
					<el-input id="competition_name" v-model="form['competition_name']" placeholder="请输入比赛名称"
							  v-if="user_group === '管理员' || (form['competition_result_information_id'] && $check_field('set','competition_name')) || (!form['competition_result_information_id'] && $check_field('add','competition_name'))" :disabled="disabledObj['competition_name_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','competition_name')">{{form['competition_name']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','site_name') || $check_field('add','site_name') || $check_field('set','site_name')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="场地名称" prop="site_name">
					<el-input id="site_name" v-model="form['site_name']" placeholder="请输入场地名称"
							  v-if="user_group === '管理员' || (form['competition_result_information_id'] && $check_field('set','site_name')) || (!form['competition_result_information_id'] && $check_field('add','site_name'))" :disabled="disabledObj['site_name_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','site_name')">{{form['site_name']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','score') || $check_field('add','score') || $check_field('set','score')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="成绩分数" prop="score">
					<el-input-number id="score" v-model.number="form['score']"
						v-if="user_group === '管理员' || (form['competition_result_information_id'] && $check_field('set','score')) || (!form['competition_result_information_id'] && $check_field('add','score'))"></el-input-number>
					<div v-else-if="$check_field('get','score')">{{form['score']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','athletes') || $check_field('add','athletes') || $check_field('set','athletes')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="运动员" prop="athletes">
						<el-select v-if="user_group === '管理员' || (form['competition_result_information_id'] && $check_field('set','athletes')) || (!form['competition_result_information_id'] && $check_field('add','athletes'))" id="athletes" v-model="form['athletes']" :disabled="disabledObj['athletes_isDisabled']">
							<el-option v-for="o in list_user_athletes" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
									   :value="o['user_id']">
							</el-option>
						</el-select>
						<el-select v-else-if="$check_field('get','athletes')" id="athletes" v-model="form['athletes']" :disabled="true">
							<el-option v-for="o in list_user_athletes" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
									   :value="o['user_id']">
							</el-option>
						</el-select>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','cover') || $check_field('add','cover') || $check_field('set','cover')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="封面" prop="cover">
					<el-upload :disabled="disabledObj['cover_isDisabled']" id="cover" class="avatar-uploader" drag
						accept="image/gif, image/jpeg, image/png, image/jpg" action="" :http-request="upload_cover"
						:show-file-list="false" v-if="user_group === '管理员' || (form['competition_result_information_id'] && $check_field('set','cover')) || (!form['competition_result_information_id'] && $check_field('add','cover'))">
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
			<el-col v-if="user_group === '管理员' || $check_field('get','project_type') || $check_field('add','project_type') || $check_field('set','project_type')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="项目类型" prop="project_type">
					<el-input id="project_type" v-model="form['project_type']" placeholder="请输入项目类型"
							  v-if="user_group === '管理员' || (form['competition_result_information_id'] && $check_field('set','project_type')) || (!form['competition_result_information_id'] && $check_field('add','project_type'))" :disabled="disabledObj['project_type_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','project_type')">{{form['project_type']}}</div>
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
				field: "competition_result_information_id",
				url_add: "~/api/competition_result_information/add?",
				url_set: "~/api/competition_result_information/set?",
				url_get_obj: "~/api/competition_result_information/get_obj?",
				url_upload: "~/api/competition_result_information/upload?",

				query: {
					"competition_result_information_id": 0,
				},

				form: {
					"competition_number":'', // 比赛编号
					"competition_type":'', // 比赛类型
					"competition_name":'', // 比赛名称
					"site_name":'', // 场地名称
					"score":0, // 成绩分数
					"athletes": 0, // 运动员
					"cover":'', // 封面
					"project_type":'', // 项目类型
					"competition_result_information_id": 0, // ID

				},
				disabledObj:{
					"competition_number_isDisabled": false,
					"competition_type_isDisabled": false,
					"competition_name_isDisabled": false,
					"site_name_isDisabled": false,
					"athletes_isDisabled": false,
					"cover_isDisabled": false,
					"project_type_isDisabled": false,
				},
				// 用户列表
				list_user_athletes: [],

			}
		},
		methods: {
			/**
			 * 获取运动员用户列表
			 */
			async get_list_user_athletes() {
                // if(this.user_group !== "管理员" && this.form["athletes"] === 0) {
                //     this.form["athletes"] = this.user.user_id;
                // }
                var json = await this.$get("~/api/user/get_list?user_group=运动员");
                if(json.result && json.result.list){
                    this.list_user_athletes = json.result.list;
                }
                else if(json.error){
                    console.error(json.error);
                }
			},
			get_user_athletes(id){
				var obj = this.list_user_athletes.getObj({"user_id":id});
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
						case "运动员":
							if(param["athletes"] > 0){
								param["athletes"] = this.user.user_id;
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
					bl = this.$check_action('/competition_result_information/table','add');
					console.log(bl ? "你有表格添加权限视作有添加权限" : "你没有表格添加权限");
				}
				if(!bl){
					bl = this.$check_action('/competition_result_information/table','set');
					console.log(bl ? "你有表格添加权限视作有修改权限" : "你没有表格修改权限");
				}
				if(!bl){
					bl = this.$check_action('/competition_result_information/view','add');
					console.log(bl ? "你有视图添加权限视作有添加权限" : "你没有视图添加权限");
				}
				if(!bl){
					bl = this.$check_action('/competition_result_information/view','set');
					console.log(bl ? "你有视图修改权限视作有修改权限" : "你没有视图修改权限");
				}
				if(!bl){
					bl = this.$check_action('/competition_result_information/view','get');
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
			this.get_list_user_athletes();
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
