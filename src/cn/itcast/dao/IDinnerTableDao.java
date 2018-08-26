package cn.itcast.dao;

import java.util.List;

import cn.itcast.entity.DinnerTable;
import cn.itcast.entity.Food;
import cn.itcast.entity.TableStatus;

public interface IDinnerTableDao {
	/**
	 * ��ѯȫ��
	 */
	List<DinnerTable> getAll();
	/**
	 * ���ݲ������Ʋ�ѯ������ΪҪ��ѯ����
	 */
	List<DinnerTable> getAll(String tableName);
	/**
	 * ����Ԥ��״̬��ѯ
	 */
	List<DinnerTable> findByStatus(TableStatus ts);

	/**
	 * ������ѯ
	 */
	DinnerTable findById(int id);
	/**
	 * ���
	 */
	void save(DinnerTable dt);
	
	/**
	 * ����
	 */
	//void update(DinnerTable dt);
	
	/**
	 * ɾ��
	 */
	void delete(int id);

}
