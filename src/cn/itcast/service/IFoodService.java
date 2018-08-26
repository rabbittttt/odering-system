package cn.itcast.service;

import java.util.List;

import cn.itcast.entity.Food;
import cn.itcast.utils.PageBean;

public interface IFoodService {

	

	/**
	 * ��ҳ��ѯ
	 */
	void getAll(PageBean<Food> pb);
	/**
	 * ������ͳ�Ʋ�Ʒ���ܼ�¼��
	 */
	int getTotalCount(PageBean<Food> pb);
	/**
	 * ������ѯ
	 */
	Food findById(int id);
	/**
	 * ���
	 */
	void save(Food food);
	
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
