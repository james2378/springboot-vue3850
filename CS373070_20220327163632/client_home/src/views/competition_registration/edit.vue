<template>
	<div class="diy_edit page_competition_registration" id="competition_registration_edit">
		<div class='warp'>
			<div class='container'>
				<div class='row diy_edit_content_box'>
					<div v-if="$check_field('set','competition_number') || $check_field('add','competition_number') || $check_field('get','competition_number')" class="form-item col-12 col-md-6">
						<div class="diy_title">
							<span>比赛编号:
							</span>
						</div>
						<!-- 文本 -->
						<div class="diy_field diy_text">
							<input type="text" id="form_competition_number" v-model="form['competition_number']" placeholder="请输入比赛编号" v-if="(form['competition_number'] && $check_field('set','competition_number')) || (!form['competition_number'] && $check_field('add','competition_number'))"  :disabled="disabledObj['competition_number_isDisabled']"/>
							<span v-else-if="$check_field('get','competition_number')">{{ form['full_name'] }}</span>
						</div>
					</div>
					<div v-if="$check_field('set','competition_type') || $check_field('add','competition_type') || $check_field('get','competition_type')" class="form-item col-12 col-md-6">
						<div class="diy_title">
							<span>比赛类型:
							</span>
						</div>
						<!-- 文本 -->
						<div class="diy_field diy_text">
							<input type="text" id="form_competition_type" v-model="form['competition_type']" placeholder="请输入比赛类型" v-if="(form['competition_type'] && $check_field('set','competition_type')) || (!form['competition_type'] && $check_field('add','competition_type'))"  :disabled="disabledObj['competition_type_isDisabled']"/>
							<span v-else-if="$check_field('get','competition_type')">{{ form['full_name'] }}</span>
						</div>
					</div>
					<div v-if="$check_field('set','project_type') || $check_field('add','project_type') || $check_field('get','project_type')" class="form-item col-12 col-md-6">
						<div class="diy_title">
							<span>项目类型:
							</span>
						</div>
						<!-- 文本 -->
						<div class="diy_field diy_text">
							<input type="text" id="form_project_type" v-model="form['project_type']" placeholder="请输入项目类型" v-if="(form['project_type'] && $check_field('set','project_type')) || (!form['project_type'] && $check_field('add','project_type'))"  :disabled="disabledObj['project_type_isDisabled']"/>
							<span v-else-if="$check_field('get','project_type')">{{ form['full_name'] }}</span>
						</div>
					</div>
					<div v-if="$check_field('set','site_name') || $check_field('add','site_name') || $check_field('get','site_name')" class="form-item col-12 col-md-6">
						<div class="diy_title">
							<span>场地名称:
							</span>
						</div>
						<!-- 文本 -->
						<div class="diy_field diy_text">
							<input type="text" id="form_site_name" v-model="form['site_name']" placeholder="请输入场地名称" v-if="(form['site_name'] && $check_field('set','site_name')) || (!form['site_name'] && $check_field('add','site_name'))"  :disabled="disabledObj['site_name_isDisabled']"/>
							<span v-else-if="$check_field('get','site_name')">{{ form['full_name'] }}</span>
						</div>
					</div>
					<div v-if="$check_field('set','registration_time') || $check_field('add','registration_time') || $check_field('get','registration_time')" class="form-item col-12 col-md-6">
						<div class="diy_title">
							<span>报名时间:
							</span>
						</div>
						<!-- 文本 -->
						<div class="diy_field diy_text">
							<input type="text" id="form_registration_time" v-model="form['registration_time']" placeholder="请输入报名时间" v-if="(form['registration_time'] && $check_field('set','registration_time')) || (!form['registration_time'] && $check_field('add','registration_time'))"  :disabled="disabledObj['registration_time_isDisabled']"/>
							<span v-else-if="$check_field('get','registration_time')">{{ form['full_name'] }}</span>
						</div>
					</div>
					<div v-if="$check_field('set','full_name') || $check_field('add','full_name') || $check_field('get','full_name')" class="form-item col-12 col-md-6">
						<div class="diy_title">
							<span>姓名:
							</span>
						</div>
						<!-- 文本 -->
						<div class="diy_field diy_text">
							<input type="text" id="form_full_name" v-model="form['full_name']" placeholder="请输入姓名" v-if="(form['full_name'] && $check_field('set','full_name')) || (!form['full_name'] && $check_field('add','full_name'))"  :disabled="disabledObj['full_name_isDisabled']"/>
							<span v-else-if="$check_field('get','full_name')">{{ form['full_name'] }}</span>
						</div>
					</div>
					<div v-if="$check_field('set','gender') || $check_field('add','gender') || $check_field('get','gender')" class="form-item col-12 col-md-6">
						<div class="diy_title">
							<span>性别:
							</span>
						</div>
						<!-- 文本 -->
						<div class="diy_field diy_text">
							<input type="text" id="form_gender" v-model="form['gender']" placeholder="请输入性别" v-if="(form['gender'] && $check_field('set','gender')) || (!form['gender'] && $check_field('add','gender'))"  :disabled="disabledObj['gender_isDisabled']"/>
							<span v-else-if="$check_field('get','gender')">{{ form['full_name'] }}</span>
						</div>
					</div>
					<div v-if="$check_field('set','contact_information') || $check_field('add','contact_information') || $check_field('get','contact_information')" class="form-item col-12 col-md-6">
						<div class="diy_title">
							<span>联系方式:
							</span>
						</div>
						<!-- 文本 -->
						<div class="diy_field diy_text">
							<input type="text" id="form_contact_information" v-model="form['contact_information']" placeholder="请输入联系方式" v-if="(form['contact_information'] && $check_field('set','contact_information')) || (!form['contact_information'] && $check_field('add','contact_information'))"  :disabled="disabledObj['contact_information_isDisabled']"/>
							<span v-else-if="$check_field('get','contact_information')">{{ form['full_name'] }}</span>
						</div>
					</div>
					<div v-if="$check_field('set','age') || $check_field('add','age') || $check_field('get','age')" class="form-item col-12 col-md-6">
						<div class="diy_title">
							<span>年龄:
							</span>
						</div>
						<!-- 文本 -->
						<div class="diy_field diy_text">
							<input type="text" id="form_age" v-model="form['age']" placeholder="请输入年龄" v-if="(form['age'] && $check_field('set','age')) || (!form['age'] && $check_field('add','age'))"  :disabled="disabledObj['age_isDisabled']"/>
							<span v-else-if="$check_field('get','age')">{{ form['full_name'] }}</span>
						</div>
					</div>
					<div v-if="$check_field('set','athletes') || $check_field('add','athletes') || $check_field('get','athletes')" class="form-item col-12 col-md-6">
						<div class="diy_title">
							<span>运动员:
							</span>
						</div>
						<div class="diy_field diy_down">
							<select id="form_athletes" :disabled="disabledObj['athletes_isDisabled']" v-model="form['athletes']" v-if="(form['athletes'] && $check_field('set','athletes')) || (!form['athletes'] && $check_field('add','athletes'))" >
								<option v-for="o in list_user_athletes" :value="o['user_id']">
									{{o['nickname'] + '-' + o['username']}}
								</option>
							</select>
							<span v-else-if="$check_field('get','athletes')">{{ form['athletes'] }}</span>
						</div>
					</div>
					<div v-if="$check_field('set','competition_name') || $check_field('add','competition_name') || $check_field('get','competition_name')" class="form-item col-12 col-md-6">
						<div class="diy_title">
							<span>比赛名称:
							</span>
						</div>
						<!-- 文本 -->
						<div class="diy_field diy_text">
							<input type="text" id="form_competition_name" v-model="form['competition_name']" placeholder="请输入比赛名称" v-if="(form['competition_name'] && $check_field('set','competition_name')) || (!form['competition_name'] && $check_field('add','competition_name'))"  :disabled="disabledObj['competition_name_isDisabled']"/>
							<span v-else-if="$check_field('get','competition_name')">{{ form['full_name'] }}</span>
						</div>
					</div>
					<div v-if="user_group === '管理员' || $check_examine()" class="form-item col-12 col-md-6">
						<div class="diy_title">
							<span>
								审核状态:
							</span>
						</div>
						<div class="diy_field diy_select" v-if="$check_action('/competition_registration/edit','examine')">
							<!--<span> {{ form['examine_state'] }} </span>-->
							<select v-model="form['examine_state']">
								<option value="未审核">
									未审核
								</option>
								<option value="已通过">
									已通过
								</option>
								<option value="未通过">
									未通过
								</option>
							</select>
						</div>
						<div class="diy_field diy_text" v-else>
							<span>
								{{ form['examine_state'] }}
							</span>
						</div>
					</div>
					<div v-if="user_group === '管理员' || $check_examine()" class="form-item col-12 col-md-6">
						<div class="diy_title">
							<span>
								审核回复:
							</span>
						</div>
						<div class="diy_field diy_desc" v-if="$check_action('/competition_registration/edit','examine')">
							<textarea v-model="form['examine_reply']"></textarea>
						</div>
						<div class="diy_field diy_text" v-else>
							<span>
								{{ form['examine_reply'] }}
							</span>
						</div>
					</div>
				</div>
				<div class="diy_edit_submit_box row">
					<div class="col-12">
						<div class="btn_box">
							<button class="btn_submit" @click="submit()">提交</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</template>

<script>
	import mixin from "@/mixins/page.js";
	export default {
		mixins: [mixin],
		components: {},
		data() {
			return {
				url_get_obj: "~/api/competition_registration/get_obj?",
				url_add: "~/api/competition_registration/add?",
				url_set: "~/api/competition_registration/set?",

				// 登录权限
				oauth: {
					"signIn": true,
					"user_group": []
				},

				// 查询条件
				query: {
					"competition_number": "",
					"competition_type": "",
					"project_type": "",
					"site_name": "",
					"registration_time": "",
					"full_name": "",
					"gender": "",
					"contact_information": "",
					"age": "",
					"athletes": 0,
					"competition_name": "",
					"competition_registration_id": 0,
				},

				obj: {
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
					"competition_registration_id": 0,
				},

				// 表单字段
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
					"competition_registration_id": 0,

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

				// ID字段
				field: "competition_registration_id",
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
			async get_user_session_athletes(){
				var _this = this;
				var json = await this.$get("~/api/user_group/get_obj?name=运动员");
				if(json.result && json.result.obj){
					var source_table = json.result.obj.source_table;
					var user_id = _this.$store.state.user.user_id;
					if (user_id){
						var url = "~/api/"+source_table+"/get_obj?"
						this.$get(url, {"user_id":_this.$store.state.user.user_id}, function(res) {
							if (res.result && res.result.obj) {
								var arr = []
								for (let key in res.result.obj) {
									arr.push(key)
								}
								var arrForm = []
								for (let key in _this.form) {
									arrForm.push(key)
								}
								_this.form["athletes"] = user_id
								_this.disabledObj['athletes' + '_isDisabled'] = true
								for (var i=0;i<arr.length;i++){
									for (var j=0;j<arrForm.length;j++){
										if (arr[i]===arrForm[j]){
											if (arr[i]!=="athletes") {
												_this.form[arrForm[j]] = res.result.obj[arr[i]]
												_this.disabledObj[arrForm[j] + '_isDisabled'] = true
												break;
											}
										}
									}
								}
							}
						});
					}
				}
				else if(json.error){
					console.error(json.error);
				}
			},

			/**
			 * 修改文件
			 * @param { Object } files 上传文件对象
			 * @param { String } str 表单的属性名
			 */
			change_file(files, str) {
				var form = new FormData();
				form.append("file", files[0]);
				this.$post("~/api/competition_registration/upload?", form, (res) => {
					if (res.result) {
						this.form[str] = res.result.url;
					} else if (res.error) {
						this.$toast(res.error.message);
					}
				});
			},

			/**
			 * 获取对象后获取缓存表单
			 * @param {Object} json
			 * @param {Object} func
			 */
			get_obj_before(param){
				var form = $.db.get("form");
				if (form) {
					this.obj = $.push(this.obj ,form);
					this.form = $.push(this.form ,form);
				}
				var arr = []
				for (let key in form) {
					arr.push(key)
				}
				for (var i=0;i<arr.length;i++){
					this.disabledObj[arr[i] + '_isDisabled'] = true
				}
				return param;
			},

			/**
			 * 获取对象后获取缓存表单
			 * @param {Object} json
			 * @param {Object} func
			 */
			get_obj_after(json ,func){
				var form = $.db.get("form");
				var obj = Object.assign({} ,form ,this.obj);
				if (form) {
					this.obj = $.push(this.obj ,obj);
				}
				if (form) {
					this.form = $.push(this.form ,form);
				}
				if(func){
					func(json);
				}
			},

		},
		created() {
			this.get_user_session_athletes();
			this.get_list_user_athletes();
		}
	}
</script>

<style>
</style>
