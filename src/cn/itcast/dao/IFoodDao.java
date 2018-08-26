package cn.itcast.dao;

import java.util.List;

import cn.itcast.entity.Food;
import cn.itcast.entity.FoodType;
import cn.itcast.utils.PageBean;

/**
 * 菜品管理
 * 
 *
 */
public interface IFoodDao {

	/**
	 * 分页且按条件查询所有的菜品
	 */
	void getAll(PageBean<Food> pb);
	
	/**
	 * 按条件统计菜品的总记录数
	 */
	int getTotalCount(PageBean<Food> pb);
	
	/**
	 * 根据主键id查询
	 */
	Food findById(int id);
	/**
	 * 添加
	 */
	void save(Food food );
	
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
