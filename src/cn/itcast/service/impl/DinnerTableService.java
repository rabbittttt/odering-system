package cn.itcast.service.impl;

import java.util.List;

import cn.itcast.dao.IDinnerTableDao;
import cn.itcast.entity.DinnerTable;
import cn.itcast.entity.TableStatus;
import cn.itcast.factory.BeanFactory;
import cn.itcast.service.IDinnerTableService;

public class DinnerTableService implements IDinnerTableService {

	// 调用的Dao, 通常工厂创建实例
	private IDinnerTableDao dinnerTableDao = BeanFactory.getInstance(
			"dinnerTableDao", IDinnerTableDao.class);

	@Override
	public List<DinnerTable> findNoUseTable() {
		try {
			// 调用dao的根据状态查询的方法，查询没有预定的餐桌
			return dinnerTableDao.findByStatus(TableStatus.Free);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	/**
	 * 查询全部
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
	 * 根据餐桌名称查询，参数为要查询的项
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
	 * 根据预定状态查询
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
	 * 主键查询
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
	 * 添加
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
	 * 更新
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
	 * 删除
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
