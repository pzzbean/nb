package com.ibase.web.roadtest.controlle;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import com.ibase.core.http.ResponsePacket4;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.ibase.core.http.ResponsePacket2;
import com.ibase.core.http.ResponsePacket3;
import com.ibase.core.utils.ImageUtils;
import com.ibase.core.utils.StringUtil;
import com.ibase.web.roadtest.domain.CellIndexResult;
import com.ibase.web.roadtest.domain.CellIndexResultTotal;
import com.ibase.web.roadtest.domain.CellParameterCheck;
import com.ibase.web.roadtest.domain.Image;
import com.ibase.web.roadtest.domain.LonLat;
import com.ibase.web.roadtest.domain.RoadTest;
import com.ibase.web.roadtest.domain.RoadTest2;
import com.ibase.web.roadtest.domain.RoadTestData;
import com.ibase.web.roadtest.domain.RoadTestData2;
import com.ibase.web.roadtest.domain.RoadTestFile;
import com.ibase.web.roadtest.domain.RoadTestTotal;
import com.ibase.web.roadtest.domain2.StationNoTestDate;
import com.ibase.web.roadtest.domain2.Station_new;
import com.ibase.web.roadtest.domain2.TestPlan_new;
import com.ibase.web.roadtest.service.RoadService;
import com.ibase.web.roadtest.util.CSVRoadTest;
import com.ibase.web.roadtest.util.RoadTestUtil;
import com.sun.org.apache.xml.internal.security.algorithms.implementations.IntegrityHmac.IntegrityHmacRIPEMD160;

@Controller
@RequestMapping(value = "/roadTest")
public class RoadTestController {
	@Autowired
	private RoadService roadService;

	@Autowired
	protected HttpServletResponse response;

	@Autowired
	private HttpServletRequest request;
	/*	*//**
			 * 添加路测数据
			 *//*
			 * @RequestMapping(path = "/addRoadTest")
			 * 
			 * @ResponseBody public ResponsePacket addRoadTest(RoadTest
			 * roadTest){ ResponsePacket json = new ResponsePacket(-1,"添加失败！");
			 * FileReader fr = null;; try { fr = new
			 * FileReader("D:\\RoadTest.csv"); } catch (FileNotFoundException e)
			 * { e.printStackTrace(); }
			 * 
			 * //添加 if(CSVRoadTest.addRoadTest(fr, roadService)){
			 * json.setCode(1); json.setMsg("添加成功！"); } return json; }
			 */

	/**
	 * 上传路测
	 */
	@RequestMapping(path = "/addRoadTestCSV")
	@ResponseBody
	public ResponsePacket4 addRoadTest(MultipartFile file) {
		ResponsePacket4 json = new ResponsePacket4(-1, "添加失败！");
		CommonsMultipartFile cf = (CommonsMultipartFile) file;
		DiskFileItem fi = (DiskFileItem) cf.getFileItem();
		File f = fi.getStoreLocation();
		String fileName = fi.getName();
		fileName = fileName.substring(0, fileName.indexOf("."));
		FileReader fr = null;
		try {
			fr = new FileReader(f);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Integer rt_count = roadService.countRoadTest();
		// 添加
		if (CSVRoadTest.addRoadTest(fr, roadService, rt_count, fileName)) {
			json.setCode(1);
			json.setMsg("添加成功！");
		}
		return json;
	}

	/**
	 * 分页的传入的 当前页 字段为page.currentPage 分页穿去的 显示条数 字段为page.pageSize
	 */
	@RequestMapping(path = "/listRoadTest")
	@ResponseBody
	public ResponsePacket4 listRoadTestFile(RoadTestFile roadTestFile) {
		// 模糊查询
		if (!StringUtil.isEmpty(roadTestFile.getRtf_name())) {
			roadTestFile.setRtf_name("%" + roadTestFile.getRtf_name() + "%");
		}

		List<RoadTestFile> list = roadService.queryRoadTestFile(roadTestFile);

		ResponsePacket4 json = new ResponsePacket4(1, "查询成功");
		json.setListObject(list);
		json.setPage(roadTestFile.getPage());
		return json;
	}

	@RequestMapping(path = "/selectAllLng_Lat")
	@ResponseBody
	// public List<RoadTest> selectAllLng_Lat(Integer id){
	//
	// List<RoadTest> list = roadService.selectAllLng_Lat(id);
	// System.out.println(id);
	// System.out.println(list);
	// return list;
	// }

	public ResponsePacket2 selectAllLng_Lat(Integer id) {
		Integer id1 = Integer.valueOf(request.getParameter("id"));
		List<RoadTest> list = roadService.selectAllLng_Lat(id1);

		ResponsePacket2 json = new ResponsePacket2(list);
		System.out.println(json);
		return json;
	}

	@RequestMapping(path = "/selectPCI")
	@ResponseBody
	public ResponsePacket2 selectPCI(String PCI, Integer id) {

		// List<RoadTest> list = roadService.selectPCI(PCI);
		//
		// List<Map<Long ,String>> listDate = new ArrayList<>();
		// Map<Long ,String> map = new HashMap<>();
		// for (RoadTest roadTest : list) {
		// map.put(roadTest.getRt_id(), roadTest.getRt_cell_PCI());
		// }
		// listDate.add(map);
		//
		//
		// return listDate;
		// }
		List<RoadTest> list = roadService.selectPCI(PCI, id);

		ResponsePacket2 json = new ResponsePacket2(list);
		System.out.println(json);
		return json;
	}

	@RequestMapping(path = "/selectRSRP")
	@ResponseBody
	public ResponsePacket2 selectRSRP(String RSRP, Integer id) {

		// List<RoadTest> list = roadService.selectRSRP(RSRP);
		//
		// List<Map<Long, String>> listDate = new ArrayList<>();
		// Map<Long, String> map = new HashMap<>();
		// for (RoadTest roadTest : list) {
		// map.put(roadTest.getRt_id(), roadTest.getRt_log_RSRP());
		// }
		// listDate.add(map);
		// return listDate;
		// }

		List<RoadTest> list = roadService.selectRSRP(RSRP, id);

		ResponsePacket2 json = new ResponsePacket2(list);
		System.out.println(json);
		return json;
	}

	@RequestMapping(path = "/selectSINR")
	@ResponseBody
	public ResponsePacket2 selectSINR(String SINR, Integer id) {

		// List<RoadTest> list = roadService.selectRSRP(SINR);
		//
		// return list;
		// }
		List<RoadTest> list = roadService.selectSINR(SINR, id);

		ResponsePacket2 json = new ResponsePacket2(list);
		System.out.println(json);
		return json;
	}

	@RequestMapping("/queryRSRPXY1")
	@ResponseBody
	public List<LonLat> queryRSRPXY1(String RSRP, long count) throws IOException {
		List<LonLat> list = roadService.queryRSRPXY1(RSRP, count);
		System.out.println(list);
		return list;
	}

	@RequestMapping("/queryRSRPXY2")
	@ResponseBody
	public List<LonLat> queryRSRPXY2(String RSRP, long count) throws IOException {
		List<LonLat> list = roadService.queryRSRPXY2(RSRP, count);
		System.out.println(list);
		return list;
	}

	@RequestMapping("/queryRSRPXY3")
	@ResponseBody
	public List<LonLat> queryRSRPX3(String RSRP, long count) throws IOException {
		List<LonLat> list = roadService.queryRSRPXY3(RSRP, count);
		System.out.println(list);
		return list;
	}

	@RequestMapping("/queryRSRPXY4")
	@ResponseBody
	public List<LonLat> queryRSRPX4(String RSRP, long count) throws IOException {
		List<LonLat> list = roadService.queryRSRPXY4(RSRP, count);
		System.out.println(list);
		return list;
	}

	@RequestMapping("/querySINRXY1")
	@ResponseBody
	public List<LonLat> querySINRXY1(String SINR, long count) {
		List<LonLat> list = roadService.querySINRXY1(SINR, count);
		System.out.println(list);
		return list;
	}

	@RequestMapping("/querySINRXY2")
	@ResponseBody
	public List<LonLat> querySINRXY2(String SINR, long count) {
		List<LonLat> list = roadService.querySINRXY2(SINR, count);
		System.out.println(list);
		return list;
	}

	@RequestMapping("/querySINRXY3")
	@ResponseBody
	public List<LonLat> querySINRXY3(String SINR, long count) {
		List<LonLat> list = roadService.querySINRXY3(SINR, count);
		System.out.println(list);
		return list;
	}

	@RequestMapping("/querySINRXY4")
	@ResponseBody
	public List<LonLat> querySINRXY4(String SINR, long count) {
		List<LonLat> list = roadService.querySINRXY4(SINR, count);
		System.out.println(list);
		return list;
	}

	@RequestMapping("/queryPCIXY1")
	@ResponseBody
	public List<LonLat> queryPCIXY1(String PCI, long count) {
		List<LonLat> list = roadService.queryPCIXY1(PCI, count);
		System.out.println(list);
		return list;
	}

	@RequestMapping("/queryPCIXY2")
	@ResponseBody
	public List<LonLat> queryPCIXY2(String PCI, long count) {
		List<LonLat> list = roadService.queryPCIXY2(PCI, count);
		System.out.println(list);
		return list;
	}

	@RequestMapping("/queryPCIXY3")
	@ResponseBody
	public List<LonLat> queryPCIXY3(String PCI, long count) {
		List<LonLat> list = roadService.queryPCIXY3(PCI, count);
		System.out.println(list);
		return list;
	}

	@RequestMapping("/queryPCIXY4")
	@ResponseBody
	public List<LonLat> queryPCIXY4(String PCI, long count) {
		List<LonLat> list = roadService.queryPCIXY4(PCI, count);
		System.out.println(list);
		return list;
	}

	/**
	 * 截图
	 * 
	 * @return
	 * @throws IOException
	 *             getAutoPhotos?rtf_id=1&target_name=rt_log_RSRP;
	 */
	@RequestMapping("/getAutoPhotos")
	@ResponseBody
	public ResponsePacket4 getAutoPhotos(HttpServletRequest request, @RequestParam long id, String paramName)
			throws IOException {
		ResponsePacket4 json = new ResponsePacket4(-1, "截图失败！");
		System.out.println("id:" + id + "paramName:" + paramName);
		// roadService.getImageAddress(id,paramName);
		// 输入文件id和指标名，返回布尔类型如果address==null，返回true
		if (roadService.getImageAddress(id, paramName) == true) {
			System.out.println("begin");
			Image image = ImageUtils.snapShot(id, paramName, "D:\\nbPicture", "png");

			roadService.insertImage(image);
			if (roadService.getImageAddress(id, paramName) == false) {
				json.setCode(1);
				json.setMsg("截图成功！");
			}
			/// nb/WebContent/img
			System.out.println("image:" + image);
		} else {
			json.setCode(1);
			json.setMsg("截图成功！");
		}
		response.addHeader("Access-Control-Allow-Origin", "*");
		return json;

	}
	// 获取所有的指标以及其对应的经纬度

	@RequestMapping("/getSomeRoadTest")
	@ResponseBody
	public ResponsePacket4 getSomeRoadTest(Integer id) throws IOException {

		Integer id1 = Integer.valueOf(request.getParameter("id"));
		System.out.println(id1);

		List<Map<String, Object>> data = roadService.getAllRoadTestData(id1);
		System.out.println(data.toString());
		ResponsePacket4 json = new ResponsePacket4();
		json.setListObject(data);

		// 解决跨域问题
		// System.out.println(json.toString());
		response.addHeader("Access-Control-Allow-Origin", "*");

		return json;

	}

	// ````````````````````````````````````````````````````````````````````````````

	// 为上海移动测试临时加的方法，目的是接受APP传来的小区测试结果
	@RequestMapping("/insertTemporaryLog")
	@ResponseBody
	public ResponsePacket3 insertTemporaryLog(CellIndexResult cir) {
		System.out.println(cir);
		ResponsePacket3 json = new ResponsePacket3(-1, "添加测试结果失败！");
//		int userId = cir.getUserId();
//		String testDate = cir.getTestDate();
//		String station_No = cir.getStation_No();
//		List<CellIndexResultTotal> cellIndexResultTotals = roadService.selectCellIndexResultTotal(userId, testDate,
//				station_No);
//		if (cellIndexResultTotals.size()==0) {
			// 调用service的添加方法，将接受的数据cir(测试结果以小区为单位接受)
		int m = roadService.insertTemporaryLog(cir);
		if (m > 0) {
			json.setResultCode(1);
			json.setmMessage("添加测试结果成功！");
		}
//		} else {
//			int n = roadService.updateTemporaryLog(cir);
//			if (n > 0) {
//				json.setResultCode(1);
//				json.setmMessage("修改测试结果成功！");
//			}
//		}
		response.addHeader("Access-Control-Allow-Origin", "*");
		return json;
	}

	// 为上海移动测试临时加的方法，目的是核查APP传来的小区工参
	@RequestMapping("/checkCellParameter")
	@ResponseBody
	public ResponsePacket3 checkCellParameter(CellParameterCheck cpc) {

		ResponsePacket3 json = new ResponsePacket3(-1, "添加小区工参失败！");
		//int userId = Integer.valueOf(cpc.getUserId());
		int userId = cpc.getUserId();
		String testDate = cpc.getTestDate();
		String station_No = cpc.getStation_No();
		List<CellIndexResultTotal> cellIndexResultTotals = roadService.selectCellIndexResultTotal(userId, testDate,
				station_No);
		if (cellIndexResultTotals.size() > 0) {
			// 调用service的添加方法，接受APP传来的的工参cpc
			// 如果能查到，更新
			int m = roadService.insertTemporaryLogCellParameter(cpc);
			if (m > 0) {
				json.setResultCode(1);
				json.setmMessage("修改小区工参成功！");
			}
		} else {
			// 如果查不到，插入
			int n = roadService.insertCellIndexResultTotal(cpc);
			if (n > 0) {
				json.setResultCode(1);
				json.setmMessage("添加小区工参成功！");
			}
		}
		response.addHeader("Access-Control-Allow-Origin", "*");
		return json;
	}

	// 为上海移动测试临时加的方法，目的是接受APP传来的小区路测数据
	@RequestMapping(value = "/insertCellRoadTest", method = RequestMethod.GET)
	@ResponseBody
	public ResponsePacket3 insertCellRoadTest(RoadTestData2 rtd1) {
		System.out.println("rtd1:" + rtd1.toString());

		String rtlist = rtd1.getRtlist();
		/*
		 * JsonParser jp = new JsonParser(); JsonArray ja =
		 * jp.parse(rtlist).getAsJsonArray();
		 */
		Gson gson = new Gson();
		ArrayList<RoadTest2> list1 = gson.fromJson(rtlist, new TypeToken<ArrayList<RoadTest2>>() {
		}.getType());

		/*
		 * for (JsonElement ja1 : ja) { RoadTest2 roadTest2 = gson.fromJson(ja1,
		 * RoadTest2.class); list1.add(roadTest2); }
		 */
		// gson.fromJson(rtlist, list1);

		RoadTestData rtd = new RoadTestData();
		rtd.setUserId(rtd1.getUserId());
		rtd.setStation_No(rtd1.getStation_No());
		rtd.setCommunityName(rtd1.getCommunityName());
		rtd.setRtlist(list1);
		System.out.println("rtd:" + rtd);
		ResponsePacket3 json = new ResponsePacket3(-1, "添加小区路测数据失败！");

		// 调用service的添加方法，接受APP传来的的路测数据rtd
		int m = roadService.insertCellRoadTest(rtd);
		if (m > 0) {
			json.setResultCode(1);
			json.setmMessage("添加小区路测数据成功！");
		}
		response.addHeader("Access-Control-Allow-Origin", "*");
		return json;

	}

	// 为上海移动测试临时加的方法，APP要求根据测试时间和基站编号把RSRP，SINR，PCI的值以及其对应的经纬度传给前端
	@RequestMapping("/selectCellRoadTest")
	@ResponseBody
	public ResponsePacket4 selectCellRoadTest(String station_No, String roadTestDate) {
		System.out.println("``````````````````" + station_No + roadTestDate);
		ResponsePacket4 json = new ResponsePacket4(-1, "查询小区路测数据失败！");

		List<RoadTestTotal> list = roadService.selectCellRoadTest(station_No, roadTestDate);
		System.out.println(list.toString());
		if (list != null) {
			json.setListObject(list);
			json.setCode(1);
			json.setMsg("查询小区路测数据成功！");
		}
		response.addHeader("Access-Control-Allow-Origin", "*");
		return json;

	}

	// 为上海移动测试临时加的方法，把基站列表传给前端
	@RequestMapping("/selectStationRoadTest")
	@ResponseBody
	public ResponsePacket4 selectStationRoadTest(StationNoTestDate stationNoTestDate) {
		System.out.println("进入selectStationRoadTest");
		ResponsePacket4 json = new ResponsePacket4(-1, "查询小区路测数据失败！");

		List<StationNoTestDate> list = roadService.selectStationRoadTest();
		System.out.println(list.toString());
		if (list != null) {
			json.setListObject(list);
			json.setPage(stationNoTestDate.getPage());
			json.setCode(1);
			json.setMsg("查询小区路测数据成功！");
		}
		response.addHeader("Access-Control-Allow-Origin", "*");
		System.out.println(json);
		return json;

	}

	// 为上海移动测试临时加的方法，APP要求根据用户编号查询出测试计划的内容获取测试id
	@RequestMapping("/selectTestPlanNew")
	@ResponseBody
	public ResponsePacket3 selectTestPlanNew(String userId) {

		ResponsePacket3 json = new ResponsePacket3(-1, "查询测试计划数据失败！");
		// 调用service的添加方法，接受APP传来的用户id（没有从数据库中查数据，直接模拟的测试计划id为1）
		TestPlan_new tpn = roadService.selectTestPlanNew(userId);
		List<TestPlan_new> list = new ArrayList<>();
		list.add(tpn);

		if (tpn != null) {
			json.setResultCode(1);
			json.setmMessage("查询测试计划数据成功！");
			json.setDataSource(list);
		}
		response.addHeader("Access-Control-Allow-Origin", "*");
		return json;

	}

	// 为上海移动测试临时加的方法，APP要求根据测试计划id查出该计划中的基站以及其对应的小区
	// 和每个小区对应需要测试的测试项，每个测试项对应的测试配置（测试项以及测试配置初步写死）
	// 传参加入userId
	@RequestMapping("/selectTestPlanNewStationnew")
	@ResponseBody
	public ResponsePacket3 selectTestPlanNewStationnew(String userId, String testDate) {
		// 测试计划id默认为1
		String parameter1 = request.getParameter("testDate");
		String parameter2 = request.getParameter("userId");
		System.out.println("parameter1:" + parameter1);
		System.out.println("parameter2:" + parameter2);
		ResponsePacket3 json = new ResponsePacket3(-1, "查询测试计划数据失败！");
		// 根据测试id查询所有的基站（初步打算直接查出数据nokia的基站,不根据计划id）
		List<Station_new> list1 = roadService.selectTestPlanNewStationnew();
		if (list1 != null) {
			json.setDataSource(list1);
			json.setResultCode(1);
			json.setmMessage("查询测试计划数据成功！");
		} else {
			json.setResultCode(1);
			json.setmMessage("为查到测试计划数据！");
		}
		response.addHeader("Access-Control-Allow-Origin", "*");
		return json;

	}
}
