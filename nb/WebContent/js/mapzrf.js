$(function(){
// ===============map===============
    $(".el-table__row .el-table_1_column_4 .el-button").click(function(){
        $(".MapBigBox").css("display","block");
        var index=$(this).index(".el-table__row .el-table_1_column_4 .el-button");
        var station_No=$(".el-table__row .el-table_1_column_1 .cell").eq(index).text();
        var roadTestDate=$(".el-table__row .el-table_1_column_3 .cell").eq(index).text();
        mappp(station_No,roadTestDate);

    });
    function mappp(station_No,roadTestDate){
        // 获取打点数据：
    	
            var url="http://localhost:8080/nb/roadTest/selectCellRoadTest?station_No="+station_No+"&roadTestDate="+roadTestDate;
            //rsrp打点：
            RsrpMap();
            function RsrpMap() {
            	
                $.ajax({ type: "POST",
                    dataType: "json",
                    async:false,
                    url: url,
                    context: document.body, success: function(data){
                    var mapdate=data.listObject;
                    var length=mapdate.length;
                    if(length==0){
                    	 var map = new BMap.Map("container");
                         var point = new BMap.Point(121.4921, 30.83355);
                         map.centerAndZoom(point,10);
                         map.enableScrollWheelZoom();
                    }else{
                    	// 创建地图实例
                        var lon=mapdate[6].longitude-0.0001;
                        var lat=mapdate[6].latitude-0.0007;
                        alert(lon);
                        var map = new BMap.Map("container");
                        var point = new BMap.Point(lon, lat);
                        map.centerAndZoom(point,20);
                        map.enableScrollWheelZoom();
                    }
                    
                    //海量打点：
                    RsrpData();
                    function RsrpData(){}{
                        map.clearOverlays();
                        if (document.createElement('canvas').getContext) {  // 判断当前浏览器是否支持绘制海量点
                            var points1 = [];  // 添加海量点数据
                            var points2 = [];  // 添加海量点数据
                            var points3 = [];  // 添加海量点数据
                            var points4 = [];  // 添加海量点数据
                            var points5 = [];  // 添加海量点数据
                            var points6 = [];  // 添加海量点数据
                            for (var i = 0; i < mapdate.length; i++) {
                                if(mapdate[i].rsrp < -110 && mapdate[i].rsrp >= -140){
                                    points1.push(new BMap.Point(mapdate[i].longitude, mapdate[i].latitude));
                                } else if(mapdate[i].rsrp >= -110 && mapdate[i].rsrp < -100 ){
                                    points2.push(new BMap.Point(mapdate[i].longitude, mapdate[i].latitude));
                                } else if(mapdate[i].rsrp >= -100 && mapdate[i].rsrp < -90 ){
                                    points3.push(new BMap.Point(mapdate[i].longitude, mapdate[i].latitude));
                                } else if(mapdate[i].rsrp >= -90 && mapdate[i].rsrp < -80 ){
                                    points4.push(new BMap.Point(mapdate[i].longitude, mapdate[i].latitude));
                                } else if(mapdate[i].rsrp >= -80 && mapdate[i].rsrp < -70 ){
                                    points5.push(new BMap.Point(mapdate[i].longitude, mapdate[i].latitude));
                                } else if(mapdate[i].rsrp >= -70 && mapdate[i].rsrp <= 30 ){
                                    points6.push(new BMap.Point(mapdate[i].longitude, mapdate[i].latitude));
                                }
                            }
                            //第一组：
                            var options1 = {
                                size:BMAP_POINT_SIZE_SMALL,
                                shape:0,
                                color: '#dd3b22'
                            }
                            var pointCollection1 = new BMap.PointCollection(points1, options1);  // 初始化PointCollection
                            map.addOverlay(pointCollection1);  // 添加Overlay
                            // 第二组：
                            var options2 = {
                                size:BMAP_POINT_SIZE_SMALL,
                                shape:0,
                                color: '#f7c045'
                            }
                            var pointCollection2 = new BMap.PointCollection(points2, options2);  // 初始化PointCollection
                            map.addOverlay(pointCollection2);  // 添加Overlay
                            // 第三组：
                            var options3 = {
                                size:BMAP_POINT_SIZE_SMALL,
                                shape:0,
                                color: '#fffd48'
                            }
                            var pointCollection3 = new BMap.PointCollection(points3, options3);  // 初始化PointCollection
                            map.addOverlay(pointCollection3);  // 添加Overlay
                            // 第四组：
                            var options4 = {
                                size:BMAP_POINT_SIZE_SMALL,
                                shape:0,
                                color: '#9fce5d'
                            }
                            var pointCollection4 = new BMap.PointCollection(points4, options4);  // 初始化PointCollection
                            map.addOverlay(pointCollection4);  // 添加Overlay
                            // 第五组：
                            var options5 = {
                                size:BMAP_POINT_SIZE_SMALL,
                                shape:0,
                                color: '#57a95c'
                            }
                            var pointCollection5 = new BMap.PointCollection(points5, options5);  // 初始化PointCollection
                            map.addOverlay(pointCollection5);  // 添加Overlay
                            // 第六组：

                            var options6 = {
                                size:BMAP_POINT_SIZE_SMALL,
                                shape:0,
                                color: '#0d47ff'
                            }
                            var pointCollection6 = new BMap.PointCollection(points6, options6);  // 初始化PointCollection
                            map.addOverlay(pointCollection6);  // 添加Overlay
                        } else {
                            alert('请在chrome、safari、IE8+以上浏览器查看本示例');
                        }
                    }
                }});
            }
        //sinr打点：
            function SinrMap() {
                $.ajax({  type: "POST",
                    dataType: "json",
                    async:false,
                    url: url,
                    context: document.body, success: function(data){
                    var mapdate=data.listObject;
                    // 创建地图实例
                    if(length==0){
                   	 var map = new BMap.Map("container");
                        var point = new BMap.Point(121.4921, 30.83355);
                        map.centerAndZoom(point,10);
                        map.enableScrollWheelZoom();
                   }else{
                   	// 创建地图实例
                       var lon=mapdate[6].longitude-0.0001;
                       var lat=mapdate[6].latitude-0.0007;
                       alert(lon);
                       var map = new BMap.Map("container");
                       var point = new BMap.Point(lon, lat);
                       map.centerAndZoom(point,20);
                       map.enableScrollWheelZoom();
                   }
                    //海量打点：
                    SinrData();
                    function SinrData(){}{
                        map.clearOverlays();
                        if (document.createElement('canvas').getContext) {  // 判断当前浏览器是否支持绘制海量点
                            var points1 = [];  // 添加海量点数据
                            var points2 = [];  // 添加海量点数据
                            var points3 = [];  // 添加海量点数据
                            var points4 = [];  // 添加海量点数据
                            var points5 = [];  // 添加海量点数据
                            var points6 = [];  // 添加海量点数据
                            for (var i = 0; i < mapdate.length; i++) {
                                if(mapdate[i].sinr < 0 && mapdate[i].sinr >= -15){
                                    points1.push(new BMap.Point(mapdate[i].longitude, mapdate[i].latitude));
                                } else if(mapdate[i].sinr < 5 && mapdate[i].sinr >= 0 ){
                                    points2.push(new BMap.Point(mapdate[i].longitude, mapdate[i].latitude));
                                } else if(mapdate[i].sinr < 10 && mapdate[i].sinr >= 5){
                                    points3.push(new BMap.Point(mapdate[i].longitude, mapdate[i].latitude));
                                } else if(mapdate[i].sinr < 15 && mapdate[i].sinr >= 10 ){
                                    points4.push(new BMap.Point(mapdate[i].longitude, mapdate[i].latitude));
                                } else if(mapdate[i].sinr < 20 && mapdate[i].sinr >= 15 ){
                                    points5.push(new BMap.Point(mapdate[i].longitude, mapdate[i].latitude));
                                } else if(mapdate[i].sinr < 30 && mapdate[i].sinr >= 20 ){
                                    points6.push(new BMap.Point(mapdate[i].longitude, mapdate[i].latitude));
                                }
                            }
                            //第一组：
                            var options1 = {
                                size:BMAP_POINT_SIZE_SMALL,
                                shape:0,
                                color: '#dd3b22'
                            }
                            var pointCollection1 = new BMap.PointCollection(points1, options1);  // 初始化PointCollection
                            map.addOverlay(pointCollection1);  // 添加Overlay
                            // 第二组：
                            var options2 = {
                                size:BMAP_POINT_SIZE_SMALL,
                                shape:0,
                                color: '#f7c045'
                            }
                            var pointCollection2 = new BMap.PointCollection(points2, options2);  // 初始化PointCollection
                            map.addOverlay(pointCollection2);  // 添加Overlay
                            // 第三组：
                            var options3 = {
                                size:BMAP_POINT_SIZE_SMALL,
                                shape:0,
                                color: '#fffd48'
                            }
                            var pointCollection3 = new BMap.PointCollection(points3, options3);  // 初始化PointCollection
                            map.addOverlay(pointCollection3);  // 添加Overlay
                            // 第四组：
                            var options4 = {
                                size:BMAP_POINT_SIZE_SMALL,
                                shape:0,
                                color: '#9fce5d'
                            }
                            var pointCollection4 = new BMap.PointCollection(points4, options4);  // 初始化PointCollection
                            map.addOverlay(pointCollection4);  // 添加Overlay
                            // 第五组：
                            var options5 = {
                                size:BMAP_POINT_SIZE_SMALL,
                                shape:0,
                                color: '#57a95c'
                            }
                            var pointCollection5 = new BMap.PointCollection(points5, options5);  // 初始化PointCollection
                            map.addOverlay(pointCollection5);  // 添加Overlay
                            // 第六组：

                            var options6 = {
                                size:BMAP_POINT_SIZE_SMALL,
                                shape:0,
                                color: '#0d47ff'
                            }
                            var pointCollection6 = new BMap.PointCollection(points6, options6);  // 初始化PointCollection
                            map.addOverlay(pointCollection6);  // 添加Overlay
                        } else {
                            alert('请在chrome、safari、IE8+以上浏览器查看本示例');
                        }
                    }
                }});
            }
        //pci打点：
            function PciMap() {
                $.ajax({  type: "POST",
                    dataType: "json",
                    async:false,
                    url: url,
                    context: document.body, success: function(data){
                    var mapdate=data.listObject;
                    // 创建地图实例
                    if(length==0){
                   	 var map = new BMap.Map("container");
                        var point = new BMap.Point(121.4921, 30.83355);
                        map.centerAndZoom(point,10);
                        map.enableScrollWheelZoom();
                   }else{
                   	// 创建地图实例
                       var lon=mapdate[6].longitude-0.0001;
                       var lat=mapdate[6].latitude-0.0007;
                       alert(lon);
                       var map = new BMap.Map("container");
                       var point = new BMap.Point(lon, lat);
                       map.centerAndZoom(point,20);
                       map.enableScrollWheelZoom();
                   }
                    //海量打点：
                    PciData();
                    function PciData(){}{
                        map.clearOverlays();
                        if (document.createElement('canvas').getContext) {  // 判断当前浏览器是否支持绘制海量点
                            var points1 = [];  // 添加海量点数据
                            var points2 = [];  // 添加海量点数据
                            var points3 = [];  // 添加海量点数据
                            for (var i = 0; i < mapdate.length; i++) {
                                if(mapdate[i].pci == 119){
                                    points1.push(new BMap.Point(mapdate[i].longitude, mapdate[i].latitude));
                                } else if(mapdate[i].pci == 396){
                                    points2.push(new BMap.Point(mapdate[i].longitude, mapdate[i].latitude));
                                } else if(mapdate[i].pci == 398){
                                    points3.push(new BMap.Point(mapdate[i].longitude, mapdate[i].latitude));
                                }
                            }
                            //第一组：
                            var options1 = {
                                size:BMAP_POINT_SIZE_SMALL,
                                shape:0,
                                color: '#dd3b22'
                            }
                            var pointCollection1 = new BMap.PointCollection(points1, options1);  // 初始化PointCollection
                            map.addOverlay(pointCollection1);  // 添加Overlay
                            // 第二组：
                            var options2 = {
                                size:BMAP_POINT_SIZE_SMALL,
                                shape:0,
                                color: '#57a95c'
                            }
                            var pointCollection2 = new BMap.PointCollection(points2, options2);  // 初始化PointCollection
                            map.addOverlay(pointCollection2);  // 添加Overlay
                            // 第三组：
                            var options3 = {
                                size:BMAP_POINT_SIZE_SMALL,
                                shape:0,
                                color: '#0d47ff'
                            }
                            var pointCollection3 = new BMap.PointCollection(points3, options3);  // 初始化PointCollection
                            map.addOverlay(pointCollection3);  // 添加Overlay
                        } else {
                            alert('请在chrome、safari、IE8+以上浏览器查看本示例');
                        }
                    }
                }});
            }
    //=================选项卡============================
        $(".MapBigBox .MapBox .header .radio").click(function(){
        	var index=$(this).index(".MapBigBox .MapBox .header .radio");
            $(".MapBigBox .MapBox .header .radio").removeClass("active").eq(index).addClass("active");
            $(".MapBigBox .MapBox .map .right .indexui").css("display",'none').eq(index).css("display",'block');
            //切换打点数据：
            if(index==0){
            	RsrpMap();
            }else if(index==1){
                SinrMap();
            }else{
                PciMap();
            }
        });
        $(".MapBigBox .MapBox .header .close").click(function(){
            $(".MapBigBox").css("display","none");
        });
    }
});