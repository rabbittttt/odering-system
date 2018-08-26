package cn.itcast.service;

import java.util.List;

import cn.itcast.entity.Food;
import cn.itcast.utils.PageBean;

public interface IFoodService {

	

	/**
	 * 分页查询
	 */
	void getAll(PageBean<Food> pb);
	/**
	 * 按条件统计菜品的总记录数
	 */
	int getTotalCount(PageBean<Food> pb);
	/**
	 * 主键查询
	 */
	Food findById(int id);
	/**
	 * 添加
	 */
	void save(Food food);
	
	/**
	 * 更新
	 */
	void update(Food food);
	
	/**
	 * 删除
	 */
	void delete(int id);
	/**
	 * 查询全部
	 */
	List<Food> getAll();
	/**
	 * 根据菜品名称查询，参数为要查询的项
	 */
	List<Food> getAll(String foodName);
}
