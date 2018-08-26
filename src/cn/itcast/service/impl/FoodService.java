package cn.itcast.service.impl;

import java.util.List;

import cn.itcast.dao.IFoodDao;
import cn.itcast.entity.Food;
import cn.itcast.entity.FoodType;
import cn.itcast.factory.BeanFactory;
import cn.itcast.service.IFoodService;
import cn.itcast.utils.PageBean;

public class FoodService implements IFoodService {

	// ����dao
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
	 * ���
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
	 * ����
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
	 * ɾ��
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
	 * ��ѯȫ��
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
	 * ���ݲ�Ʒ���Ʋ�ѯ������ΪҪ��ѯ����
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
