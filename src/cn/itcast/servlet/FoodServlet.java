package cn.itcast.servlet;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.itcast.entity.DinnerTable;
import cn.itcast.entity.Food;
import cn.itcast.entity.FoodType;
import cn.itcast.utils.Condition;
import cn.itcast.utils.PageBean;

public class FoodServlet extends BaseServlet {

	/**
	 * 1. 进入主页，显示菜品以及菜系
	 */
	public Object foodDetail(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		//1.1 获取餐桌ID,根据ID查询，再把查询到的结果保存到session （生成订单用）
		// 只需要执行一次即可: 先从session获取看有没有餐桌对象； 如果没有，就执行根据主键查询；
		// 如果sesison中已经有餐桌对象，就不执行主键查询
		Object obj = session.getAttribute("dinnerTable");
		// 判断
		if (obj == null){
			// 只在第一次执行的时候，查询餐桌对象
			String tableId = request.getParameter("tableId");
			DinnerTable dt = dinnerTableService.findById(Integer.parseInt(tableId));
			// 保存到session
			session.setAttribute("dinnerTable", dt);
		
		}
		
		//1.2 查询所有的“菜品信息”, 保存
		PageBean<Food> pb = new PageBean<Food>();
		// 分页参数： 获取当前页参数
		String curPage = request.getParameter("currentPage");
		// 判断
		if (curPage == null || "".equals(curPage.trim())) {
			// 第一次访问，设置当前页为1
			pb.setCurrentPage(1);
		} else {
			// 【设置当前页参数】
			pb.setCurrentPage(Integer.parseInt(curPage));
		}
		
		// 条件对象
		Condition condition = new Condition();
		// 分页参数： 菜系id
		String foodTypeId = request.getParameter("foodTypeId");
		if (foodTypeId != null) {  // 如果类别为null,不作为条件，那就查询全部
			// 设置条件
			condition.setFoodTypeId(Integer.parseInt(foodTypeId));
		}
		// 分页参数： 菜名称
		String foodName = request.getParameter("foodName");
		// 设置菜品参数
		condition.setFoodName(foodName);
		
		// 【设置条件对象到pb中】
		pb.setCondition(condition);

		// ---->分页查询
		foodService.getAll(pb);
		// 保存查询后的pb对象
		request.setAttribute("pb", pb);
		
		//1.3 查询所有的“菜品信息”， 保存
		List<FoodType> listFoodType = foodTypeService.getAll();
		request.setAttribute("listFoodType", listFoodType);
		
		//1.4 跳转(转发)
		return request.getRequestDispatcher("/app/caidan.jsp");
	}
	// a. 添加菜品
		public Object addFood(HttpServletRequest request,
				HttpServletResponse response) throws ServletException, IOException {
			Object uri = null;
			// 1. 获取请求数据封装
			
			String foodName = request.getParameter("foodName");
			String foodType_id=request.getParameter("foodType_id");
			String price=request.getParameter("price");
			String mprice=request.getParameter("mprice");
			String remark=request.getParameter("remark");
			String img=request.getParameter("img");
			Food f = new Food();
			//String sql="select ft.foodTypeName from foodType ft,food f where f.id=ft.id";
			f.setFoodName(foodName);
			f.setFoodType_id(Integer.parseInt(foodType_id));
			f.setPrice(Double.parseDouble(price));
			f.setMprice(Double.parseDouble(mprice));
			f.setRemark(remark);
			f.setImg(img);
            
			// 2. 调用service处理业务逻辑
			foodService.save(f);

			// 3. 跳转
			uri = request.getRequestDispatcher("/food?method=list");

			return uri;

		}

		// b. 菜品列表展示
		public Object list(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			Object uri = null;
			// 调用Service查询所有的类别
			List<Food> list = foodService.getAll();
			// 保存
			request.setAttribute("listFood", list);
			// 跳转的菜品列表页面
			uri = request.getRequestDispatcher("/sys/food/food_list.jsp");

			return uri;
		}

		// c. 进入更新页面
		public Object viewUpdate(HttpServletRequest request,
				HttpServletResponse response) throws ServletException, IOException {
			Object uri = null;
			// 1. 获取请求id
			String id = request.getParameter("id");
			// 2. 根据id查询对象
			Food f = foodService.findById(Integer.parseInt(id));
			// 3. 保存
			request.setAttribute("food", f);
			// 4. 跳转
			uri = request.getRequestDispatcher("/sys/food/food_update.jsp");
			return uri;
		}

		// d. 删除
		public Object delete(HttpServletRequest request,
				HttpServletResponse response) throws ServletException, IOException {
			Object uri = null;
			// 1. 获取请求id
			String id = request.getParameter("id");
			// 2. 调用Service
			foodService.delete(Integer.parseInt(id));
			// 3. 跳转
			uri = "/food?method=list";
			return uri;
		}

		// e. 更新
		public Object update(HttpServletRequest request,
				HttpServletResponse response) throws ServletException, IOException {
			Object uri = null;
			// 1. 获取请求数据封装
			int id = Integer.parseInt(request.getParameter("id"));
			String foodName = request.getParameter("foodName");
			String foodType_id=request.getParameter("foodType_id");
			String price=request.getParameter("price");
			String mprice=request.getParameter("mprice");
			String remark=request.getParameter("remark");
			String img=request.getParameter("img");
			System.out.println(foodName);
			System.out.println(foodType_id);
			
			Food food = new Food();
			food.setId(id);
			food.setFoodName(foodName);
			food.setFoodType_id(Integer.parseInt(foodType_id));
			food.setPrice(Double.parseDouble(price));
			food.setMprice(Double.parseDouble(mprice));
			food.setRemark(remark);
			food.setImg(img);

			// 2. 调用Service更新
			foodService.update(food);
			// 3. 跳转
			// list(request,response);
			uri = "/food?method=list";
			return uri;
		}

}












