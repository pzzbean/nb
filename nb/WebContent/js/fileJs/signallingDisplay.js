
new Vue({
    el: '#app',
    data:{
      
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
	    
	    
	  },
	  mounted: function () {
		  this.refresh();
	  }
});