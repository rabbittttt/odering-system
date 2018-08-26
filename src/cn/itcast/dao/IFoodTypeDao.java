package cn.itcast.dao;

import java.util.List;

import cn.itcast.entity.FoodType;

/**
 * 2. 菜系模块，dao接口设计
 * 
 *
 */
public interface IFoodTypeDao {

	/**
	 * 添加
	 */
	void save(FoodType foodType);
	
	/**
	 * 更新
	 */
	void update(FoodType foodType);
	
	/**
	 * 删除
	 */
	void delete(int id);
	
	/**
	 * 根据主键查询，点击更新时，会将更新内容传到servlet，再从servlet查询
	 */
	FoodType findById(int id);
	
	/**
	 * 查询全部
	 */
	List<FoodType> getAll();
	
	/**
	 * 根据菜系名称查询，参数为要查询的项
	 */
	List<FoodType> getAll(String typeName);
	
	
}








