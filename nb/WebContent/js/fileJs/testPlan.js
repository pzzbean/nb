
new Vue({
    el: '#app',
    data:{
        input: '',
        // 表格中数据
        tableData:[],
        // 分页 当前页
        totalRows:0,//总条数，后台传过来的
        pageSize:10,//每页显示的条数      
        currentPage:1,// 分页 当前页
        //查询
        serach:false,
        closeArr:[false,false,false,true,true],
        plan_test_engineer:'',
	    plan_te_phone:'',
	    plane_test_station:'',
	    plane_test_start_time:'',
	    plane_test_end_time:'',
	  
        dialogTableVisible:false,
        dialogFormVisible:false,
        dialogFormVisible2:false,
        dialogFormVisible3: false,
        
        //plane_test_items:[],
        // 计划弹出框表单内容
        form: {
    	    plan_id: '',
    	    user_id: '',
    	  
    	    plan_test_engineer:'',
    	    plan_te_phone:'',
    	    plan_creater:'',
    	    plan_creater_phone:'',
    	    //plane_test_station:'',
    	    plane_test_status:'',
    	    plane_test_start_time:'',
    	    plane_test_end_time:'',
    	    plane_create_time:'',
    	    plane_update_time:'',
    	    plane_Modifier:'',
    	    plane_test_configStation:'',
    	    plane_test_stationIdList:[],//选中基站ID
    	    plane_test_stationIdList1:''
        },

        items: [],  //获取小区
        items1: [], //获取小区内基站
        
        //配置基站内容
        allSelectStationsInfo: [],//所有选中基站的信息
        configStationValue: '',//当前基站名称
        station: [{stationName: ""},{stationId: ""}],//当前选中基站
        cellInfo: [],//接收后台基站下的所有小区
        //配置参数后的基站信息
//        selectStation: [
//        	{selectStationId: ""},
//        	{selectStationName: ""},
//        	//配置参数后的基站属性
//        	{selectStationProperty: []},
//        	//配置参数后的小区
//        	{selectCellInfo: [
//            	{selectCellId: ""},
//            	{selectCellName: ""},
//            	{selectCategory: [
//            		{selectCategotyId: ""},
//            		{selectCategoryName:""},
//            		{selectCellPropertyId: []},
//            	]},
//            	
//            	//配置的小区指标
//            	{selectIndexId: []},
//            ]},
//        ],
        selectStationInfo :[],
        stationParams: [],
        checkAll: false,
        isIndeterminate: false,
        
        //用户
  	    user_code: '',
  	    user_name:'',
  	    user_phone: '',
      	
  	    tableDataUser:[],
  	    totalRowsUser:0,//总条数，后台传过来的
  	    pageSizeUser:10,//每页显示的条数      
  	    currentPageUser:1,// 分页 当前页
  	    searchUser:false
    },
    methods: {
	    /*
	     * 退出跳转到主页
	     */
	    logOut:function(){
		    window.parent.location.href = "http://localhost:8080/nb/login.html"
	    },
	  
	  
	    /*
	     * 刷新
	     */
        refresh:function(){
		var that=this;
		    $.ajax({
				type:"post",
				url:"/nb/plane/listPlane",
				async:false,
				dataType:'json',
				data:{'page.pageSize':that.pageSize,'page.currentPage':1},
				success:function(res){
					//console.log(res)
					if(res.code==1){
						that.tableData=res.listObject;
						that.totalRows=res.page.totalRows;
						that.currentPage=res.page.currentPage;
					}
				},
				error:function(e){
					alert("加载失败！");
				}
			});
	    },
	    
	    inputChange:function (a){
			if(a == 0){
				//console.log(this.user_name)
				if(this.plan_test_engineer != ''){
					this.closeArr[0] = true;
				}else{
					this.closeArr[0] = false;
				}
			}else if(a == 1){
				if(this.plan_te_phone != ''){
					this.closeArr[1] = true;
				}else{
					this.closeArr[1] = false;
				}
			}else if(a == 2){
				if(this.plane_test_station != ''){
					this.closeArr[2] = true;
				}else{
					this.closeArr[2] = false;
				}
			}else if(a==3){
				if(this.plane_test_start_time != ''){
					this.closeArr[3] = true;
				}else{
					this.closeArr[3] = false;
				}
			}else if(a==4){
				if(this.plane_test_end_time != ''){
					this.closeArr[4] = true;
				}else{
					this.closeArr[4] = false;
				}
			}
		},  
		
		closeBtn:function (a) {
			if(a == 0){
				this.plan_test_engineer = '';
				this.closeArr[0]=false;
			}else if(a == 1){
				this.plan_te_phone = '';
				this.closeArr[1]=false;
			}else if(a == 2){
				this.plane_test_station = '';
				this.closeArr[2]=false;
			}else if(a == 3){
				this.plane_test_start_time = '';
				this.closeArr[3]=false;
			}else if(a == 4){
				this.plane_test_end_time = '';
				this.closeArr[4]=false;
			}
		},
		//点击查询按钮
		search:function(){
	    	var that=this;
	    	that.serach=true;    	
	    	
	    	if(that.plane_test_start_time!=''){
	    		var changeStartTime=new Date(that.form.plane_test_start_time);
	    		that.form.plane_test_start_time=changeStartTime.getFullYear()+'-'+(changeStartTime.getMonth() + 1)+ '-' + changeStartTime.getDate();
	    		if(changeStartTime.getMonth()<10){
			  		that.form.plane_test_start_time=changeStartTime.getFullYear()+'-'+(changeStartTime.getMonth() + 1)+ '-0' + changeStartTime.getDate();
			  	}
	    	}
	    	if(that.plane_test_end_time!=''){
	    		var changeEndTime=new Date(that.form.plane_test_end_time);
	  	  	    that.form.plane_test_end_time=changeEndTime.getFullYear()+'-'+(changeEndTime.getMonth() + 1)+ '-' + changeEndTime.getDate();
	  	  	    if(changeEndTime.getMonth()<10){
	  	  		   that.form.plane_test_end_time=changeEndTime.getFullYear()+'-'+(changeEndTime.getMonth() + 1)+ '-0' + changeEndTime.getDate();
	  	  	   }
	    	}
		  	  
	    	//alert(that.plane_test_start_time)
	    	$.ajax({
		  			type:"post",
		  			url:"/nb/plane/listPlane",
		  			async:false,
		  			dataType:'json',
		  			data:{'page.pageSize':that.pageSize,'page.currentPage':1,
		  				  plan_test_engineer:that.plan_test_engineer,
		  				  plan_te_phone:that.plan_te_phone,
		  				  plane_test_start_time:that.plane_test_start_time,
		  				  plane_test_end_time:that.plane_test_end_time,
		  				  plane_test_station:that.plane_test_station
		  				  },
		  			success:function(res){
		  				//console.log(res)
		  				if(res.code==1){
		  					that.tableData=res.listObject;
		  					that.totalRows=res.page.totalRows;
		  					//没跳页
		  					if(that.currentPage==res.page.currentPage){
		  						that.serach=false;
		  					}
		  					that.currentPage=res.page.currentPage;
		  					
		  				}
		  			},
		  			error:function(e){
		  				alert("加载失败！");
		  			}
		  		});
	    },
	    // 列表分页
	    handleSizeChange:function(val){
	     
	    },
    
	    handleCurrentChange:function(currentPage) {
	    	var that=this;
	    	//查询跳页判断
	    	if(that.serach){
	    		that.serach=false;
	    		return;
	    	}
		  	  $.ajax({
		  			type:"post",
		  			url:"/nb/plane/listPlane",
		  			async:false,
		  			dataType:'json',
		  			data:{'page.pageSize':that.pageSize,'page.currentPage':currentPage,
		  				  plan_test_engineer:that.plan_test_engineer,
		  				  plan_te_phone:that.plan_te_phone,
		  				  plane_test_start_time:that.plane_test_start_time,
		  				  plane_test_end_time:that.plane_test_end_time,
		  				  plane_test_station:that.plane_test_station
		  			},
		  			success:function(res){
		  				//console.log(res)
		  				if(res.code==1){
		  					that.tableData=res.listObject;
		  					that.totalRows=res.page.totalRows;
		  					that.currentPage=res.page.currentPage;
		  				}
		  			},
		  			error:function(e){
		  				alert("加载失败！");
		  			}
		  		});
	    },
    
	    //添加测试计划
	    addClick:function(){
	        var that=this;
	        that.user_code='';
	        that.user_name='';
	        that.user_phone='';
			  $.ajax({
					type:"post",
					url:"/nb/user/listUser",
					async:false,
					dataType:'json',
					data:{'page.pageSize':that.pageSizeUser,'page.currentPage':1},
					success:function(res){
						//console.log(res)
						if(res.code==1){
							for(var i=0;i<res.listObject.length;i++){
		  						var user = res.listObject[i];
		  						if(user['status']==1)res.listObject[i].statusStr='管理员';
		  						if(user['status']==2)res.listObject[i].statusStr='测试人员';
		  					}
							that.tableDataUser=res.listObject;
							that.totalRowsUser=res.page.totalRows;
							that.currentPageUser=res.page.currentPage;
							that.dialogTableVisible=true;
						}
					},
					error:function(e){
						alert("加载失败！");
					}
				});
	     },
     
     
	     searchUserFun:function(){
	    	var that=this;
	     	that.searchUser=true;    	
	     	$.ajax({
	 	  			type:"post",
	 	  			url:"/nb/user/listUser",
	 	  			async:false,
	 	  			dataType:'json',
	 	  			data:{'page.pageSize':that.pageSizeUser,'page.currentPage':1,
	 	  				   user_code:that.user_code,user_name:that.user_name,user_phone:that.user_phone
	 	  				  },
	 	  			success:function(res){
	 	  				//console.log(res)
	 	  				if(res.code==1){
	 	  					for(var i=0;i<res.listObject.length;i++){
		  						var user = res.listObject[i];
		  						if(user['status']==1)res.listObject[i].statusStr='管理员';
		  						if(user['status']==2)res.listObject[i].statusStr='测试人员';
		  					}
	 	  					that.tableDataUser=res.listObject;
							that.totalRowsUser=res.page.totalRows;
	 	  					//没跳页
	 	  					if(that.currentPageUser==res.page.currentPage){
	 	  						that.searchUser=false;
	 	  					}
	 	  					that.currentPageUser=res.page.currentPage;
	 	  					
	 	  				}
	 	  			},
	 	  			error:function(e){
	 	  				alert("加载失败！");
	 	  			}
	 	  		});
	     },
	     //用户列表分页
	     handleSizeChangeUser:function(){
	    	 
	     },
	     handleCurrentChangeUser:function(currentPage){
	    	 var that=this;
	     	//查询跳页判断
	     	if(that.searchUser){
	     		that.searchUser=false;
	     		return;
	     	}
	 	  	  $.ajax({
	 	  			type:"post",
	 	  			url:"/nb/user/listUser",
	 	  			async:false,
	 	  			dataType:'json',
	 	  			data:{'page.pageSize':that.pageSizeUser,'page.currentPage':currentPage,
	 	  			 user_code:that.user_code,user_name:that.user_name,user_phone:that.user_phone
	 	  			},
	 	  			success:function(res){
	 	  				//console.log(res)
	 	  				if(res.code==1){
	 	  					for(var i=0;i<res.listObject.length;i++){
		  						var user = res.listObject[i];
		  						if(user['status']==1)res.listObject[i].statusStr='管理员';
		  						if(user['status']==2)res.listObject[i].statusStr='测试人员';
		  					}
	 	  					that.tableDataUser=res.listObject;
							that.totalRowsUser=res.page.totalRows;
							that.currentPageUser=res.page.currentPage;
	 	  				}
	 	  			},
	 	  			error:function(e){
	 	  				alert("加载失败！");
	 	  			}
	 	  		});
	     },
	     
	    // 双击用户信息弹出计划弹窗
	    rowDbClick:function(row){
	      var that = this;
	      //that.form.user_id = row.user_id;
	      that.form.plan_test_engineer = row.user_name;
	      that.form.plan_te_phone = row.user_phone;
	      that.form.plan_creater = '';
	 	  that.form.plan_creater_phone = '';
	 	  that.form.plane_Modifier = '';
	 	  that.form.plane_test_start_time = '';
	 	  that.form.plane_test_end_time = '';
	 	  that.form.plane_test_status = '';
	 	  that.plane_test_stationList = '';
	      this.dialogFormVisible=true;
	      
	      //全部区域：
	      var url1 = "http://localhost:8080/nb/area/queryHomeArea";
	      $.ajax({
	    	  type:"GET",
	    	  url:url1,
	    	  async:true,
	    	  success:function(data){
	    
	    		 that.items1 = eval('(' + data + ')').listObject;
	    	  },
	      });
	      //全部基站：
	      var url = "http://localhost:8080/nb/station/queryStations";
	      $.ajax({
	    	  type:"GET",
	    	  url:url,
	    	  async:true,
	    	  success:function(data){
	    		 that.items = eval('(' + data + ')').listObject;
	    	  },
	      });
	     
	    },
	    //区域改变之后联动基站：
	    AreaStationChange:function(){
	    	 var that = this;
	    	 that.form.plane_test_stationIdList=[];
	    	 var AreaName=this.form.plane_test_stationIdList1;
	    	 var url = "http://localhost:8080/nb/area/queryAllByHa?home_area="+AreaName;
		      $.ajax({
		    	  type:"GET",
		    	  url:url,
		    	  async:false,
		    	  success:function(data){
		    	
		    		var list = eval('(' + data + ')').listObject;
		    		
		    		if(list.length === 0){
		    			that.items = [];
		    			return false;
		    		}list.map((value, index) => {
		    			that.items[index].stationName = value.station_name;
		    			that.items[index].stationId = value.id;
		    			
		    		})
		    		
		    	  },
		      });
	    },
	    //点击配置测试基站按钮
	    configStation:function() {
	    	var that = this;
	    	var selectStationId=[];
	    	selectStationId= that.form.plane_test_stationIdList;
	    	 for(var i=0;i<selectStationId.length;i++){
   			   for(var j=0;j<that.items.length;j++ ){
   				  if(selectStationId[i] == that.items[j].stationId){
   					  that.station[i].stationId = that.items[j].stationId;
   					  that.station[i].stationName = that.items[j].stationName;
   				  }
   			   }
   		     }
	    	 var tempStationId = JSON.stringify(selectStationId);
	    	 $.ajax({  
	            type: "POST",  
	            url:"/nb/testplan/queryAll1",  
	            async:false,  
	            dataType: 'json',
	            traditional:true, 
	            data:{'stationId':tempStationId},
	            success:function(res) {
	            	console.log(res);
	            	that.allSelectStationsInfo = res.listObject;
	            },  
	            error:function(){
	            	alert("加载失败!");
	            }  
	        }); 
	    	that.dialogFormVisible3 = true;
	    },
	    
	    /*
	     * 选择基站时发生变化基站参数及小区参数发生改变
	     */
	    configStationChange:function() {
	    	var that = this;
	    	var tempStation = that.station;//选中基站集合
	    	var tempStationInfo =  that.allSelectStationsInfo;//后台基站信息
	    	var tempstationProperty = [];//基站属性
	    	if("" == that.configStationValue) {
	    		alert("添加失败,请选择基站!");
	    	}
	    	for(var i = 0;i<tempStationInfo.length;i++){
	    		var station = tempStationInfo[i];//当前选择基站
	    		if(station.stationId == that.configStationValue){
	    			tempstationProperty = station.listStationProperty;
	    			//加载基站属性
	    			for(var j = 0;j<tempstationProperty.length;j++){
	    				if(tempstationProperty[j].stationPropertyName == "station_height"){
	    					tempstationProperty[j].stationPropertyName = "海拔";
	    				}else if(tempstationProperty[j].stationPropertyName == "station_longitude"){
	    					tempstationProperty[j].stationPropertyName = "经度";
	    				}else if(tempstationProperty[j].stationPropertyName == "station_latitude"){
	    					tempstationProperty[j].stationPropertyName = "纬度";
	    				}else if(tempstationProperty[j].stationPropertyName == "TAC"){
	    					tempstationProperty[j].stationPropertyName = "TAC";
	    				}
	    			}
	    			that.stationParams = tempstationProperty; 
	    			//加载小区
	    			that.cellInfo = station.listStationCellsInfo;
	    		}
	    	}    	    	    	
	    },
	    
	    
	    //基站指标参数选中状态改变
	    handleStationParamChange:function(value){
	    	alert(value);
	    	var that = this;
	    	let checkedCount = value.length;
	    	that.checkAll = checkedCount === that.stationParams.length;
	    	that.isIndeterminate = checkedCount > 0 && checkedCount < that.stationParams.length;
	    },
	    
	    //基站指标全选
	    handleCheckAllChange:function(val) {
	    	var that = this;
	    	that.checkedStationParam = val ? that.stationParams : [];
	    	that.isIndeterminate = false;
	    },
	    
	    selectParms:function(Value){
	    	var that=this;
	    	alert(Value);
	    },
	    
	    //点击配置测试取消按钮
	    configStaCancel:function() {
	    	var that = this;
	    	that.dialogFormVisible3 = false;
	    	configStationValue = '';
	    },
	    
	    //点击配置测试确定按钮
	    configStaSave:function() {
	    	var that = this;
	    	console.log(that.checkedStationParam);
	    	that.checkedStationParam = [];
	    },
	    
	    // 点击计划弹窗中保存按钮
	    planSave:function(){
	    	
	      var that = this;
	      //验证
	      if(that.form.plan_test_engineer==''){
	    	  that.$message("测试工程师不能为空！");
	    	  return;
	      }
	      if(that.form.plan_te_phone==''){
	    	  that.$message("测试工程师电话不能为空！");
	    	  return;
	      }
	      var regx_phone = /^1[34578]\d{9}$/;
		  if(!(regx_phone.test(that.form.plan_te_phone))) {
		  		that.$message("测试工程师电话格式不对！");
		  		return;
		  }
		  if(that.form.plan_creater==''){
			  that.$message("计划创建人不能为空！");
	    	  return;
		  }
		  if(that.form.plan_creater_phone==''){
			  that.$message("创建人电话不能为空！");
	    	  return;
		  }
		  if(!(regx_phone.test(that.form.plan_creater_phone))) {
		  		that.$message("创建人电话格式不对！");
		  		return;
		  }
		  if(that.form.plane_test_start_time==''){
			  that.$message("测试开始时间不能为空！");
		  	  return;
		  }
		  if(that.form.plane_test_end_time==''){
			  that.$message("测试结束时间不能为空！");
		  	  return;
		  }
		  if(that.form.plane_test_stationIdList==''){
			  that.$message("测试基站不能为空！");
		  	  return;
		  }
		  that.form.plane_test_stationIdList = that.form.plane_test_stationIdList.join(',');
//		  that.form.plane_test_station = that.form.plane_test_station.substring(0,that.form.plane_test_station.length-1);
//		  
//		  var changeStartTime=new Date(that.form.plane_test_start_time);
//		  var changeEndTime=new Date(that.form.plane_test_end_time);
//		  that.form.plane_test_start_time=changeStartTime.getFullYear()+'-'+(changeStartTime.getMonth() + 1)+ '-' + changeStartTime.getDate();
//		  that.form.plane_test_end_time=changeEndTime.getFullYear()+'-'+(changeEndTime.getMonth() + 1)+ '-' + changeEndTime.getDate();
//		  if(changeStartTime.getMonth()<10){
//				that.form.plane_test_start_time=changeStartTime.getFullYear()+'-'+(changeStartTime.getMonth() + 1)+ '-0' + changeStartTime.getDate();
//	
//		  }
//		  if(changeEndTime.getMonth()<10){
//				that.form.plane_test_end_time=changeEndTime.getFullYear()+'-'+(changeEndTime.getMonth() + 1)+ '-0' + changeEndTime.getDate();
//				 alert(333);
//		  }
		  //添加
		  $.ajax({
	 			type:"post",
	 			url:"/nb/temporarytestplan/insertTestplans",
	 			async:true,
	 			dataType:'json',
	 			data:{
	 				userId: that.form.user_id,
	 				testEngineer:that.form.plan_test_engineer,
	 				testEngineerPhone:that.form.plan_te_phone,
	 				planCreator:that.form.plan_creater,
	 				planCreatorPhone:that.form.plan_creater_phone,
	 				stationNo:that.form.plane_test_station,
	 				testStartTime:that.form.plane_test_start_time,
	 				testEndTime:that.form.plane_test_end_time,
	 				
	 				testJizhang:form.plan_test_jizhang,
	 				teststationArea:that.form.plane_test_stationIdList1,
	 				teststationIdlist:that.form.plane_test_stationIdList
	 		    	  
	 			},
	 			success:function(res){
	 				alert(11111);
	 				//console.log(res)
	 				if(res.code==1){
	 					that.$message("添加成功");
	 					that.refresh();
	 					that.dialogFormVisible=false;
	 				  	  return;
	 				}
	 			},
	 			error:function(e){
	 				alert("加载失败！");
	 			}
	 		});
		  
	    },
	    // 点击计划弹窗中取消按钮
	    planCancel:function(){
	      this.dialogFormVisible=false;
	      this.dialogFormVisible2=false;
	    },
	    //点击修改按钮
	    change:function(row){
	    	var that = this;
	    	console.log(row);
	    	that.form.plan_id = row.plan_id;
	        that.form.user_id = row.user_id;
	        that.form.plan_test_engineer = row.plan_test_engineer;
	        that.form.plan_te_phone = row.plan_te_phone;
	        that.form.plan_creater = row.plan_creater;
		   	that.form.plan_creater_phone = row.plan_creater_phone;
		   	that.form.plane_test_start_time = row.plane_test_start_time;
		   	that.form.plane_test_end_time = row.plane_test_end_time;
		   	that.form.plane_test_station='';
//		    var content = row.plane_test_station.split(',');
		    that.dialogFormVisible2 = true;
	    },
	    //点击修改窗中的确定按钮
	    planChange:function(){
	    	var that = this;
	        //验证
	        if(that.form.plan_test_engineer==''){
	      	  that.$message("测试工程师不能为空！");
	      	  return;
	        }
	        if(that.form.plan_te_phone==''){
	      	  that.$message("测试工程师电话不能为空！");
	      	  return;
	        }
	        var regx_phone = /^1[34578]\d{9}$/;
	  	  if(!(regx_phone.test(that.form.plan_te_phone))) {
	  	  		that.$message("测试工程师电话格式不对！");
	  	  		return;
	  	  }
	  	  if(that.form.plan_creater==''){
	  		  that.$message("计划创建人不能为空！");
	      	  return;
	  	  }
	  	  if(that.form.plan_creater_phone==''){
	  		  that.$message("创建人电话电话不能为空！");
	      	  return;
	  	  }
	  	  if(!(regx_phone.test(that.form.plan_creater_phone))) {
	  	  		that.$message("创建人电话电话格式不对！");
	  	  		return;
	  	  }
	  	  if(that.form.plane_test_start_time==''){
	  		  that.$message("测试开始时间不能为空！");
	  	  	  return;
	  	  }
	  	if(that.form.plane_test_end_time==''){
			  that.$message("测试结束时间不能为空！");
		  	  return;
		  }
	  	  
	  	  that.form.plane_test_station = that.form.plane_test_station.substring(0,that.form.plane_test_station.length-1);
	  	  var changeStartTime=new Date(that.form.plane_test_start_time);
		  var changeEndTime=new Date(that.form.plane_test_end_time);
		  that.form.plane_test_start_time=changeStartTime.getFullYear()+'-'+(changeStartTime.getMonth() + 1)+ '-' + changeStartTime.getDate();
		  that.form.plane_test_end_time=changeEndTime.getFullYear()+'-'+(changeEndTime.getMonth() + 1)+ '-' + changeEndTime.getDate();
		  if(changeStartTime.getMonth()<10){
				that.form.plane_test_start_time=changeStartTime.getFullYear()+'-'+(changeStartTime.getMonth() + 1)+ '-0' + changeStartTime.getDate();
		  }
		  if(changeEndTime.getMonth()<10){
				that.form.plane_test_end_time=changeEndTime.getFullYear()+'-'+(changeEndTime.getMonth() + 1)+ '-0' + changeEndTime.getDate();
		  }
	  	  //修改
	  	$.ajax({
				type:"post",
				url:"/nb/plane/updatePlaneAdmin",
				async:false,
				dataType:'json',
				data:{
					  plan_id:that.form.plan_id,
					  user_id:that.form.user_id,
			    	  plan_test_engineer:that.form.plan_test_engineer,
			    	  plan_te_phone:that.form.plan_te_phone,
			    	  plan_creater:that.form.plan_creater,
			    	  plan_creater_phone:that.form.plan_creater_phone,
			    	  plane_test_station:that.form.plane_test_station,
			    	  plane_test_start_time:that.form.plane_test_start_time,
			    	  plane_test_end_time:that.form.plane_test_end_time,
			    	  plane_test_station:form.plane_test_stationIdList
			    	  
				},
				success:function(res){
					//console.log(res)
					if(res.code==1){
						that.$message("修改成功");
						that.refresh();
						that.dialogFormVisible2=false;
					  	  return;
					}
				},
				error:function(e){
					alert("加载失败！");
				}
			});
	    },
	    del:function(row){
	    	var that = this;
	    	$.ajax({
				type:"post",
				url:"/nb/plane/deletePlane",
				async:false,
				dataType:'json',
				data:{
					  plan_id:row.plan_id
				},
				success:function(res){
					//console.log(res)
					if(res.code==1){
						that.$message("删除成功！");
						that.refresh();
					  	return;
					}
				},
				error:function(e){
					alert("加载失败！");
				}
			});
	    }
	  },
	  mounted: function () {
		  this.refresh();
	  }
});