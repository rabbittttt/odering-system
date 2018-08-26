package cn.itcast.dao;

import java.util.List;

import cn.itcast.entity.DinnerTable;
import cn.itcast.entity.Food;
import cn.itcast.entity.TableStatus;

public interface IDinnerTableDao {
	/**
	 * 查询全部
	 */
	List<DinnerTable> getAll();
	/**
	 * 根据餐桌名称查询，参数为要查询的项
	 */
	List<DinnerTable> getAll(String tableName);
	/**
	 * 根据预定状态查询
	 */
	List<DinnerTable> findByStatus(TableStatus ts);

	/**
	 * 主键查询
	 */
	DinnerTable findById(int id);
	/**
	 * 添加
	 */
	void save(DinnerTable dt);
	
	/**
	 * 更新
	 */
	//void update(DinnerTable dt);
	
	/**
	 * 删除
	 */
	void delete(int id);

}
