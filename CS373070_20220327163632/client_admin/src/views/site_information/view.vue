<template>
	<el-main class="bg">
		<el-form ref="form" :model="form" status-icon label-width="120px" v-if="is_view()">
			<el-col v-if="user_group === '管理员' || $check_field('get','site_number') || $check_field('add','site_number') || $check_field('set','site_number')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="场地编号" prop="site_number">
					<el-input id="site_number" v-model="form['site_number']" placeholder="请输入场地编号"
							  v-if="user_group === '管理员' || (form['site_information_id'] && $check_field('set','site_number')) || (!form['site_information_id'] && $check_field('add','site_number'))" :disabled="true"></el-input>
					<div v-else-if="$check_field('get','site_number')">{{form['site_number']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','site_type') || $check_field('add','site_type') || $check_field('set','site_type')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="场地类型" prop="site_type">
					<el-input id="site_type" v-model="form['site_type']" placeholder="请输入场地类型"
							  v-if="user_group === '管理员' || (form['site_information_id'] && $check_field('set','site_type')) || (!form['site_information_id'] && $check_field('add','site_type'))" :disabled="disabledObj['site_type_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','site_type')">{{form['site_type']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','site_name') || $check_field('add','site_name') || $check_field('set','site_name')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="场地名称" prop="site_name">
					<el-input id="site_name" v-model="form['site_name']" placeholder="请输入场地名称"
							  v-if="user_group === '管理员' || (form['site_information_id'] && $check_field('set','site_name')) || (!form['site_information_id'] && $check_field('add','site_name'))" :disabled="disabledObj['site_name_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','site_name')">{{form['site_name']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','site_address') || $check_field('add','site_address') || $check_field('set','site_address')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="场地地址" prop="site_address">
					<el-input id="site_address" v-model="form['site_address']" placeholder="请输入场地地址"
							  v-if="user_group === '管理员' || (form['site_information_id'] && $check_field('set','site_address')) || (!form['site_information_id'] && $check_field('add','site_address'))" :disabled="disabledObj['site_address_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','site_address')">{{form['site_address']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','cover') || $check_field('add','cover') || $check_field('set','cover')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="封面" prop="cover">
					<el-upload :disabled="disabledObj['cover_isDisabled']" id="cover" class="avatar-uploader" drag
						accept="image/gif, image/jpeg, image/png, image/jpg" action="" :http-request="upload_cover"
						:show-file-list="false" v-if="user_group === '管理员' || (form['site_information_id'] && $check_field('set','cover')) || (!form['site_information_id'] && $check_field('add','cover'))">
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
			<el-col v-if="user_group === '管理员' || $check_field('get','remarks') || $check_field('add','remarks') || $check_field('set','remarks')" :xs="24" :sm="12" :lg="8">
				<el-form-item label="备注" prop="remarks">
					<el-input type="textarea" id="remarks" v-model="form['remarks']" placeholder="请输入备注"
						v-if="user_group === '管理员' || (form['site_information_id'] && $check_field('set','remarks')) || (!form['site_information_id'] && $check_field('add','remarks'))" :disabled="disabledObj['remarks_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','remarks')">{{form['remarks']}}</div>
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
				field: "site_information_id",
				url_add: "~/api/site_information/add?",
				url_set: "~/api/site_information/set?",
				url_get_obj: "~/api/site_information/get_obj?",
				url_upload: "~/api/site_information/upload?",

				query: {
					"site_information_id": 0,
				},

				form: {
					"site_number":this.$get_stamp(), // 场地编号
					"site_type":'', // 场地类型
					"site_name":'', // 场地名称
					"site_address":'', // 场地地址
					"cover":'', // 封面
					"remarks":'', // 备注
					"site_information_id": 0, // ID

				},
				disabledObj:{
					"site_number_isDisabled": false,
					"site_type_isDisabled": false,
					"site_name_isDisabled": false,
					"site_address_isDisabled": false,
					"cover_isDisabled": false,
					"remarks_isDisabled": false,
				},

			}
		},
		methods: {
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
					bl = this.$check_action('/site_information/table','add');
					console.log(bl ? "你有表格添加权限视作有添加权限" : "你没有表格添加权限");
				}
				if(!bl){
					bl = this.$check_action('/site_information/table','set');
					console.log(bl ? "你有表格添加权限视作有修改权限" : "你没有表格修改权限");
				}
				if(!bl){
					bl = this.$check_action('/site_information/view','add');
					console.log(bl ? "你有视图添加权限视作有添加权限" : "你没有视图添加权限");
				}
				if(!bl){
					bl = this.$check_action('/site_information/view','set');
					console.log(bl ? "你有视图修改权限视作有修改权限" : "你没有视图修改权限");
				}
				if(!bl){
					bl = this.$check_action('/site_information/view','get');
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
