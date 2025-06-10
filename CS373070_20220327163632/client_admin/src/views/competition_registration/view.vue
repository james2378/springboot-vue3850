<template>
	<el-main class="bg">
		<el-form ref="form" :model="form" status-icon label-width="120px" v-if="is_view()">
			<el-col v-if="user_group === '管理员' || $check_field('get','competition_number') || $check_field('add','competition_number') || $check_field('set','competition_number')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="比赛编号" prop="competition_number">
					<el-input id="competition_number" v-model="form['competition_number']" placeholder="请输入比赛编号"
							  v-if="user_group === '管理员' || (form['competition_registration_id'] && $check_field('set','competition_number')) || (!form['competition_registration_id'] && $check_field('add','competition_number'))" :disabled="disabledObj['competition_number_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','competition_number')">{{form['competition_number']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','competition_type') || $check_field('add','competition_type') || $check_field('set','competition_type')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="比赛类型" prop="competition_type">
					<el-input id="competition_type" v-model="form['competition_type']" placeholder="请输入比赛类型"
							  v-if="user_group === '管理员' || (form['competition_registration_id'] && $check_field('set','competition_type')) || (!form['competition_registration_id'] && $check_field('add','competition_type'))" :disabled="disabledObj['competition_type_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','competition_type')">{{form['competition_type']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','project_type') || $check_field('add','project_type') || $check_field('set','project_type')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="项目类型" prop="project_type">
					<el-input id="project_type" v-model="form['project_type']" placeholder="请输入项目类型"
							  v-if="user_group === '管理员' || (form['competition_registration_id'] && $check_field('set','project_type')) || (!form['competition_registration_id'] && $check_field('add','project_type'))" :disabled="disabledObj['project_type_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','project_type')">{{form['project_type']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','site_name') || $check_field('add','site_name') || $check_field('set','site_name')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="场地名称" prop="site_name">
					<el-input id="site_name" v-model="form['site_name']" placeholder="请输入场地名称"
							  v-if="user_group === '管理员' || (form['competition_registration_id'] && $check_field('set','site_name')) || (!form['competition_registration_id'] && $check_field('add','site_name'))" :disabled="disabledObj['site_name_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','site_name')">{{form['site_name']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','registration_time') || $check_field('add','registration_time') || $check_field('set','registration_time')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="报名时间" prop="registration_time">
					<el-input id="registration_time" v-model="form['registration_time']" placeholder="请输入报名时间"
							  v-if="user_group === '管理员' || (form['competition_registration_id'] && $check_field('set','registration_time')) || (!form['competition_registration_id'] && $check_field('add','registration_time'))" :disabled="disabledObj['registration_time_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','registration_time')">{{form['registration_time']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','full_name') || $check_field('add','full_name') || $check_field('set','full_name')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="姓名" prop="full_name">
					<el-input id="full_name" v-model="form['full_name']" placeholder="请输入姓名"
							  v-if="user_group === '管理员' || (form['competition_registration_id'] && $check_field('set','full_name')) || (!form['competition_registration_id'] && $check_field('add','full_name'))" :disabled="disabledObj['full_name_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','full_name')">{{form['full_name']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','gender') || $check_field('add','gender') || $check_field('set','gender')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="性别" prop="gender">
					<el-input id="gender" v-model="form['gender']" placeholder="请输入性别"
							  v-if="user_group === '管理员' || (form['competition_registration_id'] && $check_field('set','gender')) || (!form['competition_registration_id'] && $check_field('add','gender'))" :disabled="disabledObj['gender_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','gender')">{{form['gender']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','contact_information') || $check_field('add','contact_information') || $check_field('set','contact_information')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="联系方式" prop="contact_information">
					<el-input id="contact_information" v-model="form['contact_information']" placeholder="请输入联系方式"
							  v-if="user_group === '管理员' || (form['competition_registration_id'] && $check_field('set','contact_information')) || (!form['competition_registration_id'] && $check_field('add','contact_information'))" :disabled="disabledObj['contact_information_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','contact_information')">{{form['contact_information']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','age') || $check_field('add','age') || $check_field('set','age')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="年龄" prop="age">
					<el-input id="age" v-model="form['age']" placeholder="请输入年龄"
							  v-if="user_group === '管理员' || (form['competition_registration_id'] && $check_field('set','age')) || (!form['competition_registration_id'] && $check_field('add','age'))" :disabled="disabledObj['age_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','age')">{{form['age']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','athletes') || $check_field('add','athletes') || $check_field('set','athletes')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="运动员" prop="athletes">
						<div v-if="user_group !== '管理员'">
							{{ get_user_session_athletes(form['athletes']) }}
							<!--<el-input id="business_name" v-model="form['athletes']" placeholder="请输入运动员"-->
							<!--v-if="user_group === '管理员' || (form['competition_registration_id'] && $check_field('set','athletes')) || (!form['competition_registration_id'] && $check_field('add','athletes'))" :disabled="disabledObj['athletes_isDisabled']"></el-input>-->
							<!--<div v-else-if="$check_field('get','athletes')">{{form['athletes']}}</div>-->
							<el-select v-if="user_group === '管理员' || (form['competition_registration_id'] && $check_field('set','athletes')) || (!form['competition_registration_id'] && $check_field('add','athletes'))" id="athletes" v-model="form['athletes']" :disabled="disabledObj['athletes_isDisabled']">
								<el-option v-for="o in list_user_athletes" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
										   :value="o['user_id']">
								</el-option>
							</el-select>
							<el-select v-else-if="$check_field('get','athletes')" id="athletes" v-model="form['athletes']" :disabled="true">
								<el-option v-for="o in list_user_athletes" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
										   :value="o['user_id']">
								</el-option>
							</el-select>
						</div>
						<el-select v-else id="athletes" v-model="form['athletes']" :disabled="disabledObj['athletes_isDisabled']">
							<el-option v-for="o in list_user_athletes" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
									   :value="o['user_id']">
							</el-option>
						</el-select>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','competition_name') || $check_field('add','competition_name') || $check_field('set','competition_name')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="比赛名称" prop="competition_name">
					<el-input id="competition_name" v-model="form['competition_name']" placeholder="请输入比赛名称"
							  v-if="user_group === '管理员' || (form['competition_registration_id'] && $check_field('set','competition_name')) || (!form['competition_registration_id'] && $check_field('add','competition_name'))" :disabled="disabledObj['competition_name_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','competition_name')">{{form['competition_name']}}</div>
				</el-form-item>
			</el-col>
			<el-col :xs="24" :sm="12" :lg="8">
				<el-form-item label="审核状态" prop="examine_state">
					<el-select id="examine_state" v-model="form['examine_state']"
						v-if="user_group === '管理员' || (form['examine_state'] && $check_examine()) || (!form['examine_state'] && $check_examine())">
						<el-option key="未审核" label="未审核" value="未审核"></el-option>
						<el-option key="已通过" label="已通过" value="已通过"></el-option>
						<el-option key="未通过" label="未通过" value="未通过"></el-option>
					</el-select>
					<div v-else-if="$check_field('get','examine_state')">{{form["examine_state"]}}</div>
				</el-form-item>
			</el-col>
			<el-col :xs="24" :sm="12" :lg="8">
				<el-form-item label="审核回复" prop="examine_reply">
					<el-input id="examine_reply" v-model="form['examine_reply']" placeholder="请输入审核回复"
						v-if="user_group === '管理员' || (form['examine_reply'] && $check_examine()) || (!form['examine_reply'] && $check_examine())"></el-input>
					<div v-else-if="$check_field('get','examine_reply')">{{form["examine_reply"]}}</div>
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
				field: "competition_registration_id",
				url_add: "~/api/competition_registration/add?",
				url_set: "~/api/competition_registration/set?",
				url_get_obj: "~/api/competition_registration/get_obj?",
				url_upload: "~/api/competition_registration/upload?",

				query: {
					"competition_registration_id": 0,
				},

				form: {
					"competition_number":'', // 比赛编号
					"competition_type":'', // 比赛类型
					"project_type":'', // 项目类型
					"site_name":'', // 场地名称
					"registration_time":'', // 报名时间
					"full_name":'', // 姓名
					"gender":'', // 性别
					"contact_information":'', // 联系方式
					"age":'', // 年龄
					"athletes": 0, // 运动员
					"competition_name":'', // 比赛名称
					"examine_state": "未审核",
					"examine_reply": "",
					"competition_registration_id": 0, // ID

				},
				disabledObj:{
					"competition_number_isDisabled": false,
					"competition_type_isDisabled": false,
					"project_type_isDisabled": false,
					"site_name_isDisabled": false,
					"registration_time_isDisabled": false,
					"full_name_isDisabled": false,
					"gender_isDisabled": false,
					"contact_information_isDisabled": false,
					"age_isDisabled": false,
					"athletes_isDisabled": false,
					"competition_name_isDisabled": false,
				},
				// 用户列表
				list_user_athletes: [],
				// 用户组
				group_user_athletes: "",

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
			/**
			 * 获取运动员用户组
			 */
			async get_group_user_athletes() {
				this.form["athletes"] = this.user.user_id;
				var json = await this.$get("~/api/user_group/get_obj?name=运动员");
				if(json.result && json.result.obj){
					this.group_user_athletes = json.result.obj;
				}
				else if(json.error){
					console.error(json.error);
				}
			},
			get_user_session_athletes(id){
				var _this = this;
				var user_id = {"user_id":id}
				var url = "~/api/"+_this.group_user_athletes.source_table+"/get_obj?"
				this.$get(url, user_id, function(res) {
					if (res.result && res.result.obj) {
						var arr = []
						for (let key in res.result.obj) {
							arr.push(key)
						}
						var arrForm = []
						for (let key in _this.form) {
							arrForm.push(key)
						}
						for (var i=0;i<arr.length;i++){
							for (var j=0;j<arrForm.length;j++){
								if (arr[i]===arrForm[j]){
									if (arr[i]!=="athletes") {
										_this.form[arrForm[j]] = res.result.obj[arr[i]]
										_this.disabledObj[arrForm[j] + '_isDisabled'] = true
										break;
									}else {
										_this.disabledObj[arrForm[j] + '_isDisabled'] = true
									}
								}
							}
						}
					}
				});
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
					bl = this.$check_action('/competition_registration/table','add');
					console.log(bl ? "你有表格添加权限视作有添加权限" : "你没有表格添加权限");
				}
				if(!bl){
					bl = this.$check_action('/competition_registration/table','set');
					console.log(bl ? "你有表格添加权限视作有修改权限" : "你没有表格修改权限");
				}
				if(!bl){
					bl = this.$check_action('/competition_registration/view','add');
					console.log(bl ? "你有视图添加权限视作有添加权限" : "你没有视图添加权限");
				}
				if(!bl){
					bl = this.$check_action('/competition_registration/view','set');
					console.log(bl ? "你有视图修改权限视作有修改权限" : "你没有视图修改权限");
				}
				if(!bl){
					bl = this.$check_action('/competition_registration/view','get');
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
			this.get_group_user_athletes();
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
