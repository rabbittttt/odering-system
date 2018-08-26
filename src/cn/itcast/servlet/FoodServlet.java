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
	 * 1. ������ҳ����ʾ��Ʒ�Լ���ϵ
	 */
	public Object foodDetail(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		//1.1 ��ȡ����ID,����ID��ѯ���ٰѲ�ѯ���Ľ�����浽session �����ɶ����ã�
		// ֻ��Ҫִ��һ�μ���: �ȴ�session��ȡ����û�в������� ���û�У���ִ�и���������ѯ��
		// ���sesison���Ѿ��в������󣬾Ͳ�ִ��������ѯ
		Object obj = session.getAttribute("dinnerTable");
		// �ж�
		if (obj == null){
			// ֻ�ڵ�һ��ִ�е�ʱ�򣬲�ѯ��������
			String tableId = request.getParameter("tableId");
			DinnerTable dt = dinnerTableService.findById(Integer.parseInt(tableId));
			// ���浽session
			session.setAttribute("dinnerTable", dt);
		
		}
		
		//1.2 ��ѯ���еġ���Ʒ��Ϣ��, ����
		PageBean<Food> pb = new PageBean<Food>();
		// ��ҳ������ ��ȡ��ǰҳ����
		String curPage = request.getParameter("currentPage");
		// �ж�
		if (curPage == null || "".equals(curPage.trim())) {
			// ��һ�η��ʣ����õ�ǰҳΪ1
			pb.setCurrentPage(1);
		} else {
			// �����õ�ǰҳ������
			pb.setCurrentPage(Integer.parseInt(curPage));
		}
		
		// ��������
		Condition condition = new Condition();
		// ��ҳ������ ��ϵid
		String foodTypeId = request.getParameter("foodTypeId");
		if (foodTypeId != null) {  // ������Ϊnull,����Ϊ�������ǾͲ�ѯȫ��
			// ��������
			condition.setFoodTypeId(Integer.parseInt(foodTypeId));
		}
		// ��ҳ������ ������
		String foodName = request.getParameter("foodName");
		// ���ò�Ʒ����
		condition.setFoodName(foodName);
		
		// ��������������pb�С�
		pb.setCondition(condition);

		// ---->��ҳ��ѯ
		foodService.getAll(pb);
		// �����ѯ���pb����
		request.setAttribute("pb", pb);
		
		//1.3 ��ѯ���еġ���Ʒ��Ϣ���� ����
		List<FoodType> listFoodType = foodTypeService.getAll();
		request.setAttribute("listFoodType", listFoodType);
		
		//1.4 ��ת(ת��)
		return request.getRequestDispatcher("/app/caidan.jsp");
	}
	// a. ��Ӳ�Ʒ
		public Object addFood(HttpServletRequest request,
				HttpServletResponse response) throws ServletException, IOException {
			Object uri = null;
			// 1. ��ȡ�������ݷ�װ
			
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
            
			// 2. ����service����ҵ���߼�
			foodService.save(f);

			// 3. ��ת
			uri = request.getRequestDispatcher("/food?method=list");

			return uri;

		}

		// b. ��Ʒ�б�չʾ
		public Object list(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			Object uri = null;
			// ����Service��ѯ���е����
			List<Food> list = foodService.getAll();
			// ����
			request.setAttribute("listFood", list);
			// ��ת�Ĳ�Ʒ�б�ҳ��
			uri = request.getRequestDispatcher("/sys/food/food_list.jsp");

			return uri;
		}

		// c. �������ҳ��
		public Object viewUpdate(HttpServletRequest request,
				HttpServletResponse response) throws ServletException, IOException {
			Object uri = null;
			// 1. ��ȡ����id
			String id = request.getParameter("id");
			// 2. ����id��ѯ����
			Food f = foodService.findById(Integer.parseInt(id));
			// 3. ����
			request.setAttribute("food", f);
			// 4. ��ת
			uri = request.getRequestDispatcher("/sys/food/food_update.jsp");
			return uri;
		}

		// d. ɾ��
		public Object delete(HttpServletRequest request,
				HttpServletResponse response) throws ServletException, IOException {
			Object uri = null;
			// 1. ��ȡ����id
			String id = request.getParameter("id");
			// 2. ����Service
			foodService.delete(Integer.parseInt(id));
			// 3. ��ת
			uri = "/food?method=list";
			return uri;
		}

		// e. ����
		public Object update(HttpServletRequest request,
				HttpServletResponse response) throws ServletException, IOException {
			Object uri = null;
			// 1. ��ȡ�������ݷ�װ
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

			// 2. ����Service����
			foodService.update(food);
			// 3. ��ת
			// list(request,response);
			uri = "/food?method=list";
			return uri;
		}

}












