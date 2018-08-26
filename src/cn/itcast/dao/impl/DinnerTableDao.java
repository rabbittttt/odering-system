package cn.itcast.dao.impl;


import java.util.List;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.itcast.dao.IDinnerTableDao;
import cn.itcast.entity.DinnerTable;
import cn.itcast.entity.Food;
import cn.itcast.entity.TableStatus;
import cn.itcast.utils.JdbcUtils;

public class DinnerTableDao implements IDinnerTableDao{

	

	
	/**
	 * ��ѯȫ��
	 */
	@Override
	public List<DinnerTable> getAll(){
		String sql = "select * from dinnertable";
		try {
			return JdbcUtils.getQuerrRunner().query(sql, new BeanListHandler<DinnerTable>(DinnerTable.class));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	/**
	 * ���ݲ������Ʋ�ѯ������ΪҪ��ѯ����
	 */
	@Override
	public List<DinnerTable> getAll(String tableName){
		String sql = "select * from dinnertable where tableName like ?";
		try {
			return JdbcUtils.getQuerrRunner()
				.query(sql, new BeanListHandler<DinnerTable>(DinnerTable.class),"%" + tableName + "%");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	/**
	 * ����Ԥ��״̬��ѯ
	 */
	@Override
	public List<DinnerTable> findByStatus(TableStatus ts) {
		String sql = "select * from dinnerTable where tableStatus=?";
//		int status = -1;
		// �ж�		
//		if (ts == TableStatus.Free) {
//			status = 0;   // δԤ��״̬
//		} else {
//			status = 1;
//		}
//		
		try {
			return JdbcUtils.getQuerrRunner().query(sql, new BeanListHandler<DinnerTable>(DinnerTable.class), ts.ordinal());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * ������ѯ
	 */
	@Override
	public DinnerTable findById(int id) {
		String sql = "select * from dinnerTable where id=?";
		try {
			return JdbcUtils.getQuerrRunner().query(sql, new BeanHandler<DinnerTable>(DinnerTable.class), id);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	/**
	 * ���
	 */
	@Override
	public void save(DinnerTable dt) {
		String sql = "INSERT INTO dinnertable(tableName,tableStatus,orderDate) VALUES(?,?,?);";
		try {
			JdbcUtils.getQuerrRunner().update(sql, dt.getTableName(),dt.getTableStatus(),dt.getOrderDate());

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * ����
	 */
	//@Override
	//public void update(DinnerTable dt) {
		//String sql= "update dinnertable set tableName=?,tableStatus=?,orderDate=?  where id=?";
		//try {
			//JdbcUtils.getQuerrRunner().update(sql, dt.getTableName(),dt.getTableStatus(),dt.getOrderDate(),dt.getId());

		//} catch (Exception e) {
			//throw new RuntimeException(e);
		//}
	//}
	
	/**
	 * ɾ��
	 */
	@Override
	public void delete(int id) {
		String sql = "delete from dinnertable where id=?";
		try {
			JdbcUtils.getQuerrRunner().update(sql, id);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
