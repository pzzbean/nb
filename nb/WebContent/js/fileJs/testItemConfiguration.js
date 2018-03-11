
new Vue({
    el: '#app',
    data:{
    	btnShow: "",
    	btn_datas:[],
    	all_btn_datas: [],
    	btn_tic_tarfet:[],
    	testItemName: '',
    	flag: false,
		//分页 当前页
		totalRows:0,//总条数，后台传过来的
		pageSize:10,//每页显示的条数      
		currentPage:1,// 分页 当前页
		serach:false,
		form: {
			  indexId: 0,
			  conllections: [],
			  testItemName: '',
			  targetName: '',
			  collocationId: '',
			  targetValue: '',
	          delivery: false,
	          desc: '',
	        },
	    formLabelWidth: '120px',
        targetFormVisible:false, //指标弹出框不可见
        addTestItemFormVisible:false,//添加指标弹出框不可见
        addTargetVisible: false,//指标配置弹出框不可见
        tic_input: '',
        title: '',
        targetParm: [], //未配置的参数列表
        conllectionsParm: [],//后台传过来的配置参数
        updateConllectionValue: [],//更新后传给后台的配置参数
        collocationValue:'',
        collocationId: '',
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
		var that = this;
		    $.ajax({
				type:"post",
				url:"/nb/index/queryIndexes",
				async:false,
				dataType:'json',
				data:{'page.pageSize':that.pageSize,'page.currentPage':1},
				success:function(res){
					that.all_btn_datas = res.listObject;
					that.btn_datas = that.all_btn_datas
					that.totalRows = res.page.totalRows;
					that.currentPage = res.page.currentPage;
				},
				error:function(e){
					alert("加载失败！");
				}
			});
	    },
	    
	    //指标配置弹出框
	    tic_target:function(testItemName,testItemId){
	    	var that=this;
	    	that.targetFormVisible = true;
	    	that.title = testItemName;
	    	that.form.indexId = testItemId;
	    	$.ajax({
				type:"get",
				url:"/nb/indexAndCollocation/queryCollocationsById",
				async:false,
				dataType:'json',
				data:{'indexId':testItemId},
				success:function(res){
					console.log(res);
					that.conllectionsParm = res;
					that.form.conllections = that.conllectionsParm;
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
		  			url:"/nb/index/queryIndexes",
		  			async:false,
		  			dataType:'json',
		  			data:{'page.pageSize':that.pageSize,'page.currentPage':currentPage},
		  			success:function(res){
		  				//console.log(res.listObject);
		  				that.btn_datas=res.listObject;
						that.totalRows=res.page.totalRows;
						that.currentPage=res.page.currentPage;
		  			},
		  			error:function(e){
		  				alert("加载失败！");
		  			}
		  		});
	    },
	    
	    //查询指标
	    searchTestItem:function(testItemName) {
	    	if(testItemName == ""){
	    		that.btn_datas = that.all_btn_datas;
	    	}
	    	var that=this;
	    	$.ajax({
	  			type:"post",
	  			url:"/nb/index/queryIndexes",
	  			async:false,
	  			dataType:'json',
	  			data:{'indexName':testItemName},
	  			success:function(res){
	  				that.btn_datas=res.listObject;
					that.totalRows=res.page.totalRows;
					that.currentPage=res.page.currentPage;
	  			},
	  			error:function(e){
	  				alert("加载失败！");
	  			}
	  		});
	    },
	    
	    change: function(value){
	    	var that = this;
	    	if(value == ""){
	    		that.btn_datas = that.all_btn_datas;
	    		that.handleCurrentChange(that.currentPage);
	    	}
	    },
	    
	    //添加指标
	    addTestItem:function() {
	    	var that = this;
	    	that.addTestItemFormVisible = true;
	    },
	    
	    //保存指标
	    saveTestItem: function(testItemName){
	    	var that = this;
	    	if(testItemName == ""){
	    		alert("请输入指标名称!");
	    		return;
	    	}
	    	$.ajax({
	  			type: "post",
	  			url: "/nb/index/insertIndex",
	  			async: false,
	  			dataType: 'json',
	  			data:{'indexName':testItemName},
	  			success: function(res){
	  				console.log(res);
	  				if(res.code == 1){
	  					alert('添加指标成功!');
	  					that.handleCurrentChange(that.currentPage);
	  				}
	  			},
	  			error:function(e){
	  				alert("添加指标失败！");
	  			}
	  		});
	    	that.form.testItemName = ''; 
	    	that.addTestItemFormVisible = false;
	    },
	    
	    
	    //取消指标保存
	    cancelTestItem: function(){
	    	var that = this;
	    	that.form.testItemName = ''; 
	    	that.addTestItemFormVisible = false;
	    },
	    
	    //删除指标
	    deleteTestItem: function(testItemId){
	    	var that = this;
	    	if(testItemId == ""){
	    		alert("删除指标失败！");
	    		return;
	    	}
	    	if(confirm("你确定要删除这个指标吗?") == true){
	    		$.ajax({
		  			type: "post",
		  			url: "/nb/index/deleteIndex",
		  			async: false,
		  			dataType: 'json',
		    	  	data:{'indexId':testItemId},
		  			success: function(res){
		  				if(res.code == 1){
		  					alert("指标已删除");
		  				}
		  			},
		  			error:function(e){
		  				alert("删除指标失败！");
		  			}
		  		});
	    	}
	    	that.targetFormVisible = false;
	    	that.handleCurrentChange(that.currentPage);
	    },
	    
	    //添加指标配置
	    addTarget: function(testItemId){
	    	var that = this;
	    	if(testItemId == ""){
	    		alert("添加配置失败！");
	    		return;
	    	}
	    	$.ajax({
	  			type: "post",
	  			url: "/nb/indexAndCollocation/queryNoCollocationsById",
	  			async: false,
	  			dataType: 'json',
	    	  	data:{'indexId':testItemId},
	  			success: function(res){
	  				that.targetParm = res;
	  			},
	  			error:function(e){
	  				alert("添加配置失败！");
	  			}
	  		});
	    	that.addTargetVisible = true;
	    },
	    
	    //保存指标参数
	    saveTargetVisible: function(indexId,collocationId,targetValue){
	    	var that = this;
	    	var name = that.title;
	    	if(indexId == ""||collocationId == ""||targetValue == ""){
	    		alert("加载失败！");
	    		return;
	    	}
	    	$.ajax({
	  			type: "post",
	  			url: "/nb/indexAndCollocation/insertIndexAndCollocation",
	  			async: false,
	  			dataType: 'json',
	    	  	data:{'indexId':indexId,'collocationId':collocationId,'collocationValue':targetValue},
	  			success: function(res){
	  				console.log(res);
	  				that.tic_target(name,indexId)
	  			},
	  			error:function(e){
	  				alert("加载失败！");
	  			}
	  		});
	    	that.form.targetName = '';
	    	that.form.targetValue = '';
	    	that.addTargetVisible = false;
	    },
	  //取消指标参数保存
	    cancelTargetVisible: function(){
	    	var that = this;
	    	that.form.targetName = '';
	    	that.form.targetValue = '';
	    	that.addTargetVisible = false;
	    },
	    
	    //删除指标配置
	    delete_Conllection: function(indexId,collocationId){
	    	var that = this;
	    	var name = that.title;
	    	if(indexId == ""||collocationId == ""){
	    		alert("删除配置失败！");
	    		return;
	    	}
	    	if(confirm("你确定要删除该配置吗?") == true){
	    		$.ajax({
		  			type: "post",
		  			url: "/nb/indexAndCollocation/deleteIndexAndCollocation",
		  			async: false,
		  			dataType: 'json',
		    	  	data:{'indexId':indexId,'collocationId':collocationId},
		  			success: function(res){
		  				alert("该配置已删除!");
		  				that.tic_target(name,indexId)
		  			},
		  			error:function(e){
		  				alert("删除配置失败！");
		  			}
		  		});
	    	}
	    },
	    
	    //更新值
	    updateParm: function(collocationId,collocationValue){
	    	var that=this;
	    	if(collocationValue == ""||collocationId == ""){
	    		alert("数据不能为空!");
	    		flag = true;
	    	}else{
	    		flag = false;
	    	}
	    	that.updateConllectionValue = that.conllectionsParm;
	    	for(var i=0;i<that.updateConllectionValue.length;i++){
	    		if(collocationId == that.updateConllectionValue[i].collocationId){
	    			that.updateConllectionValue[i].collocationValue = collocationValue;
	    		}
	    	};
	    },
	    
	    //保存全部配置
	    savaParm: function(indexId){
	    	var that=this;
	    	var updateConllectionValue = JSON.stringify(that.updateConllectionValue);
	    	if(flag){
	    		alert("配置保存失败!");
	    	}else{
	    		$.ajax({  
		            type: "post",  
		            url:"/nb/indexAndCollocation/updateIndexAndCollocation" ,  
		            async:false,  
		            contentType:"application/x-www-form-urlencoded; charset=utf-8", 
		            traditional:true, 
		            data:{'updateConllectionValue':updateConllectionValue,'indexId':indexId},
		            success:function(res) { 
		                alert("配置保存成功!");
		            },  
		            error:function(){
		            	alert("配置保存失败!");
		            }  
		        }); 
	    		flag = false;
	    	}
	    },
	    
	  },
	  mounted: function () {
		  this.refresh();
	  }
});