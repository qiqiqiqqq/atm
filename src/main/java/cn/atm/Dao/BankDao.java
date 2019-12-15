package cn.atm.Dao;

import cn.atm.entity.Bank;

import cn.itcast.jdbc.TxQueryRunner;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

public class BankDao {
	private QueryRunner qr = new TxQueryRunner();
	
	/**
	 * 按id查找银行
	 * @param bankId
	 * @return
	 */
	public Bank findbyId(String bankId) {
		try {
			String sql = "select * from bank where bankId=?";
			return qr.query(sql, new BeanHandler<Bank>(Bank.class), bankId);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
