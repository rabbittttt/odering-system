package cn.itcast.service;

import java.util.List;

import cn.itcast.entity.DinnerTable;
import cn.itcast.entity.TableStatus;

public interface IDinnerTableService {

	/**
	 * ��ѯ����δԤ���Ĳ���????
	 */
	List<DinnerTable> findNoUseTable();
	
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
