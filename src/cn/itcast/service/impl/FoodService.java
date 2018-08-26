package cn.itcast.service.impl;

import java.util.List;

import cn.itcast.dao.IFoodDao;
import cn.itcast.entity.Food;
import cn.itcast.entity.FoodType;
import cn.itcast.factory.BeanFactory;
import cn.itcast.service.IFoodService;
import cn.itcast.utils.PageBean;

public class FoodService implements IFoodService {

	// 创建dao
	private IFoodDao foodDao = BeanFactory.getInstance("foodDao", IFoodDao.class);
	


	@Override
	public void getAll(PageBean<Food> pb) {
		try {
			foodDao.getAll(pb);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	@Override
	public int getTotalCount(PageBean<Food> pb) {
		try {
			return foodDao.getTotalCount(pb);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	@Override
	public Food findById(int id) {
		try {
			return foodDao.findById(id);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * 添加
	 */
	@Override
	public void save(Food food) {
		try {
			foodDao.save(food);
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	/**
	 * 更新
	 */
	@Override
	public void update(Food food) {
		try {
			foodDao.update(food);
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	
	/**
	 * 删除
	 */
	@Override
	public void delete(int id) {
		try {
			foodDao.delete(id);
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	/**
	 * 查询全部
	 */
	@Override
	public List<Food> getAll() {
		try {
			return foodDao.getAll();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	};
	/**
	 * 根据菜品名称查询，参数为要查询的项
	 */
	@Override
	public List<Food> getAll(String foodName){
		try {
			return foodDao.getAll(foodName);
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
