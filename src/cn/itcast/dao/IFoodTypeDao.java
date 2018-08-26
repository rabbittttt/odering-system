package cn.itcast.dao;

import java.util.List;

import cn.itcast.entity.FoodType;

/**
 * 2. ��ϵģ�飬dao�ӿ����
 * 
 *
 */
public interface IFoodTypeDao {

	/**
	 * ���
	 */
	void save(FoodType foodType);
	
	/**
	 * ����
	 */
	void update(FoodType foodType);
	
	/**
	 * ɾ��
	 */
	void delete(int id);
	
	/**
	 * ����������ѯ���������ʱ���Ὣ�������ݴ���servlet���ٴ�servlet��ѯ
	 */
	FoodType findById(int id);
	
	/**
	 * ��ѯȫ��
	 */
	List<FoodType> getAll();
	
	/**
	 * ���ݲ�ϵ���Ʋ�ѯ������ΪҪ��ѯ����
	 */
	List<FoodType> getAll(String typeName);
	
	
}








