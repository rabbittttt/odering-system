package cn.itcast.service.impl;

import java.util.List;

import cn.itcast.dao.IDinnerTableDao;
import cn.itcast.entity.DinnerTable;
import cn.itcast.entity.TableStatus;
import cn.itcast.factory.BeanFactory;
import cn.itcast.service.IDinnerTableService;

public class DinnerTableService implements IDinnerTableService {

	// ���õ�Dao, ͨ����������ʵ��
	private IDinnerTableDao dinnerTableDao = BeanFactory.getInstance(
			"dinnerTableDao", IDinnerTableDao.class);

	@Override
	public List<DinnerTable> findNoUseTable() {
		try {
			// ����dao�ĸ���״̬��ѯ�ķ�������ѯû��Ԥ���Ĳ���
			return dinnerTableDao.findByStatus(TableStatus.Free);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	/**
	 * ��ѯȫ��
	 */
	@Override
	public List<DinnerTable> getAll(){
		try {
			return dinnerTableDao.getAll();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	/**
	 * ���ݲ������Ʋ�ѯ������ΪҪ��ѯ����
	 */
	@Override
	public List<DinnerTable> getAll(String tableName){
		try {
			return dinnerTableDao.getAll();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	/**
	 * ����Ԥ��״̬��ѯ
	 */
	@Override
	public
	List<DinnerTable> findByStatus(TableStatus ts){
		try {
			return dinnerTableDao.findByStatus(ts);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * ������ѯ
	 */
	@Override
	public DinnerTable findById(int id) {
		try {
			return dinnerTableDao.findById(id);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	/**
	 * ���
	 */
	@Override
	public
	void save(DinnerTable dt) {
		try {
			dinnerTableDao.save(dt);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * ����
	 */
	//@Override
	//public
	//void update(DinnerTable dt) {
		//try {
			//dinnerTableDao.update(dt);
		//} catch (Exception e) {
			//throw new RuntimeException(e);
		//}
	//}
	
	/**
	 * ɾ��
	 */
	@Override
	public
	void delete(int id) {
		try {
		  dinnerTableDao.delete(id);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
