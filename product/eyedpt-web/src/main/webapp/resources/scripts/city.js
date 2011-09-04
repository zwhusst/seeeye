var PROVINCE = new Array();
PROVINCE[0] = "北京";
PROVINCE[1] = "上海";
PROVINCE[2] = "天津";
PROVINCE[3] = "重庆";
PROVINCE[4] = "河北";
PROVINCE[5] = "山西";
PROVINCE[6] = "辽宁";
PROVINCE[7] = "吉林";
PROVINCE[8] = "黑龙江";
PROVINCE[9] = "江苏";
PROVINCE[10] = "浙江";
PROVINCE[11] = "安徽";
PROVINCE[12] = "福建";
PROVINCE[13] = "江西";
PROVINCE[14] = "山东";
PROVINCE[15] = "河南";
PROVINCE[16] = "湖北";
PROVINCE[17] = "湖南";
PROVINCE[18] = "广东";
PROVINCE[19] = "甘肃";
PROVINCE[20] = "陕西";
PROVINCE[21] = "内蒙古";
PROVINCE[22] = "广西";
PROVINCE[23] = "四川";
PROVINCE[24] = "贵州";
PROVINCE[25] = "云南";
PROVINCE[26] = "西藏";
PROVINCE[27] = "海南";
PROVINCE[28] = "宁夏";
PROVINCE[29] = "青海";
PROVINCE[30] = "新疆";
PROVINCE[31] = "香港";
PROVINCE[32] = "澳门";
PROVINCE[33] = "台湾";

var CITY = new Array();
CITY[0] = new Array("北京");
CITY[1] = new Array("上海");
CITY[2] = new Array("天津");
CITY[3] = new Array("重庆");
CITY[4] = new Array("石家庄", "邯郸", "邢台", "保定", "张家口", "承德", "廊坊", "唐山", "秦皇岛",
		"沧州", "衡水");
CITY[5] = new Array("太原", "大同", "阳泉", "长治", "晋城", "朔州", "吕梁", "忻州", "晋中", "临汾",
		"运城");
CITY[6] = new Array("沈阳", "大连", "鞍山", "抚顺", "本溪", "丹东", "锦州", "营口", "阜新", "辽阳",
		"盘锦", "铁岭", "朝阳", "葫芦岛");
CITY[7] = new Array("长春", "吉林", "四平", "辽源", "通化", "白山", "松原", "白城", "延边");
CITY[8] = new Array("哈尔滨", "齐齐哈尔", "牡丹江", "佳木斯", "大庆", "绥化", "鹤岗", "鸡西", "黑河",
		"双鸭山", "伊春", "七台河", "大兴安岭");
CITY[9] = new Array("南京", "镇江", "苏州", "南通", "扬州", "盐城", "徐州", "连云港", "常州",
		"无锡", "宿迁", "泰州", "淮安");
CITY[10] = new Array("杭州", "宁波", "温州", "嘉兴", "湖州", "绍兴", "金华", "衢州", "舟山",
		"台州", "丽水");
CITY[11] = new Array("合肥", "芜湖", "蚌埠", "马鞍山", "淮北", "铜陵", "安庆", "黄山", "滁州",
		"宿州", "池州", "淮南", "巢湖", "阜阳", "六安", "宣城", "亳州");
CITY[12] = new Array("福州", "厦门", "莆田", "三明", "泉州", "漳州", "南平", "龙岩", "宁德");
CITY[13] = new Array("南昌", "景德镇", "九江", "鹰潭", "萍乡", "新馀", "赣州", "吉安", "宜春",
		"抚州", "上饶");
CITY[14] = new Array("济南", "青岛", "淄博", "枣庄", "东营", "烟台", "潍坊", "济宁", "泰安",
		"威海", "日照", "莱芜", "临沂", "德州", "聊城", "滨州", "菏泽");
CITY[15] = new Array("郑州", "开封", "洛阳", "平顶山", "安阳", "鹤壁", "新乡", "焦作", "濮阳",
		"许昌", "漯河", "三门峡", "南阳", "商丘", "信阳", "周口", "驻马店", "济源");
CITY[16] = new Array("武汉", "宜昌", "荆州", "襄樊", "黄石", "荆门", "黄冈", "十堰", "恩施",
		"潜江", "天门", "仙桃", "随州", "咸宁", "孝感", "鄂州");
CITY[17] = new Array("长沙", "常德", "株洲", "湘潭", "衡阳", "岳阳", "邵阳", "益阳", "娄底",
		"怀化", "郴州", "永州", "湘西", "张家界");
CITY[18] = new Array("广州", "深圳", "珠海", "汕头", "东莞", "中山", "佛山", "韶关", "江门",
		"湛江", "茂名", "肇庆", "惠州", "梅州", "汕尾", "河源", "阳江", "清远", "潮州", "揭阳", "云浮");
CITY[19] = new Array("兰州", "嘉峪关", "金昌", "白银", "天水", "酒泉", "张掖", "武威", "定西",
		"陇南", "平凉", "庆阳", "临夏", "甘南");
CITY[20] = new Array("西安", "宝鸡", "咸阳", "铜川", "渭南", "延安", "榆林", "汉中", "安康", "商洛");
CITY[21] = new Array("呼和浩特", "包头", "乌海", "集宁", "通辽", "赤峰", "呼伦贝尔盟", "阿拉善盟",
		"哲里木盟", "兴安盟", "乌兰察布盟", "锡林郭勒盟", "巴彦淖尔盟", "伊克昭盟");
CITY[22] = new Array("南宁", "柳州", "桂林", "梧州", "北海", "防城港", "钦州", "贵港", "玉林",
		"南宁", "柳州", "贺州", "百色", "河池");
CITY[23] = new Array("成都", "绵阳", "德阳", "自贡", "攀枝花", "广元", "内江", "乐山", "南充",
		"宜宾", "广安", "达川", "雅安", "眉山", "甘孜", "凉山", "泸州");
CITY[24] = new Array("贵阳", "六盘水", "遵义", "安顺", "铜仁", "黔西南", "毕节", "黔东南", "黔南");
CITY[25] = new Array("昆明", "大理", "曲靖", "玉溪", "昭通", "楚雄", "红河", "文山", "思茅",
		"西双版纳", "保山", "德宏", "丽江", "怒江", "迪庆", "临沧");
CITY[26] = new Array("拉萨", "日喀则", "山南", "林芝", "昌都", "阿里", "那曲");
CITY[27] = new Array("海口", "三亚");
CITY[28] = new Array("银川", "石嘴山", "吴忠", "固原");
CITY[29] = new Array("西宁", "海东", "海南", "海北", "黄南", "玉树", "果洛", "海西");
CITY[30] = new Array("乌鲁木齐", "石河子", "克拉玛依", "伊犁", "巴音郭勒", "昌吉", "克孜勒苏柯尔克孜",
		"博尔塔拉", "吐鲁番", "哈密", "喀什", "和田", "阿克苏");
CITY[31] = new Array("香港");
CITY[32] = new Array("澳门");
CITY[33] = new Array("台北", "高雄", "台中", "台南", "屏东", "南投", "云林", "新竹", "彰化",
		"苗栗", "嘉义", "花莲", "桃园", "宜兰", "基隆", "台东", "金门", "马祖", "澎湖");

$(function() {
	// initialize provinces
	for ( var i = 0; i < PROVINCE.length; i++) {
		$("#provinceSelect").append(
				"<option value='" + PROVINCE[i] + "'>" + PROVINCE[i]
						+ "</option>");
	}

	// initialize cities
	for ( var j = 0; j < CITY[1].length; j++) {
		$("#citySelect").append(
				"<option value='" + CITY[1][j] + "'>" + CITY[1][j]
						+ "</option>");
	}

	// select default province
	$("#provinceSelect option:eq(1)").attr("selected", "selected");

	// select default city
	$("#citySelect option:first").attr("selected", "selected");

	// refresh city list responding to province change
	$("#provinceSelect").bind(
			"change",
			function() {
				var i = $(this)[0].selectedIndex;
				$("#citySelect").empty();
				for ( var j = 0; j < CITY[i].length; j++) {
					$("#citySelect").append(
							"<option value='" + CITY[i][j] + "'>" + CITY[i][j]
									+ "</option>");
				}
			});
});