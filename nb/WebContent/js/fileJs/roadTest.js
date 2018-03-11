new Vue({
	el : '#app',
	data : {
		input : '',
		// 表格中数据
		tableData : [],
		// 查询
		serach : false,
		closeArr : [ false, false, false, true ],
		rtf_time : '',
		// 分页 当前页
		totalRows : 0,// 总条数，后台传过来的
		pageSize : 10,// 每页显示的条数
		currentPage : 1,// 分页 当前页
	},
	methods : {
		logOut:function(){
			  window.parent.location.href = "http://localhost:8080/nb/login.html"
		  },
		  
		ajaxFileUpload : function() {
			var that = this;
			if ($('#upspan').html().indexOf(".csv") <= 0) {
				that.$message("请选择csv格式的文件！");
				return;
			}
			$.ajaxFileUpload({
				url : '/nb/roadTest/addRoadTestCSV',
				// secureuri: false,
				fileElementId : 'upfile',
				dataType : 'JSON',
				success : function(data, status) {
					data = eval("(" + data + ")");
					if (data.code == 1) {
						that.$message("导入成功！");
						that.refresh(1);
					} else {
						that.$message("导入失败！");
					}
				},
				error : function(data, status, e) {
					that.$message("加载异常！");
				}
			})
			// return false;
		},
		inputChange : function(a) {
			if (a == 0) {
				// console.log(this.user_name)
				if (this.station_no != '') {
					this.closeArr[0] = true;
				} else {
					this.closeArr[0] = false;
				}
			}
		},
		closeBtn : function(a) {
			if (a == 0) {
				this.station_no = '';
				this.closeArr[0] = false;
			}
		},
		refresh : function(currentPage) {
			var that = this;
			$.ajax({
				type : "post",
				url : "/nb/roadTest/listRoadTest",
				async : false,
				dataType : 'json',
				data : {
					'page.pageSize' : that.pageSize,
					'page.currentPage' : currentPage,
					rtf_time : that.rtf_time
				},
				success : function(res) {
					console.log(res)
					if (res.code == 1) {
						that.tableData = res.listObject;
						that.totalRows = res.page.totalRows;

						// 没跳页
						if (that.currentPage == res.page.currentPage) {
							that.serach = false;
						}
						that.currentPage = res.page.currentPage;
					}
				},
				error : function(e) {
					alert("加载失败！")
				}
			});
		},
		// 查询
		search : function() {
			var that = this;
			that.serach = true;
			that.refresh(1);
		},
		// 分页
		handleSizeChange : function(val) {
			// console.log(`每页 ${val} 条`);
		},
		handleCurrentChange : function(currentPage) {
			var that = this;
			// 查询跳页判断
			if (that.serach) {
				that.serach = false;
				return;
			}
			that.refresh(currentPage);
		},
		exportFn : function(a){
			//显示地图盒子和关闭地图按钮
			$(".wrapmap").show();
			
			/*根据浏览器所在位置定位
			 * // 创建Map实例
			var map = new BMap.Map("allmap", {});
			var geolocation = new BMap.Geolocation();
			geolocation.getCurrentPosition(function(r){
				if(this.getStatus() == BMAP_STATUS_SUCCESS){
					var mk = new BMap.Marker(r.point);
					map.addOverlay(mk);
					map.panTo(r.point);
					//alert('您的位置：'+r.point.lng+','+r.point.lat);
				}
			},{enableHighAccuracy: true})
			*/
			
			//获取后台传过来的经纬度等信息
			var info = {},
				arr = [];
			$.ajax({
				type: "get",
				url: "http://101.200.45.128:8090/nb/roadTest/getSomeRoadTest?id=1", //这个是后端传给你的url地址
				async: false,
				data: {},
				dataType: "json",
				success: function(data) {
					info = data;
				}
			});
			arr = info.listObject;
			// 创建Map实例
			var map = new BMap.Map("allmap", {});
			map.centerAndZoom(new BMap.Point(arr[0].rt_station_longitude, arr[0].rt_station_latitude), 14); // 初始化地图,设置中心点坐标和地图级别
			//启用滚轮放大缩小
			map.enableScrollWheelZoom();
			
			//自定义控件
			function staticControl() {
				this.defaultAnchor = BMAP_ANCHOR_TOP_LEFT;
				this.defaultOffset = new BMap.Size(10, 10);
			}
			//继承Control的API
			staticControl.prototype = new BMap.Control();
			//初始化控件
			staticControl.prototype.initialize = function(map) {
				//创建地图上参数控件
				var div = document.createElement("div");
				//a标签功能是关闭地图
				var a = document.createElement("a");
				//input标签指地图左上角的具体参数
				var inp1 = $("<input id='inp1'>").get(0);
				var inp2 = $("<input id='inp2'>").get(0);
				var inp3 = $("<input id='inp3'>").get(0);
				//var inp4 = $("<input id='inp4'>").get(0);
				var lab1 = $("<label for = 'inp1'></label>").get(0);
				var lab2 = $("<label for = 'inp2'></label>").get(0);
				var lab3 = $("<label for = 'inp3'></label>").get(0);
				//var lab4 = $("<label for = 'inp4'></label>").get(0);
				var p1 = document.createElement("p");
				var p2 = document.createElement("p");
				//var p3 = document.createElement("p");
				
				inp1.name = "param";
				inp1.value = "rsrp";
				inp1.type = "radio";
				lab1.innerHTML = "RSRP";
				inp1.onclick = function() {
					statics(inp1);
				};
				div.appendChild(inp1);
				div.appendChild(lab1);
				div.appendChild(p1);

				inp2.name = "param";
				inp2.value = "sinr";
				inp2.type = "radio";
				lab2.innerHTML = "SINR";
				inp2.onclick = function() {
					statics(inp2);
				};
				div.appendChild(inp2);
				div.appendChild(lab2);
				div.appendChild(p2);

				inp3.name = "param";
				inp3.value = "pci";
				inp3.type = "radio";
				lab3.innerHTML = "PCI";
				inp3.onclick = function() {
					statics(inp3);
				};
				
				div.appendChild(inp3);
				div.appendChild(lab3);
				
				a.className = "closeMapBtn";
				a.innerHTML = "×";
				a.onclick = function() {
					closeMap();
				}
				div.appendChild(a);
				/*div.appendChild(p3);

				inp4.type = "checkbox";
				lab4.innerHTML = "4444";
				inp4.onclick = function() {
					statics();
				};
				div.appendChild(inp4);
				div.appendChild(lab4);*/
				
				
				//添加DOM元素到地图中
				map.getContainer().appendChild(div);
				//返回DOM
				return div;
			};
			
			//创建控件实例
			var staticsCtrl = new staticControl();
			//添加到地图当中
			map.addControl(staticsCtrl);
			//将点显示在地图上
			
			/**
			 * 功能：关闭地图及让选中的参数取消
			 */
			function closeMap() {
				//bug:关闭地图后选中的input未取消
				//取消选中的参数
				var inpArr = $(".particulars").find("input");
				console.log(inpArr);
				for (var i = 0; i < inpArr.length; i++) {
					console.log(inpArr[i]);
					inpArr[i].removeAttribute("checked");
				}
				//关闭地图
				$(".wrapmap").hide();
			}
			
			
			/*
			 * 功能：点击地图上的参数控件，右侧显示其该参数详情
			 * 
			 */
			function statics(ele) {
				//选择地图上某个参数
				if(ele.checked) {
					var ulArr = $(".particulars").children("ul");
					for(var i = 0; i < ulArr.length; i++) {
						if(ele.value == ulArr[i].className) {
							//隐藏所有参数
							for(var j = 0; j < ulArr.length; j++) {
								ulArr[j].style.display = "none";
							}
							//显示当前参数
							ulArr[i].style.display = "block";

							//右侧参数全选与反选
							var inpArr = $(ulArr[i]).find("input");
							selectAll(inpArr);
						}
					}
				}
			}
			
			/*
			 * 功能：右侧参数全选与反选
			 * 
			 */
			function selectAll(ele) {
				ele[ele.length - 1].onclick = function() {
					//被点击的input按钮的checked属性值，应该直接作为上面的所有的input按钮的checked属性值
					for(var i = 0; i < ele.length - 1; i++) {
						ele[i].checked = ele[ele.length - 1].checked;
					}
				};

				//点击上面的的input，如果上面的全部选定了，下面的全选input也选中，否则相反。
				for(var i = 0; i < ele.length - 1; i++) {
					ele[i].onclick = function() {
						//开闭原则
						var bool = true;
						//检测每一个input的checked属性值。
						for(var j = 0; j < ele.length - 1; j++) {
							if(ele[j].checked === false) {
								bool = false;
							};
						}
						ele[ele.length - 1].checked = bool;
					};
				}
			};
			
			
			function getDot() {
				
			}
			
			
		},
		
		
		
	},
	
	mounted : function() {
		this.refresh();
	},
	
	
})