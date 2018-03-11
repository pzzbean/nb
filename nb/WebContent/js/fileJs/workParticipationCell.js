
new Vue({
  el: '#app',
  data: {
	  lableName: '1',
      input: '',
      dialogFormVisible: false,
      dialogFormVisible1: false,
      // 表格中数据
      tableDataWorkParam: [],
      //查询
      searchPWorkParam: false,
      
      closeArrWorkParam: [false,false,false,false,true],
      
      wp_cell_idParam: '',
      wp_cell_nameParam: '',
      wp_cell_belongToStationParma: '',
      // 分页 当前页
      totalRowsWorkParam:0,//总条数，后台传过来的
      pageSizeWorkParam:10,//每页显示的条数      
      currentPageWorkParam:1,// 分页 当前页
      
      //表单中的内容
      form : {
    	  wp_cell_id : "",
    	  wp_cell_name : "",
    	  wp_cell_belongToStation : "",
    	  wp_cell_includeCategory : "",
    	  wp_cell_frequency : "",
    	  wp_cell_pci : "",
    	  wp_cell_rsPower : "",
    	  wp_cell_antennaHeight : "",
    	  wp_cell_azimuth : "",
    	  wp_cell_totalDipAngle : "",
    	  wp_cell_prefabricatedDipAngle : "",
    	  wp_cell_mechanicalDipAngle : "",
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
	  
	  /*
	   * 切换tab页
	   */
	  handleClick: function(tab, event) {
		  
	  },
	  
	  
	  /*
	   * 上传文件
	   */
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
      
	  
	  /*
	   * 输入内容时显示关闭按钮
	   */
	  inputChangeWorkParam:function (a){
			if(a == 0){
				if(this.wp_cell_idParam != ''){
					this.closeArrWorkParam[0] = true;
				}else{
					this.closeArrWorkParam[0] = false;
				}
			}else if(a == 1){
				if(this.wp_cell_nameParam != ''){
					this.closeArrWorkParam[1] = true;
				}else{
					this.closeArrWorkParam[1] = false;
				}
			}else if(a == 2){
				if(this.wp_cell_belongToStationParma != ''){
					this.closeArrWorkParam[2] = true;
				}else{
					this.closeArrWorkParam[2] = false;
				}
			}
		}, 
	  
	  /*
	   * 清空内容隐藏关闭按钮
	   */
	  closeBtnWorkParam:function (a) {
		  if(a == 0){
			  this.wp_cell_idParam = '';
			  this.closeArrWorkParam[0]=false;
		  }else if(a == 1){
			  this.wp_cell_nameParam = '';
			  this.closeArrWorkParam[1]=false;
		  }else if(a == 2){
			  this.wp_cell_belongToStationParma = '';
			  this.closeArrWorkParam[2]=false;
		  }
		  
	  }, 
	  
	  /*
	   * 查询
	   */
	  searchWorkParam:function(){
		  var that=this;
	      that.searchPWorkParam=true;    	
	      that.refreshWorkParam(1);
	  },
		
	  /*
	  * 加载
	  */
		refreshWorkParam:function(currentPage){
			var that=this;
			$.ajax({
	  			type:"post",
	  			url:"/nb/workParam/listWorkParam",
	  			async:false,
	  			dataType:'json',
	  			data:{'page.pageSize':that.pageSizeWorkParam,'page.currentPage':currentPage,
	  				wp_cell_id:that.wp_cell_idParam,
	  				wp_cell_name:that.wp_cell_nameParam,
	  				wp_cell_belongToStation:that.wp_cell_belongToStationParma
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
		
		/*
		 * 导出表格中的数据
		 */
		exportFn:function(a){
			window.open(
					'/nb/workParam/createExcelWorkParam?wp_station_no='+this.tableDataWorkParam[a.$index].wp_station_nodeBid
					+"&wp_station_name="+this.tableDataWorkParam[a.$index].wp_station_name
				    +"&wp_station_height="+this.tableDataWorkParam[a.$index].wp_station_height
					+"&wp_station_longitude="+this.tableDataWorkParam[a.$index].wp_station_longitude
					+"&wp_station_latitude="+this.tableDataWorkParam[a.$index].wp_station_latitude
					+"&wp_station_tac="+this.tableDataWorkParam[a.$index].wp_station_tac
					+"&wp_station_workModel="+this.tableDataWorkParam[a.$index].wp_station_workModel
					);
		  },
		  
		/*
	     * 查看详情
	     */
	    detail:function(row){
		    var that = this;
		    that.dialogFormVisible=true;
		    that.form.wp_station_nodeBid = row.wp_station_nodeBid;
		    that.form.wp_station_name = row.wp_station_name;
		    that.form.wp_station_height = row.wp_station_height;
		    that.form.wp_station_longitude = row.wp_station_longitude;
		    that.form.wp_station_latitude = row.wp_station_latitude;
		    that.form.wp_station_tac = row.wp_station_tac;
		    that.form.wp_station_workModel = row.wp_station_workModel;
	    },
		
	   /*
	    * 修改
	    */ 
	    changeCell:function(row) {
	    	this.dialogFormVisible1 = true;
	    },
	    
	    /*
	     * 取消修改
	     */
	    changeCancel:function() {
	    	this.dialogFormVisible1 = false;
	    },
	    
	    /*
	     * 确定保存修改
	     */
	    changeSave:function() {
	    	this.dialogFormVisible1 = false;
	    },
	    
	   /*
	    * 删除
	    */
	    delCell:function(row) {
	    	
		},  
	    
      /*
       * 分页
       */
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
     
  },
  mounted: function () {
	  this.refreshWorkParam(1);
  }
});