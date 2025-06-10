<template>
	<div class="diy_home diy_list diy_referee_allocation" id="diy_referee_allocation_list">
		<!-- 列表 -->
		<div class="diy_view_list list list-x" v-if="show">
			<router-link class="diy_card goods diy_list_box_wrap" v-for="(o, i) in list" :key="i"
				:to="'/referee_allocation/details?referee_allocation_id=' + o['referee_allocation_id']">
				<!-- 图片 -->
				<div class="diy_list_img_box" v-if="imgList.length" >
					<div class="diy_row" v-for="(item,index) in imgList" :key="item+index" v-show="$check_field('get',item.name,'/referee_allocation/details') && +item.is_img_list">
						<div class="diy_title diy_list_img_title">
							<span>{{item.title}}:</span>
						</div>
						<div class="diy_field diy_img">
							<img :src="$fullUrl(o[item.name])" style="width:100%;height:100%" />
						</div>
					</div>
				</div>
				<!-- 内容 -->
				<div class="diy_list_item_box">
					<div class="diy_list_item_content" v-for="(item,index) in showItemList" :key="item+index">
						<div class="diy_row" :class="{[item.name]:true}" v-if="$check_field('get',item.name,'/referee_allocation/details') && +item.is_img_list">
							<div class="diy_title">
								<span>{{item.title}}:</span>
							</div>
							<div class="diy_field diy_text">
								<span v-if="item.type == 'UID'" v-text="get_user_name(o[item.name])"></span>
								<span v-else-if="item.type == '日期'" v-text="$toTime(o[item.name],'yyyy-MM-dd')"></span>
								<span v-else-if="item.type == '时间'" v-text="$toTime(o[item.name],'hh:mm:ss')"></span>
								<span v-else-if="item.type == '日长'" v-text="$toTime(o[item.name],'yyyy-MM-dd hh:mm:ss')"></span>
								<span v-else v-text="o[item.name]"></span>
							</div>
						</div>
					</div>
				</div>
			</router-link>
		</div>
		<!-- 表格 -->
		<div class="diy_view_table" v-else>
			<table class="diy_table">
				<tr class="diy_row">
					<th class="diy_title" v-if="$check_field('get','competition_number')">比赛编号
					</th>
					<th class="diy_title" v-if="$check_field('get','competition_type')">比赛类型
					</th>
					<th class="diy_title" v-if="$check_field('get','project_type')">项目类型
					</th>
					<th class="diy_title" v-if="$check_field('get','site_name')">场地名称
					</th>
					<th class="diy_title" v-if="$check_field('get','game_time')">比赛时间
					</th>
					<th class="diy_title" v-if="$check_field('get','arrival_time')">到位时间
					</th>
					<th class="diy_title" v-if="$check_field('get','referee')">裁判员
					</th>
					<th class="diy_title" v-if="$check_field('get','competition_name')">比赛名称
					</th>
					<th class="diy_title" v-if="$check_field('get','matters_needing_attention')">注意事项
					</th>
				</tr>
				<tr class="diy_row" v-for="(o,i) in list" :key="o+i">
					<td class="diy_field diy_text" v-if="$check_field('get','competition_number')">
						<span>
							{{ o["competition_number"] }}
						</span>
					</td>
					<td class="diy_field diy_text" v-if="$check_field('get','competition_type')">
						<span>
							{{ o["competition_type"] }}
						</span>
					</td>
					<td class="diy_field diy_text" v-if="$check_field('get','project_type')">
						<span>
							{{ o["project_type"] }}
						</span>
					</td>
					<td class="diy_field diy_text" v-if="$check_field('get','site_name')">
						<span>
							{{ o["site_name"] }}
						</span>
					</td>
					<td class="diy_field diy_text" v-if="$check_field('get','game_time')">
						<span>
							{{ o["game_time"] }}
						</span>
					</td>
					<td class="diy_field diy_text" v-if="$check_field('get','arrival_time')">
						<span>
							{{ o["arrival_time"] }}
						</span>
					</td>
					<td class="diy_field diy_uid" v-if="$check_field('get','referee')">
						<span>
							{{ get_user_name(o['referee']) }}
						</span>
					</td>
					<td class="diy_field diy_text" v-if="$check_field('get','competition_name')">
						<span>
							{{ o["competition_name"] }}
						</span>
					</td>
					<td class="diy_field diy_text" v-if="$check_field('get','matters_needing_attention')">
						<span>
							{{ o["matters_needing_attention"] }}
						</span>
					</td>
				</tr>
			</table>
		</div>
	</div>
</template>

<script>
	export default {
		props: {
			list: {
				type: Array,
				default: function() {
					return [];
				},
			},
			show: {
				type: Boolean,
				default: function(){
					return true;
				}
			}
		},
		data() {
			return {
						imgList: [
						],
						itemList: [
								{
									title: "比赛编号",
									name: "competition_number",
									type: "文本",
									is_img_list: "0"
								},
								{
									title: "比赛类型",
									name: "competition_type",
									type: "文本",
									is_img_list: "0"
								},
								{
									title: "项目类型",
									name: "project_type",
									type: "文本",
									is_img_list: "0"
								},
								{
									title: "场地名称",
									name: "site_name",
									type: "文本",
									is_img_list: "0"
								},
								{
									title: "比赛时间",
									name: "game_time",
									type: "文本",
									is_img_list: "0"
								},
								{
									title: "到位时间",
									name: "arrival_time",
									type: "文本",
									is_img_list: "0"
								},
								{
									title: "裁判员",
									name: "referee",
									type: "UID",
									is_img_list: "0"
								},
								{
									title: "比赛名称",
									name: "competition_name",
									type: "文本",
									is_img_list: "0"
								},
						],
						richList: [
								{
									title: "注意事项",
									name: "matters_needing_attention",
									type: "多文本"
								},
						],
				// 用户列表
				list_user_referee: [],
			};
		},
		methods: {
			/**
			 * 获取裁判员用户列表
			 */
			async get_list_user_referee() {
				var json = await this.$get("~/api/user/get_list?user_group=裁判员");
				if(json.result && json.result.list){
					this.list_user_referee = json.result.list;
				}
				else if(json.error){
					console.error(json.error);
				}
			},
			get_user_name(id){
				var obj = this.list_user_referee.getObj({"user_id":id});
				var ret = "";
				if(obj){
					ret = obj.nickname+"-"+obj.username;
					// if(obj.nickname){
					// 	ret = obj.nickname;
					// }
					// else{
					// 	ret = obj.username;
					// }
				}
				return ret;
			},
		},
		created() {
			this.get_list_user_referee();
		},
		computed:{
			showItemList(){
				let arr = [];
				let _type = ["视频","音频","文件"];
				this.itemList.forEach(item => {
					if(_type.indexOf(item.type) === -1 && !!+item.is_img_list){
						arr.push(item)
					}
				})
				return arr.slice(0,4);
			}
		}
	};
</script>

<style scoped>
	.media {
		display: flex;
		flex-direction: column;
		justify-content: space-between;
		flex-basis: 75%;
		min-height: 10rem;
	}

	.goods {
		display: flex;
		width: calc(25% - 1rem);
		margin: 0.5rem;
		padding: 0.5rem;
		flex-direction: column;
		justify-content: space-between;
		background-color: white;
		border-radius: 0.5rem;
	}

	.goods:hover {
		border: 0.2rem solid #909399;
		box-shadow: 0 0.1rem 0.3rem rgba(0, 0, 0, 0.15);
	}

	.goods:hover img {
		filter: blur(1px);
	}

	.price {
		font-size: 1rem;
		margin-right: 3px;
	}

	.price_ago {
		text-decoration: line-through;
		font-size: 0.5rem;
		color: #999;

	}

	.title {
		word-break: break-all;
		overflow: hidden;
		text-overflow: ellipsis;
		white-space: nowrap;
		font-weight: 700;
		padding: .25rem;
	}

	.icon_cart {
		color: #FF5722;
		float: right;
	}

	@media (max-width: 992px) {

		.goods {
			width: calc(33% - 1rem);
			;
		}

	}

	@media (max-width: 768px) {

		.goods {
			width: calc(50% - 1rem);
			;
		}

	}
</style>

