package cn.itcast.dao;

import java.util.List;

import cn.itcast.entity.Food;
import cn.itcast.entity.FoodType;
import cn.itcast.utils.PageBean;

/**
 * ��Ʒ����
 * 
 *
 */
public interface IFoodDao {

	/**
	 * ��ҳ�Ұ�������ѯ���еĲ�Ʒ
	 */
	void getAll(PageBean<Food> pb);
	
	/**
	 * ������ͳ�Ʋ�Ʒ���ܼ�¼��
	 */
	int getTotalCount(PageBean<Food> pb);
	
	/**
	 * ��������id��ѯ
	 */
	Food findById(int id);
	/**
	 * ���
	 */
	void save(Food food );
	
	/**
	 * ����
	 */
	void update(Food food);
	
	/**
	 * ɾ��
	 */
	void delete(int id);
	/**
	 * ��ѯȫ��
	 */
	List<Food> getAll();
	/**
	 * ���ݲ�Ʒ���Ʋ�ѯ������ΪҪ��ѯ����
	 */
	List<Food> getAll(String foodName);
}
