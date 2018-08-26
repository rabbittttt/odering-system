package cn.itcast.servlet;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.itcast.entity.DinnerTable;
import cn.itcast.entity.Food;
import cn.itcast.entity.FoodType;
import cn.itcast.factory.BeanFactory;
import cn.itcast.service.IDinnerTableService;
import cn.itcast.utils.Condition;
import cn.itcast.utils.PageBean;
import cn.itcast.utils.WebUtils;

public class IndexServlet extends BaseServlet {

	/*
	 * // 创建Service private IDinnerTableService dinnerTableService =
	 * BeanFactory.getInstance("dinnerTableService", IDinnerTableService.class);
	 * 
	 * 
	 * 
	 * public void doGet(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException {
	 * 
	 * // 获取操作的类型 String method = request.getParameter("method"); if (method ==
	 * null) { // 默认执行的方法： 进入前台列表的首页 method = "listTable"; }
	 * 
	 * // 判断 if ("listTable".equals(method)) { // 1. 前台首页：显示所有未预定的餐桌
	 * listTable(request,response); }
	 * 
	 * }
	 * 
	 * public void doPost(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException { this.doGet(request,
	 * response); }
	 */

	// 1. 前台首页：显示所有未预定的餐桌
	public Object listTable(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 保存跳转资源(转发/重定向)
		Object uri = null;
		// 查询所有未预定餐桌
		List<DinnerTable> list = dinnerTableService.findNoUseTable();
		// 保存到request
		request.setAttribute("listDinnerTable", list);
		// 跳转到首页显示
		uri = request.getRequestDispatcher("/app/index.jsp");
		return uri;

		// 跳转
		// WebUtils.goTo(request, response, uri);
	}
	
	// a. 添加餐桌
		public Object addDinnerTable(HttpServletRequest request,
				HttpServletResponse response) throws ServletException, IOException, ParseException {
			Object uri = null;
			// 1. 获取请求数据封装
		
			String tableName = request.getParameter("tableName");
			String tableStatus=request.getParameter("tableStatus");
			String Date=request.getParameter("orderDate");
		    DinnerTable dt=new DinnerTable();
			
			dt.setTableName(tableName);
			dt.setTableStatus(Integer.parseInt(tableStatus));
			//日期的格式  
			DateFormat myFormat =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
			//将字符串转化为日期类型  
			Date orderDate = myFormat.parse(Date); 
			dt.setOrderDate(orderDate);
		
			// 2. 调用service处理业务逻辑
			dinnerTableService.save(dt);

			// 3. 跳转
			uri = request.getRequestDispatcher("/index?method=list");

			return uri;

		}

		// b. 餐桌列表展示
		public Object list(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			Object uri = null;
			// 调用Service查询所有的类别
			List<DinnerTable> list = dinnerTableService.getAll();
			// 保存
			request.setAttribute("listDinnerTable", list);
			// 跳转的菜品列表页面
			uri = request.getRequestDispatcher("/sys/board/board_list.jsp");

			return uri;
		}

		// c. 进入更新页面
		///public Object viewUpdate(HttpServletRequest request,
				//HttpServletResponse response) throws ServletException, IOException {
			//Object uri = null;
			// 1. 获取请求id
			//String id = request.getParameter("id");
			// 2. 根据id查询对象
			//DinnerTable dt= dinnerTableService.findById(Integer.parseInt(id));
		
			// 3. 保存
			//request.setAttribute("dinnertable", dt);
			// 4. 跳转
			//uri = request.getRequestDispatcher("/sys/board/board_update.jsp");
			//return uri;
		//}

		// d. 删除
		public Object delete(HttpServletRequest request,
				HttpServletResponse response) throws ServletException, IOException {
			Object uri = null;
			// 1. 获取请求id
			String id = request.getParameter("id");
			// 2. 调用Service
			dinnerTableService.delete(Integer.parseInt(id));
			// 3. 跳转
			uri = "/index?method=list";
			return uri;
		}


}
