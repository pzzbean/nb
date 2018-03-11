
new Vue({
  el: '#app',
  data: {
	  
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
	  handleOpen:function() {
		  
	  },
	  
	  /*
	   * 点击关闭工参导航
	   */
	  handleClose:function() {
		  
	  },
	  
  },
  mounted: function () {
	  
  }
});