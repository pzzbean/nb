
new Vue({
  el: '#app',
  data: {
      input: '',
      // 表格中数据
      tableData: [],
      //查询
      serach:false,
      closeArr:[false,false,false,true],
      station_no:'',
      cell_section:'',
      // 分页 当前页
      totalRows:0,//总条数，后台传过来的
      pageSize:10,//每页显示的条数      
      currentPage:1,// 分页 当前页
      
      dialogFormVisible:false,//详情弹出框
      
      form:{
    	  station_no:'',
    	  cell_section:'',
    	  log_RSRP:'',
    	  log_SINR:'',
    	  log_top_rate:'',
    	  log_down_rate:'',
    	  log_delayTime:'',
    	  log_ReselectDelay:'',
    	  log_AttachDelay:'',
    	  log_openRate:'',
    	  log_create_time:'',
    	  log_desc:'',
    	  
          statusStr:''
      }
    
  },
  methods: {
	  logOut:function(){
		  window.parent.location.href = "http://localhost:8080/nb/login.html"
	  },
	  
	  inputChange:function (a){
			if(a == 0){
				//console.log(this.user_name)
				if(this.station_no != ''){
					this.closeArr[0] = true;
				}else{
					this.closeArr[0] = false;
				}
			}else if(a == 1){
				if(this.cell_section != ''){
					this.closeArr[1] = true;
				}else{
					this.closeArr[1] = false;
				}
			}
		},  
		closeBtn:function (a) {
			if(a == 0){
				this.station_no = '';
				this.closeArr[0]=false;
			}else if(a == 1){
				this.cell_section = '';
				this.closeArr[1]=false;
			}
		},
		//刷新
	   refresh:function(){
			var that=this;
			  $.ajax({
					type:"post",
					url:"/nb/log/listLog",
					async:false,
					dataType:'json',
					data:{'page.pageSize':that.pageSize,'page.currentPage':1},
					success:function(res){
						//console.log(res)
						if(res.code==1){
							for(var i=0;i<res.listObject.length;i++){
								var log = res.listObject[i];
								if(log.status==1){
									res.listObject[i].statusStr='达标';
								}else if(log.status==-1){
									res.listObject[i].statusStr='不达标';
								}
							}
							
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
	//查询
	search:function(){
		var that=this;
    	that.serach=true;    	
    	
    	$.ajax({
	  			type:"post",
	  			url:"/nb/log/listLog",
	  			async:false,
	  			dataType:'json',
	  			data:{'page.pageSize':that.pageSize,'page.currentPage':1,
	  				station_no:that.station_no,
	  				cell_section:that.cell_section
	  				  },
	  			success:function(res){
	  				//console.log(res)
	  				if(res.code==1){
					   for(var i=0;i<res.listObject.length;i++){
							var log = res.listObject[i];
							if(log.status==1){
								res.listObject[i].statusStr='达标';
							}else if(log.status==-1){
								res.listObject[i].statusStr='不达标达标';
					   }
	  					that.tableData=res.listObject;
	  					that.totalRows=res.page.totalRows;
	  					//没跳页
	  					if(that.currentPage==res.page.currentPage){
	  						that.serach=false;
	  					}
	  					that.currentPage=res.page.currentPage;
	  					
	  				  }
	  			   }
	  			},
	  			error:function(e){
	  				alert("加载失败！");
	  			}
	  		});
	},
    // 分页
    handleSizeChange:function(val) {
      //console.log(`每页 ${val} 条`);
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
	  			url:"/nb/log/listLog",
	  			async:false,
	  			dataType:'json',
	  			data:{'page.pageSize':that.pageSize,'page.currentPage':currentPage,
	  				station_no:that.station_no,
	  				cell_section:that.cell_section
	  			},
	  			success:function(res){
	  				//console.log(res)
	  				if(res.code==1){
						for(var i=0;i<res.listObject.length;i++){
							var log = res.listObject[i];
							if(log.status==1){
								res.listObject[i].statusStr='达标';
							}else if(log.status==-1){
								res.listObject[i].statusStr='不达标达标';
							}
						}
						
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
    //查看详情
    detail:function(row){
    	var that = this;
    	that.form.station_no = row.station_no;
    	that.form.cell_section = row.cell_section;
    	that.form.log_RSRP = row.log_RSRP;
    	that.form.log_SINR = row.log_SINR;
    	that.form.log_top_rate = row.log_top_rate;
    	that.form.log_down_rate = row.log_down_rate;
    	that.form.log_delayTime = row.log_delayTime,
    	that.form.log_openRate = row.log_openRate;
    	that.form.statusStr = row.statusStr;
    	that.form.log_create_time = row.log_create_time;
    	that.form.log_desc = row.log_desc;
    	that.form.log_AttachDelay = row.log_AttachDelay;
    	that.form.log_ReselectDelay = row.log_ReselectDelay;
    	that.dialogFormVisible=true;
    },
    //详情取消
    detailCancel:function(){
    	this.dialogFormVisible=false;
    }
  },
  mounted: function () {
	  this.refresh();
  }
});