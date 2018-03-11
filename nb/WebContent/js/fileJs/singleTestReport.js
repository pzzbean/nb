new Vue(
		{
			el : '#app',
			data : {
				input : '',
				// 下拉框的元素
				items : [ {
					text : 'CMCC',
					value : 'a'
				}, {
					text : 'QCUQ',
					value : 'b'
				}, {
					text : 'CT',
					value : 'c'
				} ],
				selected : 'a',
				// 表格中数据
				tableData : [],
				// 查询
				serach : false,
				closeArr : [ false, false, false, true ],
				station_no : '',
				// 分页 当前页
				totalRows : 0,// 总条数，后台传过来的
				pageSize : 10,// 每页显示的条数
				currentPage : 1,// 分页 当前页
				//指标选中值
				indexbool:[true,true,true],
				inb:1,
				centerdata:''
			},

			watch:{
				inb:function(a,b){
					console.log(this.indexbool);
					for(var i=0;i<3;i++){
						if(this.indexbool[i] == true){
							$('.indexui').eq(i).css('display','block')
						}else{
							$('.indexui').eq(i).css('display','none')
						}
					}
					this.exportFn(this.centerdata)
				}
			},
			methods : {
				
				logOut:function(){
					  window.parent.location.href = "http://localhost:8080/nb/login.html"
				  },
				  
				ajaxFileUpload : function() {
					$.ajaxFileUpload({
						url : '',
						secureuri : false,
						fileElementId : 'upfile',
						dataType : 'json',
						success : function(data, status) {
							console.log(data);
						},
						error : function(data, status, e) {
							console.log(e);
						}
					});
					return false;
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
						url : "/nb/roadTest/selectStationRoadTest",
						async : false,
						dataType : 'json',
						data : {
							'page.pageSize' : that.pageSize,
							'page.currentPage' : currentPage,
						},
						success : function(res) {
							console.log(res.listObject);
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
							alert("加载失败！");
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

				exportFn : function(a) {
					console.log(111111111111);
					this.centerdata = a;
					var that = this;
					var mJsonOfMap; 
					var	paramName;
					var id = 1, mapData = [];
					var printBtn = $(".printscreen").get(0);
					var paramS = ["rsrp","sinr","pci"];
					var failPrint = $(".failprint")[0];
					
					if (that.selected=='a') {
						console.log(that.selected)
						// 显示地图盒子和关闭地图按钮
						$(".singlemap-wrap").show();
						
//						 获取经纬度信息
						$.ajax({
							type : "post",
							url : "/nb/roadTest/selectCellRoadTest",
							async : false,
							dataType : 'json',
							data: {"station_No":a.row.station_No,"roadTestDate":a.row.testDate},
							success : function(data) {
								mapData = data.listObject;
							},
							error:function(e){
								console.log(e)
							}
						});
						
						//alert('添加数据给allinfo')
						var baseStation = new BMap.Point(121.41059,30.81544);
						// 创建Map
						var map = new BMap.Map("singlemap-map", {
							enableMapClick : false
						});
						map.centerAndZoom(baseStation, 14);
						map.enableScrollWheelZoom();
//						[{lng:121.41059,lat:30.81544,rsrp:10,sinr:20,pci:665},{lng:121.41069,lat:30.81534,rsrp:8,sinr:10,pci:535}]
						var allinfo=mapData,infoobj={};
						infoobj.rsrp1=[];  //-140 <= RSRP < -110
						infoobj.rsrp2=[];  //-110 <= RSRP < -100
						infoobj.rsrp3=[];  //-100 <= RSRP < -90
						infoobj.rsrp4=[];  //-90 <= RSRP < -80
						infoobj.rsrp5=[];  //-80 <= RSRP < -70
						infoobj.rsrp6=[];  //-70 <= RSRP <= 30
						infoobj.sinr1=[];  //-15 <= SINR < 0
						infoobj.sinr2=[];  //0 <= SINR < 5
						infoobj.sinr3=[];  //5 <= SINR < 10
						infoobj.sinr4=[];  //10 <= SINR < 15
						infoobj.sinr5=[];  //15 <= SINR < 20
						infoobj.sinr6=[];  //20 <= SINR < 30
						infoobj.pci1=[];  //PCI = 535
						infoobj.pci5=[];  //PCI = 759
						infoobj.pci6=[];  //PCI = 665
						
						
						//根据参数划分数据infoobj
						for(var i=0;i<allinfo.length;i++){
							if(this.indexbool[0] == true){
								var rsrp={};
								rsrp.lng=allinfo[i].longitude;
								rsrp.lat=allinfo[i].latitude;
								rsrp.rsrp=Number(allinfo[i].rsrp);
								if(-140 <= rsrp.rsrp && rsrp.rsrp <-110){
									infoobj.rsrp1.push(rsrp)
								}else if(-110 <= rsrp.rsrp && rsrp.rsrp <-100){
									infoobj.rsrp2.push(rsrp)
								}else if(-100 <= rsrp.rsrp && rsrp.rsrp  < -90){
									infoobj.rsrp3.push(rsrp)
								}else if(-90 <= rsrp.rsrp && rsrp.rsrp  < -80){
									infoobj.rsrp4.push(rsrp)
								}else if(-80 <= rsrp.rsrp && rsrp.rsrp  < -70){
									infoobj.rsrp5.push(rsrp)
								}else if(-70 <= rsrp.rsrp && rsrp.rsrp  < 30){
									infoobj.rsrp6.push(rsrp)
								}
							}
							if(this.indexbool[1] == true){
								var sinr={};
								sinr.lng=allinfo[i].longitude;
								sinr.lat=allinfo[i].latitude;
								sinr.sinr=Number(allinfo[i].sinr);
								if(-15 <= sinr.sinr && sinr.sinr < 0 ){
									infoobj.sinr1.push(sinr)
								}else if(0 <= sinr.sinr && sinr.sinr < 5 ){
									infoobj.sinr2.push(sinr)
								}else if(5 <= sinr.sinr && sinr.sinr < 10 ){
									infoobj.sinr3.push(sinr)
								}else if(10 <= sinr.sinr && sinr.sinr < 15 ){
									infoobj.sinr4.push(sinr)
								}else if(15 <= sinr.sinr && sinr.sinr < 20 ){
									infoobj.sinr5.push(sinr)
								}else if(20 <= sinr.sinr && sinr.sinr < 30 ){
									infoobj.sinr6.push(sinr)
								}
							}
							if(this.indexbool[2] == true){
								var pci={};
								pci.lng=allinfo[i].longitude;
								pci.lat=allinfo[i].latitude;
								pci.pci=Number(allinfo[i].pci);
								if(pci.pci == 119){
									infoobj.pci1.push(pci)
								}else if(pci.pci == 396){
									infoobj.pci5.push(pci)
								}if(pci.pci == 398){
									infoobj.pci6.push(pci)
								}
							}
						}
						console.log(infoobj)
//						//渲染加载
					if (document.createElement('canvas').getContext) {	
						
						var allarr=[infoobj.rsrp1,infoobj.rsrp2,infoobj.rsrp3,infoobj.rsrp4,infoobj.rsrp5,infoobj.rsrp6];
						var allcolor=['#ff0000','#ffc000','#ffff00','#92d050','#00b050','#003eff'];
						for(var m=0;m<allarr.length;m++){
							if(allarr[m].length != 0){
								var points=[];
								for(var n=0;n<allarr[m].length;n++){
									points.push(new BMap.Point(allarr[m][n].lng,allarr[m][n].lat));
								}
								var options = {
						        		size : BMAP_POINT_SIZE_SMALL,
										shape : BMAP_POINT_SHAPE_CIRCLE,
						            color: allcolor[m]
						        }
								var pointCollection = new BMap.PointCollection(points, options);  // 初始化PointCollection
							    map.addOverlay(pointCollection); 
							}
						};
//						//alert('加入')
						var sinrarr=[infoobj.sinr1,infoobj.sinr2,infoobj.sinr3,infoobj.sinr4,infoobj.sinr5,infoobj.sinr6];
						for(var m=0;m<sinrarr.length;m++){
							if(sinrarr[m].length != 0){
								var points=[];
								for(var n=0;n<sinrarr[m].length;n++){
									points.push(new BMap.Point(sinrarr[m][n].lng,sinrarr[m][n].lat));
								}
								var options = {
						        		size : BMAP_POINT_SIZE_SMALL,
										shape : BMAP_POINT_SHAPE_CIRCLE,
						            color:allcolor[m]
						        }
								var pointCollection = new BMap.PointCollection(points, options);  
							    map.addOverlay(pointCollection); 
							}
						};
						
						var pciarr=[infoobj.pci1,infoobj.pci5,infoobj.pci6];
						for(var m=0;m<pciarr.length;m++){
							if(pciarr[m].length != 0){
								var points=[];
								for(var n=0;n<pciarr[m].length;n++){
									points.push(new BMap.Point(pciarr[m][n].lng,pciarr[m][n].lat));
								}
								var num=m;
								if(m == 1){
									num=4;
								}else if(m == 2){
									num=5;
								}
								var options = {
						        		size : BMAP_POINT_SIZE_SMALL,
										shape : BMAP_POINT_SHAPE_CIRCLE,
						            color: allcolor[num]
						        }
								var pointCollection = new BMap.PointCollection(points, options); 
							    map.addOverlay(pointCollection); 
							}
						};
						
					 } else {
					        alert('请在chrome、safari、IE8+以上浏览器查看本示例');
					    }
						
						// 初始化地图，让点加载到地图上，提高截图效率
						// 判断当前浏览器是否支持绘制海量点
//						if (document.createElement('canvas').getContext) {
//							// 添加海量点
//							var initPoints = [];
//							for (var i = 0; i < mapData.length; i++) {
//								initPoints.push(new BMap.Point(
//										mapData[i].rt_station_longitude,
//										mapData[i].rt_station_latitude));
//							}
//						} else {
//							 alert('请在谷歌、safari、火狐、IE11+以上浏览器查看本示例');
//						}
						
						//根据坐标调整地图视野
						//map.setViewport(initPoints);
						//map.addOverlay(initPoints);
						
						
						//在地图上添加关闭按钮,控制器
						function staticControl() {
							this.defaultAnchor = BMAP_ANCHOR_TOP_RIGHT;
							this.defaultOffset = new BMap.Size(10, 14);
						}
						
						staticControl.prototype = new BMap.Control();
						staticControl.prototype.initialize = function(map) {
							var div = document.createElement("div");
							var a = document.createElement("a");
							a.className = "closeMapBtn";
							a.innerHTML = "×";
							a.onclick = function() {
								closeMap(that);
							}
							div.appendChild(a);
							map.getContainer().appendChild(div);
							return div;
						};
						
						var staticsCtrl = new staticControl();
						map.addControl(staticsCtrl);
						
						
						
						// 将要截图的指标发给后台，并获取到要截图的所有点的信息
						$.ajax({
							type : "GET",
							url : "/nb/log/autoCreateReport?paramS=" + paramS,
							async : false,
							success : function(data) {
								mJsonOfMap = JSON.parse(data);
								console.log(mJsonOfMap)
							}
						});
						
						//tracingPoint(mJsonOfMap, paramS.length);
						
						
						
						/*
						 * 功能：关闭地图
						 */
						function closeMap(ele) {
							console.log(2222222);
							console.log(ele);
							var ulArr = $(".singlemap-param").find("ul");
							var bool = false;
							for (var i = 0; i < ulArr.length; i++) {
								ulArr[i].style.display = "none";
							}
							
							$(".singlemap-wrap").hide();
							
							//关闭地图后弹出保存报告页面
							window.open('/nb/log/createSingle1?plane_id='
									+ ele.tableData[a.$index].plane_id
									+ '&user_id=' + ele.tableData[a.$index].user_id
									+ "&station_no="
									+ ele.tableData[a.$index].station_no
									+ "&plane_test_time="
									+ ele.tableData[a.$index].plane_test_time);
						}
						
						/*
						 * 显示轨迹
						 */
						function tracingPoint(ele, long) {
					
							// 递归实现地图打点
							if (long>0) {
								toolShowMap(ele, long);
							} 
						}
						
						/**
						 * 显示地图
						 */
						function toolShowMap(ele, num) {
							console.log(ele,num);
							var judgePrint = {}, paramName = paramS[paramS.length - num], tempParam = [], colorParam = [];
							
							// 清空地图上的点
							map.clearOverlays();
							
							//在地图上显示基站
							var iconAnchor = new BMap.Size(17, 30);
							var url1 = "../img/sector.png";
							var offset1 = new BMap.Size(15, 21);
							var offset2 = new BMap.Size(-13, 23);
							var myIcon1 = new BMap.Icon(url1, new BMap.Size(34, 30),{anchor:iconAnchor});
							var myIcon2 = new BMap.Icon(url1, new BMap.Size(34, 30),{anchor:iconAnchor});
							var myIcon3 = new BMap.Icon(url1, new BMap.Size(34, 30),{anchor:iconAnchor});
							var marker1 = new BMap.Marker(baseStation, {icon: myIcon1});
							var marker2 = new BMap.Marker(baseStation, {icon: myIcon2,rotation:"120",offset:offset1});
							var marker3 = new BMap.Marker(baseStation, {icon: myIcon3,rotation:"240",offset:offset2});
							map.addOverlay(marker1);
							map.addOverlay(marker2);
							map.addOverlay(marker3);
							
							// 获取每个指标所有的信息点的经纬度
							for ( var k in ele.mapinfo) {
								console.log(k)
								if (k.indexOf(paramName) != -1) {
									// 记录键值
									tempParam.push(ele.mapinfo[k]);
									// 记录key
									colorParam.push(k);
								}
							}
							console.log(tempParam,colorParam);
							// 遍历一个指标所有点的经纬度
							for (var i = 0; i < tempParam.length; i++) {
								var points = [];
								for (var j = 0; j < tempParam[i].length; j++) {								
									points.push(new BMap.Point(
											tempParam[i][j].rt_station_longitude,
											tempParam[i][j].rt_station_latitude));
								}
								
								// 定义点样式
								if ("rsrp1" === colorParam[i]
										|| "sinr1" === colorParam[i]
										|| "pci1" === colorParam[i]) {
									var options = {
										size : BMAP_POINT_SIZE_SMALL,
										shape : BMAP_POINT_SHAPE_CIRCLE,
										color : '#E80308'
									};
								} else if ("rsrp2" === colorParam[i]
										|| "sinr2" === colorParam[i]) {
									var options = {
										size : BMAP_POINT_SIZE_SMALL,
										shape : BMAP_POINT_SHAPE_CIRCLE,
										color : '#E85C60'
									};
								} else if ("sinr3" === colorParam[i]) {
									var options = {
										size : BMAP_POINT_SIZE_SMALL,
										shape : BMAP_POINT_SHAPE_CIRCLE,
										color : '#C637C7'
									};
								} else if ("rsrp3" === colorParam[i]
										|| "sinr4" === colorParam[i]) {
									var options = {
										size : BMAP_POINT_SIZE_SMALL,
										shape : BMAP_POINT_SHAPE_CIRCLE,
										color : '#E6E807'
									};
								} else if ("rsrp4" === colorParam[i]
										|| "sinr5" === colorParam[i]
										|| "pci3" === colorParam[i]) {
									var options = {
										size : BMAP_POINT_SIZE_SMALL,
										shape : BMAP_POINT_SHAPE_CIRCLE,
										color : '#0E14E8'
									};
								} else if ("rsrp5" === colorParam[i]
										|| "sinr6" === colorParam[i]
										|| "pci2" === colorParam[i]) {
									var options = {
										size : BMAP_POINT_SIZE_SMALL,
										shape : BMAP_POINT_SHAPE_CIRCLE,
										color : '#1EDEE8'
									};
								} else if ("rsrp6" === colorParam[i]
										|| "sinr7" === colorParam[i]) {
									var options = {
										size : BMAP_POINT_SIZE_SMALL,
										shape : BMAP_POINT_SHAPE_CIRCLE,
										color : '#0BE857'
									};
								} else if ("rsrp7" === colorParam[i]
										|| "sinr8" === colorParam[i]) {
									var options = {
										size : BMAP_POINT_SIZE_SMALL,
										shape : BMAP_POINT_SHAPE_CIRCLE,
										color : '#0AC723'
									};
								} else if ("rsrp8" === colorParam[i]
										|| "sinr9" === colorParam[i]
										|| "pci4" === colorParam[i]) {
									var options = {
										size : BMAP_POINT_SIZE_SMALL,
										shape : BMAP_POINT_SHAPE_CIRCLE,
										color : '#01A50E'
									};
								}
								
								map.setViewport(points);
								var pointCollection = new BMap.PointCollection(points, options);
								
								
								map.addOverlay(pointCollection);
								
							}
							
							/*setTimeout(function() {
								requestPrint(ele,paramName,num);
							},3000)*/
							
						}
						
						/**
						 * 请求截图
						 */
						/*function requestPrint(ele,exName,long) {
							console.log("nei" + exName);
							$.ajax({
								type : "GET",
								url : "/nb/roadTest/getAutoPhotos?id=" + id
										+ "&paramName=" + exName + "",
								async : false,
								success : function(data) {
									judgePrint = JSON.parse(data);
									if (judgePrint.code == 1) {
										failPrint.innerHTML = exName + "截图成功";
										$(failPrint).fadeIn(2000).fadeOut(2000);
										
									} else {
										failPrint.innerHTML = exName + "截图失败";
										$(failPrint).fadeIn(2000).fadeOut(2000);
									}
									tracingPoint(ele, long - 1);
								}
								
							});
						} */
					}else if(that.selected=='b') {
						  window.open('/nb/log/createSingle2?plane_id='+that.tableData[a.$index].plane_id+'&user_id='+that.tableData[a.$index].user_id+"&station_no="+that.tableData[a.$index].station_no+"&plane_test_time="+that.tableData[a.$index].plane_test_time);
					}else if(that.selected=='c') {
						window.open('/nb/log/createSingle3?plane_id='+that.tableData[a.$index].plane_id+'&user_id='+that.tableData[a.$index].user_id+"&station_no="+that.tableData[a.$index].station_no+"&plane_test_time="+that.tableData[a.$index].plane_test_time);
					}
					
				},
				
				
				
			},
			mounted : function() {
				this.refresh();
				console.log($('#rsrp').attr('checked'))
				var that=this;
				$('.indexclick').on('click',function(){
					var index = $('.indexclick').index(this);
					that.indexbool[index] = !that.indexbool[index];
					that.inb++;
					$('.indexclick').eq(index).attr('checked',that.indexbool[index]);
				});
				
			}
		});