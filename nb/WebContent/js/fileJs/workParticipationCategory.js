
new Vue({
  el: '#app',
  data: {
	  lableName:'1',
      input: '',
      dialogFormVisible:false,
      // 表格中数据
      tableDataWorkParam:[],
      tableDataWorkParam_in:[],
      //查询
      searchPWorkParam_in:false,
      searchPWorkParam:false,
      
      closeArrWorkParam_in:[false,false,false,true],
      closeArrWorkParam:[false,false,false,true],
      
      wp_station_noWorkParam:'',
      wp_cell_sectionWorkParam:'',
      
      wp_station_noWorkParam_in:'',
      wp_cell_sectionWorkParam_in:'',
      // 分页 当前页
      totalRowsWorkParam:0,//总条数，后台传过来的
      pageSizeWorkParam:10,//每页显示的条数      
      currentPageWorkParam:1,// 分页 当前页
      
      totalRowsWorkParam_in:0,//总条数，后台传过来的
      pageSizeWorkParam_in:10,//每页显示的条数      
      currentPageWorkParam_in:1,// 分页 当前页
      
      form : {
     	 wp_station_no : "",
     	 wp_station_height : "",
     	 wp_station_longitude : "",
     	 wp_station_latitude : "",
     	 wp_station_TAC : "",
     	 wp_station_ENBID : "",
     	 wp_cell_section : "",
     	 wp_cell_ECI : "",
     	 wp_cell_PCI : "",
     	 wp_cell_workModel : "",
     	 wp_cell_bearing : "",
     	 wp_cell_dipAangle : "",
     	 wp_cell_top_frequency : "",
     	 wp_cell_top_bandwidth : "",
     	 wp_cell_down_frequency : "",
     	 wp_cell_down_bandwidth : ""
      }
  },
  methods: {
	  /*
	   * 退出，返回到登录页
	   */
	  logOut:function(){
		  window.parent.location.href = "http://localhost:8080/nb/login.html"
	  },
	  
	  /*
	   * 点击展开工参导航
	   */
	  handleOpen:function(key, keyPath) {
		  console.log(key, keyPath);
	  },
	  
	  /*
	   * 点击关闭工参导航
	   */
	  handleClose:function(key, keyPath) {
		  console.log(key, keyPath);
	  },
	  
	  showModule:function() {
		  
	  },
	  
	  handleClick: function(tab, event) {
	        console.log(tab);
	  },
	  exportFn:function(a){
		  window.open('/nb/workParam_in/createExcelWorkParam_in?wp_station_no='+this.tableDataWorkParam_in[a.$index].wp_station_no+"&wp_cell_section="+this.tableDataWorkParam_in[a.$index].wp_cell_section);
	  },
	  ajaxFileUpload:function() {
		  var that = this;
		  if($('#upspan').html().indexOf(".xls")<=0||$('#upspan').html().indexOf(".xlsx")>0){
			  that.$message("请选择xls格式的文件！");
			  return;
		  }
          $.ajaxFileUpload({
                  url: '/nb/workParam/addWorkParamExcel', 
                  fileElementId: 'upfile', 
                  dataType: 'JSON',
                  success: function (data, status){
                	  data = eval("("+data+")");
                	  if(data.code==1){
                		  that.$message("导入成功！");
                		  that.refreshWorkParam(1);
                	  }else{
                		  that.$message("导入失败！");
                	  }
                  },
                  error: function (data, status, e){
                	  that.$message("加载异常！");
                  }
              });
          //return false;
      },
	inputChangeWorkParam_in:function (a){
		
		if(a == 0){
			
			if(this.wp_station_noWorkParam_in != ''){
				this.closeArrWorkParam_in[0] = true;
			}else{
				this.closeArrWorkParam_in[0] = false;
			}
			
		}else if(a == 1){
			
			if(this.wp_cell_sectionWorkParam_in != ''){
				this.closeArrWorkParam_in[1] = true;
			}else{
				this.closeArrWorkParam_in[1] = false;
			}
			
		}
	},
	inputChangeWorkParam:function (a){
		if(a == 0){
			
			if(this.wp_station_noWorkParam != ''){
				this.closeArrWorkParam[0] = true;
			}else{
				this.closeArrWorkParam[0] = false;
			}
			
		}else if(a == 1){
			
			if(this.wp_cell_sectionWorkParam != ''){
				this.closeArrWorkParam[1] = true;
			}else{
				this.closeArrWorkParam[1] = false;
			}
			
		}
	}, 
	closeBtnWorkParam_in:function (a) {
		if(a == 0){
			this.wp_station_noWorkParam_in = '';
			this.closeArrWorkParam_in[0]=false;
		}else if(a == 1){
			this.wp_cell_sectionWorkParam_in = '';
			this.closeArrWorkParam_in[1]=false;
		}
	}, 
	closeBtnWorkParam:function (a) {
		if(a == 0){
			this.wp_station_noWorkParam = '';
			this.closeArrWorkParam[0]=false;
		}else if(a == 1){
			this.wp_cell_sectionWorkParam = '';
			this.closeArrWorkParam[1]=false;
		}
	}, 
	//加载
	   refreshWorkParam_in:function(currentPage){
			var that=this;
			$.ajax({
	  			type:"post",
	  			url:"/nb/workParam_in/listWorkParam_in",
	  			async:false,
	  			dataType:'json',
	  			data:{'page.pageSize':that.pageSizeWorkParam_in,'page.currentPage':currentPage,
	  				wp_station_no:that.wp_station_noWorkParam_in,
	  				wp_cell_section:that.wp_cell_sectionWorkParam_in
	  				  },
	  			success:function(res){
	  				if(res.code==1){
					   for(var i=0;i<res.listObject.length;i++){
							var workParam_in = res.listObject[i];
							if(workParam_in.status==1){
								res.listObject[i].statusStr='一置'; 
							}else if(workParam_in.status==-1){
								res.listObject[i].statusStr='不一置';
					        }
					   }
	  					that.tableDataWorkParam_in=res.listObject;
	  					that.totalRowsWorkParam_in=res.page.totalRows;
	  					
	  					//没跳页
	  					if(that.currentPageWorkParam_in==res.page.currentPage){
	  						that.searchPWorkParam_in=false;
	  					}
	  					that.currentPageWorkParam_in=res.page.currentPage;
	  				  }
	  			},
	  			error:function(e){
	  				alert("加载失败！");
	  			}
	  		});
		},
		refreshWorkParam:function(currentPage){
			var that=this;
			$.ajax({
	  			type:"post",
	  			url:"/nb/workParam/listWorkParam",
	  			async:false,
	  			dataType:'json',
	  			data:{'page.pageSize':that.pageSizeWorkParam,'page.currentPage':currentPage,
	  				wp_station_no:that.wp_station_noWorkParam,
	  				wp_cell_section:that.wp_cell_sectionWorkParam
	  				  },
	  			success:function(res){
	  				console.log(res);
	  				if(res.code==1){
	  					that.tableDataWorkParam=res.listObject;
	  					that.totalRowsWorkParam=res.page.totalRows;
	  					//没跳页
	  					if(that.currentPageWorkParam==res.page.currentPage){
	  						that.searchPWorkParam=false;
	  					}
	  					that.currentPageWorkParam=res.page.currentPage;
	  			   }
	  			},
	  			error:function(e){
	  				alert("加载失败！");
	  			}
	  		});
		},
	//查询
	searchWorkParam_in:function(){
		var that=this;
    	that.searchPWorkParam_in=true;    	
    	that.refreshWorkParam_in(1);
	},
	searchWorkParam:function(){
		var that=this;
    	that.searchPWorkParam=true;    	
    	that.refreshWorkParam(1);
	},
    // 分页
    handleSizeChangeWorkParam_in:function(val) {
    },
    handleCurrentChangeWorkParam_in:function(currentPage) {
    	var that=this;
    	//查询跳页判断
    	if(that.searchPWorkParam_in){
    		that.searchPWorkParam_in=false;//默认为跳页，如果没跳页则在refreshWorkParam_in里判断
    		return;
    	}
    	that.refreshWorkParam_in(currentPage);
    },
    handleSizeChangeWorkParam:function(val) {
    },
    handleCurrentChangeWorkParam:function(currentPage) {
    	var that=this;
    	//查询跳页判断
    	if(that.searchPWorkParam){
    		that.searchPWorkParam=false;//默认为跳页，如果没跳页则在refreshWorkParam里判断
    		return;
    	}
    	that.refreshWorkParam(currentPage);
    },
   //查看详情
   detail:function(row){
	   var that = this;
	   
	   that.form.wp_station_no = row.wp_station_no;
	   that.form.wp_station_height = row.wp_station_height;
	   that.form.wp_station_longitude = row.wp_station_longitude;
	   that.form.wp_station_latitude = row.wp_station_latitude;
	   that.form.wp_station_TAC = row.wp_station_TAC;
	   that.form.wp_station_ENBID = row.wp_station_ENBID;
	   that.form.wp_cell_section = row.wp_cell_section;
	   that.form.wp_cell_ECI = row.wp_cell_ECI;
	   that.form.wp_cell_PCI = row.wp_cell_PCI;
	   that.form.wp_cell_workModel = row.wp_cell_workModel;
	   that.form.wp_cell_bearing = row.wp_cell_bearing;
	   that.form.wp_cell_dipAangle = row.wp_cell_dipAangle;
	   that.form.wp_cell_top_frequency = row.wp_cell_top_frequency;
	   that.form.wp_cell_top_bandwidth = row.wp_cell_top_bandwidth;
	   that.form.wp_cell_down_frequency = row.wp_cell_down_frequency;
	   that.form.wp_cell_down_bandwidth = row.wp_cell_down_bandwidth;
   	   
       that.dialogFormVisible=true;
   }
  },
  mounted: function () {
	  this.refreshWorkParam_in(1);
	  this.refreshWorkParam(1);
  }
});