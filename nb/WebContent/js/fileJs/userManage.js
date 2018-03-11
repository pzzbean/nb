
new Vue({
  el: '#app',
  data: {
      //分页
      totalRows:0,//总条数，后台传过来的
      pageSize:10,//每页显示的条数      
      currentPage: 1,// 分页 当前页
      //查询条件
      serach:false,
      user_name:'',
      user_code:'',
      user_phone: '',
      closeArr:[false,false,false],
      dialogFormVisible: false,
      dialogFormVisible2: false,
      // 表格中数据
      tableData: [],     
      // 新增修改弹出框表单内容
      form: {
    	user_id:'',
    	user_code: '',
    	user_password: '',
    	user_name:'',
    	user_phone: '',
    	status: '2',
    		
    	user_code2:''
      }
  },
  methods: {
	  logOut:function(){
		  window.parent.location.href = "http://localhost:8080/nb/login.html"
	  },
	  
	refresh:function(){
		var that=this;
		  $.ajax({
				type:"post",
				url:"/nb/user/listUser",
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
			console.log(this.user_name);
			if(this.user_code != ''){
				this.closeArr[0] = true;
			}else{
				this.closeArr[0] = false;
			}
		}else if(a == 1){
			if(this.user_name != ''){
				this.closeArr[1] = true;
			}else{
				this.closeArr[1] = false;
			}
		}else if(a == 2){
			if(this.user_phone != ''){
				this.closeArr[2] = true;
			}else{
				this.closeArr[2] = false;
			}
		}
	},  
	closeBtn:function (a) {
		if(a == 0){
			this.user_code = '';
			this.closeArr[0]=false;
		}else if(a == 1){
			this.user_name = '';
			this.closeArr[1]=false;
		}else if(a == 2){
			this.user_phone = '';
			this.closeArr[2]=false;
		}
	},
	//点击查询按钮
	search:function(){
    	var that=this;
    	that.serach=true;    	
    	$.ajax({
	  			type:"post",
	  			url:"/nb/user/listUser",
	  			async:false,
	  			dataType:'json',
	  			data:{'page.pageSize':that.pageSize,'page.currentPage':1,
	  				   user_code:that.user_code,user_name:that.user_name,user_phone:that.user_phone
	  				  },
	  			success:function(res){
	  				console.log(res);
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
    // 点击修改按钮
    change:function(row) {
      //console.log(row);
      this.dialogFormVisible = true;
      this.form.user_id = row.user_id;
      this.form.user_code = row.user_code;
      this.form.user_password = row.user_password;
      this.form.user_name = row.user_name;
      this.form.user_phone = row.user_phone;
      this.form.status = row.status;
      
      this.form.user_code2 = row.user_code;
    },
    changeCancel:function(){
    	this.dialogFormVisible = false;
    },
    
    // 点击修改确定按钮
    changeSave:function(){
    	var that = this;
    	//非空判断
    	if(that.form.user_code==''){
    		that.$message("用户名不能为空！");
    		return;
    	}
    	if(that.form.user_password==''){
    		that.$message("密码不能为空！");
    		return;
    	}
    	if(that.form.user_name==''){
    		that.$message("用户真实姓名不能为空！");
    		return;
    	}
    	if(that.form.user_phone==''){
    		that.$message("用户电话不能为空！");
    		return;
    	}
    	var regx_phone = /^1[34578]\d{9}$/;
    	if (!(regx_phone.test(that.form.user_phone))) {
    		that.$message("请输入正确手机号码!！");
    		return;
    	}
    	if(that.form.status==''){
    		that.$message("角色不能为空！");
    		return;
    	}
    	//alert(that.form.user_code+":"+that.form.user_code2)
    	//修改
    	$.ajax({
  			type:"post",
  			url:"/nb/user/updateUser",
  			async:false,
  			dataType:'json',
  			data:{
  				userId:that.form.user_id,
  				user_code:that.form.user_code,
  				user_password:that.form.user_password,
  				user_name:that.form.user_name,
  				user_phone:that.form.user_phone,
  				status:that.form.status,
  				user_code2:that.form.user_code2
  			},
  			success:function(res){
  				if(res.code==1){
  					that.$message(res.msg);
  					that.refresh(); 
  					that.dialogFormVisible = false;
  					return;
  				}else{
  					that.$message(res.msg);
  				}
  				
  			},
  			error:function(e){
  				alert("加载失败！");
  			}
  		});
    },
    // 点击删除按钮
    del:function(row){
      //console.log(row);
    	var that = this;
    	$.ajax({
  			type:"post",
  			url:"/nb/user/deleteUser",
  			async:false,
  			dataType:'json',
  			data:{
  				userId:row.user_id
  			},
  			success:function(res){
  				if(res.code==1){
  					that.$message(res.msg);
  					that.refresh(); 
  					return;
  				}else{
  					that.$message(res.msg);
  				}
  				
  			},
  			error:function(e){
  				alert("删除失败！");
  			}
  		});
    },
    // 点击新增用户按钮
    add:function(){
      this.dialogFormVisible2 = true;
      this.form.user_id = '';
      this.form.user_code = '';
      this.form.user_password = '';
      this.form.user_name = '';
      this.form.user_phone = '';
      this.form.status = '2';
    },
    
    // 点击新增确定按钮
    addSave:function(){
    	var that = this;
    	
    	//非空判断
    	if(that.form.user_code==''){
    		that.$message("用户名不能为空！");
    		return;
    	}
    	if(that.form.user_password==''){
    		that.$message("密码不能为空！");
    		return;
    	}
    	if(that.form.user_name==''){
    		that.$message("用户真实姓名不能为空！");
    		return;
    	}
    	if(that.form.user_phone==''){
    		that.$message("用户电话不能为空！");
    		return;
    	}
    	var regx_phone = /^1[34578]\d{9}$/;
    	if (!(regx_phone.test(that.form.user_phone))) {
    		that.$message("请输入正确手机号码!！");
    		return;
    	}
    	if(that.form.status==''){
    		that.$message("角色不能为空！");
    		return;
    	}
    	//插入数据
    	$.ajax({
  			type:"post",
  			url:"/nb/user/addUser",
  			async:false,
  			dataType:'json',
  			data:{
  				user_code:that.form.user_code,
  				user_password:that.form.user_password,
  				user_name:that.form.user_name,
  				user_phone:that.form.user_phone,
  				status:that.form.status
  			},
  			success:function(res){
  				if(res.code==1){
  					that.$message(res.msg);
  					that.refresh(); 
  					that.dialogFormVisible2 = false;
  					return;
  				}else{
  					that.$message(res.msg);
  				}
  				
  			},
  			error:function(e){
  				alert("加载失败！");
  			}
  		});
    },
    // 点击新增取消按钮
    addCancel:function(){
      this.dialogFormVisible2 = false;
    },
    // 分页
    handleSizeChange:function(val) {
      
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
	  			url:"/nb/user/listUser",
	  			async:false,
	  			dataType:'json',
	  			data:{'page.pageSize':that.pageSize,'page.currentPage':currentPage,
	  				user_code:that.user_code,user_name:that.user_name,user_phone:that.user_phone
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
  },
  mounted: function () {
	  
	  this.refresh();
  }
});