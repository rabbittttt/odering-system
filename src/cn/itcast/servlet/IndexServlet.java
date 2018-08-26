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
	 * // ����Service private IDinnerTableService dinnerTableService =
	 * BeanFactory.getInstance("dinnerTableService", IDinnerTableService.class);
	 * 
	 * 
	 * 
	 * public void doGet(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException {
	 * 
	 * // ��ȡ���������� String method = request.getParameter("method"); if (method ==
	 * null) { // Ĭ��ִ�еķ����� ����ǰ̨�б����ҳ method = "listTable"; }
	 * 
	 * // �ж� if ("listTable".equals(method)) { // 1. ǰ̨��ҳ����ʾ����δԤ���Ĳ���
	 * listTable(request,response); }
	 * 
	 * }
	 * 
	 * public void doPost(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException { this.doGet(request,
	 * response); }
	 */

	// 1. ǰ̨��ҳ����ʾ����δԤ���Ĳ���
	public Object listTable(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// ������ת��Դ(ת��/�ض���)
		Object uri = null;
		// ��ѯ����δԤ������
		List<DinnerTable> list = dinnerTableService.findNoUseTable();
		// ���浽request
		request.setAttribute("listDinnerTable", list);
		// ��ת����ҳ��ʾ
		uri = request.getRequestDispatcher("/app/index.jsp");
		return uri;

		// ��ת
		// WebUtils.goTo(request, response, uri);
	}
	
	// a. ��Ӳ���
		public Object addDinnerTable(HttpServletRequest request,
				HttpServletResponse response) throws ServletException, IOException, ParseException {
			Object uri = null;
			// 1. ��ȡ�������ݷ�װ
		
			String tableName = request.getParameter("tableName");
			String tableStatus=request.getParameter("tableStatus");
			String Date=request.getParameter("orderDate");
		    DinnerTable dt=new DinnerTable();
			
			dt.setTableName(tableName);
			dt.setTableStatus(Integer.parseInt(tableStatus));
			//���ڵĸ�ʽ  
			DateFormat myFormat =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
			//���ַ���ת��Ϊ��������  
			Date orderDate = myFormat.parse(Date); 
			dt.setOrderDate(orderDate);
		
			// 2. ����service����ҵ���߼�
			dinnerTableService.save(dt);

			// 3. ��ת
			uri = request.getRequestDispatcher("/index?method=list");

			return uri;

		}

		// b. �����б�չʾ
		public Object list(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			Object uri = null;
			// ����Service��ѯ���е����
			List<DinnerTable> list = dinnerTableService.getAll();
			// ����
			request.setAttribute("listDinnerTable", list);
			// ��ת�Ĳ�Ʒ�б�ҳ��
			uri = request.getRequestDispatcher("/sys/board/board_list.jsp");

			return uri;
		}

		// c. �������ҳ��
		///public Object viewUpdate(HttpServletRequest request,
				//HttpServletResponse response) throws ServletException, IOException {
			//Object uri = null;
			// 1. ��ȡ����id
			//String id = request.getParameter("id");
			// 2. ����id��ѯ����
			//DinnerTable dt= dinnerTableService.findById(Integer.parseInt(id));
		
			// 3. ����
			//request.setAttribute("dinnertable", dt);
			// 4. ��ת
			//uri = request.getRequestDispatcher("/sys/board/board_update.jsp");
			//return uri;
		//}

		// d. ɾ��
		public Object delete(HttpServletRequest request,
				HttpServletResponse response) throws ServletException, IOException {
			Object uri = null;
			// 1. ��ȡ����id
			String id = request.getParameter("id");
			// 2. ����Service
			dinnerTableService.delete(Integer.parseInt(id));
			// 3. ��ת
			uri = "/index?method=list";
			return uri;
		}


}
